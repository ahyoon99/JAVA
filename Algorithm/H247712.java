package Algorithm;

import java.util.*;
import java.io.*;

/* 입력 예제1
HELLOWORLD
PLAYFAIRCIPHERKEY
*/
public class H247712 {
    static char[] keyArr;
    static int index1;
    static int index2;

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        String message = st.nextToken();
        st = new StringTokenizer(br.readLine(), " ");
        String key = st.nextToken();

        // 1. 5X5 key 만들기
        keyArr = new char[25];
        boolean[] used = new boolean[25];
        int idx=0;
        for(int i=0;i<key.length();i++){
            if(key.charAt(i)>'J'){
                if(used[key.charAt(i)-'A'-1]==false){
                    keyArr[idx]=key.charAt(i);
                    idx++;
                    used[key.charAt(i)-'A'-1]=true;
                }
            }
            else{
                if(used[key.charAt(i)-'A']==false){
                    keyArr[idx]=key.charAt(i);
                    idx++;
                    used[key.charAt(i)-'A']=true;
                }
            }
        }

        for(int i=0;i<25;i++){
            if(used[i]==false){
                if(i>=9){
                    keyArr[idx]=(char)('A'+i+1);
                    idx++;
                    used[i]=true;
                }
                else{
                    keyArr[idx]=(char)('A'+i);
                    idx++;
                    used[i]=true;
                }
            }
        }

        // 2. message -> 2개씩 나누기
        ArrayList<String> messages = new ArrayList<>();
        while(!message.equals("")){
            if(message.length()<2){
                messages.add(message.substring(0,1)+"X");
                message = "";
            }
            else{
                if(message.charAt(0)==message.charAt(1)){
                    if(message.charAt(0)=='X'){
                        messages.add(message.substring(0,1)+"Q");
                    }   
                    else{
                        messages.add(message.substring(0,1)+"X");
                    }
                    message = message.substring(1, message.length());
                }
                else{
                    messages.add(message.substring(0,2));
                    message = message.substring(2,message.length());
                    
                }
            }
        }

        // 3. 암호화 하기
        String answer = "";
        for(int i=0;i<messages.size();i++){
            calIdx(messages.get(i));
            String med = String.valueOf(keyArr[index1])+String.valueOf(keyArr[index2]);
            answer+=med;
        }
        System.out.println(answer);
    }

    static public void calIdx(String before){
        char c1 = before.charAt(0);
        char c2 = before.charAt(1);
        int[] idx1 = new int[2];
        int[] idx2 = new int[2];
        
        for(int i=0;i<keyArr.length;i++){
            if(c1 == keyArr[i]){
                idx1[0] = i;
                break;
            }
        }

        for(int i=0;i<keyArr.length;i++){
            if(c2 == keyArr[i]){
                idx2[0] = i;
                break;
            }
        }
        
        idx1[1]=idx1[0]%5;
        idx1[0]=idx1[0]/5;
        idx2[1]=idx2[0]%5;
        idx2[0]=idx2[0]/5;
        
        if(idx1[0]==idx2[0]){   // same row
            idx1[1]=(idx1[1]+1)%5;
            idx2[1]=(idx2[1]+1)%5;
        }
        else if(idx1[1] == idx2[1]){    // same column
            idx1[0]=(idx1[0]+1)%5;
            idx2[0]=(idx2[0]+1)%5;
        }
        else{
            int temp = idx2[1];
            int temp2 = idx1[1];
            idx1[1]=temp;
            idx2[1]=temp2;
        }

        index1 = idx1[0]*5 + idx1[1];
        index2 = idx2[0]*5 + idx2[1];
    }
}
