import java.io.*;
import java.util.*;

public class Main{
    
    public static class Point{
        int r;
        int c;
        int v;
        
        public Point(int r, int c, int v){
            this.r = r;
            this.c = c;
            this.v = v;
        }
    }
    
    static int BFS(Point jh, List<Point> fires, int[][] map, int R, int C){
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        Queue<Point> Q = new ArrayDeque<>();
        Q.add(jh);
        
        for(Point fr : fires)
        	Q.add(fr);
        
        while(!Q.isEmpty()){
            Point P = Q.poll();
            
            if(P.v < 0){
                for(int i = 0; i < 4; i++){
                    int nr = P.r + dr[i];
                    int nc = P.c + dc[i];
                    
                    if(nr < 0 || nr >= R || nc < 0 || nc >=C || map[nr][nc] < 0) continue;
                    
                    map[nr][nc] = -3;
                    Q.add(new Point(nr, nc, -3));
                }
            }else{
                
                if(map[P.r][P.c] < 0 ) continue;
                
                for(int i = 0; i < 4; i++){
                    int nr = P.r + dr[i];
                    int nc = P.c + dc[i];
                    
                    if(nr < 0 || nr > R || nc < 0 || nc > C || map[nr][nc]!= 0) continue;
                    
                    map[nr][nc] = P.v + 1;
                    if(nr == 0 || nr == R || nc ==0 || nc == C)
                        return map[nr][nc];
                    Q.add(new Point(nr, nc, map[nr][nc]));
                }
            }
            
        }
        return 0;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(stk.nextToken());
        int C = Integer.parseInt(stk.nextToken());
        
        int[][] map = new int[R+2][C+2];
        Point jh = null;
        List<Point> fires = new ArrayList<>();
        
        for(int i = 1; i <= R; i++){
            String S = br.readLine();
            for(int j = 0; j < C ;j++){
                switch (S.charAt(j)){
                    case '#':
                        map[i][j + 1] = -2;
                        break;
                    case '.':
                        break;
                    case 'J':
                        jh = new Point(i, j + 1, 0);
                        break;
                    case 'F':
                        map[i][j + 1] = -3;
                        fires.add(new Point(i, j + 1, -3));
                        break;
                }
            }
        }
        
        int res = BFS(jh, fires, map, R+1, C+1);
        
        if(res!=0){
            System.out.println(res);
        }else{
            System.out.println("IMPOSSIBLE");
        }
    }
}