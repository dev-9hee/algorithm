import java.util.*;

class Solution {

    class Data{
        String A, B, C;
        boolean isAdd;
        
        Data(String expression){

            StringTokenizer st = new StringTokenizer(expression);

            A = st.nextToken();
            isAdd = st.nextToken().equals("+");
            B = st.nextToken();
            st.nextToken();
            C = st.nextToken();
        }
        
        String calculate(int radix, boolean check){
            int aa = Integer.parseInt(A, radix);
            int bb = Integer.parseInt(B, radix);
            
            if(!isAdd){
                bb *= -1;
            }
            
            if(!check || Integer.parseInt(C, radix) == aa + bb){
                return Integer.toString(aa + bb, radix);
            }
            
            return "Wrong";
        }
        
    }
    
    public String[] solution(String[] expressions) {
    
        List<Data> dataList = new ArrayList<>();
        for(String exp : expressions){
            dataList.add(new Data(exp));
        }
                        
        int limitL = 2;
       
        for(String exp : expressions){
            for(int i = 0; i < exp.length(); i++){
                char c =  exp.charAt(i);
                if( '0' <= c && c <= '9'){
                    limitL = Math.max(limitL, c - '0' + 1);
                }
            }
        }
        
        boolean failed[] = new boolean[10];
        
        for(Data data : dataList){
            if(data.C.equals("X")){
                continue;
            }

            for(int i = limitL; i <= 9; i++){
                if(failed[i]){
                    continue;
                }
                
                if(data.calculate(i, true).equals("Wrong")){
                    failed[i] = true;
                }    
            }
        }
        
        List<String> answerList = new ArrayList<>();
        StringBuilder sb;
        
        for(Data data : dataList){
            if(!data.C.equals("X")){
                continue;
            }
            
            String temp = "";
            boolean flag = false;
            
            sb = new StringBuilder();
            sb.append(data.A).append(data.isAdd ? " + " : " - ").append(data.B).append(" = ");
            
            for(int i = limitL; i <= 9; i++){
                if(failed[i]){
                    continue;
                }
                
                if(temp.length() == 0){
                    temp = data.calculate(i, false);
                } else if(!temp.equals(data.calculate(i, false))){
                    flag = true;
                    break;
                }
            }
            
            if(flag || temp.length() == 0){
                sb.append("?");
            }else{
                
                sb.append(temp);
            }
            answerList.add(sb.toString());
        }
                          
        String[] answer = new String[answerList.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = answerList.get(i);
        }
                
        return answer;
    }

}