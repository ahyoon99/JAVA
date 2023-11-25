package Algorithm;

import java.util.Scanner;

public class B2609 {

    public static int GCD(int a, int b){
        if(b==0){
            return a;
        }
        else{
            return GCD(b,a%b);
        }
    }

    public static int LCM(int a, int b){
        return a*b/GCD(a,b);
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        System.out.println(GCD(num1, num2));
        System.out.println(LCM(num1, num2));

        
    }
    
}