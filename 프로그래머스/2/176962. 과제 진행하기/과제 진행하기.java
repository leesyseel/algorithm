import java.util.*;

class Solution {
    
    public static class Subject implements Comparable<Subject>{
        String name;
        int start;
        int playTime;
        
        public Subject(String name, int start, int playTime){
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
        
        public int compareTo(Subject o){
            return this.start - o.start;
        }   
    }
    
    int strToTime(String str){
        String[] arr = str.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
    
    public String[] solution(String[][] plans) {
        int N = plans.length;
        String[] answer = new String[N];
        Subject[] arr = new Subject[N];
        
        for(int i = 0; i < N; i++){
            arr[i] = new Subject(plans[i][0], strToTime(plans[i][1]), Integer.parseInt(plans[i][2]));
        }
        Arrays.sort(arr);
        
        ArrayDeque<Subject> stack = new ArrayDeque<>();
        int nxt = 1, idx = 0;
        Subject curl = arr[0];
        
        while(idx < N){
            int endTime = curl.start + curl.playTime;
            if(nxt < N && endTime > arr[nxt].start){
                curl.playTime = endTime - arr[nxt].start;
                stack.add(curl);
                curl = arr[nxt++];
            }else if(nxt < N && endTime == arr[nxt].start){
                answer[idx++] = curl.name;
                curl = arr[nxt++];
            }else{
                answer[idx++] = curl.name;
                if(!stack.isEmpty()){
                    curl = stack.pollLast();
                    curl.start = endTime;
                }else if(nxt < N){
                    curl = arr[nxt++];
                }
            }
        }
        
        return answer;
    }
}