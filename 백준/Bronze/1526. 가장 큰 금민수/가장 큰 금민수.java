import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		
		//-1을 몇번을 해야할지 모르기때문에 무한루프로 반복
		while(true) {
			//4와 7로만 이루어진 값인지 판단하기위한 변수
			boolean check = true;
			//해당 인덱스에 4와 7 둘다 아니면 check에 false를 저장하고 반복문 종료
			for(int i = 0; i < N.length(); i++) {
				if(N.charAt(i) != '4' && N.charAt(i) != '7') {
					check = false;
					break;
				}
			}
			//해당 값이 4와 7이라면 check는 true일 것이고, true라면 반복문 종료
			//false라면 해당 값에 -1을 해준다. 입력받은건 String이기 때문에 형변환을 해줘서 빼주고, 다시 형변환
			if(check == true) break;
			else N = String.valueOf(Integer.parseInt(N) - 1);
		}
		System.out.println(N);
	}

}