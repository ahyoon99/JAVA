package Algorithm;

import java.util.*;
import java.io.*;

public class H235241 {
    static class Product{
        int weight;
        int price;

        Product(){}
        Product(int weight, int price){
            this.weight = weight;
            this.price = price;
        }
    }
    
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        ArrayList<Product> products = new ArrayList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            products.add(new Product(weight, price));
        }

        products.sort((s1, s2) -> {
            return s2.price-s1.price;
        });

        int answer = 0;
        for(int i=0;i<products.size();i++){
            if(w<=0){
                break;
            }
            int minus = Math.min(products.get(i).weight, w);
            w-=minus;
            answer+=(minus*products.get(i).price);
        }
        System.out.println(answer);
    }
}
