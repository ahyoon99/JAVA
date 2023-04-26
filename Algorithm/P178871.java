package Algorithm;

import java.util.*;

public class P178871 {
    static public void main(String args[]){
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String[] result = solution(players,callings);

        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }

    static public String[] solution(String[] players, String[] callings) {
        
        HashMap<String, Integer> order = new HashMap<>();
        for(int i=0;i<players.length;i++){
            order.put(players[i], i);
        }
        
        for(int i=0;i<callings.length;i++){
            String winner = callings[i];
            int loserRank = order.get(winner);
            int winnerRank = loserRank-1;
            String loser = players[winnerRank];
            
            swap(players, loserRank, winnerRank);
            order.put(winner, winnerRank);
            order.put(loser, loserRank);
        }
        return players;
    }
    
    static public void swap(String[] array, int i, int j){
        String temp = array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
