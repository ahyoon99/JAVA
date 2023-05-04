package Algorithm;

import java.util.*;
import java.io.*;

public class P131128 {
    static public void main(String args[]){
        String X = "100";
        String Y = "123450";
        String answer = solution(X, Y);
        System.out.println(answer);
    }
    
    static public String solution(String X, String Y) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int[] xCnt = new int[10];
        int[] yCnt = new int[10];
        
        for(char ch : X.toCharArray()){
            xCnt[ch-'0'] ++;
        }
        for(char ch : Y.toCharArray()){
            yCnt[ch-'0'] ++;
        }
        
        for(int i=9;i>=0;i--){
            if(xCnt[i]==0 || yCnt[i]==0){
                continue;
            }
            int min = (xCnt[i]>yCnt[i]) ? yCnt[i] : xCnt[i] ;
            for(int j=0;j<min;j++){
                sb.append(String.valueOf(i));
            }
        }
        answer = sb.toString();
        if(answer.equals("")){
            answer = "-1";
        }
        else if(answer.charAt(0)=='0'){
            answer = "0";
        }
        
        return answer;
    }
}
