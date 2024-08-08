import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 그래프 표현, 그래프 초기값 설정
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i=1; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        // 그래프 구축 => 간선 사용
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        // bfs 초기화
        boolean[] visited = new boolean[n+1]; // 방문 표시
        Queue<int[]> queue = new ArrayDeque<>(); // 노드, 거리 저장
        queue.add(new int[]{1, 0}); // 시작 노드 1, 초기 거리 0으로 설정
        visited[1] = true; // 시작노드 방문 표시
        
        int maxDist = 0, count = 0; // 최대 거리와 최대 거리의 노드 개수 초기값
        while (!queue.isEmpty()) { // 큐가 빌 때까지 반복
            int[] cur = queue.remove(); // 현재 노드와 현재 거리
            // cur[0] : 현재 노드, cur[1] : 현재 거리
            
            // 최대 거리 찾는 과정
            if (maxDist < cur[1]) {
                maxDist = cur[1];
                count = 1;
            } else if (maxDist == cur[1]) {
                count++;
            }
            
            // 인접 노드를 큐에 추가
            for (int next : graph.get(cur[0])) {
                if (visited[next]) continue; // 방문했다면 넘어감
                
                visited[next] = true; // 방문 표시
                queue.add(new int[]{next, cur[1] + 1});
            }
        }
        
        return count;
    }
}