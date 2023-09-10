package Algorithm;

import java.util.*;
import java.io.*;

public class B10610 {
    static public void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        String number = st.nextToken();
        Integer[] numbers = new Integer[number.length()];
        int total=0;
        boolean check=false;
        for(int i=0;i<number.length();i++){
            numbers[i]=number.charAt(i)-'0';
            total+=number.charAt(i)-'0';
            if(number.charAt(i)=='0'){
                check=true;
            }
        }

        Arrays.sort(numbers, Collections.reverseOrder());

        if(!check){
            System.out.println(-1);
            return;
        }
        else if(total%3!=0){
            System.out.println(-1);
            return;
        }
        else{
            String result = "";
            for(int i=0;i<numbers.length;i++){
                result+=String.valueOf(numbers[i]);
            }
            System.out.println(result);
        }
        return;
    }
}
