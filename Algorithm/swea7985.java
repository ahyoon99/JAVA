package Algorithm;

import java.util.*;
import java.io.*;

public class swea7985 {
    static int t;
    static int k;
    static int n;
    static Integer[] num;
    static Queue<Integer[]> nums;
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        t = Integer.parseInt(st.nextToken());
        for(int testcase=1;testcase<=t;testcase++){
            System.out.print("#"+testcase+" ");
            input(br, st);
            solution();
        }
    }

    static void solution(){
        Queue<Integer[]> temp;
        for(int i=0;i<k;i++){
            temp = new LinkedList<Integer[]>();
            while(true){
                if(nums.isEmpty()){
                    break;
                }
                Integer[] top = nums.poll();
                int mid = top.length/2;
                System.out.print(top[mid]+" ");
                
                Integer[] left = new Integer[mid];
                Integer[] right = new Integer[mid];

                for(int j=0;j<mid;j++){
                    left[j]=top[j];
                }
                for(int j=0;j<mid;j++){
                    right[j] = top[j+mid+1];
                }
                temp.add(left);
                temp.add(right);
            }
            System.out.println();
            for(Integer[] tempArr : temp){
                nums.add(tempArr);
            }
        }
        
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        k = Integer.parseInt(st.nextToken());
        n = (int)Math.pow(2, k) -1;

        String[] str = br.readLine().split(" ");
        num = new Integer[n];

        for(int i=0;i<str.length;i++){
            num[i] = Integer.parseInt(str[i]);
        }
        nums = new LinkedList<Integer[]>();
        nums.add(num);
    }
}
