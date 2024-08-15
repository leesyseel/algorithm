import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			String[] inp = (bf.readLine()).split(" ");
			int[] len = new int[3];
            for(int i=0;i<3;i++) {
				len[i]=Integer.parseInt(inp[i]);
			}
			Arrays.sort(len);
			if(len[0]==0&&len[1]==0&&len[2]==0) break;
			
			int lng=len[2]*len[2];
			int srt=len[0]*len[0]+len[1]*len[1];
			
			if (srt==lng) bw.append("right").append("\n");
			else bw.append("wrong").append("\n");
			bw.flush();
		}
		bf.close();
		bw.close();
	}
}