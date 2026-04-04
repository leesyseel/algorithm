class Solution {
    public int solution(String word) {
        
        int answer = 0;
        char[] arr = word.toCharArray();
        int[] weights = {781, 156, 31, 6, 1};
        char[] dict = {'A', 'E', 'I', 'O', 'U'};
        
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < 5; j++){
                if(arr[i] == dict[j]){
                    answer += j * weights[i] + 1;
                }
            }
        }
        
        
        return answer;
    }
}