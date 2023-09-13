package Algorithm;

import java.util.*;
import java.io.*;

public class B1541{
    static public void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        String com = st.nextToken();

        ArrayList<Integer> num = new ArrayList<>();
        String med = "";
        boolean isPlus = true;
        for(int i=0;i<com.length();i++){
            if(com.charAt(i)=='-' || com.charAt(i)=='+'){
                if(isPlus){
                    num.add(Integer.parseInt(med));
                }
                else{
                    num.add(Integer.parseInt(med)*(-1));
                }
                med=""; 

                if(com.charAt(i)=='+'){
                    isPlus=true;
                }
                else if(com.charAt(i)=='-'){
                    isPlus=false;
                }
            }
            else if('0' <= com.charAt(i) && com.charAt(i) <='9'){
                med+=String.valueOf(com.charAt(i));
            }
        }

        if(isPlus){
            num.add(Integer.parseInt(med));
        }
        else{
            num.add(Integer.parseInt(med)*(-1));
        }

        int answer = num.get(0);
        boolean isMinus = false;
        for(int i=1;i<num.size();i++){
            if(num.get(i)<0){
                isMinus=true;
                answer+=num.get(i);
            }
            else{
                if(isMinus){
                    answer-=num.get(i);
                }
                else{
                    answer+=num.get(i);
                }
            }
        }
        System.out.println(answer);
    }
}
