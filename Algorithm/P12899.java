package Algorithm;

public class P12899 {
    static public void main(String args[]){
        int n = 4;

        String result = solution(n);
        System.out.println(result);
    }

    static public String solution(int n) {
        String answer = "";
        
        while(n>0){
            int remainder = n%3;
            n/=3;
            if(remainder==0){    // 나누어 떨어진 경우, n에 -1을 해준다.
                n--;
                remainder=4;
            }
            answer=String.valueOf(remainder)+answer;
        }
        return answer;
    }
}
