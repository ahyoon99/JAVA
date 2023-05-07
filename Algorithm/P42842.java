package Algorithm;

public class P42842 {
    static public void main(String args[]){
        int brown = 10;
        int yellow = 2;
        
        int[] result = solution(brown, yellow);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }
    static public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int area = brown+yellow;
        int width=0;
        int height=0;
        for(int i=3;i*i<=area;i++){
            if(area%i==0){
                height=i;
                width=area/i;
                if(2*(width+height)-4==brown){  // brown 카펫의 개수 확인하기
                    answer[0]=width;
                    answer[1]=height;
                    return answer;
                }
            }
        }
        return answer;
    }
}
