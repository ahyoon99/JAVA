package Algorithm;

import java.util.*;

public class G1682313 {
    public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String password = sc.next();
		
		char[] alphabet = new char[26];
		for(int i=0;i<26;i++){
			int num = 97+i;
			alphabet[i] = (char) num;
		}
		
		String answer = "";
		for(int i=0;i<n-1;i+=2){
			char alp = password.charAt(i);
			int alpCnt = alp-'a';
			
			char med = password.charAt(i+1);
			int cnt = med-'0';
			cnt = (int) Math.pow(cnt,2);
			
			int totalCnt = alpCnt+cnt;
			if(totalCnt>=26){
				totalCnt%=26;
			}
			
			char resultAlp = alphabet[totalCnt];
			answer+=String.valueOf(resultAlp);
		}
		
		System.out.println(answer);
		
	}
}
