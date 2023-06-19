package Algorithm;

import java.util.*;

public class P42839 {
    static int answer=0;
    static HashSet<Integer> hs = new HashSet<>();

    static public void main(String args[]){
        String numbers = "011";
        int result = solution(numbers);
        System.out.println(result);
    }

    static public int solution(String numbers) {
        
        int[] number = new int[numbers.length()];
        for(int i=0;i<numbers.length();i++){
            number[i]=numbers.charAt(i)-'0';
        }
        
        Arrays.sort(number);
        
        for(int i=1;i<=numbers.length();i++){
            int[] result = new int[i];
            boolean[] checked = new boolean[numbers.length()];
            go(number, result, checked, 0);
        }
        return answer;
    }
    
    static public void go(int[] number, int[] result, boolean[] checked, int idx){
        if(idx==result.length){
            String numStr = "";
            for(int i=0;i<result.length;i++){
                numStr+=(String.valueOf(result[i]));
            }
            
            int num = Integer.parseInt(numStr);
            if(hs.contains(num)){
                return;
            }
            else{
                hs.add(num);
                if(isPrime(num)){
                    answer++;
                }
            }
            return ;
        }
        
        for(int i=0;i<number.length;i++){
            if(checked[i]==false){
                checked[i]=true;
                result[idx]=number[i];
                go(number, result, checked, idx+1);
                checked[i]=false;
            }
        }
    }
    
    static public boolean isPrime(int n){
        if(n==1 || n==0){
            return false;
        }
        if(n==2){
            return true;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
