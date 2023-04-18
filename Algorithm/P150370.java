package Algorithm;

import java.util.*;

public class P150370 {
    static public void main(String args[]){
        // testcase 1
        // String today = "2022.05.19";
        // String[] terms = {"A 6", "B 12", "C 3"};
        // String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        
        // testcase 2
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        
        ArrayList<Integer> result = solution(today, terms, privacies);
        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
        }
        System.out.println();
    }
    
    static public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        // today 정수화하기 -> {2022,05,19} -> 2022 * 12 * 28 + 5 * 28 + 19
        String[] todayArrMed = today.split("[.]");
        int[] todayArr = new int[3];
        for(int i=0;i<todayArrMed.length;i++){
            todayArr[i] = Integer.parseInt(todayArrMed[i]);
        }
        int todayInt = (todayArr[0]*12*28) + (todayArr[1]*28) + (todayArr[2]);
        
        // 유효기간 배열에 담기
        int[] alpToTerms = new int[26];
        for(int i=0;i<terms.length;i++){
            String[] term = terms[i].split(" ");
            alpToTerms[terms[i].charAt(0)-'A'] = Integer.parseInt(term[1]);
        }
        
        // 체결 날짜 정수화하기
        for(int i=0;i<privacies.length;i++){
            String[] coms = privacies[i].split(" "); // {"2021.05.02", A}
            String[] startMed = coms[0].split("[.]");    // {"2021","05","02"}
            int[] start = new int[3]; // {2021, 5, 2}
            for(int j=0;j<startMed.length;j++){
                start[j]=Integer.parseInt(startMed[j]);
            }
            int validMonth = alpToTerms[coms[1].charAt(0)-'A'];

            int startInt = (start[0]*12*28) + (start[1]*28) + (start[2]) + validMonth* 28 -1;
            
            if(todayInt>startInt){
                answer.add(i+1);
            }
            
            
        }        
        
        return answer;
    }
}
