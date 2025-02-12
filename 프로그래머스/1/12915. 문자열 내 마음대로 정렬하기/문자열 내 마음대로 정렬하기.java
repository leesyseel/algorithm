import java.util.*;

class Solution {
    
    static class Word implements Comparable<Word>{
        char alpha;
        String wd;
        
        public Word(char alpha, String wd){
            this.alpha = alpha;
            this.wd = wd;
        }
        
        public int compareTo(Word W){
            if(this.alpha != W.alpha){
                return Character.compare(this.alpha, W.alpha);
            }else{
                return this.wd.compareTo(W.wd);
            }
        }
    }
    
    public String[] solution(String[] strings, int n) {
        int len = strings.length;
        String[] answer = new String[len];
        Word[] lst = new Word[len];
        
        for(int i = 0; i < len; i++){
            lst[i] = new Word(strings[i].charAt(n), strings[i]);
        }
        Arrays.sort(lst);
        
        for(int i = 0; i < len; i++){
            answer[i] = lst[i].wd;
        }
        
        return answer;
    }
}