package Algorithm;

import java.util.*;
import java.io.*;

public class B9655 {
    static int n;
    static public void main(String args[]) throws IOException{
        
        input();

        if(n%2==0){
            System.out.println("CY");
        }
        else{
            System.out.println("SK");
        }
    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
    }
}
