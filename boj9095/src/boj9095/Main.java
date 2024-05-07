// package boj9095;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력 파일에서 데이터 읽기 (테스트용)
        // System.setIn(new FileInputStream("src/input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 테스트 케이스의 개수 T 입력받기
        int T = Integer.parseInt(br.readLine());
        
        // 각 테스트 케이스의 정수 n 저장할 배열
        int[] testCases = new int[T];
        
        // 테스트 케이스 입력받기
        for (int i = 0; i < T; i++) {
            testCases[i] = Integer.parseInt(br.readLine());
        }
        
        br.close();
        
        // 메모이제이션을 위한 배열 초기화
        int[] memo = new int[11];
        memo[1] = 1; // 1
        memo[2] = 2; // 1+1, 2
        memo[3] = 4; // 1+1+1, 2+1, 1+2, 3
        
        // 메모이제이션을 이용한 동적 계획법으로 문제 해결
        for (int i = 4; i < memo.length; i++) {
            // ... + 1 또는 ... + 2 또는 ... + 3
            memo[i] = memo[i - 3] + memo[i - 2] + memo[i - 1];
        }
        
        // 결과 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int n : testCases) {
            bw.write(Integer.toString(memo[n]) + "\n");
        }
        bw.flush();
        bw.close();
    }
}