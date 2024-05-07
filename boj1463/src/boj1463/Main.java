// package boj1463;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력 파일에서 데이터 읽기 (테스트용)
        // System.setIn(new FileInputStream("src/input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 정수 N 입력받기
        int N = Integer.parseInt(br.readLine());
        
        br.close();
        
        // 메모이제이션을 위한 배열 초기화
        int[] memo = new int[1_000_001];
        
        // 동적 계획법을 이용하여 최소 연산 횟수 계산
        for (int i = 2; i <= N; i++) {
            int minCount = Integer.MAX_VALUE;
            
            // 2로 나누어 떨어지는 경우
            if (i % 2 == 0) {
                minCount = Math.min(minCount, memo[i / 2]);
            }
            
            // 3으로 나누어 떨어지는 경우
            if (i % 3 == 0) {
                minCount = Math.min(minCount, memo[i / 3]);
            }
            
            // 1을 빼는 경우
            minCount = Math.min(minCount, memo[i - 1]);
            
            // 현재 수에 대한 최소 연산 횟수 저장
            memo[i] = minCount + 1;
        }
        
        // 결과 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(memo[N]));
        bw.flush();
        bw.close();
    }
}