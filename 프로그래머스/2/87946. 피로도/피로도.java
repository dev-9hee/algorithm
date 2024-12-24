class Solution {
    int answer = 0; // 탐험할 수 있는 던전 수를 저장
    int n; // 던전의 개수를 저장
    boolean[] visited; // 각 던전에 대해 방문 여부를 저장하는 배열
    
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length; // 던전의 수를 n에 저장
        visited = new boolean[n];
        // 재귀를 이용하여 dungeons의 원소를 완전탐색
        backtrack(k, 0, dungeons);
        return answer;
    }
    
    // k : 현재 피로도, cnt : 현재까지 탐험한 던전 수
    public void backtrack(int k, int cnt, int[][] dungeons) {
        // 최대 cnt를 answer에 업데이트
        if (cnt > answer) {
            answer = cnt;
        }
        // dungeons를 순회
        for (int i=0; i<n; i++) {
            // 현재 피로도 k가 던전 i의 최소 필요 피로도 dungeons[i][0] 이상이고, 
            // 아직 방문하지 않은 던전이라면 그 던전을 탐험
            if (k >= dungeons[i][0] && !visited[i]) {
                visited[i] = true; // 방문
                // 현재 던전 i를 탐험했으므로, 피로도 dungeons[i][1]만큼 줄이고, 
                // 탐험한 던전 수 cnt를 1 증가시켜 재귀적으로 다음 탐험을 시도
                backtrack(k - dungeons[i][1], cnt + 1, dungeons);
                visited[i] = false; // 방문 취소
            }
        }
    }
}