class Solution {
    static int answer;
    static int[] board;
    
    static void solve(int idx, int n){
        if(idx == n){
            answer++;
            return;
        }
        
        for(int i = 0; i < n; i++){    
            board[idx] = i;
            if(check(idx)){
                solve(idx + 1, n);
            } 
        }
    }
    
    static  boolean check(int idx){
        for(int i = 0; i < idx; i++){
            if(board[i] == board[idx]) return false;
            if(Math.abs(i - idx) == Math.abs(board[i] - board[idx])) return false;
        }
        return true;
    }
    
    public int solution(int n) {
        answer = 0;
        board = new int[n];
        solve(0, n);
        
        return answer;
    }
}