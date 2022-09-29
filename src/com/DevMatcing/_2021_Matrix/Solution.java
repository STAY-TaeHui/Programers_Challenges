package com.DevMatcing._2021_Matrix;

public class Solution {
    int min;

    public int[] solution(int rows, int columns, int[][] queries) {
        //6,6, [[2,2,5,4],[3,3,6,6],[5,1,6,3]]
        int[] answer = new int[queries.length];

        int [][] matrix = new int[rows][columns];

        int init=1 ;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                matrix[i][j] =init;
                init++;
            }
        }

        for(int index =0; index<queries.length; index++){
            min=rows*columns;

            int x1 = queries[index][0]-1;//2
            int y1 = queries[index][1]-1;//2
            int x2 = queries[index][2]-1;//5
            int y2 = queries[index][3]-1;//4

            int[][] matrix_copy = matrixCopy(rows, columns, matrix);

            for(int tmpY = y1; tmpY<y2; tmpY++){
                matrix[x1][tmpY+1] = matrix_copy[x1][tmpY];
                checkMin(matrix_copy[x1][tmpY]);
            }
            for(int tmpX = x1; tmpX<x2; tmpX++){
                matrix[tmpX+1][y2] = matrix_copy[tmpX][y2];
                checkMin(matrix_copy[tmpX][y2]);
            }

            for(int tmpY = y2; tmpY>y1; tmpY--){
                matrix[x2][tmpY-1] = matrix_copy[x2][tmpY];
                checkMin(matrix_copy[x2][tmpY]);
            }
            for(int tmpX = x2; tmpX>x1; tmpX--){
                matrix[tmpX-1][y1] = matrix_copy[tmpX][y1];
                checkMin(matrix_copy[tmpX][y1]);
            }
            answer[index]=min;
        }


        return answer;
    }

    private void checkMin(int value)
    {
        if(min>value){
            min=value;
        }
    }

    private  int[][] matrixCopy(int rows, int columns, int[][] matrix)
    {
        int [][]matrix_copy = new int[rows][columns];

        for(int i=0; i<rows; i++){
            matrix_copy[i] = matrix[i].clone();
        }
        return matrix_copy;
    }
}