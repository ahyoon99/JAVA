package Algorithm;

public class P148653 {
    static public void main(String args[]){
        int storey = 16;
        int result = solution(storey);

        System.out.println(result);
    }

    static public int solution(int storey) {
        int answer = 0;
        
        while(storey!=0){
            if(storey%10<5){
                answer+=storey%10;
                storey/=10;
            }
            else if(storey%10>5){
                answer+=(10-storey%10);
                storey/=10;
                storey++;
            }
            else if(storey%10==5){
                if(storey%100>=50){
                    answer+=(10-storey%10);
                    storey/=10;
                    storey++;
                }
                else{
                    answer+=storey%10;
                    storey/=10;
                }
            }
        }
        return answer;
    }
}
