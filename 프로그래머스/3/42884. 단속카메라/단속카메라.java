import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int last = -30001;
        int len = routes.length;
        
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        for(int i = 0; i < len; i++){
            if(last < routes[i][0]){
                last = routes[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}