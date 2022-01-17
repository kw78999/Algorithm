/*
문제
수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 
통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 
단, N은 홀수라고 가정하자.

산술평균 : N개의 수들의 합을 N으로 나눈 값
중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
최빈값 : N개의 수들 중 가장 많이 나타나는 값
범위 : N개의 수들 중 최댓값과 최솟값의 차이
N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 단, N은 홀수이다. 
그 다음 N개의 줄에는 정수들이 주어진다. 
입력되는 정수의 절댓값은 4,000을 넘지 않는다.

출력
첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
둘째 줄에는 중앙값을 출력한다.
셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
넷째 줄에는 범위를 출력한다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nArr = new int[n];
        long mean = 0;
        int median = 0, freq = 0, range = 0;
        double sum = 0;
        int[] counting = new int[8001];
        int[] orderedArr = new int[n];

        for(int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(br.readLine());
            sum += nArr[i];
            counting[nArr[i] + 4000]++;
        }
        br.close();

        // 최빈값
        int max = 0;
        boolean flag = false;

        for(int i = 0; i < counting.length; i++) {
            if(counting[i] > max) {
                max = counting[i];
                freq = i - 4000;
                flag = true;
            } else if(counting[i] == max && flag == true) {
                freq = i - 4000;
                flag = false;
            }
        }

        // 누적합 구하기
        for(int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        // 정렬된 값 저장
        for(int i = nArr.length - 1; i >= 0; i--) {
            int value = nArr[i];
            counting[value+4000]--;
            orderedArr[counting[value+4000]] = value;
        }

        // 산술평균
        mean = Math.round(sum / n);
        // 중앙값
        median = orderedArr[orderedArr.length/2];
        // 범위
        range = orderedArr[n-1] - orderedArr[0];

        System.out.println(mean);
        System.out.println(median);
        System.out.println(freq);
        System.out.println(range);

    }
}
