package Algorithm;
import java.util.*;
import java.util.stream.*;

public class B3052 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int[] num = new int[10];
        for(int i=0;i<10;i++){
            int n = sc.nextInt();
            num[i]=n%42;
        }
        
        IntStream stream = Arrays.stream(num);
        System.out.println(stream.distinct().count());
    }
}
