package Algorithm;

import java.util.*;
import java.io.*;

public class B1963 {
    static int t;
    static int n = 10000;
    static int before;
    static int after;

    static boolean[] prime;
    static int result;
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        t = Integer.parseInt(st.nextToken());

        prime = new boolean[n];
        isPrime();

        for(int testcase=0;testcase<t;testcase++){
            input(br, st);
            
            if(before==after){
                System.out.println(result);
            }
            else{
                result = bfs();
                if(result==-1){
                    System.out.println("Impossible");
                }
                else{
                    System.out.println(result);
                }
            }
        }
    }

    static int bfs(){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int[] count = new int[n];
        Arrays.fill(count, -1);

        q.add(before);
        visited[before]=true;
        count[before]=0;

        while(!q.isEmpty()){
            int num = q.poll();
            for(int i=0;i<4;i++){
                for(int j=0;j<=9;j++){
                    if(i==0 && j==0){
                        continue;
                    }
                    int next = swap(num,i,j);
                    if(prime[next]==false && visited[next]==false){
                        visited[next]=true;
                        count[next]=count[num]+1;
                        q.add(next);
                    }
                }
            }
        }
        return count[after];
    }

    static int swap(int num, int idx, int afterNum){
        int[] beforeArr = new int[4];
        String beforeStr = String.valueOf(num);

        for(int i=0;i<beforeStr.length();i++){
            beforeArr[i] = beforeStr.charAt(i)-'0';
        }
        
        beforeArr[idx]=afterNum;

        String afterStr = "";
        for(int i=0;i<beforeArr.length;i++){
            afterStr+=String.valueOf(beforeArr[i]);
        }

        return Integer.parseInt(afterStr);
    }

    static void isPrime(){
        prime[0]=true;
        prime[1]=true;
        for(int i=2;i<n;i++){
            if(!prime[i]){
                for(int j=i+i;j<n;j+=i){
                    prime[j]=true;
                }
            }
        }
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        before = Integer.parseInt(st.nextToken());
        after = Integer.parseInt(st.nextToken());
        
        result = 0;
    }
}
