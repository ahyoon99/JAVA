package Algorithm;

import java.io.*;
import java.util.*;

public class G1679178 {
    public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in)	;
		int myMoney = sc.nextInt();
		int m = sc.nextInt();
		Queue<Integer> reservation = new LinkedList<>();
		
		for(int i=0;i<m;i++){
			String command = sc.next();
			int price = sc.nextInt();
			
			if(command.equals("deposit")){
				myMoney += price;
				
			}
			else if(command.equals("pay")){
				if(myMoney>=price){
					myMoney-=price;
				}
			}
			else if(command.equals("reservation")){
				if(reservation.isEmpty() && myMoney>=price){
					myMoney-=price;
				}
				else{
					reservation.add(price);
				}
			}
			
			while(!reservation.isEmpty()){
					if(myMoney>=reservation.peek()){
						myMoney-=reservation.peek();
						reservation.poll();
					}
					else{
						break;
					}
				}
			
		}
		System.out.println(myMoney);
	}
}
