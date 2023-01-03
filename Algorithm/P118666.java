package Algorithm;

public class P118666 {
    static public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        int[][] scores = new int[4][2];  // RT/CF/JM/AN
        String[][] type = {{"R","T"},
                           {"C","F"},
                           {"J","M"},
                           {"A","N"}};
        for(int i=0;i<survey.length;i++){
            char disagree = survey[i].charAt(0);
            char agree = survey[i].charAt(1);
            
            int score = 0;
            if(choices[i]==4){
                continue;
            }
            else if(choices[i]<4){  // disagree
                score = 4-choices[i];
                if(disagree=='R'){
                    scores[0][0]+=score;
                }
                else if(disagree=='T'){
                    scores[0][1]+=score;
                }
                else if(disagree=='C'){
                    scores[1][0]+=score;
                }
                else if(disagree=='F'){
                    scores[1][1]+=score;
                }
                else if(disagree=='J'){
                    scores[2][0]+=score;
                }
                else if(disagree=='M'){
                    scores[2][1]+=score;
                }
                else if(disagree=='A'){
                    scores[3][0]+=score;
                }   
                else if(disagree=='N'){
                    scores[3][1]+=score;
                }
            }
            else if(choices[i]>4){  // agree
                score = choices[i]-4;  
                if(agree=='R'){
                    scores[0][0]+=score;
                }
                else if(agree=='T'){
                    scores[0][1]+=score;
                }
                else if(agree=='C'){
                    scores[1][0]+=score;
                }
                else if(agree=='F'){
                    scores[1][1]+=score;
                }
                else if(agree=='J'){
                    scores[2][0]+=score;
                }
                else if(agree=='M'){
                    scores[2][1]+=score;
                }
                else if(agree=='A'){
                    scores[3][0]+=score;
                }   
                else if(agree=='N'){
                    scores[3][1]+=score;
                }
            }
        }
        for(int i=0;i<4;i++){
            if(scores[i][0]>=scores[i][1]){
                answer +=type[i][0];
            }
            if(scores[i][0]<scores[i][1]){
                answer +=type[i][1];
            }                
        } 
        return answer;
    }
    static public void main(String args[]){
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        solution(survey, choices);
    }
}
