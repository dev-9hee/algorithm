import java.util.*; 

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // 저번 달 이용한 통화 수
		int yPlan = 0, mPlan = 0; // 두 요금 각자 저장
        
        // 통화 시간
        for (int i=0; i<n; i++) { 
            int m = sc.nextInt();
            
            // 요금을 30과 60으로 나눴을때 결과에 맞춰 요금을 저장
			if((m % 30) >= 0) {
				yPlan += ((m / 30) + 1) * 10;
			}else {
				yPlan += (m / 30) * 10;
			}
			if((m % 60) >= 0) {
				mPlan += ((m / 60) + 1) * 15;
			}else {
				mPlan += (m / 60) * 15;
			}
        }
        
        //두 요금을 비교해서 출력
		if(yPlan < mPlan) {
			System.out.println("Y " + yPlan);
		}else if(mPlan < yPlan) {
			System.out.println("M " + mPlan);
		}else {
			System.out.println("Y M " + yPlan);
		}
        
        sc.close();
    }
}