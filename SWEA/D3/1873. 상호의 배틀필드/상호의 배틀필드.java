import java.util.*;
import java.io.*;
 
public class Solution {
	
	static boolean check(int r,int c,int R, int C) {
		if(r>=0&&r<R&&c>=0&&c<C) return true;
		return false;
	}
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;
 
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
 
            stk = new StringTokenizer(br.readLine());
            int R=Integer.parseInt(stk.nextToken());
            int C=Integer.parseInt(stk.nextToken());
            
            
            char[][] map = new char[R][C];
            int r=0, c=0;
            int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
            int d=0;
            
            for (int i = 0; i < R; i++) {
                String str=br.readLine();
                for (int j = 0; j < C; j++) {
                    map[i][j] = str.charAt(j);
                    
                    switch (map[i][j]) {
                	case '^': d=0; r=i; c=j; break;
                	case 'v': d=2; r=i; c=j; break;
                	case '<': d=3; r=i; c=j; break;
                	case '>': d=1; r=i; c=j; break;
                	}
                }
            }
            
            int N = Integer.parseInt(br.readLine());
            String action = br.readLine();
            int nr=0, nc=0;
            
            //r,c 전차 위치     d 전차  진행 방향
            
            for(int i=0;i<N;i++) {
            	
            	char act=action.charAt(i);
            	
            	switch (act) {
            	case 'U':
            		d=0;
            		map[r][c]='^';
            		nr=r+deltas[d][0]; nc=c+deltas[d][1];
            		if(check(nr,nc,R,C)&&map[nr][nc]=='.') {
            			map[r][c]='.';
            			map[nr][nc]='^';
            			r=nr; c=nc;
            		}
            		break;
            	case 'D':
            		d=2;
            		map[r][c]='v';
            		nr=r+deltas[d][0]; nc=c+deltas[d][1];
            		if(check(nr,nc,R,C)&&map[nr][nc]=='.') {
            			map[r][c]='.';
            			map[nr][nc]='v';
            			r=nr; c=nc;
            		}
            		break;
            	case 'L':
            		d=3;
            		map[r][c]='<';
            		nr=r+deltas[d][0]; nc=c+deltas[d][1];
            		if(check(nr,nc,R,C)&&map[nr][nc]=='.') {
            			map[r][c]='.';
            			map[nr][nc]='<';
            			r=nr; c=nc;
            		}
            		break;
            	case 'R':
            		d=1;
            		map[r][c]='>';
            		nr=r+deltas[d][0]; nc=c+deltas[d][1];
            		if(check(nr,nc,R,C)&&map[nr][nc]=='.') {
            			map[r][c]='.';
            			map[nr][nc]='>';
            			r=nr; c=nc;
            		}
            		break;
            	case 'S':
            		nr=r+deltas[d][0]; nc=c+deltas[d][1];
            		while(check(nr,nc,R,C)) {
            			if(map[nr][nc]=='*') { //벽돌
            				map[nr][nc]='.';
            				break;
            			}else if(map[nr][nc]=='#') { //강철
            				break;
            			}
            			nr+=+deltas[d][0]; nc+=deltas[d][1];
            		}
            	}            	
            } //모든 action 수행
            
            for(int i=0;i<R;i++) {
            	for(int j=0;j<C;j++) {
            		sb.append(map[i][j]);
            	}
            	sb.append("\n");
            }

        }
        System.out.println(sb);
 
    }
 
}