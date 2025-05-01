class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int now = health;
        int time = 0;
        
        for(int[] attack : attacks){
            int t = attack[0] - time - 1;
            now += bandage[1] * t + bandage[2] * (t / bandage[0]);
            now = now > health ? health : now;
            
            now -= attack[1];
            time = attack[0];
            
            if(now <= 0) break;
        }
        
        answer = now <= 0 ? -1 : now;
        return answer;
    }
}