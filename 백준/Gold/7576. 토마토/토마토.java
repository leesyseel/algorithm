import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int day=0;
		String[] inp;
		
		inp=bf.readLine().split(" ");
		int col=Integer.parseInt(inp[0]);
		int row=Integer.parseInt(inp[1]);
		
		int[][] tmt=new int[row][col];
		Queue<Point> Q = new LinkedList<>();
		int[] dr= {-1,0,1,0};
		int[] dc= {0,1,0,-1};
		
		for(int i=0;i<row;i++) {
			inp=bf.readLine().split(" ");
			for(int j=0;j<col;j++) {
				tmt[i][j]=Integer.parseInt(inp[j]);
				if (tmt[i][j]==1) Q.add(new Point(i,j));
			}
		}
		
		int len=Q.size();
		Point P;
		while(!Q.isEmpty()) {
			if(len==0) {
				day++;
				len=Q.size();
			}
			len--;
			P=Q.poll();
			int r=P.row, c=P.col;
			for(int i=0;i<4;i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				if(nr>=0&&nr<row&&nc>=0&&nc<col&&tmt[nr][nc]==0) {
					tmt[nr][nc]=1;
					Q.add(new Point(nr,nc));
				}
			}
		}
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(tmt[i][j]==0) {
					day=-1; break;
				}
			}
		}

		
		bw.append(day+"").append("\n");
		bw.flush();
		bf.close();
		bw.close();
	}
}

class Point{
	int row;
	int col;
	
	public Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
}