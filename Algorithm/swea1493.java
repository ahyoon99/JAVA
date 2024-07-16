package Algorithm;

import java.util.*;
import java.io.*;

public class swea1493 {
    // 방법 2 : 2차원배열(int[][] matrix), 1차원 배열 (Node[] reverseMatrix) 사용한 방법
    static int T;
    static int p;
    static int q;
    static int[][] matrix;
    static Node[] reverseMatrix;
    static int n;
    static int l;

    static class Node{
        int x;
        int y;

        Node(){};
        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        prev();

        st = new StringTokenizer(br.readLine(), " ");
        T = Integer.parseInt(st.nextToken());

        for(int testcase=1;testcase<=T;testcase++){
            System.out.print("#"+testcase+" ");
            input(br, st);
            solution();
        }
    }

    static void prev() {
        n = 50000;
        l = 300;
        matrix = new int[l+1][l+1];
        reverseMatrix = new Node[n+1];

        int x = 1;
        int y = 1;
        for(int i=1;i<=n;i++){
            if(x>l){
                break;
            }
            if(y==0){
                y = x;
                x = 1;
            }

            matrix[x][y]=i;
            reverseMatrix[i] = new Node(x,y);

            x++;
            y--;
        }
    }

    static void solution() {
        Node n1 = reverseMatrix[p];
        Node n2 = reverseMatrix[q];
        Node node = new Node(n1.x+n2.x, n1.y+n2.y);
        int result = matrix[node.x][node.y];
        System.out.println(result);
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
    }


    // 방법 1 : 내가 푼 방법
    // static int T;
    // static int p;
    // static int q;
    // static int[][] matrix;
    // static HashMap<Integer, Node> numToNode;

    // static class Node{
    //     int x;
    //     int y;

    //     Node(){}
    //     Node(int x, int y){
    //         this.x=x;
    //         this.y=y;
    //     }
    // }

    // static public void main(String args[]) throws IOException{
    //     System.setIn(new FileInputStream("res/input.txt"));

    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringTokenizer st;

    //     prev();

    //     st = new StringTokenizer(br.readLine(), " ");
    //     T = Integer.parseInt(st.nextToken());

    //     for(int testcase = 1;testcase<=T;testcase++){
    //         System.out.print("#"+testcase+" ");
    //         input(br, st);
    //         solution();
    //     }
    // }
    // static void prev(){
    //     int n=300;
    //     matrix = new int[n+1][n+1];
    //     numToNode = new HashMap<Integer, Node>();

    //     int num=1;
    //     int end=1;
    //     int prevEnd=1;
    //     int x=1;
    //     while(true){
    //         if(x==n+1 || end==n+1){
    //             break;
    //         }
    //         if(end==0){
    //             x=1;
    //             prevEnd++;
    //             end=prevEnd;
    //         }
    //         matrix[x][end]=num;
    //         numToNode.put(num, new Node(x, end));
    //         if(x+end!=n+1){
    //             int temp = (int) (Math.pow(n, 2)) - num + 1 ;
    //             matrix[n+1-x][n+1-end]= temp;
    //             numToNode.put(temp, new Node(n+1-x, n+1-end));
    //         }
    //         num++;
    //         end--;
    //         x++;
    //     }
    // }

    // static void solution(){
    //     Node n1 = numToNode.get(p);
    //     Node n2 = numToNode.get(q);
    //     Node node = new Node(n1.x+n2.x, n1.y+n2.y);
    //     int result = matrix[node.x][node.y];
    //     System.out.println(result);
    // }

    // static void input(BufferedReader br, StringTokenizer st) throws IOException{
    //     st = new StringTokenizer(br.readLine(), " ");
    //     p = Integer.parseInt(st.nextToken());
    //     q = Integer.parseInt(st.nextToken());
    // }
}
