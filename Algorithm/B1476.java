package Algorithm;

import java.util.Scanner;

public class B1476 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int year = 0;
        int E,S,M;
        int e=0;
        int s=0;
        int m=0;
        E = sc.nextInt();
        S = sc.nextInt();
        M = sc.nextInt();

        while(true){
            year++;
            if(e==15){
                e=1;
            }
            else{
                e++;
            }
            if(s==28){
                s=1;
            }
            else{
                s++;
            }
            if(m==19){
                m=1;
            }
            else{
                m++;
            }
            if(e==E && s==S && m==M){
                System.out.println(year);
                return;
            }
        }
    }
    
}
