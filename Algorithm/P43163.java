package Algorithm;

import java.util.*;

public class P43163 {
    static class Word{
        String word;
        int idx;
        
        Word(String word, int idx){
            this.word=word;
            this.idx=idx;
        }
    }

    static public void main(String args[]){
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        int result = solution(begin, target, words);
        System.out.println(result);
    }

    static public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        int answerIdx=-1;
        for(int i=0;i<words.length;i++){
            if(target.equals(words[i])){
                answerIdx=i;
                break;
            }
        }
        if(answerIdx==-1){
            return 0;
        }
        
        boolean[] visited = new boolean[words.length+1];
        int[] depth = new int[words.length+1];
        bfs(begin, target, words, visited, depth);
        answer = depth[answerIdx];
        
        return answer;
    }
    
    static public void bfs(String begin, String target, String[] words, boolean[] visited, int[] depth){
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(begin, words.length));
        visited[words.length]=true;
        depth[words.length]=0;
        
        while(!q.isEmpty()){
            Word com = q.poll();
            String comWord=com.word;
            int comIdx=com.idx;
            
            for(int i=0;i<words.length;i++){
                if(visited[i]){
                    continue;
                }
                int diffCnt=0;
                for(int j=0;j<words[i].length();j++){
                    if(comWord.charAt(j)!=words[i].charAt(j)){
                        diffCnt++;
                    }
                }
                if(diffCnt==1){
                    q.add(new Word(words[i],i));
                    visited[i]=true;
                    depth[i]=depth[comIdx]+1;
                }
            }
        }
    }
}
