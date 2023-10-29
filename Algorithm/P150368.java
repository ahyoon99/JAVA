package Algorithm;

import java.util.*;

public class P150368 {
    static int maxJoiner;
    static int maxPrice;
    
    static public void main(String args[]){
        // tc1
        // int[][] users = {{40, 10000},{25, 10000}};
        // int[] emoticons = {7000, 9000};

        // tc2
        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons = {1300, 1500, 1600, 4900};

        int[] result = solution(users, emoticons);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }

    static public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        maxJoiner = Integer.MIN_VALUE;
        maxPrice = Integer.MIN_VALUE;
        
        int[] sales = {10, 20, 30, 40};
        int[] emoticonsSale = new int[emoticons.length];
        calculateEmoticonsSale(sales, emoticonsSale, 0, users, emoticons);

        
        answer[0]=maxJoiner;
        answer[1]=maxPrice;
        return answer;
    }
    
    static public void calculateEmoticonsSale(int[] sales, int[] emoticonsSale, int idx, int[][] users, int[] emoticons){
        if(idx>=emoticonsSale.length){
            buy(emoticonsSale, users, emoticons);
            return;
        }
        for(int i=0;i<4;i++){
            emoticonsSale[idx]=sales[i];
            calculateEmoticonsSale(sales, emoticonsSale, idx+1, users, emoticons);
        }
    }
    
    static public void buy(int[] emoticonsSale, int[][] users, int[] emoticons){
        int joiner=0;
        int price=0;
        
        int[] emoticonsPrice = new int[emoticons.length];
        for(int i=0;i<emoticons.length;i++){
            emoticonsPrice[i]=(int) (emoticons[i]*(100-emoticonsSale[i])/100);
        }

        int[] receipt = new int[users.length];
        for(int i=0;i<users.length;i++){
            for(int j=0;j<emoticonsSale.length;j++){
                if(emoticonsSale[j]>=users[i][0]){
                    receipt[i]+=emoticonsPrice[j];
                }
            }
            
            if(receipt[i]>=users[i][1]){
                joiner++;
                receipt[i]=0;
            }
            else{
                price += receipt[i];
            }
        }
        
        if(joiner>maxJoiner){
            maxJoiner = joiner;
            maxPrice = price;
        }
        else if(joiner == maxJoiner && price>maxPrice){
            maxJoiner = joiner;
            maxPrice = price;
        }
    }
}
