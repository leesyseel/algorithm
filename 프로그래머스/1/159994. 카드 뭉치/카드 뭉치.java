class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        boolean flag = true;
        int pt1 = 0;
        int pt2 = 0;
        
        for(int i = 0; i < goal.length; i++){
            String str = goal[i];
            
            if(pt1 < cards1.length && str.equals(cards1[pt1])){
                pt1++;
            }else if(pt2 < cards2.length && str.equals(cards2[pt2])){
                pt2++;
            }else{
                flag = false;
                break;
            }
        }
        
        String answer = "Yes";
        if(!flag) answer = "No";
        
        return answer;
    }
}