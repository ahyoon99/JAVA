package Algorithm;

import java.util.*;
import java.io.*;

public class swea1230 {
    static int n;
    static ArrayList<String> passwords;
    static int m;
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int testcase=1;testcase<=10;testcase++){
            System.out.print("#"+testcase+" ");
            input(br);
            solution(br);
            print();
        }
    }

    static void solution(BufferedReader br) throws IOException{
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0;i<m;i++){
            String command = st.nextToken();
            if(command.equals("I")){
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                for(int j=0;j<y;j++){
                    String password = st.nextToken();
                    passwords.add(x, password);
                    x++;
                }
            }
            else if(command.equals("D")){
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                
                for(int j=0;j<y;j++){
                    passwords.remove(x);
                }
            }
            else if(command.equals("A")){
                int y = Integer.parseInt(st.nextToken());

                for(int j=0;j<y;j++){
                    String password = st.nextToken();
                    passwords.add(password);
                }
            }
        }
    }

    static void input(BufferedReader br) throws IOException{
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        passwords = new ArrayList<String>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            passwords.add(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
    }

    static void print(){
        for(int i=0;i<10;i++){
            System.out.print(passwords.get(i)+" ");
        }
        System.out.println();
    }
}
