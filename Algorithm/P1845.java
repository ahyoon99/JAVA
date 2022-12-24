package Algorithm;

import java.util.*;
import java.util.Map.*;

public class P1845 {
    static public int solution(int[] nums) {
        int answer = 0;
        
        Arrays.sort(nums);
        
        HashMap<Integer, Integer> pocketmon = new HashMap<>();
        
        int m = 0;
        
        for(int i=0;i<nums.length;i++){
            if(pocketmon.containsKey(nums[i])){
                int num = pocketmon.get(nums[i]);
                pocketmon.put(nums[i],num+1);
            }
            else{
                pocketmon.put(nums[i],1);
                m++;
            }
        }
        
        if(m>=nums.length/2){
            return nums.length/2;
        }
        else{
            return m;
        }
    }

    static public void main(String args[]){
        int[] nums = {3,1,2,3};
        solution(nums);
    }
}