package Algorithm;

import java.util.Scanner;

public class B1934 {

    public static int GCD(int a, int b){
        while(b!=0){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int LCM(int a, int b){
        return a*b/GCD(a,b);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        for(int i=0;i<cnt;i++){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            System.out.println(LCM(num1, num2));
        }
    }
}