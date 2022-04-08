package Algorithm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class B11723 {
    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        boolean[] check = new boolean[21];
        int[] num = new int[21];
        int result=0;

        for(int i=0;i<n;i++){
            String com = sc.next();
            if(com.equals("add")){
                int x = sc.nextInt();
                x=x-1;
                result = result | (1<<x);
            }
            else if(com.equals("remove")){
                int x = sc.nextInt();
                x=x-1;
                result = result & ~(1<<x);
            }
            else if(com.equals("check")){
                int x = sc.nextInt();
                x=x-1;
                if( (result & (1<<x)) == (1<<x)){
                    bw.write("1\n");
                    //System.out.println("1");
                }
                else{
                    bw.write("0\n");
                    // System.out.println("0");
                }
            }
            else if(com.equals("toggle")){
                int x = sc.nextInt();
                x=x-1;
                result = result ^ (1<<x);
            }
            else if(com.equals("all")){
                result = (int) Math.pow(2, 20) -1;
            }
            else if(com.equals("empty")){
                result = 0;
            }
        }

        bw.flush();
        return;
    }
    
}
