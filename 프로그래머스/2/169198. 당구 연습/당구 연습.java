class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        
        int len = balls.length;
        int[] answer = new int[len];
        
        for(int i = 0; i < len; i++){
            int targetX = balls[i][0];
            int targetY = balls[i][1];
            answer[i] = Integer.MAX_VALUE;
            
            if(!(startX == targetX && startY < targetY)){
                int dx = startX - targetX;
                int dy = 2 * n - startY - targetY;
                answer[i] = Math.min(answer[i], dx * dx + dy * dy);
            }
            
            if(!(startX == targetX && startY > targetY)){
                int dx = startX - targetX;
                int dy = startY + targetY;
                answer[i] = Math.min(answer[i], dx * dx + dy * dy);
            }
            
            if(!(startX < targetX && startY == targetY)){
                int dx = 2 * m - startX - targetX;
                int dy = startY - targetY;
                answer[i] = Math.min(answer[i], dx * dx + dy * dy);
            }
            
            if(!(startX > targetX && startY == targetY)){
                int dx = startX + targetX;
                int dy = startY - targetY;
                answer[i] = Math.min(answer[i], dx * dx + dy * dy);
            }
        }
        
        return answer;
    }
}