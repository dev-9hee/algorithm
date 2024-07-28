import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // ✅ phone_book 정렬한다.
        Arrays.sort(phone_book);

        // ✅ i를 0 ~ phone_book.length - 2까지 순회한다.
        for (int i = 0; i < phone_book.length - 1; i++) {
            //✅ phone_book[i+1]이 phone_book[i]로 시작한다면 false 를 반환한다.
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        // ✅ 접두어를 찾지 못했다면 true 를 반환한다.
        return true;
    }
}