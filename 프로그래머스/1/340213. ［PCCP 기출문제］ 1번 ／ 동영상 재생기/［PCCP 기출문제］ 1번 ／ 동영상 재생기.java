class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int curl = stringToTime(pos);
        int len = stringToTime(video_len);
        int start = stringToTime(op_start);
        int end = stringToTime(op_end);
        
        for(String comm : commands){
            
            if(curl >= start && curl < end){
                curl = end;
            }
            
            if(comm.equals("prev")){
                curl = curl - 10 < 0 ? 0 : curl - 10;
            }else {
                curl = curl + 10 > len ? len : curl + 10;
            }
            
            if(curl >= start && curl < end){
                curl = end;
            }
        }
        
        String answer = new StringBuilder()
            .append((curl/60)/10).append((curl/60)%10)
            .append(":")
            .append((curl%60)/10).append((curl%60)%10)
            .toString();
        return answer;
    }
    
    static int stringToTime(String str){
        char[] chars = str.toCharArray();
        return ((chars[0] - '0') * 10 + (chars[1] - '0')) * 60 
            + ((chars[3] - '0')* 10 + (chars[4] - '0'));
    }
}