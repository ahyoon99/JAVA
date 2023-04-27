package Algorithm;

import java.util.*;

public class P1684540 {
    public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] event = new int[n+1];
		int max=-1;
		for(int i=0;i<m;i++){
			int cnt = sc.nextInt();
			for(int j=0;j<cnt;j++){
				int num = sc.nextInt();
				event[num]++;
				if(max<event[num]){
					max=event[num];
				}
			}
		}
		
		LinkedList<Integer> result = new LinkedList<>();
		for(int i=1;i<event.length;i++){
			if(event[i]==max){
				result.add(i);
			}
		}
		
		Collections.sort(result);
		Collections.reverse(result);
		
		for(int i=0;i<result.size();i++){
			System.out.print(result.get(i)+" ");
		}
	}
}
