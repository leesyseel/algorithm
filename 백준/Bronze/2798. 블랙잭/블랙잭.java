import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	static int N,M,result=Integer.MIN_VALUE;
	static int[] card;
	
	public static void DFS(int idx, int cnt, int sum, int noSum, int cardSum) {
		if(cnt==3) {
            if (sum==M) { result=sum; return;}
			else if (sum<M) {
				if (sum>result) { result=sum; return;}
				else return;
				
			}else { return;}
		}else { //cnt가 3보다 작을 떄
			if(sum>M) return;
			else if(N-idx<3-cnt) return;
			else if((N-idx==3-cnt)&&(sum+cardSum-noSum<result)) return;
			else {
				DFS(idx+1,cnt+1,sum+card[idx],noSum,cardSum);
				DFS(idx+1,cnt,sum,noSum+card[idx],cardSum);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inp=(bf.readLine()).split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);
		int cardSum=0;
		
		inp=(bf.readLine()).split(" ");
		card=new int[N];
		for(int i=0;i<N;i++) {
			card[i]=Integer.parseInt(inp[i]);	
			cardSum+=card[i];
		}
		
		DFS(0,0,0,0,cardSum); //현재 인덱스, 현재 담은 갯수, 현재 누적합, 안 더한 것들의 합, 카드전체합,  M
		
		bw.append(result+"").append("\n");
		bw.flush();
		bw.close();
		bf.close();
	}
}
