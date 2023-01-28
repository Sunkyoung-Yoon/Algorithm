class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        //한글자씩 끊어서 문자열 배열로 저장
        String[] tokens = s.split("");
        boolean flag = true; //앞에 공백인지 체크
        
        for(int i=0; i<tokens.length; i++){
            
            //공백이라면 공백 저장
            if(tokens[i].equals(" ")){
                sb.append(" ");
                flag = true; //공백 등장
            } 
            
            //flag==true면(=앞에 공백이면)대문자, 아니라면 소문자
            else{
                sb.append(flag?tokens[i].toUpperCase():tokens[i].toLowerCase());
                flag=false;
            }
            
        }
        
        answer = String.valueOf(sb); 
        
        return answer; 
    }
}