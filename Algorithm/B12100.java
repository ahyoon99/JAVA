package Algorithm;

import java.util.*;
import java.io.*;

public class B12100 {
    static int n;
    static int[][] matrix;
    static ArrayList<Integer> before;
    static ArrayList<Integer> after;
    static int answer;
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        input();

        int[] result = new int[5];
        findOrder(result, 0);
        System.out.println(answer);
    }

    static void findOrder(int[] result, int idx){
        if(idx>=result.length){

            int[][] arr = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=matrix[i][j];
                }
            }

            for(int i=0;i<result.length;i++){
                if(result[i]==0){
                    goUp(arr);
                }
                else if(result[i]==1){
                    goDown(arr);
                }
                else if(result[i]==2){
                    goLeft(arr);
                }
                else if(result[i]==3){
                    goRight(arr);
                }
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(arr[i][j]>answer){
                        answer = arr[i][j];
                    }
                }
            }
            return;
        }
        
        for(int i=0;i<4;i++){
            result[idx]=i;
            findOrder(result, idx+1);
        }
    }

    static void calculate(ArrayList<Integer> before, ArrayList<Integer> after){
        if(before.size()==0){

        }
        else if(before.size()==1){
            after.add(before.get(0));
        }
        else{
            for(int i=0;i<before.size();i++){
                if(i==before.size()-1){
                    after.add(before.get(i));
                    break;
                }
                if(before.get(i).equals(before.get(i+1))){
                    after.add(before.get(i)+before.get(i+1));
                    i++;
                }
                else{
                    after.add(before.get(i));
                }
            }
        }
    }

    static void goUp(int[][] arr){
        for(int i=0;i<n;i++){
            before = new ArrayList<Integer>();
            after = new ArrayList<Integer>();

            for(int j=0;j<n;j++){
                if(arr[j][i]!=0){
                    before.add(arr[j][i]);
                }
            }

            calculate(before, after);
            
            int[] temp = new int[n];
            for(int j=0;j<after.size();j++){
                temp[j] = after.get(j);
            }

            for(int j=0;j<n;j++){
                arr[j][i]=temp[j];
            }
        } 
    }

    static void goDown(int[][] arr){
        for(int i=0;i<n;i++){
            before = new ArrayList<Integer>();
            after = new ArrayList<Integer>();

            for(int j=n-1;j>=0;j--){
                if(arr[j][i]!=0){
                    before.add(arr[j][i]);
                }
            }

            calculate(before, after);
            
            int[] temp = new int[n];
            for(int j=0;j<after.size();j++){
                temp[n-j-1] = after.get(j);
            }

            for(int j=0;j<n;j++){
                arr[j][i]=temp[j];
            }
        }
    }

    static void goLeft(int[][] arr){
        for(int i=0;i<n;i++){
            before = new ArrayList<Integer>();
            after = new ArrayList<Integer>();

            for(int j=0;j<n;j++){
                if(arr[i][j]!=0){
                    before.add(arr[i][j]);
                }
            }

            calculate(before, after);
            
            int[] temp = new int[n];
            for(int j=0;j<after.size();j++){
                temp[j] = after.get(j);
            }

            for(int j=0;j<n;j++){
                arr[i][j]=temp[j];
            }
        }
    }

    static void goRight(int[][] arr){
        for(int i=0;i<n;i++){
            before = new ArrayList<Integer>();
            after = new ArrayList<Integer>();

            for(int j=n-1;j>=0;j--){
                if(arr[i][j]!=0){
                    before.add(arr[i][j]);
                }
            }

            calculate(before, after);
            
            int[] temp = new int[n];
            for(int j=0;j<after.size();j++){
                temp[n-j-1] = after.get(j);
            }

            for(int j=0;j<n;j++){
                arr[i][j]=temp[j];
            }
        }
    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        
        matrix = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<n;j++){
                matrix[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        before = new ArrayList<Integer>();
        after = new ArrayList<Integer>();

        answer = Integer.MIN_VALUE;
    }
}
