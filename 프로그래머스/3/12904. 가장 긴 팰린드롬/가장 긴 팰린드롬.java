class Solution
{
    public int solution(String s)
    {
        int n = s.length();
        if(n == 1) return 1;
        char[] arr = s.toCharArray();
        
        for(int i = n; i > 0; i--){
            for(int j = 0; j <= n - i; j++){
                int lt = j;
                int rt = j + i - 1;
                boolean flag = true;
                
                while(lt <= rt){
                    if(arr[lt++] != arr[rt--]){
                        flag = false;
                        break;
                    }
                }
                if(flag) return i;
            }
        }
        return 0;
    }
}