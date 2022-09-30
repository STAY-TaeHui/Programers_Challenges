package com.DevMatcing._2022_KAKAO_FeeOfParking;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Solution
{
    static Map<String,Record> recordMap = new HashMap<>();

    static int baseTime=0;
    static int baseFee=0;
    static int timeUnit=0;
    static int feeUnit=0;


    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        baseTime = fees[0];
        baseFee = fees[1];
        timeUnit = fees[2];
        feeUnit = fees[3];

        // 공식 : 기본요금 + [(전체시간 - 기본시간) / 단위시간]* 단위요금

        //records 순회하면서 하나씩 확인
        for(int i=0; i<records.length; i++){
            String recordString = records[i];

            //records split 해서 각 정보 확인 확인
            String[] splitRecord = recordString.split(" ");

            String time = splitRecord[0];
            String carNum = splitRecord[1];
            String status = splitRecord[2];

            //Map에 해당 carNum이 존재하면 Map에서 가져오고, 없으면 새로 생성
            Record record = recordMap.containsKey(carNum) ? recordMap.get(carNum) : new Record(carNum);
            recordMap.put(carNum,record);

            record.setTotalTime(time,status);
        }
        Iterator<String> iterator = recordMap.keySet().iterator();
        while(iterator.hasNext()){
            Record record = recordMap.get(iterator.next());
            if(record.totalTime<=baseTime){
                record.fee = baseFee;
            }
            else{
                record.fee = baseFee + (int) Math.ceil((record.totalTime - baseTime)/timeUnit) * feeUnit;
            }

        }
        //Todo
        // Record Map 돌면서 key 꺼내서 fee 순서대로 answer에 넣으면 끝
        Set<String> strings = recordMap.keySet();


        return answer;
    }

    static class Record{
         String number;
         int inTime;
         int totalTime;
         String status;
         int fee;

        public Record(String number)
        {
            this.number = number;
            this.totalTime=0;
            this.inTime=0;
            this.fee=0;
            this.status="OUT";
        }

        public void setTotalTime(String time, String status)
        {
            String[] splitTime = time.split(":");

            int checkedTime = (Integer.parseInt(splitTime[0]) * 60) + Integer.parseInt(splitTime[1]);

            if ("IN".equals(status))
            {
                inTime = checkedTime;
            }
            else if("OUT".equals(status)){
                totalTime += (checkedTime - inTime);
            }
        }
        public void in(){

        }
        public void out(){

        }
    }
}
