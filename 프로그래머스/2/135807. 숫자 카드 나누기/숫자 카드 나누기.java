class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        // 1번 조건
        int gcdA = arrayA[0];
        for(int num : arrayA){
            gcdA = gcd(gcdA, num);
        }
        for(int num : arrayB){
            if(num % gcdA == 0){
                gcdA = 0;
                break;
            }
        }
        answer = Math.max(answer, gcdA);
        
        // 2번 조건
        int gcdB = arrayB[0];
        for(int num : arrayB){
            gcdB = gcd(gcdB, num);
        }
        for(int num : arrayA){
            if(num % gcdB == 0){
                gcdB = 0;
                break;
            }
        }
        answer = Math.max(answer, gcdB);
        
        return answer;
    }
    
    public int gcd(int a , int b) {
	    while (b != 0) {
		    int tmp = b;
		    b = a % b;
		    a = tmp;
	    }
	    return a;
    }
}