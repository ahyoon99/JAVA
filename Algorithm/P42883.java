package Algorithm;

import java.util.*;
import java.io.*;

public class P42883 {
    static public void main(String args[]){
        String number = "4177252841";
        int k=4;

        String result = solution(number, k);
        System.out.println(result);
    }

    static public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        int resultLength = number.length()-k;
        String med = number;
        int totalIdx=0;
        
        for(int i=0;i<number.length()-k;i++){
            med = med.substring(0, med.length()-resultLength+1);
            
            char max = '-';
            int idx=-1;
            for(int j=0;j<med.length();j++){
                if(med.charAt(j)=='9'){
                    max=med.charAt(j);
                    idx=j;
                    break;
                }
                else if(max=='-' || max - med.charAt(j)<0){
                    max=med.charAt(j);
                    idx=j;
                }
            }
            sb.append(max);
            totalIdx+=(idx+1);
            med = number.substring(totalIdx, number.length());     
            resultLength--;
        }
        
        return sb.toString();
    }
}
