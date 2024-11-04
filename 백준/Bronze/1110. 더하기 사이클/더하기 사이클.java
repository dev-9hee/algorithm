import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.print(1);
            return;
        }
        int ans = n;
        int newN = 0;
        int count = 0;
        while (newN != n) {
            newN = ans;
            count++;
            if (n < 10) {
                n = n*10 + n;
            } else {
                n = (n%10)*10 + ((n%10)+(n/10))%10;
            }
        }

        System.out.print(count);
    }
}