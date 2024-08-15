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
		
		int N = Integer.parseInt(bf.readLine());
		Member[] mList = new Member[N];
		for(int i=0;i<N;i++) {
			String[] inp=bf.readLine().split(" ");
			mList[i]=new Member(Integer.parseInt(inp[0]),inp[1]);
		}
		
		Arrays.sort(mList,(m1,m2)->{return m1.age-m2.age;});
		
		
		for(int i=0;i<N;i++) {
			bw.append(mList[i].age+" ").append(mList[i].name).append("\n");
		}
		
		bw.flush();
		bf.close();
		bw.close();
	}
	
	public static class Member{
		int age;
		String name;
		
		public Member(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}
}
