package Algorithm;

import java.util.*;
import java.io.*;

public class H230262 {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int[][] numbers = {
                            {1,1,1,0,1,1,1}, // 0
                            {0,0,1,0,0,1,0}, // 1
                            {0,1,1,1,1,0,1}, // 2
                            {0,1,1,1,0,1,1}, // 3
                            {1,0,1,1,0,1,0}, // 4
                            {1,1,0,1,0,1,1}, // 5
                            {1,1,0,1,1,1,1}, // 6
                            {1,1,1,0,0,1,0}, // 7
                            {1,1,1,1,1,1,1}, // 8
                            {1,1,1,1,0,1,1}, // 9
                            {0,0,0,0,0,0,0}  // 다 꺼져있는경우
        };

        int n = sc.nextInt();
        for(int tc=0;tc<n;tc++){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int cnt=0;

            while(num1!=0 || num2!=0){
                int n1 = (num1==0) ? 10 : num1%10;
                int n2 = (num2==0) ? 10 : num2%10;

                for(int i=0;i<7;i++){
                    if(numbers[n1][i]!=numbers[n2][i]){
                        cnt++;
                    }
                }
                num1/=10;
                num2/=10;
            }
            System.out.println(cnt);
        }
    }
}
