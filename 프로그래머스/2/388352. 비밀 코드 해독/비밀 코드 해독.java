import java.util.*;

class Solution {
    static int answer;
    
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        int m = ans.length;
        int[] arr = new int[5];
        
        combination(1, 0, n, m, arr, q, ans);
        
        return answer;
    }
    
    static void combination(int idx, int cnt, int n, int m, int[] arr, int[][] q, int[] ans){
        
        if(cnt == 5){
            
            for(int i = 0; i < m; i++){
                int tmp = 0;
                for(int num : arr){
                    for(int j = 0; j < 5; j++){
                        if(num == q[i][j]){
                            tmp++;
                            break;
                        }
                    }
                }
                
                if(tmp != ans[i]) return;
            }
            answer++;
            return;
        }
        
        for(int i = idx; i <= n; i++){
            arr[cnt] = i;
            combination(i + 1, cnt + 1, n, m, arr, q, ans);
        }
    }
}