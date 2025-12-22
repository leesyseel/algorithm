import java.util.*;
import java.io.*;

class Main{
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		int[] B = new int[n];
		int[] C = new int[n];
		int[] D = new int[n];
		long[] arr1 = new long[n * n];
		long[] arr2 = new long[n * n];
		
		for(int i = 0; i < n; i++){
		    StringTokenizer stk = new StringTokenizer(br.readLine());
		    A[i] = Integer.parseInt(stk.nextToken());
		    B[i] = Integer.parseInt(stk.nextToken());
		    C[i] = Integer.parseInt(stk.nextToken());
		    D[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(A);
		Arrays.sort(B);
		Arrays.sort(C);
		Arrays.sort(D);
		
		int idx = 0;
		for(int i = 0; i < n; i++){
		    for(int j = 0; j < n; j++){
		        arr1[idx] = A[i] + B[j];
		        arr2[idx++] = C[i] + D[j];
		    }
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int pt1 = 0;
		int pt2 = n * n - 1;
		long res = 0;
		
		while(pt1 < n * n && pt2 >= 0){
		    long tmp = arr1[pt1] + arr2[pt2];
		    
		    if(tmp < 0){
		        pt1++;
		    }else if(tmp > 0){
		        pt2--;
		    }else{
		        
		        long cnt1 = 1;
		        long cnt2 = 1;
		        
		        while(pt1 < n * n - 1 && arr1[pt1] == arr1[pt1 + 1]){
		            cnt1++;
		            pt1++;
		        }
		        while(pt2 > 0 && arr2[pt2] == arr2[pt2 - 1]){
		            cnt2++;
		            pt2--;
		        }
		        
		        res += cnt1 * cnt2;
		        pt1++;
		        pt2--;
		    }
		    
		}
		System.out.println(res);
	}
}
