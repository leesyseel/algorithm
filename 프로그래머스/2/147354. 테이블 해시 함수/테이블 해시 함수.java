import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, (a,b) -> {
            if(a[col - 1] != b[col - 1]) return Integer.compare(a[col - 1], b[col - 1]);
            else return -1 * Integer.compare(a[0], b[0]);
        });
        
        for(int i = row_begin; i <= row_end; i++){
            int tmp = 0;
            for(int j = 0; j < data[i - 1].length; j++){
                tmp += data[i - 1][j] % i;
            }
            answer ^= tmp;
        }
        
        return answer;
    }
}