package Algorithm;

import java.util.*;
import java.io.*;

public class B15686 {
    static int n;
    static int m;
    static int[][] matrix;
    static ArrayList<Node> chickens;
    static ArrayList<Node> homes;
    static int[] arr;
    
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        input();

        int answer = 0;
        if(chickens.size()==m){
            for(int i=0;i<homes.size();i++){
                Node home = homes.get(i);
                int distance=Integer.MAX_VALUE;
                for(int j=0;j<chickens.size();j++){
                    Node chicken = chickens.get(j);
                    int calculateDist = calculateDistance(home.x, home.y, chicken.x, chicken.y);
                    if(distance>calculateDist){
                        distance = calculateDist;
                    }
                }
                answer+=distance;
            }
            System.out.println(answer);
            return;
        }
        else{
            arr = new int[chickens.size()];
            Arrays.fill(arr, 1);
            for(int i=0;i<chickens.size()-m;i++){
                arr[i]=0;
            }
    
            int minValue = Integer.MAX_VALUE;
            do{
                answer=0;
                for(int i=0;i<homes.size();i++){
                    Node home = homes.get(i);
                    int distance=Integer.MAX_VALUE;
                    for(int j=0;j<chickens.size();j++){
                        if(arr[j]==0){
                            continue;
                        }
                        Node chicken = chickens.get(j);
                        int calculateDist = calculateDistance(home.x, home.y, chicken.x, chicken.y);
                        if(distance>calculateDist){
                            distance = calculateDist;
                        }
                    }
                    answer+=distance;
                }
                if(minValue>answer){
                    minValue = answer;
                }
            }
            while(next_permutation(arr, arr.length));

            System.out.println(minValue);
            return;
        }
    }

    static boolean next_permutation(int[] arr, int len){
        int i = len-1;
        while(i>0 && arr[i-1]>=arr[i]){
            i--;
        }
        if(i<=0){
            return false;
        }

        int j=len-1;
        while(arr[j]<=arr[i-1]){
            j--;
        }
        swap(arr, i-1, j);
        
        j=len-1;
        while(i<j){
            swap(arr, i, j);
            i++;
            j--;
        }
        return true;
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]=temp;
    }

    static int calculateDistance(int x1, int y1, int x2, int y2){
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][n];
        homes = new ArrayList<Node>();
        chickens = new ArrayList<Node>();
        

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                matrix[i][j]=Integer.parseInt(st.nextToken());
                if(matrix[i][j]==1){
                    homes.add(new Node(i,j));
                }
                else if(matrix[i][j]==2){
                    chickens.add(new Node(i,j));
                }
            }
        }

    }
}
