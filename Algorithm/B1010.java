package Algorithm;

import java.math.BigInteger;
import java.util.*;

public class B1010 {
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int testcase=0;testcase<t;testcase++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            BigInteger result = new BigInteger("1");

            for(long i=n+1;i<=m;i++){
                BigInteger temp = BigInteger.valueOf(i);
                result = result.multiply(temp);
            }

            for(long i=1;i<=(m-n);i++){
                BigInteger temp = BigInteger.valueOf(i);
                result = result.divide(temp);
            }
            
            System.out.println(result);
        }
    }
}
