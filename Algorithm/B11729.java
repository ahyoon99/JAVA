package Algorithm;

import java.util.*;

public class B11729 {

    static StringBuilder sb = new StringBuilder();

    static int countStick(int n){
        return (n==1) ? 1 : (countStick(n-1)*2)+1;
    }

    static void printStickLog(int n, int from, int mid, int to){
        if(n==1){
            sb.append(from+" "+to);
            sb.append('\n');
            return;
        }
        // step1
        printStickLog(n-1, from, to, mid);

        // step2
        sb.append(from+" "+to);
        sb.append('\n');

        // step3
        printStickLog(n-1, mid, from, to);
    }

    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countStick(n));
        printStickLog(n,1,2,3);
        System.out.println(sb);
    }
}
