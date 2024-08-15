import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	

	public static void main(String[] args) throws Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(bf.readLine());
		String[] inp = bf.readLine().split(" ");
		double[] score=new double[N];
		double[] newS=new double[N];
		double M= Double.MIN_VALUE;
		
		for(int i=0;i<N;i++) {
			score[i]=Double.parseDouble(inp[i]);
			if (M<score[i]) M=score[i];
		}
		
		double sum=0;
		for(int i=0;i<N;i++) {
			newS[i]=score[i]/M*100;
			sum+=newS[i];
		}
		bw.append(Double.toString(sum/N)).append("\n");
		bw.flush();
		bw.close();
		bf.close();
	}
}
