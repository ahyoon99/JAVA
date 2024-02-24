package Algorithm;

import java.util.*;
import java.io.*;

public class B1918 {
    static public void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");  
        String command = st.nextToken();

        int n = command.length();

        Stack<Character> stack = new Stack<>();
        String result = "";

        for(int i=0;i<n;i++){
            char c = command.charAt(i);
            if(c=='('){
                stack.add('(');
            }
            else if(c==')'){
                while(!stack.isEmpty()){
                    if(stack.peek()=='('){
                        stack.pop();
                        break;
                    }
                    result+=String.valueOf(stack.pop());
                }
                
            }
            else if(c=='+' || c=='-' || c=='*' || c=='/'){
                int cIdx = operator(c);
                while(!stack.isEmpty()){
                    if(operator(stack.peek()) >= cIdx){
                        result+=String.valueOf(stack.pop());
                    }
                    else{
                        break;
                    }
                }
                stack.add(c);
            }
            else{
                result += String.valueOf(c);
            }
        }

        while(!stack.isEmpty()){
            result += String.valueOf(stack.pop());
        }
        System.out.println(result);
    }

    static int operator(char c){
        if(c=='+' || c=='-'){
            return 1;
        }
        else if(c=='*' || c=='/'){
            return 2;
        }
        else{   // 숫자, 괄호일 경우
            return 0;
        }
    }
}
