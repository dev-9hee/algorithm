import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 두 배열을 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);
        // 두 배열이 다를 때까지 찾음
        int i;
        for ( i=0; i<completion.length; i++){

            if (!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        // 마지막 주자가 완주하지 못 했을 경우
        return participant[i];
    }
}