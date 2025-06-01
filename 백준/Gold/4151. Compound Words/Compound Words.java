import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        Set<String> answerSet = new HashSet<>();
        Set<String> set = new HashSet<>();
        
        while((str = br.readLine()) != null){
            set.add(str);
        }
        
        for (String origin : set) {
            int len = origin.length();
            for(int i = 1; i < len; i++){
                String a = origin.substring(0,i);
                String b = origin.substring(i);
                if(set.contains(a) && set.contains(b)){
                    answerSet.add(origin);
                    break;
                }
            }
        }
   
        List<String> answer = new ArrayList<>(answerSet);
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for(String s : answer){
            sb.append(s).append("\n");
        }
        
        System.out.println(sb);
    }
}