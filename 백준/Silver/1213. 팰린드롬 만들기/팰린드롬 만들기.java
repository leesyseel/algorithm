import java.util.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] str = br.readLine().toCharArray();
		int len = str.length;
		int[] count = new int[26];
		boolean[] isOdd = new boolean[26];
		
		for(int i = 0; i < len; i++){
		    int idx = str[i] - 'A';
		    count[idx]++;
		    isOdd[idx] = !isOdd[idx];
		}
		
		int oddCnt= 0;
		for(int i = 0; i < 26; i++){
		    if(isOdd[i]) oddCnt++;
		    if(oddCnt >= 2){
		        System.out.println("I'm Sorry Hansoo");
		        return;
		    }
		}
		
		for(int i = 0; i < 26; i++){
		    for(int j = 0; j < count[i] / 2; j++){
		        sb.append((char)('A' + i));
		    }
		}
		for(int i = 0; i < 26; i++){
		    if(isOdd[i]){
		        sb.append((char)('A' + i));
		        break;
		    }
		}
		for(int i = 25; i >= 0; i--){
		    for(int j = 0; j < count[i] / 2; j++){
		        sb.append((char)('A' + i));
		    }
		}
		
		System.out.println(sb);
	}
}
