package Algorithm;

import java.util.*;

public class P77485 {
    static public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];
        int number=1;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                map[i][j]=number;
                number++;
            }
        }
        
        for(int t=0;t<queries.length;t++){
            int x1 = queries[t][0]-1;
            int y1 = queries[t][1]-1;
            int x2 = queries[t][2]-1;
            int y2 = queries[t][3]-1;
            
            int min=100000;
            ArrayList<Integer> list = new ArrayList<>();
            
            // part 1
            for(int i=y1;i<=y2;i++){
                list.add(map[x1][i]);
                if(min>map[x1][i]){
                    min = map[x1][i];
                }
            }
            for(int i=x1+1;i<=x2;i++){
                list.add(map[i][y2]);
                if(min>map[i][y2]){
                    min = map[i][y2];
                }
            }
            for(int i=y2-1;i>=y1;i--){
                list.add(map[x2][i]);
                if(min>map[x2][i]){
                    min = map[x2][i];
                }
            }
            for(int i=x2-1;i>=x1+1;i--){
                list.add(map[i][y1]);
                if(min>map[i][y1]){
                    min = map[i][y1];
                }
            }
            list.add(0,list.get(list.size()-1));
            list.remove(list.size()-1);
            answer[t]=min;
            
            // part 2
            int cnt = 0;
            for(int i=y1;i<=y2;i++){
                map[x1][i] = list.get(cnt);
                cnt++;
            }
            for(int i=x1+1;i<=x2;i++){
                map[i][y2] = list.get(cnt);
                cnt++;
            }
            for(int i=y2-1;i>=y1;i--){
                map[x2][i] = list.get(cnt);
                cnt++;
            }
            for(int i=x2-1;i>=x1+1;i--){
                map[i][y1] = list.get(cnt);
                cnt++;
            }
        }
        return answer;
    }
    static public void main(String args[]){
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4},
                        {3,3,6,6},
                        {5,1,6,3}};
        int[] result = solution(rows, columns, queries);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }
}
