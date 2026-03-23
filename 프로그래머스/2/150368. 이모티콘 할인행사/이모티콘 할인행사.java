class Solution {
    static int[] answer;
    static double[] discount = {10, 20, 30, 40};
    
    public void DFS(int[][] users, int[] emoticons, int[] sum, int idx){
        if(idx == emoticons.length){
            int cnt = 0, tmp = 0;
            for(int i = 0; i < users.length; i++){
                if(users[i][1] <= sum[i]){
                    cnt++;
                }else{
                    tmp += sum[i];
                }
            }
            if(answer[0] < cnt){
                answer[0] = cnt;
                answer[1] = tmp;
            }else if(answer[0] == cnt && answer[1] < tmp){
                answer[1] = tmp;
            }
            
            return;
        }
        
        for(int i = 0; i < 4; i++){
            int dis_price = (int) (emoticons[idx] * (100 - discount[i]) * 0.01);
            for(int j = 0; j < users.length; j++){
                if(users[j][0] <= discount[i]){
                    sum[j] += dis_price;
                }
            }
            DFS(users, emoticons, sum, idx + 1);
            for(int j = 0; j < users.length; j++){
                if(users[j][0] <= discount[i]){
                    sum[j] -= dis_price;
                }
            }
            
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        int[] sum = new int[users.length];
        DFS(users, emoticons, sum, 0);
        
        
        return answer;
    }
}