class Solution {
    
    public int strToTime(String str) {
        String[] arr = str.split(":");
        int hour = Integer.valueOf(arr[0]);
        int min = Integer.valueOf(arr[1]);
        return hour * 60 + min;
    }
    
    public String convert(String str){
        return str.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
    }
    
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxTime = 0;
        m = convert(m);
        
        for(String str : musicinfos){
            String[] arr = str.split(",");
            int playTime = strToTime(arr[1]) - strToTime(arr[0]);
            String melody = convert(arr[3]);
            int len = melody.length();
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < playTime; i++) {
                sb.append(melody.charAt(i%len));
            }
            String tmp = sb.toString();
            
            if (tmp.contains(m)) {
                if (playTime > maxTime) {
                    maxTime = playTime;
                    answer = arr[2];
                }
            }
        }
        
        return answer;
    }
}