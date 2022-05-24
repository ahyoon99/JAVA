package Algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B17219 {
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int m =sc.nextInt();
        Map<String, String> map = new HashMap<>();  //<키 자료형, 값 자료형>
        for(int i=0;i<n;i++){
            String website = sc.next();
            String password = sc.next();
            map.put(website, password);
        }
        for(int i=0;i<m;i++){
            String site = sc.next();
            System.out.println(map.get(site));
        }
    }
    
}
