import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Integer[] nums = new Integer[N];
        
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums, Collections.reverseOrder());
        
        for(int i = 0; i < N; i++){
            sb.append(nums[i]).append("\n");
        }
        System.out.println(sb);
    }    
}