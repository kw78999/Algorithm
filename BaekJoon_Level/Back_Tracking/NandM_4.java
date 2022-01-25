/*
문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
1부터 N까지 자연수 중에서 M개를 고른 수열
같은 수를 여러 번 골라도 된다.
고른 수열은 비내림차순이어야 한다.
길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.

입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 
중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
수열은 사전 순으로 증가하는 순서로 출력해야 한다
*/

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

    public static int[] arr;
    public static boolean[] visit;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        arr = new int[M];
        visit = new boolean[N];
        dfs(N, M, 0);
        bw.flush();
    }

    public static void dfs(int N, int M, int depth) throws IOException {
        if (depth == M) {
            for (int i = 1 ; i < arr.length; i++){
                if(arr[i-1] > arr[i])return;
            }

            for (int val : arr) {
                bw.write(val + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
                arr[depth] = i + 1;
                dfs(N, M, depth + 1);
        }
    }
}