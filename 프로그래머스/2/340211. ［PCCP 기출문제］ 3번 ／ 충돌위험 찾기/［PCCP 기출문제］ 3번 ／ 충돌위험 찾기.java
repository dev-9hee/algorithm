import java.util.*;
class Solution {
    static Queue<int[]>[] memo; // 경로 기록용 
    static int size;
    static int answer;
    public int solution(int[][] points, int[][] routes) {
        size = routes.length;
        memo = new LinkedList[size];
        for(int i = 0; i < size; i++){
            memo[i] = new LinkedList<>();
        }
        function(points, routes); // 경로 계산 
        function2(); // 충돌 계산 
        return answer;      
    }
    public static void function2(){
        int count = 0;
        while(count != size){
            int [][] map = new int [101][101];
            count = 0;
            for(int i = 0; i < size; i++){
                if(memo[i].isEmpty()){
                    count++;
                    continue;
                }
                int [] temp = memo[i].poll();
                map[temp[0]][temp[1]]++;
            }
            for(int i = 0; i < 101; i++){
                for(int j = 0; j < 101; j++){
                    if(map[i][j] > 1) answer++; // 충돌!
                }
            }
        }
    }
    // 규칙4: 이동 우선순위 x좌표 > y좌표 
    public static void function(int [][] points, int [][] routes){
        for(int i = 0; i < size; i++){
            int [] point = points[routes[i][0] - 1];
            int x = point[0];
            int y = point[1];
            memo[i].add(new int[]{x, y});
            for(int j = 1; j < routes[0].length; j++){
                int [] next_point = points[routes[i][j] - 1];
                int nx = next_point[0];
                int ny = next_point[1];
                
                int xp = nx - x; // 다음 포인트로 이동해야하는 x좌표 
                int yp = ny - y; // 다음 포인트로 이동해야하는 y좌표
                while(xp != 0){
                    if(xp > 0){
                        xp--;
                        x++;
                        memo[i].add(new int[]{x, y});
                    }
                    else{
                        xp++;
                        x--;
                        memo[i].add(new int[]{x, y});
                    }
                }
                while(yp != 0){
                    if(yp > 0){
                        yp--;
                        y++;
                        memo[i].add(new int[]{x, y});
                    }
                    else{
                        yp++;
                        y--;
                        memo[i].add(new int[]{x, y});
                    }
                }
            }
        }
    }
}