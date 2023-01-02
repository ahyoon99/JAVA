package Algorithm;

import java.util.*;
import java.util.Map.*;

public class P67257 {
    static String[] opString = {"*","+","-"};
    static ArrayList<String[]> combination = new ArrayList<String[]>();
    
    static void go(ArrayList<String> existOp, int m, int idx, boolean[] visited, String[] result){
        if(idx==m){
            String[] finish = result.clone();
            combination.add(finish);
            return;
        }
        if(idx>m){
            return;
        }
        for(int i=0;i<m;i++){
            if(visited[i]==false){
                result[idx]=existOp.get(i);
                visited[i]=true;
                go(existOp, m, idx+1, visited, result);
                visited[i]=false;
            }
        }
    }
    
    static public long solution(String expression) {
        Long answer = 0L;
        
        // expression 전처리 + 연산자 개수 구하기
        ArrayList<Long> numInit = new ArrayList<>();    // {100L,200L,300L,500L,20L}
        ArrayList<String> op = new ArrayList<>();   // {"-","*","-","+"}
        boolean[] isExistOp = new boolean[3]; // 순서 : *, +, - 
        ArrayList<String> existOp = new ArrayList<>();
        int opCnt=0;
        
        String number = "";
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i)=='*'){
                op.add("*");
                numInit.add(Long.parseLong(number));
                number="";
                if(isExistOp[0]==false){
                    isExistOp[0]=true;
                    existOp.add("*");
                    opCnt++;
                }
            }
            else if(expression.charAt(i)=='+'){
                op.add("+");
                numInit.add(Long.parseLong(number));
                number="";
                if(isExistOp[1]==false){
                    isExistOp[1]=true;
                    existOp.add("+");
                    opCnt++;
                }
            }
            else if(expression.charAt(i)=='-'){
                op.add("-");
                numInit.add(Long.parseLong(number));
                number="";
                if(isExistOp[2]==false){
                    isExistOp[2]=true;
                    existOp.add("-");
                    opCnt++;
                }
            }
            else{
                number+=Character.toString(expression.charAt(i));
            }
        }
        numInit.add(Long.parseLong(number));
        
        // 연산자 우선순위 정하기
        boolean[] visited = new boolean[3];
        String[] result = new String[opCnt];
        go(existOp, opCnt, 0, visited, result);

        
        // 연산자 우선순위에 기반해 계산하기 + 최대값 구하기
        Long maxValue = -1L;
        for(int tc = 0;tc<combination.size();tc++){
            String[] priority = combination.get(tc);
            
            // 깊은 복사
            ArrayList<Long> num = new ArrayList<>();
            for(int i=0;i<numInit.size();i++){
                num.add(numInit.get(i));
            }
            
            for(int i=0;i<priority.length;i++){
                for(int j=0;j<op.size();j++){
                     if(op.get(j).equals(priority[i])){
                        int idx1=j;
                        while(num.get(idx1) == null){
                            idx1--;
                        }
                        Long num1 = num.get(idx1);

                        int idx2=j+1;
                        while(num.get(idx2) == null){
                            idx2--;
                        }
                        Long num2 = num.get(idx2);
                         
                        if(op.get(j).equals("*")){
                            num.set(idx1, num1*num2);
                            num.set(idx2, null);
                        }
                        else if(op.get(j).equals("+")){
                            num.set(idx1, num1+num2);
                            num.set(idx2, null);
                        }
                        else if(op.get(j).equals("-")){
                            num.set(idx1, num1-num2);
                            num.set(idx2, null);
                        }
                     }
                }
            }
            Long resultNum=0L;
            for(int j=0;j<num.size();j++){
                if(num.get(j)==null){
                    continue;
                }
                resultNum = num.get(j);
            }
            resultNum = Math.abs(resultNum);

            if(maxValue<resultNum){
                maxValue = resultNum;
            }
        }
       return maxValue;
    }
    static public void main(String args[]){
        solution("100-200*300-500+20");
    }
}
