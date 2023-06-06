package Algorithm;

import java.util.*;

public class P64065 {
    static public void main(String args[]){
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

        ArrayList<Integer> result = solution(s);
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }
    static public ArrayList<Integer> solution(String s) {
        
        s = s.substring(2, s.length()-2);
        s = s.replace(","," ");
        s = s.replace("} {",",");
        
        String[] tupleArr = s.split(",");
        Arrays.sort(tupleArr, (o1, o2) -> {
                return o1.length() - o2.length();
        });
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i=0;i<tupleArr.length;i++){
            String[] med = tupleArr[i].split(" ");
            
            for(int j=0;j<med.length;j++){
                if(answer.contains(Integer.parseInt(med[j]))){
                    continue;
                }
                else{
                    answer.add(Integer.parseInt(med[j]));
                }
            }
        }
        return answer;
    }
}
