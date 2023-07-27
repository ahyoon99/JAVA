package Algorithm;

import java.util.*;

public class P17677 {
    static public void main(String args[]){
        String str1 = "FRANCE";
        String str2 = "french";

        int result = solution(str1, str2);
        System.out.println(result);
    }
    
    static public int solution(String str1, String str2) {
        int answer = 0;
        
        ArrayList<String> a1 = new ArrayList<>();
        ArrayList<String> a2 = new ArrayList<>();
        
        ArrayList<String> intersection = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        for(int i=0;i<str1.length()-1;i++){
            String med = str1.substring(i,i+2);
            if(med.charAt(0)>='a' && med.charAt(0)<='z' && med.charAt(1)>='a' && med.charAt(1)<='z'){
                a1.add(med);
            }
        }
        
        for(int i=0;i<str2.length()-1;i++){
            String med = str2.substring(i,i+2);
            if(med.charAt(0)>='a' && med.charAt(0)<='z' && med.charAt(1)>='a' && med.charAt(1)<='z'){
                a2.add(med);
            }
        }
        
        Collections.sort(a1);
        Collections.sort(a2);
        
        if(a1.size()==0 && a2.size()==0){
            return 65536;
        }
        
        for(String entry : a1){
            if(a2.remove(entry)){
                intersection.add(entry);
            }
            union.add(entry);
        }
        
        for(String entry : a2){
            union.add(entry);
        }
        
    
        double jakard = (double) intersection.size() / (double) union.size();
        answer = (int) (jakard * 65536);

        return answer;
    }
}
