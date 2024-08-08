import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 그래프 표현
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i=1; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        // 그래프 구현 => edge 간선 사용
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        // bfs 초기화
        boolean[] visited = new boolean[n+1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, 0}); // 시작 노드 1, 현재 거리는 0
        visited[1] = true; // 방문 표시
        
        // bfs 탐색
        int maxDist = 0, count = 0; // 최대 거리, 최대 거리의 노드 수
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            // cur[0] : 현재 노드, cur[1] : 현재 거리
            
            // maxDist 구하기
            if (maxDist < cur[1]) {
                maxDist = cur[1];
                count = 1;
            } else if (maxDist == cur[1]) {
                count++;
            }
            
            // 자식 간선 탐색
            for (int next : graph.get(cur[0])) {
                if (visited[next]) continue; // 이미 방문
                
                visited[next] = true;
                queue.add(new int[]{next, cur[1] + 1});
            }
        }
        return count;
    }
}