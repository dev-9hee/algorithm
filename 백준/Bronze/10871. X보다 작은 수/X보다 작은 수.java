import java.util.*;

public class Main {
    static int n; // 수열안의 정수 개수
    static int x; // x보다 작은거 출력해야 함
    static int[] nums; // 수열 A
    
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        x = sc.nextInt();
        nums = new int[n];
        
        // 수열 A 입력 받음
        for (int i=0; i<n; i++) {
            nums[i] = sc.nextInt();
            if (nums[i] < x) System.out.printf("%d ", nums[i]); // x보다 작은 수 출력
        }
    }
}
