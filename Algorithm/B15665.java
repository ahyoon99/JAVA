package Algorithm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class B15665 {

    // 방법 1
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // public static void go(int[] num, int[] arr, int index, int n, int m) throws IOException{
    //     if(index==m){
    //         for(int i=0;i<m;i++){
    //             //System.out.print(arr[i]+" ");
    //             bw.write(arr[i]+" ");
    //         }
    //         //System.out.println();
    //         bw.write("\n");
    //         return;
    //     }
    //     for(int i=0;i<n;i++){
    //         arr[index]=num[i];
    //         go(num,arr, index+1, n,m);
    //         arr[index]=0;
    //     }
    // }
    // public static void main(String args[]) throws IOException{
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int m = sc.nextInt();
    //     int[] num = new int[n];
    //     for(int i=0;i<n;i++){
    //         num[i]=sc.nextInt();
    //     }
    //     Arrays.sort(num);
    //     int[] after_num = new int[n];
    //     int count=0;
    //     after_num[0]=num[0];
    //     for(int i=1;i<n;i++){
    //         if(num[i-1]==num[i]){
    //             continue;
    //         }
    //         else{
    //             count++;
    //             after_num[count]=num[i];
    //         }
    //     }

    //     int[] arr = new int[m];
    //     go(after_num, arr, 0, count+1, m);
    //     bw.flush();

    //     return;
    // }
    
    // 방법 2
    static StringBuilder sb = new StringBuilder();

    static void go(ArrayList<Integer> num, int[] result, int idx){
        if(idx==result.length){
            for(int i=0;i<result.length;i++){
                sb.append(result[i]+" ");
            }
            sb.append('\n');
            return;
        }
        for(int i=0;i<num.size();i++){
            result[idx]=num.get(i);
            go(num,result,idx+1);
        }
    }
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        ArrayList<Integer> num = new ArrayList<>();
        int[] numCnt = new int[10001];
        for(int i=0;i<n;i++){
            int temp = sc.nextInt();
            if(numCnt[temp]==0){
                num.add(temp);
            }
            numCnt[temp]++;
        }
        Collections.sort(num);

        int[] result = new int[m];
        go(num, result, 0);
        System.out.println(sb);
    }
}
