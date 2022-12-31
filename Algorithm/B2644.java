package Algorithm;

import java.util.*;

public class B2644 {
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] relation = new boolean[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(relation[i],false);
        }
        
        int start = sc.nextInt();
        int end = sc.nextInt();

        int m = sc.nextInt();
        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            relation[a][b]=true;
            relation[b][a]=true;
        }

        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[n+1];
        int[] result = new int[n+1];
        Arrays.fill(result, -1);

        st.add(start);
        visited[start]=true;
        result[start]=0;
        while(!st.isEmpty()){
            int top = st.pop();
            for(int i=1;i<=n;i++){
                if(relation[top][i]==true && visited[i]==false){
                    st.add(i);
                    visited[i]=true;
                    result[i]=result[top]+1;
                }
            }
        }
        System.out.println(result[end]);
    }
}
