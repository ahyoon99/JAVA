package Algorithm;

import java.util.*;

public class P12981 {
    static public void main(String args[]){
        int n=3;
        String[] words = {"tank", "kick", "know", "wheel", 
                            "land", "dream", "mother", "robot", "tank"};
        int[] result = solution(n, words);

        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }

    static public int[] solution(int n, String[] words) {
        int[] answer=new int[2];

        List<String> wordsList = new ArrayList<>();
        
        char prev = words[0].charAt(words[0].length()-1);
        wordsList.add(words[0]);
        int i=1;
        while(true){
            if(i>=words.length){
                answer[0]=0;
                answer[1]=0;
                return answer;
            }
            else if(!wordsList.contains(words[i])){
                if(prev==words[i].charAt(0)){
                    int lastIdx = words[i].length()-1;
                    prev = words[i].charAt(lastIdx);
                    wordsList.add(words[i]);
                }
                else{
                    answer[0]=(i%n)+1;
                    answer[1]=(i/n)+1;
                    return answer;
                }
            }
            else{
                answer[0]=(i%n)+1;
                answer[1]=(i/n)+1;
                return answer;
            }
            i++;
        }
    }
}
