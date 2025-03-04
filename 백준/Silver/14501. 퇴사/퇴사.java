import java.io.*;
import java.util.*;

public class Main{
	public static int[] T; // 상담에 필요한 기간 저장 배열
	public static int[] P; // 상담으로 받는 금액 저장 배열
	public static int max = Integer.MIN_VALUE; // 최대값
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력값 저장 및 배열 초기화
    	int N = Integer.parseInt(br.readLine());
    	StringTokenizer st;
    	T = new int[N+1];
    	P = new int[N+1];
    	for(int i=1;i<=N;i++) {
    		st = new StringTokenizer(br.readLine()," ");
    		T[i] = Integer.parseInt(st.nextToken());
    		P[i] = Integer.parseInt(st.nextToken());
    	}
        
    	bestCost(N, 1, 0,0); // 함수 실행
    	bw.write(max + "\n");// 최대값 BufferedWriter 저장
    	bw.flush(); //결과 출력
    	bw.close();
    	br.close();
    }
    
    // 모든 상담 경우의 수에서 받을 수 있는 금액에 최대값 구하는 함수
    public static void bestCost(int N, int cur, int cost, int lastCost) {
    	if(cur>N+1) { // 상담 기간이 퇴근 기간 넘어갈 경우 취소
    		max = Math.max(max, cost-lastCost);
    		return;
    	}else if(cur==N+1) { // 상담 기간이 퇴근 기간과 딱 맞을 경우
    		max = Math.max(max, cost);
    		return;
    	}
    	for(int i=cur;i<=N;i++) { // 재귀를 통한 모든 상담 경우의 수 구하기
    		bestCost(N, i+T[i], cost + P[i], P[i]);
    	}
    }
}