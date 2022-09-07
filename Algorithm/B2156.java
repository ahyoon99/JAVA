package Algorithm;

import java.util.Scanner;

public class B2156 {
    // 방법 1 (Bottom-up)
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] wine = new int[n];
        for(int i=0;i<n;i++){
            wine[i]=sc.nextInt();
        }
        int[][] myDrink = new int[n][3];
        myDrink[0][0]=0;
        myDrink[0][1]=wine[0];
        myDrink[0][2]=0;
        for(int i=1;i<n;i++){
            myDrink[i][0]=Math.max(Math.max(myDrink[i-1][0], myDrink[i-1][1]), myDrink[i-1][2]);
            myDrink[i][1]=myDrink[i-1][0]+wine[i];
            myDrink[i][2]=myDrink[i-1][1]+wine[i];
        }
        System.out.println(Math.max(Math.max(myDrink[n-1][0], myDrink[n-1][1]), myDrink[n-1][2]));
    }
}
