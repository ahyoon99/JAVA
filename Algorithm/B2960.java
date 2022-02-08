package Algorithm;
import java.util.Arrays;
import java.util.Scanner;

public class B2960 {

    static boolean myArr[] = new boolean[1001];

    public static int findPrime(int n, int num, int cnt, int k){
        
        myArr[num]=true;
        cnt++;
        
        if(cnt==k){
            return num;
        }
        for(int i=num; num*i <= n; i++) {
            if(myArr[num*i]==false){
                myArr[num*i]=true;
                cnt++;
                if(cnt==k){
                    return num*i;
                }
            }
        }

        int nextNum = 0;
        for(int i=num+1; i<=n; i++){
            if(myArr[i]==false){
                nextNum = i;
                break;
            }
        }

        return findPrime(n,nextNum,cnt,k);
        
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Arrays.fill(myArr,false);

        int cnt=0;
        System.out.println(findPrime(N,2,cnt,K));
    }
    
}