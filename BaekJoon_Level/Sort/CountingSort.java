/*
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.

출력
첫째 줄부터 N
*/
import java.io.*;
public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        int[] counter = new int[10001];
        int inputCount = Integer.parseInt(bufferedReader.readLine());

        while (inputCount-- > 0) {
            int inputNum = Integer.parseInt(bufferedReader.readLine());
            counter[inputNum]++;
        }

        for (int i = 0; i < 10001; i++) {
            while (counter[i] > 0) {
                bufferedWriter.append(i + "\n");
                counter[i]--;
            }
        }
            bufferedWriter.flush();
    }
}
