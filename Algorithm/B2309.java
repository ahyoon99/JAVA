package Algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class B2309 {

    // 방법 1 : 2중 for문
    // public static void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int[] people = new int[9];
    //     int total = 0;
    //     for(int i=0;i<9;i++){
    //         int a = sc.nextInt();
    //         people[i] = a;
    //         total+=a;
    //     }
    //     Arrays.sort(people);

    //     int sum=0;
    //     for(int i=0;i<8;i++){
    //         for(int j=i+1;j<9;j++){
    //             sum=total-people[i]-people[j];
    //             if(sum==100){
    //                 for(int k=0;k<9;k++){
    //                     if(k==i || k==j){
    //                         continue;
    //                     }
    //                     else{
    //                         System.out.println(people[k]);
    //                     }
    //                 }
    //                 return;
    //             }
    //         }
    //     }
    // }

    // 방법 2 : 조합 (백트래킹)
    static boolean isFinish = false;
    static void combination(int[] height, boolean[] check, int start, int r, int total){
        if(isFinish){
            return;
        }
        if(r==0){
            if(total==100){
                for(int i=0;i<9;i++){
                    if(check[i]==false){
                        System.out.println(height[i]);
                    }
                }
                isFinish = true;
            }
            return ;
        }
        for(int i=start;i<9;i++){
            check[i]=true;
            combination(height, check, i+1, r-1, total-height[i]);
            check[i]=false;
        }
        return ;
    }

    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int[] height = new int[9];
        boolean[] check = new boolean[9];

        int total = 0;
        for(int i=0;i<9;i++){
            height [i]=sc.nextInt();
            total+=height[i];
        }

        Arrays.sort(height);
        Arrays.fill(check, false);

        combination(height, check, 0, 2, total);
    }
}
