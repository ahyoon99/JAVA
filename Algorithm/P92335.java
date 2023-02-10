package Algorithm;

import java.util.*;

public class P92335 {
    // 10진수인 num을 n진수로 변환해주는 함수
    static String radix(int num, int n){
        StringBuilder sb = new StringBuilder();
        
        if(num==0){return "0";}
        while(num>0){
            sb.append(num%n);
            num/=n;
        }
        return sb.reverse().toString();
    }
    
    // 소수인지 판별하는 함수. 소수이면 true, 소수가 아니면 false를 리턴해준다.
    static boolean isPrime(long n){
        if(n==1){
            return false;
        }
        else if(n==2){
            return true;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }   
    
    static public int solution(int n, int k) {
        int answer = 0;
        
        String changeNum = radix(n,k);
        String[] splitResult = changeNum.split("0");
        
        for(int i=0;i<splitResult.length;i++){
            //System.out.println("i : "+i+", splitResult[i] :"+splitResult[i]+",");
            if(!splitResult[i].equals("")){
                long stringToInt = Long.parseLong(splitResult[i]);
                if(isPrime(stringToInt)){
                    answer++;
                }
            }
        }
        return answer;
    }

    static public void main(String args[]){
        int n = 437674;
        int k = 3;
        int result = solution(n,k);
        System.out.println(result);
    }
}
