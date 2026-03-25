class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] arr = s.toCharArray();
        int len = arr.length;
        
        int same = 1, diff = 0;
        char std = arr[0];
        boolean flag = true;
        int idx = 0;
        
        while(++idx < len){
            flag = true;
            if(std == arr[idx]) same++;
            else diff++;
            
            if(same == diff){
                answer++;
                if(idx + 1 < len){
                    std = arr[++idx];
                    same = 1; diff = 0;
                }else{
                    flag = false;
                }
            }
        }
        if(flag) answer++;
        
        return answer;
    }
}