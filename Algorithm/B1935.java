package Algorithm;

import java.util.*;
import java.io.*;

public class B1935 {
    static int n;
    static ArrayList<String> result;
    static String[] numbers;
    static public void main(String args[]) throws IOException{

        input();
        
        prev();

        solution();

    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        String command = st.nextToken();

        result = new ArrayList<String>();
        for(int i=0;i<command.length();i++){
            result.add(Character.toString(command.charAt(i)));
        }

        numbers = new String[n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            //numbers[i] = Integer.parseInt(st.nextToken());
            numbers[i] = st.nextToken();
        }
    }

    static void prev(){
        for(int i=0;i<result.size();i++){
            if(isNum(result.get(i))){
                char c = result.get(i).charAt(0);
                result.set(i, numbers[c-'A']);
            }
        }
    }

    static void solution(){

        int idx=0;
        while(result.size()>1){
            if( (isNum(result.get(idx))==true) && (isNum(result.get(idx+1))==true) && (isNum(result.get(idx+2))==false)){
                double num1 = Double.parseDouble(result.get(idx));
                double num2 = Double.parseDouble(result.get(idx+1));
                String operator = result.get(idx+2);

                double answer=-1;
                if(operator.equals("+")){
                    answer = (double) (num1+num2);
                }
                else if(operator.equals("-")){
                    answer = (double) (num1-num2);
                }
                else if(operator.equals("*")){
                    answer = (double) (num1*num2);
                }
                else if(operator.equals("/")){
                    answer = (double) (num1/num2);
                }

                result.set(idx, String.valueOf(answer));
                result.remove(idx+1);
                result.remove(idx+1);
                idx=0;
            }
            else{
                idx++;
            }
        }

        Double resultDouble = Double.parseDouble(result.get(0));
        System.out.printf("%.2f", resultDouble);
        System.out.println();
    }

    static boolean isNum(String str){
        if(str.equals("+") || str.equals("-") || str.equals("*")|| str.equals("/")){
            return false;
        }
        return true;
    }
}
