import java.util.Stack;

/*
  Given a listing of directories and file in a file system, the absolute path of a
 string containing the names of directories which have to be traversed to reach the
directory, separated by slash character. 
  The image files are the files with extension .jpeg, .png or .gif. We want to find the total 
lengths of the absolute paths to all the directories containing at least one image file

 */
public static class TotalAbsolutePaths{

public static int LengthOfPath(String S) {
        if(S == null || S.length() == 0)
            return 0;
        
        String[] tokens = S.split("\n");
        
        int curLen = 0;
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(String s: tokens){
            int lev = countLevel(s);
            //if current dir/file depth is lower than the top dir/file on the stack, pop from stack
            
            while(stack.size() > lev){
              curLen -= stack.pop();
            //   curLen = stack.peek();
            }
            
             //if s contains".jpeg or .png or gif", we have found a image file!
            if(s.contains(".jpeg")||s.contains(".png") || s.contains(".gif")){
                sum += curLen;
             
                 }else if(s.contains(".txt")){
                    continue;
                    }
            else{
               //+1 here because a "/" needs to be add before each directory   eg: /dir1/dir12
            int len = s.replaceAll("\t", "").length() + 1;
                
               curLen += len;

                stack.add(len);
               System.out.println("current Len:" + curLen);
           
                 }
        }
        
        return sum;
        
}
 private static int countLevel(String s){
        String cur = s.replaceAll("\t", "");
        
         int len = s.length() - cur.length();
          System.out.println(" level " + len+":" + cur);
        return len;
       
    }
}

public static void main(String[] args) {

        String s = "dir1\n\tdir11\n\tdir12\n\t\tfile.jpeg\n\t\tdir121\n\t\tfile1.txt\ndir2\n\tfile2.gif";

        int res = LengthOfPath(s);
      
        System.out.print(res);
       
    }
    


}
