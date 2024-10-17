package Algorithm;

import java.util.*;
import java.io.*;

public class P176962 {
    static PriorityQueue<Node> pq;
    static Stack<Node> wait;
    
    static class Node implements Comparable<Node>{
        String name;
        int startTime;
        int playtime;
        
        Node(String name, int startTime, int playtime){
            this.name=name;
            this.startTime=startTime;
            this.playtime=playtime;
        }
        
        @Override
        public int compareTo(Node next){
            return this.startTime-next.startTime;
        }
    }
    
    static public void main(String args[]){
        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"},
                             {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        ArrayList<String> result = solution(plans);
        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
        }
        System.out.println();
    }
    
    static public ArrayList<String> solution(String[][] plans) {
        ArrayList<String> answer = new ArrayList<>();
        
        int n = plans.length;
        pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            String[] startTimeArr = plans[i][1].split(":");
            int time = Integer.parseInt(startTimeArr[0])*60 + Integer.parseInt(startTimeArr[1]);
            Node node = new Node(plans[i][0], time, Integer.parseInt(plans[i][2]));
            pq.add(node);
        }
        
        wait = new Stack<Node>();
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            int time = now.startTime;
            
            if(pq.isEmpty()){   // 더 이상 남아있는 새로운 과제가 없는 경우  
                if(wait.isEmpty()){ // 잠시 멈춘 과제도 없는 경우
                    time+=now.playtime;
                    answer.add(now.name);
                }
                else{   // 잠시 멈춘 과제가 있는 경우
                    answer.add(now.name);   // 새로운 과제부터 먼저 해결
                    
                    while(!wait.isEmpty()){ // 남아있는 잠시 멈춘 과제들을 순서대로 수행
                        now = wait.pop();
                        time+=now.playtime;
                        answer.add(now.name);
                    }
                }
            }
            else{   // 새로운 과제가 남아있는 경우 (진행중이던 과제 제외)
                Node next = pq.peek();
                
                if(time+now.playtime == next.startTime){    // 다음 새로운 과제 시작 전까지 다 끝낼 수 있는 경우
                    answer.add(now.name);
                    continue;
                }
                else if(time+now.playtime < next.startTime){    // 지금 과제를 끝내고도 다음 과제 시작까지 시간이 남는 경우
                    answer.add(now.name);
                    time+=now.playtime;
                    
                    while(!wait.isEmpty()){ // 잠시 멈춘 과제가 있는 경우, 남는 시간동안 멈췄던 과제 해결
                        Node rem = wait.pop();
                        
                        if(time+rem.playtime <= next.startTime){    // 다음 새로운 과제 시작전까지 다 끝낼 수 있는 경우
                            time+=rem.playtime;
                            answer.add(rem.name);
                            continue;
                        }
                        else{   // 다음 새로운 과제 시작전까지 다 끝낼 수 없는 경우
                            int diff = rem.playtime - (next.startTime-time);
                            rem.startTime = time+diff;
                            rem.playtime=diff;
                            wait.push(rem);
                            break;
                        }
                    }
                }
                else if(time+now.playtime > next.startTime){    // 새로운 과제 시작 전까지 지금 과제를 못끝내는 경우
                    int diff = next.startTime-now.startTime;
                    now.playtime = now.playtime-diff;
                    wait.push(now);
                }
            }
            
        }
        return answer;
    }
}