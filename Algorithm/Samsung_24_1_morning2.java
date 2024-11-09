package Algorithm;

import java.util.*;
import java.io.*;

// 코드트리 투어
public class Samsung_24_1_morning2 {
    static int q;
    static int n;
    static int m;
    static int[][] land;
    static int[] distance;
    static boolean[] isMade = new boolean[30005];    // 여행상품이 만들어진적 있는지 저장
    static boolean[] isCancel = new boolean[30005];  // 여행상품이 취소되었는지 저장
    static PriorityQueue<Product> list = new PriorityQueue<>();
    static int startNum;

    static class Node{
        int id;
        int dist;
        Node(){}
        Node(int id, int dist){
            this.id = id;
            this.dist = dist;
        }
    }

    static class Product implements Comparable<Product>{
        int id;
        int revenue;
        int dest;
        int profit;
        Product(){}
        Product(int id, int revenue, int dest, int profit){
            this.id = id;
            this.revenue = revenue;
            this.dest = dest;
            this.profit = profit;
        }

        @Override
        public int compareTo(Product other){
            if(this.profit == other.profit){
                return Integer.compare(this.id, other.id);
            }
            return Integer.compare(other.profit, this.profit);
        }
    }

    static void solution(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        int command = Integer.parseInt(st.nextToken());

        if(command==100) {   // input
            input(br, st);
            findDistance();
        }
        else if(command == 200){    // create
            int id = Integer.parseInt(st.nextToken());
            int revenue = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());

            isMade[id]=true;
            list.offer(new Product(id, revenue, dest, revenue-distance[dest]));
        }
        else if(command == 300){    // remove
            int id = Integer.parseInt(st.nextToken());
            if(isMade[id]){
                isCancel[id]=true;
            }
        }
        else if(command == 400){    // sell
            boolean isValid = false;
            while(!list.isEmpty()){
                Product p = list.peek();
                if(p.profit<0){
                    break;
                }
                list.poll();
                if(!isCancel[p.id]){
                    System.out.println(p.id);
                    isValid = true;
                    break;
                }
            }
            if(!isValid){
                System.out.println(-1);
            }
        }   
        else if(command == 500){    // change startNum
            startNum = Integer.parseInt(st.nextToken());
            findDistance();

            List<Product> newList = new ArrayList<>();

            while(!list.isEmpty()){
                newList.add(list.poll());
            }

            for(Product p : newList){
                list.offer(new Product(p.id, p.revenue, p.dest, p.revenue-distance[p.dest]));
            }
        }
    }

    static void findDistance(){
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.dist-o2.dist);
        boolean[] check = new boolean[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Node node = new Node(startNum, 0);
        distance[node.id]=0;
        pq.add(node);

        while(!pq.isEmpty()){
            node = pq.poll();
            int id = node.id;
            if(check[id]){
                continue;
            }
            check[id]=true;

            for(int i=0;i<n;i++){
                if(land[id][i]>0){
                    if(distance[id]+land[id][i]<distance[i]){
                        distance[i] = distance[id]+land[id][i];
                        pq.add(new Node(i, distance[i]));
                    }
                }
            }
        }
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        land = new int[n][n];
        distance = new int[n];
        
        for(int i=0;i<n;i++){
            Arrays.fill(land[i], Integer.MAX_VALUE);
            land[i][i]=0;
        }

        for(int i=0;i<m;i++){
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            land[v][u] = Math.min(w, land[v][u]);
            land[u][v] = Math.min(w, land[u][v]);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(land[i][j]==Integer.MAX_VALUE){
                    land[i][j]=0;
                }
            }
        }
    }
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        q = Integer.parseInt(st.nextToken());

        for(int testcase=0;testcase<q;testcase++){
            solution(br, st);
        }
    }
}
