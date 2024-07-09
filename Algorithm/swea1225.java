package Algorithm;

import java.util.*;
import java.io.*;

public class swea1225 {
    static int t;
    static ArrayList<Integer> numbers;
    static public void main(String args[]) throws IOException{
        
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    

        for(int testcase=1;testcase<=10;testcase++){
            System.out.print("#"+testcase+" ");
            
            input(br);
            solution();

            for(int i=0;i<8;i++){
                System.out.print(numbers.get(i)+" ");
            }
            System.out.println();

        }

    }

    static void solution() throws IOException{

        boolean flag = true;
        while(flag){
            for(int i=1;i<=5;i++){
                int num = numbers.get(0)-i;
                if(num<=0){
                    numbers.add(0);
                    numbers.remove(0);
                    flag=false;
                    break;
                }
                numbers.add(num);
                numbers.remove(0);
            }
        }
    }

    static void input(BufferedReader br) throws IOException{
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine(), " ");
        t = Integer.parseInt(st.nextToken());

        numbers = new ArrayList<Integer>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<8;i++){
            numbers.add(Integer.parseInt(st.nextToken()));
        }
    }
}
