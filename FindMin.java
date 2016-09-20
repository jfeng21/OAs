/*
   you are given an integer x, duplicate a single number and find max one
   for instance:  x = 1254
    * 11254  
    * 12254  
    * 12554
    * 12544

    return max :  12554
 */
public class FindMin {
    
    //use O(n) time and O(n) space

    public static int solution(int x){
        int min = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        
        for(int i = 1; i < sb.length(); i++){
                 StringBuilder s = new StringBuilder(sb.toString());
           if(sb.charAt(i - 1) >= sb.charAt(i)){
         
              s.deleteCharAt(i);
           }else{
         
              s.deleteCharAt(i - 1);
           }
              int newNum = Integer.valueOf(s.toString());
              
              if(newNum < min)
                  min = newNum;
           }
        
       return min;
    }
    
    public static void main(String[] args) {
        int res = solution(233614);
        System.out.println(res);
    }
    
}
