import java.util.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
        int[][] map = new int[N][M];
        
        int[][] dx = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        int d = 0, t = 0;
        int r = 0, c = 0;
        int max = 0;
        
        String s = br.readLine();
        switch(s){
            case "U":
                r = 0; c = M / 2;
                d = 0; t = 0;
                max = N * (M - M / 2);
                break;
            case "D":
                r = N - 1; c = M / 2;
                d = 2; t = 0;
                max = N * (M - M / 2);
                break;
            case "L":
                r = N / 2; c = 0;
                d = 3; t = 1;
                max = M * (N - N / 2);
                break;
            case "R":
                r = N / 2; c = M - 1;
                d = 1; t = 1;
                max = M * (N - N / 2);
                break;
        }
        
        int num = 1;
        map[r][c] = num;

        while(num < max){
            int nr = r + dx[d][0];
            int nc = c + dx[d][1];
            
            if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] != 0){
                d = (d + 1) % 4;
                continue;
            }
            
            r = nr; c = nc;
            num++;
            map[r][c] = num;
            if(t == 0){
                map[r][M - c - 1] = num;
            }else{
                map[N - r - 1][c] = num;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        
	}
}
