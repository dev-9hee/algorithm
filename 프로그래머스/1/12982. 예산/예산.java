import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        
        int count = 0;
        
        for (int price : d) {
            budget -= price;
            if (budget < 0) break;
            count++;
        }
        return count;
    }
}