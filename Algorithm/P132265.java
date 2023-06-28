package Algorithm;

public class P132265 {
    static public void main(String args[]){
        int[] topping = {1,2,1,3,1,4,1,2};

        int result = solution(topping);
        System.out.println(result);
    }
    
    static public int solution(int[] topping) {
        int answer = 0;
        
        int[] user1 = new int[10001];
        int[] user2 = new int[10001];
        int cnt1=0;
        int cnt2=0;
        
        for(int i=0;i<topping.length;i++){
            if(user2[topping[i]]==0){
                cnt2++;
            }
            user2[topping[i]]++;
        }
        
        for(int i=0;i<topping.length;i++){
            if(user1[topping[i]]==0){
                cnt1++;
            }
            user1[topping[i]]++;
            if(user2[topping[i]]==1){
                cnt2--;
            }
            user2[topping[i]]--;
            
            if(cnt1==cnt2){
                answer++;
            }
        }
        return answer;
    }
}
