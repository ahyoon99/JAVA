package Algorithm;

import java.util.*;
import java.util.Map.*;

public class P72412 {
    static HashMap<String, ArrayList<Integer>> answerList = new HashMap<>();
    
    static void go(String[] splitInfo, int idx, String result, int score){
        if(idx==splitInfo.length-2){
            //finish
            ArrayList<Integer> hashMapList;
            if(answerList.containsKey(result)){
                hashMapList = answerList.get(result);
                hashMapList.add(score);
                answerList.put(result, hashMapList);
            }
            else{
                hashMapList = new ArrayList<>();
                hashMapList.add(score);
                answerList.put(result, hashMapList);
            }
            return;
        }
        if(idx>splitInfo.length-2){   // out of range
            return;
        }
        go(splitInfo, idx+1, result+splitInfo[idx+1], score);
        go(splitInfo, idx+1, result+"-", score);
    }
    
    static int binarySearch(ArrayList<Integer> list, int find, int left, int right){
        while(left<=right){
            int mid = (left+right)/2;
            if(list.get(mid)>=find){
                right = mid-1;
            }
            else if(list.get(mid)<find){
                left = mid+1;
            }
        }
        return list.size()-left;
    }
    
    static public ArrayList<Integer> solution(String[] info, String[] query) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i=0;i<info.length;i++){
            String[] splitInfo = info[i].split(" ");
            int score = Integer.parseInt(splitInfo[4]);
            go(splitInfo, -1,"",score);
        }
        
        // map의 ArrayList sort
        for (String key : answerList.keySet()){
            ArrayList<Integer> afterSort = answerList.get(key);
            Collections.sort(afterSort);
            answerList.put(key, afterSort);
        }
        
        
        for(int i=0;i<query.length;i++){
            //query 전처리
            String[] splitQuery = (query[i].replaceAll(" and ", " ")).split(" ");
            String queryString = "";
            int queryScore = Integer.parseInt(splitQuery[4]);
            for(int j=0;j<4;j++){
                queryString+=splitQuery[j];
            }
            
            // 각 query에 해당하는 개수 count해주기
            if(answerList.containsKey(queryString)){
                ArrayList<Integer> list = answerList.get(queryString);
                int idx = binarySearch(list, queryScore, 0, list.size()-1);
                answer.add(idx);
            }
            else{
                answer.add(0);
            }
        }
        return answer;
    }

    public static void main(String args[]){
        String[] info = {"java backend junior pizza 150",
                        "python frontend senior chicken 210",
                        "python frontend senior chicken 150",
                        "cpp backend senior pizza 260",
                        "java backend junior chicken 80",
                        "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100",
                        "python and frontend and senior and chicken 200",
                        "cpp and - and senior and pizza 250",
                        "- and backend and senior and - 150",
                        "- and - and - and chicken 100",
                        "- and - and - and - 150"};
        solution(info, query);
    }
}
