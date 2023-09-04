package Algorithm;

import java.util.*;
import java.io.*;

public class H231239 {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        String secret = "";
        for(int i=0;i<m;i++){
            secret+=sc.next();
        }

        String input = "";
        for(int i=0;i<n;i++){
            input+=sc.next();
        }

        if(input.contains(secret)){
            System.out.println("secret");
        }
        else{
            System.out.println("normal");
        }
    }
}
