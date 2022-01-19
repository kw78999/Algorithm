/*
문제
2차원 평면 위의 점 N개가 주어진다. 
좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 
둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다.
 (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

출력
첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
*/

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    static int[][] sorted;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        sorted = new int[n][2];

        for (int i = 0; i<n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        mergeSort(arr, 0, n-1);

        for (int i = 0; i<n; i++){
            bw.write(arr[i][0] + " " + arr[i][1] + "\n");
        }
        bw.flush();
        bw.close();

    }

    static void mergeSort(int[][] arr, int left, int right){
        int mid;

        if(left < right){
            mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[][] arr, int left, int mid, int right){
        int i, j, k, l;
        i = left;
        j = mid+1;
        k = left;

        /* 분할 정렬된 list의 합병 */
        while(i<=mid && j<=right){

            if(arr[i][0] == arr[j][0] && arr[i][1] <= arr[j][1]) {
                sorted[k++] = arr[i++];
            }else if(arr[i][0] == arr[j][0] && arr[i][1] >= arr[j][1]){
                sorted[k++] = arr[j++];
            }else if(arr[i][0] <= arr[j][0]){
                sorted[k++] = arr[i++];
            }else if(arr[i][0] >= arr[j][0]){
                sorted[k++] = arr[j++];
            }

        }

        if(i>mid){
            for(l=j; l<=right; l++)
                sorted[k++] = arr[l];
        }else{
            for(l=i; l<=mid; l++)
                sorted[k++] = arr[l];
        }

        for(l=left; l<=right; l++){
            arr[l] = sorted[l];
        }

    }
}