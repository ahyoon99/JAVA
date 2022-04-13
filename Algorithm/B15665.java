package Algorithm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class B15665 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void go(int[] num, int[] arr, int index, int n, int m) throws IOException{
        if(index==m){
            for(int i=0;i<m;i++){
                //System.out.print(arr[i]+" ");
                bw.write(arr[i]+" ");
            }
            //System.out.println();
            bw.write("\n");
            return;
        }
        for(int i=0;i<n;i++){
            arr[index]=num[i];
            go(num,arr, index+1, n,m);
            arr[index]=0;
        }
    }
    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] num = new int[n];
        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }
        Arrays.sort(num);
        int[] after_num = new int[n];
        int count=0;
        after_num[0]=num[0];
        for(int i=1;i<n;i++){
            if(num[i-1]==num[i]){
                continue;
            }
            else{
                count++;
                after_num[count]=num[i];
            }
        }

        int[] arr = new int[m];
        go(after_num, arr, 0, count+1, m);
        bw.flush();

        return;
    }
    
}
