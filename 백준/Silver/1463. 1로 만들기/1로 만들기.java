import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();

		int x = Integer.parseInt(br.readLine());
		
		int[] nums = new int[x+1];
		Arrays.fill(nums, x);
		nums[x]=0;
		
		for(int i=x;i>0;i--) {
			if(i-1>0&&nums[i-1]>nums[i]+1) {
				nums[i-1]=nums[i]+1;
			}
			
			if(i%3==0&&nums[i/3]>nums[i]+1) {
				nums[i/3]=nums[i]+1;
			}
			
			if(i%2==0&&nums[i/2]>nums[i]+1) {
				nums[i/2]=nums[i]+1;
			}
		}
		
		System.out.println(nums[1]);

	}

}
