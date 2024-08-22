import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int result;
	static int cnt;
	
	static void make_match(int idx, int pick,int[] arr, int[][] match) {
		if(pick==2) {
			match[cnt][0]=arr[0];
			match[cnt++][1]=arr[1];
		}else {
			for(int i=idx;i<6;i++) {
				arr[pick]=i;
				make_match(i+1,pick+1,arr,match);
			}
		}
	}
	
	static void check(int idx, int[][] match, int[][] table) {
		
		if(result==1) return;
		
		if(idx==cnt) {
			result=1;
			return;
		}
		
		//idx 매치
		int c1=match[idx][0];
		int c2=match[idx][1];
		
		//match[idx][0] win, match[idx][1] lose
		if(table[c1][0]>0&&table[c2][2]>0) {
			table[c1][0]--;
			table[c2][2]--;
			check(idx+1, match, table);
			table[c1][0]++;
			table[c2][2]++;
		}
		
		//match[idx][0] lose, match[idx][1] win
		if(table[c1][2]>0&&table[c2][0]>0) {
			table[c1][2]--;
			table[c2][0]--;
			check(idx+1, match, table);
			table[c1][2]++;
			table[c2][0]++;
		}
		
		//draw
		if(table[c1][1]>0&&table[c2][1]>0) {
			table[c1][1]--;
			table[c2][1]--;
			check(idx+1, match, table);
			table[c1][1]++;
			table[c2][1]++;
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		int[][] table= new int[6][3];
		int[][] match = new int[15][2];
		int[] arr=new int[2];
		
		cnt=0;
		make_match(0,0,arr,match);
		
		
		for (int tc = 0; tc < 4; tc++) {
			
			boolean flag=true;
			
			stk=new StringTokenizer(br.readLine());
			int total_win=0, total_lose=0, total_draw=0, draw_country=0;
			for(int r=0;r<6;r++){
				int ct_win=Integer.parseInt(stk.nextToken());
				int ct_draw=Integer.parseInt(stk.nextToken());
				int ct_lose=Integer.parseInt(stk.nextToken());
				
				
				table[r][0]=ct_win;
				table[r][1]=ct_draw;
				table[r][2]=ct_lose;
				
				if(ct_win+ct_lose+ct_draw!=5) {flag=false; break;}
				
				total_win+=ct_win; total_lose+=ct_lose;
				if(ct_draw!=0) {total_draw+=ct_draw; draw_country++; }
			}
			
			if(total_win!=total_lose) flag=false;
			
			if(total_draw!=0&&(total_draw%2!=0||draw_country<2)) flag=false;
			
			result=0;
			if(flag) {
				check(0,match,table);
			}

			sb.append(result).append(" ");
		}

		System.out.println(sb);
	}

}