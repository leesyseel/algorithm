class Solution {
    static int N;
    static int answer;
    static boolean[] visited;
    
    public void DFS(int cnt, int rate, int[][] dungeons){
        answer = Math.max(answer, cnt);
        
        for(int i = 0; i < N; i++){
            if(visited[i] || dungeons[i][0] > rate) continue;
            visited[i] = true;
            DFS(cnt + 1, rate - dungeons[i][1], dungeons);
            visited[i] = false;
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        N = dungeons.length;
        visited = new boolean[N];
        DFS(0, k, dungeons);
        return answer;
    }
}