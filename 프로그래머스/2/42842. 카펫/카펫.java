class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        for(int row = 2; row <= sum / 2; row++){
            if(sum % row != 0) continue;
            
            int col = sum / row;
            if((row + col - 2) * 2 == brown && row >= col){
                answer[0] = row; answer[1] = col;
                break;
            }
            
        }
        
        return answer;
    }
}