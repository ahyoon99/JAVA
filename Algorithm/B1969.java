package Algorithm;

import java.util.*;
import java.io.*;

public class B1969 {
    static public void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] dna = new char[n][m];
        int[][] count = new int[m][4];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            String com = st.nextToken();
            for(int j=0;j<m;j++){
                dna[i][j]=com.charAt(j);
                if(dna[i][j]=='A'){
                    count[j][0]++;
                }
                else if(dna[i][j]=='C'){
                    count[j][1]++;
                }
                else if(dna[i][j]=='G'){
                    count[j][2]++;
                }
                else if(dna[i][j]=='T'){
                    count[j][3]++;
                }
            }
        }

        String answer="";
        int hammingDistance = 0;
        for(int i=0;i<m;i++){
            int maxIdx=-1;
            int max=-1;
            for(int j=0;j<4;j++){
                if(max<count[i][j]){
                    max=count[i][j];
                    maxIdx=j;
                }
            }

            if(maxIdx==0){
                answer+="A";
            }
            else if(maxIdx==1){
                answer+="C";
            }
            else if(maxIdx==2){
                answer+="G";
            }
            else if(maxIdx==3){
                answer+="T";
            }
            hammingDistance+=(n-max);
        }
        System.out.println(answer);
        System.out.println(hammingDistance);
    }
}
