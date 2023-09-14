package Algorithm;

import java.util.*;
import java.io.*;

public class B12845 {
    static public void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int[] cards = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            cards[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);
        int gold = (n-1)*(cards[n-1]);
        for(int i=0;i<n-1;i++){
            gold+=cards[i];
        }
        System.out.println(gold);
    }
}
