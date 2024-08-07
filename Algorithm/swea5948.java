package Algorithm;

import java.util.*;
import java.io.*;

public class swea5948 {
    static int t;
    static int n;
    static int[] num;
    static HashSet<Integer> result;
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
        int[] pickNum = new int[3];

        go(pickNum, 0, 0);

        ArrayList<Integer> resultList = new ArrayList<>(result);
        
        Collections.sort(resultList, Collections.reverseOrder());

        System.out.println(resultList.get(4));
    }

    static void go(int[] pickNum, int myIdx, int numIdx){
        if(myIdx>=pickNum.length){
            int sum=0;
            for(int i=0;i<pickNum.length;i++){
                sum+=pickNum[i];
            }
            result.add(sum);
            return;
        }
        for(int i=numIdx;i<n;i++){
            pickNum[myIdx]=num[i];
            go(pickNum, myIdx+1, i+1);
            pickNum[myIdx]=0;
        }
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        n = 7;
        num = new int[n];
        result = new HashSet<Integer>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
    }
}
