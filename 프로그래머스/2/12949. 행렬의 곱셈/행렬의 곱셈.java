class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;
        int m = arr2[0].length;
        int p = arr2.length;
        int[][] answer = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int tmp = 0;
                for(int k = 0; k < p; k++){
                    tmp += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = tmp;
            }
        }
        
        return answer;
    }
}