/*

   you are given an integer x, you must choose a group idential adjacent digits and remove a single digit from that group
   for instance:  x = 223336226
    * 23336226  by deleting 2
    * 22336226  by deleting 3
    * 22333626  by deleting 2

    return max :  23336226
 */


public class FindMax {
    
    //use O(n) time and O(n) space

    public static int solution(int x){
        int max = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        
        for(int i = 1; i < sb.length(); i++){
           if(sb.charAt(i - 1) == sb.charAt(i)){
              StringBuilder s = new StringBuilder(sb.toString());
              s.deleteCharAt(i);
              
              int newNum = Integer.valueOf(s.toString());
              
              if(newNum > max)
                  max = newNum;
           }
        }
       return max;
    }
    
    public static void main(String[] args) {
        int res = solution(223336226);
        System.out.println(res);
    }
    
}
