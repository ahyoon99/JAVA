package Algorithm;

import java.util.Scanner;

public class swea1217 {
    static public void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        for(int testcase=1;testcase<=10;testcase++){
            int n = sc.nextInt();
            System.out.print("#"+n+" ");
            solution(sc);
        }
    }

    static void solution(Scanner sc){
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        System.out.println(go(n1, n2, n1));
    }

    static int go(int n1, int n2, int result){
        if(n2==1){
            return result;
        }
        else{
            return go(n1, n2-1, result*n1);
        }
    }
}
