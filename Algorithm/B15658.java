package Algorithm;

import java.util.Scanner;

public class B15658 {

    public static class Pair{
        private int max;
        private int min;

        Pair(int m1, int m2){
            max = m1;
            min = m2;
        }
    }

    static int n;
    static Pair p = new Pair(-1000000001, 1000000001);

    // a : 입력으로 주어진 수열
    // index : 현재 계산해야 하는 인덱스
    // cur : index-1번째 까지 계산한 결과  
    public static void go(int[] num, int index, int cur, int plus, int minus, int mul, int div){
        if(index==n){
            if(cur>p.max){
                p.max=cur;
            }
            if(cur<p.min){
                p.min=cur;
            }
            return ;
        }
        if(plus>0){
            go(num, index+1, cur+num[index], plus-1, minus, mul, div);
        }
        if(minus>0){
            go(num, index+1, cur-num[index], plus, minus-1, mul, div);
        }
        if(mul>0){
            go(num, index+1, cur*num[index], plus, minus, mul-1, div);
        }
        if(div>0){
            go(num, index+1, cur/num[index], plus, minus, mul, div-1);
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] num = new int[n];
        int[] op = new int[4];

        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }
        for(int i=0;i<4;i++){
            op[i]=sc.nextInt();
        }

        go(num, 1, num[0], op[0], op[1], op[2], op[3]);
        System.out.println(p.max);
        System.out.println(p.min);
    }
    
}