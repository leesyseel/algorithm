class Solution {
    
    static int[] parent;
    
    static int find(int n){
        if(parent[n] < 0) return n;
        return parent[n] = find(parent[n]);
    }
    
    static boolean union(int a, int b) {
 
        int rootA = find(a);
        int rootB = find(b);
 
        if (rootA == rootB)
            return false;
        parent[rootB] = rootA;
        return true;
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = -1;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(computers[i][j] == 1 && i < j){
                    union(i, j);
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            if(parent[i] < 0) answer++;
        }
        return answer;
    }
}