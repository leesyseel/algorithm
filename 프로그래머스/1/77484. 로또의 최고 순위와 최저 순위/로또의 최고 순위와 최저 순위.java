import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int[] chart = {6, 6, 5, 4, 3, 2, 1};
        
        Set<Integer> set = new HashSet<>();
        for(int num : win_nums){
            set.add(num);
        }
        
        int zero_cnt = 0;
        int correct_cnt = 0;
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0){
                zero_cnt++;
            }else{
                if(set.contains(lottos[i])) correct_cnt++;
            }
        }
        
        int[] answer = new int[2];
        answer[0] = chart[zero_cnt + correct_cnt];
        answer[1] = chart[correct_cnt];
        return answer;
    }
}