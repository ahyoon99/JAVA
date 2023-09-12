package Algorithm;

import java.util.*;

public class P17683 {
    static public void main(String args[]){
        String m = "ABC";
        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        String result = solution(m, musicinfos);
        System.out.println(result);
    }

    static public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        
        LinkedList<String>[] info = new LinkedList[musicinfos.length];
        for(int i=0;i<musicinfos.length;i++){
            info[i]=new LinkedList<String>();
        }
        
        for(int i=0;i<musicinfos.length;i++){
            LinkedList<String> med = new LinkedList<>();
            String[] splitString = musicinfos[i].split(",");
            // 1. name
            med.add(splitString[2]);
            
            // 2. startTime
            String[] startTime = splitString[0].split(":");
            int start = 60*(Integer.parseInt(startTime[0])) + Integer.parseInt(startTime[1]);
            med.add(String.valueOf(start));
            
            // 3. timeLength
            String[] endTime = splitString[1].split(":");
            int end = 60*(Integer.parseInt(endTime[0])) + Integer.parseInt(endTime[1]);
            int times = end-start;
            med.add(String.valueOf(times));
            
            // 4. melody
            LinkedList<String> melodyList = new LinkedList<>();
            int idx=0;
            while(idx<splitString[3].length()){
                if(idx==splitString[3].length()-1){
                    melodyList.add(String.valueOf(splitString[3].charAt(idx)));;
                    idx++;
                }
                else if(splitString[3].charAt(idx+1)=='#'){
                    melodyList.add(splitString[3].charAt(idx)+"#");
                    idx+=2;
                }
                else{
                    melodyList.add(String.valueOf(splitString[3].charAt(idx)));
                    idx++;
                }
            }
            
            String melody = "";
            idx=0;
            while(idx<times){
                melody += melodyList.get(idx%melodyList.size());
                idx++;
            }
            med.add(melody);
            
            info[i]=med;
        }
        
        int minStart=14400;
        int maxLength=-1;
        for(int i=0;i<musicinfos.length;i++){
            int infoStart = Integer.parseInt(info[i].get(1));
            int infoLength = Integer.parseInt(info[i].get(2));
            String infoMelody = info[i].get(3);
            
            for(int j=0;j<infoMelody.length()-m.length()+1;j++){
                if(infoMelody.substring(j,j+m.length()).equals(m)){
                    if(j==infoMelody.length()-m.length() || infoMelody.charAt(j+m.length())!='#'){
                        if(maxLength<infoLength){
                            minStart = infoStart;
                            maxLength = infoLength;
                            answer = info[i].get(0);
                        }
                        else if(minStart==infoStart){
                            if(minStart>infoStart){
                                minStart = infoStart;
                                maxLength = infoLength;
                                answer = info[i].get(0);
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}
