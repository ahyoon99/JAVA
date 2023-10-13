package Algorithm;

import java.util.*;
import java.io.*;

public class swea5658 {
    static int n;
	static int k;
	static String command;
	static HashSet<String> numbers;
	
	public static void main(String args[]) throws Exception
	{
	/*
	아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
	여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
	이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
	따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
	단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
	*/
	System.setIn(new FileInputStream("res/input_swea5658.txt"));

	/*
	표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
	*/
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	st = new StringTokenizer(br.readLine(), " ");
	int T = Integer.parseInt(st.nextToken());
	
	/*
	여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
	*/

	for(int test_case = 1; test_case <= T; test_case++)
	{

	/////////////////////////////////////////////////////////////////////////////////////////////
	/*
	이 부분에 여러분의 알고리즘 구현이 들어갑니다.
	*/
	/////////////////////////////////////////////////////////////////////////////////////////////
		
		solution(test_case, br, st);
	}
	}
	
	static public void solution(int T, BufferedReader br, StringTokenizer st) throws IOException{
		input(br, st);
		
		for(int i=0;i<n/4;i++) {
			splitCommand();
			
			rotateCommand();
		}
		
		ArrayList<String> result = new ArrayList<>();
		for(String s : numbers) {
			result.add(s);
		}
		
		Collections.sort(result, Collections.reverseOrder());
	
		System.out.println("#"+T+" "+Long.parseLong(result.get(k-1), 16));
	}
	
	static public void input(BufferedReader br, StringTokenizer st) throws IOException{
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		command = st.nextToken();
		
		numbers = new HashSet<String>();

	}
	
	static public void splitCommand() {
		String[] num = new String[4];
		int numLen = n/4;
		
		int idx=0;
		for(int i=0;i<n;i+=numLen) {
			num[idx]=command.substring(i,i+numLen);
			numbers.add(num[idx]);
			idx++;
		}
		
	}
	
	static public void rotateCommand() {
		command = command.substring(n-1,n)+command.substring(0,n-1);
	}
}
