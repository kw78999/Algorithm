/*
문제
알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

길이가 짧은 것부터
길이가 같으면 사전 순으로
입력
첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.

출력
조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    static String[] sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        sorted = new String[n];

        for (int i = 0; i<n; i++){
            arr[i] = br.readLine();
        }

        mergeSort(arr, 0, n-1);

        for (int i = 0; i<n; i++){
            if(i!=n-1 && arr[i].equals(arr[i+1])) continue;
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();

    }

    static void mergeSort(String[] arr, int left, int right){
        int mid;

        if(left < right){
            mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(String[] arr, int left, int mid, int right){
        int i, j, k, l;
        i = left;
        j = mid+1;
        k = left;

        /* 분할 정렬된 list의 합병 */
        while(i<=mid && j<=right){

            if(arr[i].equals(arr[j])){
                sorted[k++] = arr[i++];
            } else if(arr[i].length() == arr[j].length()){
               for (int v = 0; v < arr[i].length(); v++){
                  if(arr[i].charAt(v) != arr[j].charAt(v) && arr[i].charAt(v) > arr[j].charAt(v)) {
                      sorted[k++] = arr[j++];
                      break;
                  }else if(arr[i].charAt(v) != arr[j].charAt(v) && arr[i].charAt(v) < arr[j].charAt(v)){
                      sorted[k++] = arr[i++];
                      break;
                  }
               }
            } else if(arr[i].length() <= arr[j].length()){
                sorted[k++] = arr[i++];
            } else if(arr[i].length() >= arr[j].length()){
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