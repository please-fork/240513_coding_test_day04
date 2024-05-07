// package boj2579;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력 파일에서 데이터 읽기 (테스트용)
        // System.setIn(new FileInputStream("src/input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 계단의 개수 n 입력받기
        int n = Integer.parseInt(br.readLine());
        
        // 계단의 점수를 저장할 배열 초기화
        int[] stairs = new int[n + 1];
        
        // 계단의 점수 입력받기
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        
        br.close();
        
        // 메모이제이션을 위한 배열 초기화
        int[] memo = new int[n + 1];
        
        // 초기 값 설정
        memo[1] = stairs[1];
        if (n >= 2) {
            memo[2] = stairs[1] + stairs[2];
        }
        
        // 동적 계획법을 이용하여 최대 점수 계산
        for (int i = 3; i <= n; i++) {
            memo[i] = Math.max(memo[i - 3] + stairs[i - 1], memo[i - 2]) + stairs[i];
        }
        
        // 결과 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(memo[n]));
        bw.flush();
        bw.close();
    }
}