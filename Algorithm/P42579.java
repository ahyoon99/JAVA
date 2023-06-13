package Algorithm;

import java.util.*;

public class P42579 {
    static class Music{
        int idx;
        int plays;
        
        Music(){}
        Music(int idx, int plays){
            this.idx=idx;
            this.plays=plays;
        }
    }

    static public void main(String args[]){
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        ArrayList<Integer> result = solution(genres, plays);
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }
    
    static public ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, ArrayList<Music>> hm = new HashMap<>();
        
        // HashMap에 데이터 넣기
        for(int i=0;i<genres.length;i++){
            ArrayList<Music> musics;
            if(hm.containsKey(genres[i])){
                musics = hm.get(genres[i]);
            }
            else{
                musics = new ArrayList<>();
            }
            musics.add(new Music(i, plays[i]));
            hm.put(genres[i], musics);
        }
        
        // HashMap의 Key를 정렬 << 속한 노래가 많이 재생된 장르 순으로
        ArrayList<String> entries = new ArrayList<>(hm.keySet());
        
        Collections.sort(entries, (o1, o2) -> {
            ArrayList<Music> m1 = hm.get(o1);
            int total1 = 0;
            for(int i=0;i<m1.size();i++){
                total1 += m1.get(i).plays;
            }
            
            ArrayList<Music> m2 = hm.get(o2);
            int total2 = 0;
            for(int i=0;i<m2.size();i++){
                total2 = total2 + m2.get(i).plays;
            }
            return total2-total1;
        });
        
        // 각 장르별로 담긴 ArrayList<Music>을, plays 기준으로, 큰 순으로 정렬하기
        for(String entry : entries){
            ArrayList<Music> m = hm.get(entry);
            
            Collections.sort(m, (o1, o2) -> {
                    return o2.plays - o1.plays;
            });
            
            hm.put(entry, m);
        }
        
        // 장르 내에서 가장 많이 재생된 노래 2개(or 1개) 출력
        for(String entry : entries){
            ArrayList<Music> m = hm.get(entry);
            if(m.size()>=2){
                for(int i=0;i<2;i++){
                    Music mu = m.get(i);
                    answer.add(mu.idx);
                }   
            }
            else{
                Music mu = m.get(0);
                answer.add(mu.idx);
            }
        }
        return answer;
    }
}
