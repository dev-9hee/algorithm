import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] heights = new int[9]; // 9명의 키를 저장
        int sum = 0;
        
        for (int i=0; i<9; i++) {
            heights[i] = sc.nextInt();
            sum += heights[i]; 
        }
        
        // 가짜 난쟁이 2명 찾기 (전체 합 - 100이 가짜 난쟁이 2명의 합)
        boolean found = false;
        for (int i=0; i<8 && !found; i++) {
            for (int j=i+1; j<9; j++) {
                if (sum - heights[i] - heights[j] == 100) {
                    // 가짜 난쟁이를 제외한 7명의 키를 새 배열에 저장
                    int[] dwarfs = new int[7];
                    int idx = 0;
                    for(int k = 0; k < 9; k++) {
                        if(k != i && k != j) {
                            dwarfs[idx++] = heights[k];
                        }
                    }
                    
                    Arrays.sort(dwarfs); // 오름차순 정렬
                    
                    for (int height : dwarfs) {
                        System.out.println(height);
                    }
                    
                    found = true;
                    break;
                }
            }
        }
        sc.close();
    }
}