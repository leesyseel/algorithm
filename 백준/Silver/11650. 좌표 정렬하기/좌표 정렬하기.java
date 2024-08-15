import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(bf.readLine());
		List<Point> points = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			String[] inp=bf.readLine().split(" ");
			points.add(new Point(Integer.parseInt(inp[0]), Integer.parseInt(inp[1])));
		}
		points.sort(new Comparator<Point>() {

			@Override
			public int compare(Point p1, Point p2) {
				// TODO Auto-generated method stub
				if (p1.x>p2.x) return 1;
				else if(p1.x==p2.x) {
					if(p1.y>p2.y) return 1;
					else return -1;
				}
				else return -1;
			}
		});
		
		for(Point p: points) {
			bw.append(p.x+" ").append(p.y+"").append("\n");
		}
		
		bw.flush();
		bf.close();
		bw.close();
	}
	
	public static class Point{
		public int x;
		public int y;
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}