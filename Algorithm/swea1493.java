package Algorithm;

import java.util.*;
import java.io.*;

public class swea1493 {
    static int T;
    static int p;
    static int q;
    static int[][] matrix;
    static HashMap<Integer, Node> numToNode;

    static class Node{
        int x;
        int y;

        Node(){}
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

        for(int testcase = 1;testcase<=T;testcase++){
            System.out.print("#"+testcase+" ");
            input(br, st);
            solution();
        }
    }
    static void prev(){
        int n=300;
        matrix = new int[n+1][n+1];
        numToNode = new HashMap<Integer, Node>();

        int num=1;
        int end=1;
        int prevEnd=1;
        int x=1;
        while(true){
            if(x==n+1 || end==n+1){
                break;
            }
            if(end==0){
                x=1;
                prevEnd++;
                end=prevEnd;
            }
            matrix[x][end]=num;
            numToNode.put(num, new Node(x, end));
            if(x+end!=n+1){
                int temp = (int) (Math.pow(n, 2)) - num + 1 ;
                matrix[n+1-x][n+1-end]= temp;
                numToNode.put(temp, new Node(n+1-x, n+1-end));
            }
            num++;
            end--;
            x++;
        }
    }

    static void solution(){
        Node n1 = numToNode.get(p);
        Node n2 = numToNode.get(q);
        Node node = new Node(n1.x+n2.x, n1.y+n2.y);
        int result = matrix[node.x][node.y];
        System.out.println(result);
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
    }
}
