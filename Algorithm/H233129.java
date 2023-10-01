package Algorithm;

import java.util.*;
import java.io.*;

public class H233129 {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] data = new int[100];
        
        int prev=0;
        for(int i=0;i<n;i++){
            int time = sc.nextInt();
            int speed = sc.nextInt();
            for(int j=prev;j<prev+time;j++){
                data[j]=speed;
            }
            prev+=time;
        }

        int[] operation = new int[100];
        
        prev=0;
        for(int i=0;i<m;i++){
            int time = sc.nextInt();
            int speed = sc.nextInt();
            for(int j=prev;j<prev+time;j++){
                operation[j]=speed;
            }
            prev+=time;
        }

        int max=0;
        for(int i=0;i<100;i++){
            max = (max < operation[i]-data[i]) ? operation[i]-data[i] : max;
        }
        System.out.println(max);
    }
}
