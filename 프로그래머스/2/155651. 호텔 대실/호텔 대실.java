import java.util.*;

class Solution {
    
    int timeTrans(String str){
        String[] tmp = str.split(":");
        return Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
    }
    
    public int solution(String[][] book_time) {
        
        int answer = 0;
        int len = book_time.length;
        int[][] bookTimes = new int[len][2];
        for(int i = 0; i < len; i++){
            bookTimes[i][0] = timeTrans(book_time[i][0]);
            bookTimes[i][1] = timeTrans(book_time[i][1]) + 10;
        }
        Arrays.sort(bookTimes, (a, b) -> a[0] - b[0]);
        
        Queue<Integer> Q = new PriorityQueue<>();
        for(int[] arr : bookTimes){
            while(!Q.isEmpty() && Q.peek() <= arr[0]){
                Q.poll();
            }
            Q.add(arr[1]);
            answer = Math.max(answer, Q.size());
        }
        
        return answer;
    }
}