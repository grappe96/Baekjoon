/*
문제

수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.

입력

첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.
둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)

출력

첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
둘째 줄에는 가장 긴 증가하는 부분 수열을 출력한다.
*/

import java.io.*;
import java.util.*;

public class LongestSub4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken());
        int[] num = new int[N+1];
        int[] dp = new int[N+1];
        Stack<Integer> answer = new Stack<>();
        int max = 0, len;
        st = new StringTokenizer(br.readLine());

        for (int i=1; i<=N; i++) {
            len = 0;
            num[i] = Integer.parseInt(st.nextToken());
            for (int j=1; j<i; j++)
                if(num[j] < num[i] && len < dp[j])
                    len = dp[j];
            dp[i] = len+1;
            max = Math.max(max, dp[i]);
        }
        bw.write(max + "\n");
        for(int i=N; i>0; i--){
            if(dp[i] == max){
                answer.push(num[i]);
                max--;
            }
            if(max == 0)
                break;
        }
        len = answer.size();
        for(int i=0;i<len;i++)
            bw.write(answer.pop() + " ");
        bw.close();
    }
}