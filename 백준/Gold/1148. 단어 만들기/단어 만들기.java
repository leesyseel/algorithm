import java.util.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[][] words = new int[200000][26];
		
		
		int N = 0;
		while(true){
		    String word = br.readLine();
		    
		    if(word.equals("-")) break;
		    
		    for(int i = 0; i < word.length(); i++){
		        words[N][word.charAt(i) - 'A'] += 1;
		    }
		    N++;
		}
		
		while(true){
		    String ins = br.readLine();
		    
		    if(ins.equals("#")) break;
		    
		    int[] board = new int[26];
		    int[] res = new int[26];
		    for(int i = 0; i < ins.length(); i++){
		        board[ins.charAt(i) - 'A'] += 1;
		    }
		    
		    for(int i = 0; i < N; i++){
		        boolean flag = false;
		        for(int j = 0; j < 26; j++){
		            if(board[j] < words[i][j]){
		                flag = true;
		                break;
		            }
		        }
		        if(flag) continue;
		        
		        for(int j = 0; j < 26; j++){
		            if(words[i][j] > 0) res[j]++;
		        }
		    }
		    
		    int min = 200000;
		    int max = 0;
		    for(int i = 0; i < 26; i++){
		        if(board[i] == 0) continue;
		        
		        min = Math.min(res[i], min);
		        max = Math.max(res[i], max);
		    }
		    
		    for(int i = 0; i < 26; i++){
		        if(board[i] != 0 && res[i] == min){
		            sb.append((char)('A' + i));
		        }
		    }
		    sb.append(" " + min + " ");
		    
		    for(int i = 0; i < 26; i++){
		        if(board[i] != 0 && res[i] == max){
		            sb.append((char)('A' + i));
		        }
		    }
		    sb.append(" " + max + "\n");
		}
		
        System.out.println(sb);
	}
}