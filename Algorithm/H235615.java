package Algorithm;

import java.util.*;
import java.io.*;

/* 입력예제 1
3
1 3
2 4
3 5
*/
public class H235615 {
    static class Class{
        int start;
        int end;

        Class(){}
        Class(int start, int end){
            this.start=start;
            this.end=end;
        }
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        ArrayList<Class> inputClass = new ArrayList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            inputClass.add(new Class(start, end));
        }

        inputClass.sort((s1, s2) -> {
            return s1.end - s2.end;
        });

        int answer = 1;
        int endTime = inputClass.get(0).end;
        for(int i=1;i<inputClass.size();i++){
            if(endTime<=inputClass.get(i).start){
                endTime=inputClass.get(i).end;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
