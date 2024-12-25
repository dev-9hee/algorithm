import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int year = sc.nextInt(); // 연도
        
        if ((year%4 == 0 && year%100 != 0) || year%400 == 0) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}