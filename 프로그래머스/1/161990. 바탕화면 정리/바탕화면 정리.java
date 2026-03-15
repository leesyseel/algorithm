class Solution {
    public int[] solution(String[] wallpaper) {
        
        int minR = 100, minC = 100, maxR = 0, maxC = 0;
        
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    minR = Math.min(minR, i);
                    minC = Math.min(minC, j);
                    maxR = Math.max(maxR, i);
                    maxC = Math.max(maxC, j);
                }
            }
        }
        
        int[] answer = {minR, minC, maxR + 1, maxC + 1};
        
        return answer;
    }
}