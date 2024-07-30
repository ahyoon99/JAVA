package Algorithm;

import java.util.*;
import java.io.*;

public class swea1240 {
    static int t;
    static int n;
    static int m;
    static String[] matrix;
    static char[] password;
    static HashMap<String, Integer> passwordToNum;
    static int[] passwordInteger;
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        t = Integer.parseInt(st.nextToken());

        passwordToNum = new HashMap<String, Integer>();
        passwordToNum.put("0001101",0);
        passwordToNum.put("0011001",1);
        passwordToNum.put("0010011",2);
        passwordToNum.put("0111101",3);
        passwordToNum.put("0100011",4);
        passwordToNum.put("0110001",5);
        passwordToNum.put("0101111",6);
        passwordToNum.put("0111011",7);
        passwordToNum.put("0110111",8);
        passwordToNum.put("0001011",9);
        

        for(int testcase=1;testcase<=t;testcase++){
            System.out.print("#"+testcase+" ");
            input(br, st);
            solution();
        }
    }

    static void solution(){
        for(int i=0;i<8;i++){
            String temp="";
            for(int j=0;j<7;j++){
                temp+=String.valueOf(password[i*7+j]);
            }
            
            if(!passwordToNum.containsKey(temp)){
                passwordInteger[i]=0;
            }
            else{
                passwordInteger[i] = passwordToNum.get(temp);
            }
        }

        int odd=0;
        int even=0;
        int total=0;
        for(int i=0;i<8;i++){
            if(i%2==1){
                even+=passwordInteger[i];
            }
            else{
                odd+=passwordInteger[i];
            }
            total+=passwordInteger[i];
        }
        
        if((odd*3+even)%10==0){
            System.out.println(total);
        }
        else{
            System.out.println(0);
        }
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new String[n];
        password = new char[56];
        passwordInteger = new int[8];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            matrix[i] = st.nextToken();
        }

        boolean isFinish=false;
        for(int i=0;i<n;i++){
            if(isFinish){
                break;
            }
            
            String temp = matrix[i];
            String replaceTemp = temp.replace("0", "");
            if(replaceTemp.length()==0){
                continue;
            }
            
            String pwd = "";
            int startIdx=-1;
            int endIdx=-1;
            for(int j=0;j<m;j++){
                if(temp.charAt(j)=='1'){
                    startIdx = j;
                    break;
                }
            }

            for(int j=m-1;j>=0;j--){
                if(temp.charAt(j)=='1'){
                    endIdx = j;
                    break;
                }
            }

            for(int j=startIdx;j<=endIdx;j++){
                pwd+=String.valueOf(temp.charAt(j));
            }

            int addZero = 56-pwd.length();
            for(int j=0;j<addZero;j++){
                pwd = "0"+pwd;
            }

            for(int j=0;j<pwd.length();j++){
                password[j] = pwd.charAt(j);
            }

            isFinish=true;
        }
    }

}