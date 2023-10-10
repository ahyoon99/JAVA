package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;

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
    // static ArrayList<Pair> arr = new ArrayList<>();

    // static class Pair{
    //     public int max;
    //     public int min;

    //     Pair(int min, int max){
    //         this.min=min;
    //         this.max=max;
    //     }
    // }

    // // num : 입력으로 주어진 수열
    // // index : 현재 계산해야하는 인덱스
    // // cur : index-1번째까지 계산한 결과
    // static Pair go(int[] num, int index, int cur, int plus, int minus, int mul, int div){
    //     if(index==num.length){
    //         return new Pair(cur,cur);
    //     }
    //     if(plus>0){
    //         arr.add(go(num,index+1,cur+num[index],plus-1, minus, mul,div));
    //     }
    //     if(minus>0){
    //         arr.add(go(num,index+1,cur-num[index],plus, minus-1, mul,div));
    //     }
    //     if(mul>0){
    //         arr.add(go(num,index+1,cur*num[index],plus, minus, mul-1,div));
    //     }
    //     if(div>0){
    //         arr.add(go(num,index+1,cur/num[index],plus, minus, mul,div-1));
    //     }

    //     Pair ans = arr.get(0);
    //     for(Pair p : arr){
    //         if(ans.max < p.max){
    //             ans.max=p.max;
    //         }
    //         if(ans.min>p.min){
    //             ans.min=p.min;
    //         }
    //     }
    //     return ans;
    // }

    // public static void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int[] num = new int[n];
    //     int[] op = new int[4];

    //     for(int i=0;i<n;i++){
    //         num[i]=sc.nextInt();
    //     }
    //     for(int i=0;i<4;i++){
    //         op[i]=sc.nextInt();
    //     }   
    //     Pair p = go(num, 1, num[0], op[0], op[1], op[2],op[3]);
    //     System.out.println(p.max);
    //     System.out.println(p.min);
    // }

    // 방법 3 : 재귀
    static int[] num;
	static ArrayList<Integer> opOrder;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	
	
	static public void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		
		num = new int[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		opOrder = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<4;i++) {
			int cnt = Integer.parseInt(st.nextToken());
			for(int j=0;j<cnt;j++) {
				opOrder.add(i);
			}
		}
		
		int[] result = new int[opOrder.size()];
		boolean[] visited = new boolean[opOrder.size()];
		go(result,0,visited);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	static public void go(int[] result, int idx, boolean[] visited) {
		if(idx==opOrder.size()) {
			int answer = cal(result);
			if(answer>max) {
				max=answer;
			}
			if(answer<min) {
				min=answer;
			}
			return;
		}
		for(int i=0;i<opOrder.size();i++) {
			if(visited[i]==false) {
				result[idx]=opOrder.get(i);
				visited[i]=true;
				go(result, idx+1, visited);
				visited[i]=false;
			}
		}
		
	}
	
	static public int cal(int[] result) {
		int answer = num[0];
		for(int i=0;i<result.length;i++) {
			if(result[i]==0) {
				answer+=num[i+1];
			}
			else if(result[i]==1) {
				answer-=num[i+1];
			}
			else if(result[i]==2) {
				answer*=num[i+1];
			}
			else if(result[i]==3) {
				answer/=num[i+1];
			}
		}
		return answer;
	}
}
