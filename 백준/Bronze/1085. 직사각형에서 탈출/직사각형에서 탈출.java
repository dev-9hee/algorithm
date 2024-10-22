import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(); // 현수 위치 (x, y)
        int y = sc.nextInt();
        int w = sc.nextInt(); // 오른쪽 위 꼭짓점(w, h)
        int h = sc.nextInt();
        
        // (x, y) 에서 (0, y) (x, 0) (x, h) (w, y) 까지의 직선 거리 중 최소값
        int md1 = x;
        int md2 = y;
        int md3 = Math.abs(h - y);
        int md4 = Math.abs(w - x);
        
        // 구해야 할 거리 최소값
        int minDist = Math.min(Math.min(md1, md2), Math.min(md3, md4)); 
        
        System.out.println(minDist);
    }
}