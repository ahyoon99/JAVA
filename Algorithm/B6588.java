package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B6588 {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        // 1. 소수 찾기
        int[] prime = new int[1000001];

        Boolean[] Isprime = new Boolean[1000001];
        Arrays.fill(Isprime,false);
        Isprime[0] = Isprime[1] = true;

        int primeCnt=0;
        for(int i=2;i*i<1000001;i++){
            if(Isprime[i]==true){
                continue;
            }
            else{
                prime[primeCnt++]=i;
                for(int j=2*i;j<1000001;j+=i){
                    Isprime[j]=true;
                }
            }
        }

        primeCnt=0;
        for(int i=2;i<1000001;i++){
            if(Isprime[i]==false){
                prime[primeCnt++]=i;
            }
        }

        while(true){
            int num = sc.nextInt();

            if(num==0){
                break;
            }
            else{
                boolean check = false;
                for(int i=0;i<primeCnt;i++){
                    int a = prime[i];
                    if(Isprime[num-a]==true){
                        continue;
                    }
                    else{
                        System.out.println(num+" = "+a+" + "+(num-a));
                        check = true;
                        break;
                    }
                }
                if(check==false){
                    System.out.println("Goldbach's conjecture is wrong.");
                }
                
            }
        }
        
    }
}
