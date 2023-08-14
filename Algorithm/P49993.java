package Algorithm;

import java.util.*;

public class P49993 {
    static public void main(String args[]){
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        int result = solution(skill, skill_trees);
        System.out.println(result);
    }

    static public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        HashSet<Character> skills = new HashSet<>();
        for(int i=0;i<skill.length();i++){
            skills.add(skill.charAt(i));
        }
        
        for(int i=0;i<skill_trees.length;i++){
            String removeAlp = "";
            for(int j=0;j<skill_trees[i].length();j++){
                if(skills.contains(skill_trees[i].charAt(j))){
                    removeAlp+=String.valueOf(skill_trees[i].charAt(j));
                }
            }
            if(removeAlp.equals("")){
                answer++;
                continue;
            }
            for(int j=1;j<=skill.length();j++){
                String com = skill.substring(0,j);
                if(com.equals(removeAlp)){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
