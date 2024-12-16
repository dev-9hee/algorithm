import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int l=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int answer=0;
        for(int i=0;i<n;i++){
            int tape=l;
            tape-=1; //양 끝 0.5제거
            ++answer;
            int j=i;
            //다음 위치까지 커버할 수 있는지 검사
            while(j+1<n&&arr[j+1]-arr[j]<=tape){
                tape-=(arr[j+1]-arr[j]); //테이프 길이 업데이트
                j++; //다음 위치로 이동
            }
            i=j;
        }
        System.out.println(answer);
    }
}