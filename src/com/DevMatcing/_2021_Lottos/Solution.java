package com.DevMatcing._2021_Lottos;

import java.util.*;

public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {

        Map<Integer,Integer> rankMap = new HashMap();
        rankMap.put(6,1);
        rankMap.put(5,2);
        rankMap.put(4,3);
        rankMap.put(3,4);
        rankMap.put(2,5);
        rankMap.put(1,6);
        rankMap.put(0,6);

        int[] answer = {};
        int correct =0;
        int count0 = 0;

        for (int lotto : lottos)
        {
            if(lotto==0){
                count0++;
            }

            boolean isCorrect = Arrays.stream(win_nums).anyMatch(num -> num==lotto);

            if(isCorrect){
               correct++;
            }

        }

        answer = new int []{rankMap.get(correct+count0), rankMap.get(correct)};


        return answer;
    }
}