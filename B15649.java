import java.util.Scanner;

public class B15649 {
    public static void go(boolean[] check, int[] ans, int index, int n, int m){
        if(index == m){
            for(int i=0;i<m;i++){
                System.out.print(ans[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=1;i<=n;i++){
            if(check[i]==true){
                continue;
            }
            else{
                ans[index]=i;
                check[i]=true;
                go(check, ans, index+1, n,m);
                check[i]=false;
            }
        }

    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] check = new boolean[n+1];

        int[] arr = new int[n];
        go(check, arr, 0,n,m);
    }                     
}
