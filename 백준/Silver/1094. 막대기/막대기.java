import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int value = in.nextInt();
        int stick = 64;
        int count = 0;

        while(value>0) {
            if (value<stick) {
                stick/=2;
                }else {
                value -= stick;
                count++;
            }
        }
        System.out.println(count);
    }
}