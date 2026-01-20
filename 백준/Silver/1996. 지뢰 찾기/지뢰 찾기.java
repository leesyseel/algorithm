import java.util.*;
import java.io.*;

class Main{
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		int[][] dx = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}}; 
		
		for(int i = 0; i < N; i++){
		    char[] arr = br.readLine().toCharArray();
		    
		    for(int j = 0; j < N; j++){
		        if(arr[j] == '.') continue;
		        map[i][j] = -1;
		        
		        for(int d = 0; d < 8; d++){
		            int nr = i + dx[d][0];
		            int nc = j + dx[d][1];
		            
		            if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] < 0) continue;
		            
		            map[nr][nc] += (arr[j] - '0'); 
		        }
		    }
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++){
		    for(int j = 0; j < N; j++){
		        if(map[i][j] < 0){
		            sb.append("*");
		        } else if(map[i][j] >= 10){
		            sb.append("M");
		        } else{
		            sb.append(map[i][j] + "");
		        }
		    }
		    sb.append("\n");
		}
		System.out.println(sb);
	}
}
