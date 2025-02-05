import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = new int[9]; // 9개의 서로 다른 자연수
        int maxValue = Integer.MIN_VALUE; // 최댓값 초기값
        int maxOrder = 0;

        for (int i = 0; i < 9; i++) {
            nums[i] = sc.nextInt();

            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxOrder = i+1;
            }
        }

        System.out.println(maxValue);
        System.out.println(maxOrder);

        sc.close();
    }
}