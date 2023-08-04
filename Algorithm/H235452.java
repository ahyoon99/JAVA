package Algorithm;

import java.util.*;
import java.io.*;

/* 입력예제1
20 2
HHHHHPPPPPHPHPHPHHHP
*/
public class H235452 {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        String com = st.nextToken();
        int[] belt = new int[com.length()];
        for(int i=0;i<com.length();i++){
            if(com.charAt(i) == 'H'){
                belt[i]=1;
            }
            else if(com.charAt(i) == 'R'){
                belt[i]=0;
            }
        }

        int[] dx = new int[2*k];
        for(int i=0;i<k;i++){
            dx[i]=(i+1);
            dx[i+k]=(i+1)*(-1);
        }

        Arrays.sort(dx);

        int answer = 0;
        for(int i=0;i<belt.length;i++){
            if(belt[i]==0){
                for(int j=0;j<2*k;j++){
                    int nx = i+dx[j];
                    if(nx>=0 && nx<belt.length){
                        if(belt[nx]==1){
                            answer++;
                            belt[nx]=-1;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
