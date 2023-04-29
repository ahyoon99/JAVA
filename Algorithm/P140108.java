package Algorithm;

public class P140108 {
    static public void main(String args[]){
        String s = "banana";
        int result = solution(s);
        System.out.println(result);
    }
    
    static public int solution(String s) {
        int answer = 0;
        
        int same = 0;
        int different = 0;
        char x = s.charAt(0);
        boolean isFinish=false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==x){
                same++;
            }
            else{
                different++;
            }
            
            if(same!=0 && same==different){
                answer++;
                if(i+1<s.length()){
                    x = s.charAt(i+1);
                }
                else{
                    isFinish=true;
                    break;
                }
                same=0;
                different=0;
            }
        }
        
        answer = (isFinish==true) ? answer : (answer + 1);
        return answer;
    }
}
