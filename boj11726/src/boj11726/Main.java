// package boj11726;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력 파일에서 데이터 읽기 (테스트용)
        // System.setIn(new FileInputStream("src/input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 2×n 직사각형의 너비 n 입력받기
        int n = Integer.parseInt(br.readLine());
        
        br.close();
        
        // 메모이제이션을 위한 배열 초기화
        int[] memo = new int[1001];
        
        // 초기 값 설정
        memo[0] = 1;
        memo[1] = 1;
        
        // 동적 계획법을 이용하여 2×n 직사각형을 채우는 방법의 수 계산
        for (int i = 2; i <= n; i++) {
            memo[i] = (memo[i - 2] + memo[i - 1]) % 10007;
        }
        
        // 결과 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(memo[n]));
        bw.flush();
        bw.close();
    }
}