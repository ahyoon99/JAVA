package Algorithm;

import java.util.*;

public class P72410 {
    static public String solution(String new_id) {
        String answer = "";
        
        List<Character> newId = new ArrayList<Character>();
        for(int i=0;i<new_id.length();i++){
            newId.add(new_id.charAt(i));
        }

        // 1. 모든 대문자를 대응되는 소문자로 치환한다.
        for(int i=0;i<newId.size();i++){
            if(newId.get(i)>='A' && newId.get(i)<='Z'){
                char lowerAlp = (char)(newId.get(i)+32);
                newId.set(i, lowerAlp);
            }
        }

        // 2. 사용 불가능한 문자 제거한다.
        List<Integer> removeIdx = new ArrayList<>();
        for(int i=0;i<newId.size();i++){
            if(newId.get(i)>='a' && newId.get(i)<='z'){
                continue;
            }
            if(newId.get(i)>='0' && newId.get(i)<='9'){
                continue;
            }
            if(newId.get(i)=='-' || newId.get(i)=='_' || newId.get(i)=='.'){
                continue;
            }
            removeIdx.add(i);
        }
        for(int i=removeIdx.size()-1;i>=0;i--){
            int idx = removeIdx.get(i);
            newId.remove(idx);
        }

        // +) new_id가 빈 문자열이라면, new_id에 "a"를 대입한다.
        if(newId.size()==0){
            newId.add('a');
        }

        // 3. 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표로 치환한다.
        int startIdx=0;
        int endIdx=0;
        removeIdx = new ArrayList<>();
        int i=0;
        while(i<newId.size()){
            if(newId.get(i)=='.'){
                startIdx = i;
                endIdx = i;
                while(newId.get(endIdx)=='.'){
                    endIdx++;
                    if(newId.size() == endIdx){
                        break;
                    }
                }
                for(int j=startIdx;j<endIdx-1;j++){
                    removeIdx.add(j);
                }
                i=endIdx;
            }
            else{
                i++;
            }
        }
        for(int j=removeIdx.size()-1;j>=0;j--){
            int idx = removeIdx.get(j);
            newId.remove(idx);
        }

        // +) new_id가 빈 문자열이라면, new_id에 "a"를 대입한다.
        if(newId.size()==0){
            newId.add('a');
        }

        // 4. 마침표(.)가 처음이나 끝에 위치한다면 제거한다.
        if(newId.get(newId.size()-1)=='.'){
            newId.remove(newId.size()-1);
        }

        // +) new_id가 빈 문자열이라면, new_id에 "a"를 대입한다.
        if(newId.size()==0){
            newId.add('a');
        }

        if(newId.get(0)=='.'){
            newId.remove(0);
        }

        // +) new_id가 빈 문자열이라면, new_id에 "a"를 대입한다.
        if(newId.size()==0){
            newId.add('a');
        }

        // 6. 길이가 16이상이라면 첫 15개의 문자만 남겨둔다. 
        // 만약 제거 후 마침표(.)가 끝에 위치한다면 제거한다. -> 길이가 14가 된다.
        if(newId.size()>=16){
            newId = newId.subList(0, 15);
        }
        if(newId.get(newId.size()-1)=='.'){
            newId.remove(newId.size()-1);
        }

        // 7. 길이가 2이하라면, new_id의 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 이어붙인다.
        if(newId.size()<=2){
            while(newId.size()<3){
                newId.add(newId.get(newId.size()-1));
            }
        }
        
        // ArrayList -> String
        for(char c : newId){
            answer+=c;
        }
        
        return answer;
    }

    static public void main(String args[]){
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        solution(new_id);
    }
}
