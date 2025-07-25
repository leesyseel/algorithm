import java.io.*;
import java.util.*;

class Main{
    
    public static class Point implements Comparable<Point>{
        int x;
        int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public int compareTo(Point o){
            if(this.y != o.y)
                return this.y - o.y;
            return this.x - o.x;
        }
        
        public String toString(){
            return x +" "+y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        Point[] lst = new Point[N];
        for(int i = 0; i < N; i++){
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            lst[i] = new Point(x, y);
        }
        Arrays.sort(lst);
        
        for(int i = 0; i < N; i++){
            sb.append(lst[i].toString()).append("\n");
        }
        System.out.println(sb);
    }
}