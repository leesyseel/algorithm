import java.util.*;

class Solution {
    
    static TreeMap<Integer, Integer> sums;
    
    public void solve(int num, String enter, String out){
        String[] tmp = enter.split(":");
        int enterTime = 60 * Integer.parseInt(tmp[0]) + Integer.parseInt(tmp[1]);
        tmp = out.split(":");
        int outTime = 60 * Integer.parseInt(tmp[0]) + Integer.parseInt(tmp[1]);
        int usingTime = outTime - enterTime;
        
        if(sums.containsKey(num)){
            sums.replace(num, sums.get(num) + usingTime);
        }else{
            sums.put(num, usingTime);
        }
    }
    
    public int[] solution(int[] fees, String[] records) {
        
        sums = new TreeMap<>();
        HashMap<Integer, String> map = new HashMap<>();
        
        for(String str : records){
            StringTokenizer stk = new StringTokenizer(str);
            String time = stk.nextToken();
            int num = Integer.parseInt(stk.nextToken());
            String sign = stk.nextToken();
            
            if(sign.equals("IN")){
                map.put(num, time);
                continue;
            }
            
            String enterTime = map.get(num);
            map.remove(num);
            solve(num, enterTime, time);     
        }
        
        for(int num : map.keySet()){
            solve(num, map.get(num), "23:59");
        }
        
        int[] answer = new int[sums.size()];
        int idx = 0;
        for(int num : sums.keySet()){
            int usingTime = sums.get(num);
            
            if(usingTime < fees[0]){
                answer[idx++] = fees[1];
            }else{
                answer[idx++] = fees[1] + (int) Math.ceil((usingTime - fees[0]) * 1.0 / fees[2]) * fees[3];
            }
        }
        return answer;
    }
}