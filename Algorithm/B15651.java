package Algorithm;

import java.util.Scanner;

public class B15651 {

    static int[] num = new int[10];

    public static StringBuilder go(int index, int n, int m){
        if(m<=index){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<m;i++){
                sb.append(num[i]);
                if(i != m-1){
                    sb.append(" ");
                }
            }
            sb.append("\n");
            return sb;
        }

        StringBuilder ans = new StringBuilder();
        for(int i=0;i<n;i++){
            num[index]=i+1;
            ans.append(go(index+1, n,m));
        }
        return ans;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(go(0,n,m));
    }
}
