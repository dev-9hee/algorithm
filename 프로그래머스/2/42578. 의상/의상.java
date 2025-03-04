import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1; // 각 의상 종류별 선택 가능 개수를 곱하기 위한 변수 초기화
        Map<String, Integer> map = new HashMap<String, Integer>(); // 의상 종류별 개수를 저장할 HashMap 선언

        // 의상 데이터를 HashMap에 저장
        for (String[] cloth : clothes) {
            // cloth[1]은 의상의 종류, 해당 종류의 의상 개수를 1 증가시킴
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        // 경우의 수 계산
        for (Integer value : map.values()) {
            // 해당 종류의 의상을 선택하지 않는 경우(1)를 포함하여 경우의 수를 곱함
            answer *= value + 1;
        }

        // 최소한 하나 이상의 의상을 입어야 하므로 아무것도 입지 않는 경우(1)를 제외하고 반환
        return answer - 1;
    }
}
