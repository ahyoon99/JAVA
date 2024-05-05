package Algorithm;

import java.util.*;
import java.io.*;

public class swea1244 {
    static String numStr;
    static int[] numbers;
    static int cnt;
    static int max;
    static HashMap<Integer, HashSet<Integer>> check;

    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());

        for(int tc = 0;tc<T;tc++){
            System.out.print("#"+(tc+1)+" ");
            solution(br, st);
        }
    }

    static void solution(BufferedReader br, StringTokenizer st) throws IOException{
        input(br, st);
        
        for(int i=0;i<numStr.length();i++){
            numbers[i] = numStr.charAt(i)-'0';
        }

        for(int i=0;i<=cnt;i++){
            check.put(i, new HashSet<Integer>());
        }

        go(0);

        System.out.println(max);
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        numStr = st.nextToken();
        cnt = Integer.parseInt(st.nextToken());

        numbers = new int[numStr.length()];
        max = Integer.MIN_VALUE;

        check = new HashMap<Integer, HashSet<Integer>>();
    }

    static void go(int n){
        if(n==cnt){
            max = Math.max(max, arrToInt(numbers));
            return;
        }

        for(int i=0;i<numStr.length()-1;i++){
            for(int j=i+1;j<numStr.length();j++){
                swap(numbers, i,j);
                
                HashSet<Integer> isFinish = check.get(n+1);
                int curNum = arrToInt(numbers);
                if(!isFinish.contains(curNum)){
                    go(n+1);
                    isFinish.add(curNum);
                    check.put(n+1, isFinish);
                }

                swap(numbers, i, j);
            }
        }
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    static int arrToInt(int[] arr){
        String arrToStr = "";
        for(int i=0;i<arr.length;i++){
            arrToStr += String.valueOf(arr[i]);
        }

        int strToInt = Integer.parseInt(arrToStr);
        return strToInt;
    }
}
