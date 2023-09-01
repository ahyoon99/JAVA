package Algorithm;

import java.util.*;

public class P68936 {
    // 방법 1
    // static int[] answer;
    
    // static public void main(String args[]){
    //     int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};

    //     int[] result = solution(arr);
    //     for(int i=0;i<result.length;i++){
    //         System.out.println(result[i]);
    //     }
    // }

    // static public int[] solution(int[][] arr) {
    //     answer = new int[2];
        
    //     go(arr);
        
    //     return answer;
    // }
    
    // static void go(int[][] arr){
    //     // 영역 S의 길이가 1 -> 더 이상 쪼갤 수 없다.
    //     if(arr.length==1){
    //         answer[arr[0][0]]++;
    //         return;
    //     }
        
    //     // arr가 한 가지 숫자로 되어 있는지 확인하기!
    //     // 한 가지 숫자임 -> check가 true / 한 가지 숫자가 아님 -> check가 false
    //     int num = arr[0][0];
    //     boolean check=true;
    //     for(int i=0;i<arr.length;i++){
    //         for(int j=0;j<arr[i].length;j++){
    //             if(arr[i][j]!=num){
    //                 check=false;
    //                 break;
    //             }
    //         }
    //     }
        
    //     if(!check){ // 한 가지 숫자로 되어 있지 않다 -> 4등분 해서 다시 체크!
    //         int[][] med = new int[arr.length/2][arr.length/2];
            
    //         // 1. 왼&위
    //         for(int i=0;i<arr.length/2;i++){
    //             med[i] = Arrays.copyOfRange(arr[i], 0, arr.length/2);
    //         }
    //         go(med);
            
    //         // 2. 오&위
    //         for(int i=0;i<arr.length/2;i++){
    //             med[i] = Arrays.copyOfRange(arr[i], arr.length/2, arr.length);
    //         }
    //         go(med);
            
    //         // 3. 왼&아
    //         for(int i=arr.length/2;i<arr.length;i++){
    //             med[i-arr.length/2] = Arrays.copyOfRange(arr[i], 0, arr.length/2);
    //         }
    //         go(med);
            
    //         // 4. 오&아
    //         for(int i=arr.length/2;i<arr.length;i++){
    //             med[i-arr.length/2] = Arrays.copyOfRange(arr[i], arr.length/2, arr.length);
    //         }
    //         go(med);
            
    //     }
    //     else{   // 한 가지 숫자로 되어 있음
    //         answer[num]++;
    //     }
        
    // }

    // 방법 2
    static int[] answer;
    
    static public void main(String args[]){
        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};

        int[] result = solution(arr);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
    
    static public int[] solution(int[][] arr) {
        answer = new int[2];
        
        go(arr, 0,0, arr.length);
        
        return answer;
    }
    
    static void go(int[][] arr, int x, int y, int size){
        if(check(arr, x, y, size)){
            answer[arr[x][y]]++;
            return;
        }
        go(arr, x,y,size/2);
        go(arr, x+size/2,y,size/2);
        go(arr, x,y+size/2,size/2);
        go(arr, x+size/2,y+size/2,size/2);
    }
    
    static boolean check(int[][] arr, int x, int y, int size){
        int base = arr[x][y];
        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(arr[i][j]!=base){
                    return false;
                }
            }
        }
        return true;
    }
}
