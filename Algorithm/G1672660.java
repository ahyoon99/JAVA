package Algorithm;

import java.io.*;
import java.util.*;

public class G1672660 {
    public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum=0;
		for(int i=0;i<n;i++){
			int temp = sc.nextInt();
			sum+=temp;
		}
		System.out.println(sum);
	}
}
