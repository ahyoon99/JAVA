package Algorithm;

import java.util.*;
import java.io.*;

public class H229504 {

/* 입력 예제 1
3 7
grandeur
avante
sonata
sonata 14 16
grandeur 11 12
avante 15 18
sonata 10 11
avante 9 12
grandeur 16 18
avante 12 15
*/

/* 입력 예제 1
3 2
santafe
aerocity
porter
santafe 9 12
porter 9 18
*/
    static public void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<String, int[]> conference = new HashMap<>();

        for(int i=0;i<n;i++){
            String name = sc.next();
            int[] temp = new int[9];
            conference.put(name, temp);
        }

        for(int i=0;i<m;i++){
            String name =sc.next();
            int start = sc.nextInt();
            int end = sc.nextInt();
            int[] after = conference.get(name);
            for(int j=start-9;j<end-9;j++){
                after[j]=1;
            }
            conference.put(name, after);
        }
        
        ArrayList<String> keyValue = new ArrayList<>(conference.keySet());
        Collections.sort(keyValue);
        for(int idx=0;idx<keyValue.size();idx++){
            String entry = keyValue.get(idx);
        
            if(idx!=0){
                System.out.println("-----");
            }
            System.out.println("Room "+entry+":");
            int[] timeline = conference.get(entry);
            int cnt=1;
            String result = "09101112131415161718";

            for(int i=0;i<timeline.length;i++){
                if(timeline[i]==1){
                    String startStr = String.valueOf(i+9);
                    String endStr = String.valueOf(i+10);
                    result = result.replace(startStr+endStr, startStr+"\n"+endStr);
                    cnt++;
                }
            }

            String[] before = result.split("\n");
            LinkedList<String> after = new LinkedList<>(Arrays.asList(before));

            for(int i=after.size()-1;i>=0;i--){
                String command = after.get(i);
                if(command.length()<=3){
                    after.remove(i);
                    cnt--;
                }
                if(command.length()>=4){
                    String answer = command.substring(0,2)+"-"+command.substring(command.length()-2,command.length());
                    after.remove(i);
                    after.add(i,answer);
                }
            }
            
            if(cnt==0){
                System.out.println("Not available");
            }
            else{
                System.out.println(cnt+" available:");
                for(int i=0;i<after.size();i++){
                    System.out.println(after.get(i));
                }
            }
            
        }
    }
}
