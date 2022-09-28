package com.DevMatcing._2021_Matrix;

import java.util.*;

public class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        //6,6, [[2,2,5,4],[3,3,6,6],[5,1,6,3]]

        int [][] matrix = new int[rows][columns];

        int init=1 ;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                matrix[i][j] =init;
                init++;
            }
        }

        for(int index =0; index<queries.length; index++){
            int x1 = queries[index][0];
            int y1 = queries[index][1];
            int x2 = queries[index][2];
            int y2 = queries[index][3];
            int x=x1;
            int y=y1;

            int [][] matrix_copy = matrix.clone();


            do{
                if(y==y2){
                    matrix[x][y+1] = matrix_copy[x][y];
                    y++;
                    continue;
                }
                if(x==x2){
                    matrix[x+1][y] = matrix_copy[x][y];
                    x++;
                    continue;
                }
                if(y==y1){
                    matrix[x][y-1] = matrix_copy[x][y];
                    y--;
                    continue;
                }
                if(x==x1){
                    matrix[x-1][y] = matrix_copy[x][y];
                    x--;
                    continue;
                }
            }while(x==x1 && y==y1);
//                for ()
//                    for ()
//                        for()

        }


        int[] answer = new int[queries.length];


        return answer;
    }

    private void turnRight(int size, int[][] matrix, int[] answer)
    {

    }
}