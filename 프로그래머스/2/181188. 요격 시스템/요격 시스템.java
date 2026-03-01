/*
import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        Arrays.sort(targets, (a, b) ->{
            if(a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        });
        
        int answer = 0;
        int last = 0;
        for(int i = 0; i < targets.length; i++){
            if(last <= targets[i][0]){
                answer++;
                last = targets[i][1];
            }else{
                if(last > targets[i][1]){
                    last = targets[i][1];
                }
            }
        }
        return answer;
    }
}
*/
import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        
        Arrays.sort(targets, (arr1, arr2) -> Integer.compare(arr1[1], arr2[1]));
        int end = targets[0][1];
        for(int[] target : targets) {
            if(target[0] < end) continue;
            
            answer++;
            end = target[1];
        }
        
        return answer;
    }
}