/*
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
*/

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int[] sorted;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        int[] arr = new int[n];
        sorted = new int[n];

        for (int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        mergeSort(arr, 0, n-1);

        for (int i = 0; i<n; i++){
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();

    }

    static void mergeSort(int[] arr, int left, int right){
        int mid;

        if(left < right){
            mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }
    static void merge(int[] arr, int left, int mid, int right){
        int i, j, k, l;
        i = left;
        j = mid+1;
        k = left;

        while(i<=mid && j<=right){
            if(arr[i]<=arr[j])
                sorted[k++] = arr[i++];
            else
                sorted[k++] = arr[j++];
        }

        if(i>mid){
            for(l=j; l<=right; l++)
                sorted[k++] = arr[l];
        }
        else{
            for(l=i; l<=mid; l++)
                sorted[k++] = arr[l];
        }

        for(l=left; l<=right; l++){
            arr[l] = sorted[l];
        }

    }
}