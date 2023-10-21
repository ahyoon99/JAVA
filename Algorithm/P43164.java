package Algorithm;

import java.util.*;

public class P43164 {
    static ArrayList<String> answer;
    static public void main(String args[]){
        //String[][] tickets = {{"ICN", "JFK"},{"HND", "IAD"},{"JFK", "HND"}};
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

        String[] result = solution(tickets);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }

    static public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        
        boolean[] visited = new boolean[tickets.length];
        dfs(tickets, "ICN", "ICN", visited, 0);
        
        Collections.sort(answer);
        
        String[] result = answer.get(0).split(",");
        
        return result;
    }
    
    static public void dfs(String[][] tickets, String current, String result, boolean[] visited, int cnt){
        if(cnt==tickets.length){
            answer.add(result);
            
            return;
        }
        for(int i=0;i<tickets.length;i++){
            if(visited[i]==false && tickets[i][0].equals(current)){
                visited[i]=true;
                dfs(tickets, tickets[i][1], result+","+tickets[i][1], visited, cnt+1);
                visited[i]=false;
            }
        }
    }
}
