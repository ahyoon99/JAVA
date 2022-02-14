package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B2309 {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int[] people = new int[9];
        int total = 0;
        for(int i=0;i<9;i++){
            int a = sc.nextInt();
            people[i] = a;
            total+=a;
        }
        Arrays.sort(people);

        int sum=0;
        for(int i=0;i<8;i++){
            for(int j=i+1;j<9;j++){
                sum=total-people[i]-people[j];
                if(sum==100){
                    for(int k=0;k<9;k++){
                        if(k==i || k==j){
                            continue;
                        }
                        else{
                            System.out.println(people[k]);
                        }
                    }
                    return;
                }
            }
        }
    }
    
}
