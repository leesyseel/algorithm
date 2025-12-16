import java.util.*;
import java.io.*;

class Main{
    static class TrieNode{
        boolean isEnd;
        HashMap<Character, TrieNode> children;
        
        public TrieNode(){
            this.isEnd = false;
            this.children = new HashMap<>();
        }
    }
    
    static class Trie{
        
        TrieNode root  = new TrieNode();
        
        void insert(char[] str){
            TrieNode node = this.root;
            
            for(int i = 0; i < str.length; i++){
                char c = str[i];
                TrieNode next = node.children.get(c);
                if(next == null){
                    next = new TrieNode();
                    node.children.put(c, next);
                }
                node = next;
            }
            node.isEnd = true;
        }
        
        boolean search(char[] str){
            TrieNode node = this.root;
            
            for(int i = 0; i < str.length; i++){
                char c = str[i];
                TrieNode next = node.children.get(c);
                if(next == null){
                    return false;
                }
                node = next;
            }
            return true;
        }
    }
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		
		Trie trie = new Trie();
		for(int i = 0; i < N; i++){
		    trie.insert(br.readLine().toCharArray());
		}
		
		int res = 0;
		for(int i = 0; i < M; i++){
		    if(trie.search(br.readLine().toCharArray())) res++;
		}
        System.out.println(res);
	}
}
