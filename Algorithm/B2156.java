package Algorithm;

import java.util.*;

public class B2156 {
    // 방법 1 (Bottom-up)
    // static public void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int[] wine = new int[n];
    //     for(int i=0;i<n;i++){
    //         wine[i]=sc.nextInt();
    //     }
    //     int[][] myDrink = new int[n][3];
    //     myDrink[0][0]=0;
    //     myDrink[0][1]=wine[0];
    //     myDrink[0][2]=0;
    //     for(int i=1;i<n;i++){
    //         myDrink[i][0]=Math.max(Math.max(myDrink[i-1][0], myDrink[i-1][1]), myDrink[i-1][2]);
    //         myDrink[i][1]=myDrink[i-1][0]+wine[i];
    //         myDrink[i][2]=myDrink[i-1][1]+wine[i];
    //     }
    //     System.out.println(Math.max(Math.max(myDrink[n-1][0], myDrink[n-1][1]), myDrink[n-1][2]));
    // }

    // 방법 2 (Top-down)
    static int go(int n, int x, int[] wine, int[][] answer){
        if(answer[n][x]!=-1){
            return answer[n][x];
        }
        if(x==0){
            answer[n][x] = Math.max(Math.max(go(n-1,0,wine, answer), go(n-1,1,wine, answer)), go(n-1,2,wine,answer));
            return answer[n][x];
        }
        if(x==1){
            answer[n][x] = go(n-1,0,wine,answer)+wine[n];
            return answer[n][x];
        }
        if(x==2){
            answer[n][x] = go(n-1,1,wine,answer)+wine[n];
            return answer[n][x];
        }
        return answer[n][x];
    }
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] wine = new int[n+1];
        int[][] answer = new int[n+1][3];
        for(int i=1;i<=n;i++){
            wine[i]=sc.nextInt();
        }
        for(int i=0;i<=n;i++){
            Arrays.fill(answer[i],-1);
        }

        answer[1][0]=0;
        answer[1][1]=wine[1];
        answer[1][2]=0;

        for(int i=0;i<3;i++){
            go(n,i,wine, answer);
        }
        System.out.println(Math.max(Math.max(answer[n][0], answer[n][1]), answer[n][2]));
    }
}
