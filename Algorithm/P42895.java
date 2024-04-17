package Algorithm;

import java.util.*;

public class P42895 {
    static ArrayList<HashSet<Integer>> result;
    
    static public void main(String args[]){
        // tc1
        int N = 5;
        int number = 12;
        
        // tc2
        // int N = 2;
        // int number = 11;

        int result = solution(N, number);
        System.out.println(result);
    }

    static public int solution(int N, int number) {
        
        result = new ArrayList<HashSet<Integer>>();
        for(int i=0;i<9;i++){
            result.add(new HashSet<>());
        }
        
        result.get(1).add(N);
        
        for(int i=2;i<9;i++){
            HashSet<Integer> answer = new HashSet<>();
            for(int j=1;j<=i;j++){
                HashSet<Integer> prev = result.get(j);
                HashSet<Integer> next = result.get(i-j);
                
                for(Integer entry1 : prev){
                    for(Integer entry2 : next){
                        answer.add(entry1+entry2);
                        answer.add(entry1-entry2);
                        answer.add(entry1*entry2);
                        if(entry2!=0){
                            answer.add(entry1/entry2);
                        }
                        
                        answer.add(entry2-entry1);
                        if(entry1!=0){
                            answer.add(entry2/entry1);
                        }
                    }
                }
                String str = "";
                for(int k=0;k<i;k++){
                    str+=String.valueOf(N);
                }
                answer.add(Integer.parseInt(str));
            }
            result.set(i, answer);
        }
        
        for(HashSet<Integer> set : result){
            if(set.contains(number)){
                return result.indexOf(set);
            }
        }
        return -1;
    }
}
