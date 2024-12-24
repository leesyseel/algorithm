import java.io.*;
import java.util.*;

public class Main{
    
    static class Player{
        String id;
        int level;
        
        public Player(String id, int level){
            this.id = id;
            this.level = level;
        }
    }
    
    static class Room{
        int val;
        int cnt;
        List<Player> list;
        
        public Room(int val, int cnt, List<Player> list){
            this.val = val;
            this.cnt = cnt;
            this.list = list;
        }
        
        public void enter(Player P){
            list.add(P);
            cnt--;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;
        
        List<Room> rooms = new ArrayList<>();
        
        stk = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        
        for(int i = 0; i < p; i++){
            stk = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(stk.nextToken());
            String id = stk.nextToken();
            boolean flag = false;
            
            for(Room R : rooms){
                if(R.cnt > 0 && level >= R.val - 10 && level <= R.val + 10){
                    R.enter(new Player(id, level));
                    flag = true;
                    break;
                }
            }
            if(flag) continue;
            
            Room R = new Room(level, m, new ArrayList<>());
            R.enter(new Player(id, level));
            rooms.add(R);
        }
        
        for(Room R : rooms){
            if(R.cnt == 0)
                sb.append("Started!").append("\n");
            else
                sb.append("Waiting!").append("\n");
            
            R.list.sort((o1, o2) -> o1.id.compareTo(o2.id));
            for(Player P : R.list){
                sb.append(P.level).append(" ").append(P.id).append("\n");
            }
        }
        System.out.println(sb);
    }
}