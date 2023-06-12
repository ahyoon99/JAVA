package Algorithm;

public class P86491 {
    static public void main(String args[]){
        int[][] sizes = {{60,50},{30,70},{60,30},{80,40}};

        int result = solution(sizes);
        System.out.println(result);
    }
    
    static public int solution(int[][] sizes) {
        int answer = 0;
        
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][0]<sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0]=sizes[i][1];
                sizes[i][1]=temp;
            }
        }
        
        int n = -1;
        int m = -1;
        
        for(int i=0;i<sizes.length;i++){
            if(n<sizes[i][0]){
                n=sizes[i][0];
            }
            if(m<sizes[i][1]){
                m=sizes[i][1];
            }
        }
        answer=n*m;
        return answer;
    }
}
