class Solution {
    static int len, answer;
    static int[] arr;
    static int[][] chart = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    
    static void DFS(int idx, int sum, int[] picks){
        
        if(picks[0] + picks[1] + picks[2] == 0){
            answer = Math.min(answer, sum);
            return;
        }
        
        for(int i = 0; i < 3; i++){
            if(picks[i] == 0) continue;
            int j = idx;
            int s = 0;
            while(j < len && j < idx + 5){
                s += chart[i][arr[j]];
                j++;
            }
            if(j == len){
                answer = Math.min(answer, sum + s);
                return;
            }else{
                picks[i] -= 1;
                DFS(j, sum + s, picks);
                picks[i] += 1;
            }
        }
    }
    
    
    public int solution(int[] picks, String[] minerals) {
        answer = Integer.MAX_VALUE;
        len = minerals.length;
        arr = new int[len];
        for(int i = 0; i < len; i++){
            if(minerals[i].equals("diamond")){
                arr[i] = 0;
            }else if(minerals[i].equals("iron")){
                arr[i] = 1;
            }else{
                arr[i] = 2;
            }
        }
        
        DFS(0, 0, picks);
        
        return answer;
    }
}