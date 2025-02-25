import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int day = scanner.nextInt();
        int[] arr = new int[size];

        arr[0] = scanner.nextInt();
        for(int i = 1; i<size; i++){
            arr[i] = arr[i-1] + scanner.nextInt();
        }

        int max = arr[day-1];
        for(int i = day; i<size; i++){
            max = Math.max(arr[i] - arr[i - day], max);
        }

        System.out.println(max);
    }
}