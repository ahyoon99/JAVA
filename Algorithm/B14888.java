package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B14888 {

    // 1. 순열 사용
    // public static boolean next_permutation(int[] arr, int n){
    //     int i = n-1;
    //     while(i>0 && arr[i-1]>=arr[i]){
    //         i--;
    //     }
    //     if(i==0){
    //         return false;
    //     }
    //     int j=n-1;
    //     while(j>0 && arr[i-1]>=arr[j]){
    //         j--;
    //     }

    //     int temp = arr[i-1];
    //     arr[i-1] = arr[j];
    //     arr[j]=temp;

    //     Arrays.sort(arr, i, n);

    //     return true;
    // }
    // public static void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int[] num = new int[n];
    //     int[] op = new int[n-1];
    //     for(int i=0;i<n;i++){
    //         num[i] = sc.nextInt();
    //     }

    //     int cnt=0;
    //     for(int i=0;i<4;i++){
    //         int op_cnt = sc.nextInt();
    //         for(int j=0;j<op_cnt;j++){
    //             op[cnt]=i;
    //             cnt++;
    //         }
    //     }

    //     int min = 1000000001;
    //     int max = -1000000001;
    //     do{
    //         int result=num[0];
    //         for(int i=0;i<n-1;i++){
    //             if(op[i]==0){
    //                 result+=num[i+1];
    //             }
    //             else if(op[i]==1){
    //                 result-=num[i+1];
    //             }else if(op[i]==2){
    //                 result*=num[i+1];
    //             }else if(op[i]==3){
    //                 result/=num[i+1];
    //             }
    //         }
    //         if(result<min){
    //             min=result;
    //         }
    //         if(result>max){
    //             max=result;
    //         }
    //     }while(next_permutation(op, n-1));
        
    //     System.out.println(max);
    //     System.out.println(min);
    // }

    // 2. 재귀 사용

    static ArrayList<Pair> arr = new ArrayList<>();

    static class Pair{
        public int max;
        public int min;

        Pair(int min, int max){
            this.min=min;
            this.max=max;
        }
    }

    // num : 입력으로 주어진 수열
    // index : 현재 계산해야하는 인덱스
    // cur : index-1번째까지 계산한 결과
    static Pair go(int[] num, int index, int cur, int plus, int minus, int mul, int div){
        if(index==num.length){
            return new Pair(cur,cur);
        }
        if(plus>0){
            arr.add(go(num,index+1,cur+num[index],plus-1, minus, mul,div));
        }
        if(minus>0){
            arr.add(go(num,index+1,cur-num[index],plus, minus-1, mul,div));
        }
        if(mul>0){
            arr.add(go(num,index+1,cur*num[index],plus, minus, mul-1,div));
        }
        if(div>0){
            arr.add(go(num,index+1,cur/num[index],plus, minus, mul,div-1));
        }

        Pair ans = arr.get(0);
        for(Pair p : arr){
            if(ans.max < p.max){
                ans.max=p.max;
            }
            if(ans.min>p.min){
                ans.min=p.min;
            }
        }
        return ans;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int[] op = new int[4];

        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }
        for(int i=0;i<4;i++){
            op[i]=sc.nextInt();
        }   
        Pair p = go(num, 1, num[0], op[0], op[1], op[2],op[3]);
        System.out.println(p.max);
        System.out.println(p.min);
    }
}
