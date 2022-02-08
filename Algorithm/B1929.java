package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B1929 {

    static boolean myArr[] = new boolean[1000001];
    static int prime[] = new int[1000001];

    static void findPrime(int n, int num){
        for(int i=2;i*i<=n;i++){
            if(myArr[i]==false){
                for(int j=i;j*i<=n;j++){
                    myArr[i*j]=true;
                }
            }
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        Arrays.fill(myArr, false);  //  myArr 배열 false로 초기화
        myArr[1]=true;
        findPrime(N,2);
        for(int i=M;i<=N;i++){
            if(myArr[i]==false){
                System.out.println(i);
            }
        }
    }
    
}
