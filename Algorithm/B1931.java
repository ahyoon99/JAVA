package Algorithm;

import java.util.*;

public class B1931 {
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[][] conference = new int[n][2];

        for(int i=0;i<n;i++){
            conference[i][0]=sc.nextInt();
            conference[i][1]=sc.nextInt();
        }

        Arrays.sort(conference, (o1, o2) -> {
            if(o1[1]==o2[1]){
                return o1[0]-o2[0];
            }
            return o1[1]-o2[1];
        });
        
        int answer = 1;
        int end=conference[0][1];
        for(int i=1;i<n;i++){
            if(end<=conference[i][0]){
                answer++;
                end=conference[i][1];
            }
        }
        System.out.println(answer);
    }
}
