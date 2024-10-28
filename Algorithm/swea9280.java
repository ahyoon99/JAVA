package Algorithm;

import java.util.*;
import java.io.*;

public class swea9280 {
    static int tc;
    static int n;
    static int m;
    static int[] parkinglotPrice;
    static int[] cars;
    static int[] parkinglots;
    static ArrayList<Integer> waiting;
    static int price;
    static public void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        tc = Integer.parseInt(st.nextToken());
        for(int testcase=1;testcase<=tc;testcase++){
            System.out.print("#"+testcase+" ");
            input(br, st);
            solution(br, st);
        }
    }

    static void solution(BufferedReader br, StringTokenizer st) throws IOException{
        for(int i=0;i<2*m;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int car = Integer.parseInt(st.nextToken());
            if(car>0){
                car--;
                boolean isEmpty = false;
                int parkinglot = -1;
                for(int j=0;j<n;j++){
                    if(parkinglots[j]==-1){
                        parkinglot = j;
                        isEmpty = true;
                        break;
                    }
                }
                if(!isEmpty){
                    waiting.add(car);
                    continue;
                }
                parkinglots[parkinglot] = car;
                price += parkinglotPrice[parkinglot] * cars[car];
            }
            else{
                car*=-1;
                car--;
                int parkinglot=-1;
                for(int j=0;j<n;j++){
                    if(parkinglots[j]==car){
                        parkinglots[j]=-1;
                        parkinglot=j;
                        break;
                    }
                }
                if(!waiting.isEmpty()){
                    int waitingCar = waiting.remove(0);
                    parkinglots[parkinglot]=waitingCar;
                    price+= parkinglotPrice[parkinglot] * cars[waitingCar];
                }
            }
        }
        System.out.println(price);
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parkinglotPrice = new int[n];
        cars = new int[m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            parkinglotPrice[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine(), " ");
            cars[i] = Integer.parseInt(st.nextToken());
        }

        waiting = new ArrayList<Integer>();
        price = 0;

        parkinglots = new int[n];
        Arrays.fill(parkinglots, -1);
    }
}
