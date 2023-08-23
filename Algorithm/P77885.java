package Algorithm;

import java.util.*;

public class P77885 {
    static public void main(String args[]){
        long[] numbers = {2,7};

        long[] result = solution(numbers);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }

    static public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]%2==0){    // 짝수인 경우, +1 한 값이 정답
                answer[i]=numbers[i]+1;
            }
            else{   // 홀수인 경우
                String binaryString = Long.toBinaryString(numbers[i]);
                int zeroIdx = binaryString.lastIndexOf("0");
                if(zeroIdx!=-1){    // 1로만 이뤄어져 있지 않은 경우, 가장 나중에 나오는 01을 찾아서 10으로 바꿔주기 : 101011 -> 101101
                    String result = binaryString.substring(0,zeroIdx)+"10"+binaryString.substring(zeroIdx+2, binaryString.length());
                    answer[i] = Long.parseLong(result,2);

                }
                else{   // 1로만 이루어져 있는 경우, 맨앞 1을 10으로 바꿔주기 : 1111 -> 10111
                    String result = "10"+binaryString.substring(1,binaryString.length());
                    answer[i] = Long.parseLong(result,2);
                }
            }
        }
        return answer;
    }
}
