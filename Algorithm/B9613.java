package Algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class B9613 {

    public static int GCD(int a, int b){
        if(b==0){
            return a;
        }
        else{
            return GCD(b,a%b);
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        for(int i=0;i<cnt;i++){
            int num = sc.nextInt();
            ArrayList<Integer> myArr = new ArrayList<>(1000);
            long result = 0;
            for(int j=0;j<num;j++){
                int a = sc.nextInt();
                myArr.add(a);
            }
            
            for(int j=0;j<num-1;j++){
                for(int k=j+1;k<num;k++){
                    result += GCD(myArr.get(j), myArr.get(k));
                }
            }
            System.out.println(result);
        }
    }
}