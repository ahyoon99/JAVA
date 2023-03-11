package Algorithm;

import java.util.*;

public class B16953 {

    static long result=-1;
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        go(a,b,1);
        System.out.println(result);
    }

    static void go(long a, long b, long cnt){
        if(a>b){
            return;
        }
        else if(a==b){
            result=cnt;
        }
        go(cal1(a),b, cnt+1);
        go(cal2(a),b, cnt+1);
    }
    
    static long cal1(long num){
        return num*2;
    }

    static long cal2(long num){
        return (num*10 + 1);
    }
}
