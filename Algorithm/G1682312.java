package Algorithm;

import java.io.*;
import java.util.*;

public class G1682312 {
    public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<5;i++){
			int num = sc.nextInt();
			String numToString = String.valueOf(num);
			int[] numArray = new int[7];
			for(int j=0;j<7;j++){
				numArray[j] = (numToString.charAt(j)-'0');
			}
			
			int a=0;
			for(int j=0;j<7;j+=2){
				a+=numArray[j];
			}
			
			for(int j=1;j<7;j+=2){
				if(numArray[j]!=0){
					a*=numArray[j];
				}
			}			
			System.out.println(a%10);
		}		
	}
}
