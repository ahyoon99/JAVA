package Algorithm;

import java.util.*;
import java.io.*;

public class H233376 {
    static class Person{
        int id;
        int score;

        Person(){};
        Person(int id, int score){
            this.id=id;
            this.score=score;
        }; 
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();

        int[][] score = new int[4][n];
        for(int i=0;i<3;i++){
            for(int j=0;j<n;j++){
                score[i][j]=sc.nextInt();
            }
        }

        for(int i=0;i<n;i++){
            score[3][i] = score[0][i]+score[1][i]+score[2][i];
        }

        ArrayList<Person> testScore;
        for(int i=0;i<4;i++){
            testScore = new ArrayList<>();
            for(int j=0;j<n;j++){
                testScore.add(new Person(j,score[i][j]));
            }

            testScore.sort((s1, s2) -> {
                return s2.score - s1.score;
            });

            int idx=1;
            int[] rank = new int[n];
            rank[testScore.get(0).id]=1;
            for(int j=1;j<n;j++){
                if(testScore.get(j-1).score > testScore.get(j).score){
                    rank[testScore.get(j).id]= idx + 1;
                    idx++;
                }
                else if(testScore.get(j-1).score == testScore.get(j).score){
                    rank[testScore.get(j).id]= rank[testScore.get(j-1).id];
                    idx++;
                }
            }
            for(int j=0;j<n;j++){
                sb.append(rank[j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
