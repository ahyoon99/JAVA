package Algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;

public class B10971 {

    // 방법1 : 순열
    // public static boolean next_permutation(int[] arr, int n){
        
    //     int i=n-1;
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
    //     arr[i-1]=arr[j];
    //     arr[j]=temp;

    //     Arrays.sort(arr, i,n);
        
    //     return true;
    // }
    // public static void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int[][] price = new int[n][n];
    //     int[] city = new int[n];

    //     for(int i=0;i<n;i++){
    //         city[i]=i;
    //     }

    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<n;j++){
    //             price[i][j]=sc.nextInt();
    //         }
    //     }

    //     int min = 100000000;
    //     do{
    //         int result=0;
    //         boolean check=true;
    //         boolean exist = true;
    //         int i=0;
    //         while(check){
    //             if(i>=n-1){
    //                 check=false;
    //                 break;
    //             }
    //             if(price[city[i]][city[i+1]]==0){
    //                 exist = false;
    //                 break;
    //             }
    //             else{
    //                 result+=price[city[i]][city[i+1]];
    //             }
    //             i++;
    //         }
    //         result+=price[city[n-1]][city[0]];
    //         if(exist==true && price[city[n-1]][city[0]]!=0 && min>result){
    //             min=result;
    //         }
    //     }while(next_permutation(city, n));

    //     System.out.println(min);

    // }
    
    // 방법 2 : DFS
    static StringBuilder sb = new StringBuilder();
	static int min = Integer.MAX_VALUE;
	static int n;

    static public void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
	
		int[][] ground = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<n;j++) {
				ground[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			boolean[] visited = new boolean[n];
			visited[i]=true;
			DFS(ground,i, i, visited,0,1);
			visited[i]=false;
		}
		
		System.out.println(min);
	}
	
	static public void DFS(int[][] ground, int startPoint, int x, boolean[] visited, int dist, int cnt) {
		// 다 돌았을 경우
		if(cnt==n) {
			if(ground[x][startPoint]!=0) {
				dist+=ground[x][startPoint];
				if(min>dist) {
					min=dist;
				}
			}
			return;
		}
			
		for(int i=0;i<ground[x].length;i++) {
			if(ground[x][i]!=0 && visited[i]==false) {
				visited[i]=true;
				DFS(ground, startPoint, i, visited, dist+ground[x][i], cnt+1);
				visited[i]=false;
			}
		}
	}
}
