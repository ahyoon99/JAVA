package Algorithm;

import java.util.*;
import java.io.*;

public class swea1224 {
    static int len;
    static String command;
    static Stack<String> operator;
    static ArrayList<String> result;
    static public void main(String args[]) throws IOException {

        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<10;i++){
            System.out.print("#"+(i+1)+" ");
            solution(br);
        }
    }

    static void solution(BufferedReader br) throws IOException{
        input(br);
        
        for(int i=0;i<len;i++){
            String c = String.valueOf(command.charAt(i));
            if(c.equals("(")){
                operator.add(c);
            }
            else if(c.equals(")")){
                while(!operator.isEmpty() && !operator.peek().equals("(")){
                    result.add(operator.pop());
                }
                operator.pop();
            }
            else if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")){
                int myPri = priority(c);
                while(!operator.isEmpty() && priority(operator.peek())>=myPri){
                    result.add(operator.pop());
                }
                operator.add(c);
            }
            else{
                result.add(c);
            }
        }

        while(!operator.isEmpty()){
            result.add(operator.pop());
        }

        
        while(result.size()!=1){
            int i=0;
            while(i<result.size()-2){
                if(priority(result.get(i))==-1 && priority(result.get(i+1))==-1 && priority(result.get(i+2))!=-1){
                    int num1 = Integer.parseInt(result.get(i));
                    int num2 = Integer.parseInt(result.get(i+1));
                    int answer=-1;
                    if(result.get(i+2).equals("+")){
                        answer = num1+num2;
                    }
                    else if(result.get(i+2).equals("-")){
                        answer = num1-num2;
                    }
                    else if(result.get(i+2).equals("*")){
                        answer = num1*num2;
                    }
                    else if(result.get(i+2).equals("/")){
                        answer = num1/num2;
                    }
                    String answerStr = Integer.toString(answer);
                    result.set(i, answerStr);
                    result.remove(i+1);
                    result.remove(i+1);
                    i=0;
                }
                else{
                    i++;
                }
            }
        }
        System.out.println(result.get(0));
    }

    static void input(BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        len = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        command = st.nextToken();

        operator = new Stack<String>();
        result = new ArrayList<String>();
    }

    static int priority(String c){
        if(c.equals("+") || c.equals("-")){
            return 1;
        }
        else if(c.equals("*") || c.equals("/")){
            return 2;
        }
        return -1;
    }
}
