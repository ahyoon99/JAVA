package Algorithm;

import java.util.*;

public class P42577 {
    static public void main(String args[]){
        String[] phone_book = {"119", "97674223", "1195524421"};
        
        boolean result = solution(phone_book);
        System.out.println(result);
    }

    static public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashSet<String> phoneNumber = new HashSet<>();
        
        for(int i=0;i<phone_book.length;i++){
            phoneNumber.add(phone_book[i]);
        }
        
        for(int i=0;i<phone_book.length;i++){
            for(int j=0;j<phone_book[i].length();j++){
                if(phoneNumber.contains(phone_book[i].substring(0,j))){
                    answer=false;
                    return false;
                }
            }
        }
        
        return answer;
    }
}
