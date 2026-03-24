import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        
        List<Integer> list = new ArrayList<>();
        list.add(k);
        
        while(k > 1){
            if(k % 2 == 0){
                k /= 2;
            }else{
                k = k * 3 + 1;
            }
            list.add(k);
        }
        
        double[] answer = new double[ranges.length];
        int n = list.size();
        
        for(int i = 0; i < ranges.length; i++){
            int left = 0, right = 0;
            
            if(ranges[i][0] == 0 && ranges[i][1] == 0){
                right = n;
            }else{
                left = ranges[i][0];
                right = n + ranges[i][1];
            }
            
            if(left > right - 1){
                answer[i] = - 1;
                continue;
            }
            
            double sum = 0.0;
            for(int j = left; j < right - 1; j++){
                int tmp = list.get(j) + list.get(j + 1);
                sum += tmp / 2.0;
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}