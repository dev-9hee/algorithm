import java.util.*;
import java.io.*;

public class Main {
    static int[] nums; // 1~20까지의 숫자가 저장되어있음
    static int a, b; // 입력받을구간
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        nums = new int[20];
        for (int i=0; i<20; i++) {
            nums[i] = i+1;
        }
        
        for (int i=0; i<10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            
            reverseRange(a-1, b-1);
        }
        
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
    
    public static void reverseRange(int start, int end) {
        while (start < end) {
            // 양끝의 원소를 교환
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        
            // 인덱스를 안쪽으로 이동
            start++;
            end--;
        }
    }
}