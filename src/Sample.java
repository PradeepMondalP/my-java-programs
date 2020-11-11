import java.util.*;
public class Sample {
    
    public static void main(String[] args) {
        
//        String arr[][] = {
//            {"5","3",".",".","7",".",".",".","."},
//            {"6",".",".","1","9","5",".",".","."},
//            {".","9","8",".",".",".",".","6","."},
//            {"8",".",".",".","6",".",".",".","3"},
//            {"4",".",".","8",".","3",".",".","1"},
//            {"7",".",".",".","2",".",".",".","6"},
//            {".","6",".",".",".",".","2","8","."},
//            {".",".",".","4","1","9",".",".","5"},
//            {".",".",".",".","8",".",".","7","9"}
//        };
        
      //  System.out.println(isValidSudoku(board));
      
//      String s1 ="11" , s2="11";
//        System.out.println(getHint(s1, s2));

        System.out.println(myAtoi("  0000000000012345678"));
    }
    
    public static int myAtoi(String str) {
        long num;
        str = str.trim() ;
        String reqStr = str.split(" ")[0];
        try{
            return getValidation(new StringBuffer(reqStr));
         }
         catch(NumberFormatException e)
         {
             StringBuffer buff = new StringBuffer();
             boolean goodChar=false , badChar=false;
             for(int i=0 ; i<reqStr.length() ; i++)
                {
                   char c = reqStr.charAt(i);
                 
                   if(Character.isAlphabetic(c) || c=='.') break;
                   else if(Character.isDigit(c)){
                       goodChar=true;
                       if(buff.length()>=12) break;
                       buff.append(c);
                   }
                    else if(c=='+' || c=='-'){
                       if(goodChar) break;
                        goodChar=true;
                        buff.append(c);
                   } 
                   else if(goodChar){
                       if(!Character.isDigit(c))  break;
                       if(buff.length()>=12) break;
                       buff.append(c);
                   }
                }
             return getValidation(buff);
         }
    }
    
    public static int getValidation(StringBuffer buff){
             long num=0;
             if(buff.length()==0) return 0;
             if(buff.length()==1 && !Character.isDigit(buff.charAt(0))) return 0;
             num = Long.parseLong(buff.toString());
             if(num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
             if(num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
             return (int)num;
    }
    
        public static int[] plusOne(int[] a) {
        
        int sum=1 , n=a.length-1;
        StringBuffer buff = new StringBuffer();
        
        for(int i=n ; i>=0 ; i--)
        {
            int tsum = a[i]+ sum;
            buff.insert(0 , tsum%10);
            sum=tsum/10;
        }
        if(sum>0) buff.insert(0 , sum);
          //  System.out.println(buff);
            
        int arr[] = new int[buff.length()];    
        for(int i=0 ; i<buff.length() ; i++)
            arr[i]= buff.charAt(i)-'0';
            
        
        return arr;
    }
        
    public static  boolean isValidSudoku(char[][] board)
    {
        
        int arr[];
        
        // check row wise
        for(int i=0 ;i<9 ; i++)
        {
            arr = new int[10];
            for(int j=0; j<9 ;j++){
                 char c = board[i][j];
                 if(Character.isDigit(c)){
                     arr[c-'0']++;
                     if(arr[c-'0']>1)  return false;
                 }
            }
        }
        //check colm  wise
        for(int i=0 ;i<9 ; i++)
        {
            arr = new int[10];
            for(int j=0; j<9 ;j++){
                 char c = board[j][i];
                 if(Character.isDigit(c)){
                     arr[c-'0']++;
                     if(arr[c-'0']>1)  return false;
                 }
            }
        }
        // check individual tables
        for(int i=0; i<9 ; i+=3)
        {
            for(int j=0 ; j<9 ; j+=3)
            {
                arr = new int[10];
                 for(int x=i ; x<i+3 ; x++)
                   {
                      for(int y=j ; y<j+3 ; y++)
                        {
                          char c=board[x][y];
                          if(Character.isDigit(c))
                          {
                            arr[c-'0']++;
                            if(arr[c-'0']>1)  return false;
                           }
                        }
                   }
           }
        }    
        return true;
}
    
    
    
    public static String getHint(String a1, String a2) {
        
        Map<Integer , Map<Integer,Boolean>>map1 = new LinkedHashMap<>(),
                                           map2 = new LinkedHashMap<>();
        int bulls=0 , cows=0;
        
        map1 =conversion(a1);   map2=conversion(a2);
        
        for(Map.Entry<Integer,Map<Integer,Boolean>>ent : map1.entrySet())
        {
             int key = ent.getKey();
            if(map2.containsKey(key))
            {
                Map<Integer,Boolean> h1 = map1.get(key) ;//, temp1=map1.get(key);
                Map<Integer,Boolean> h2 = map2.get(key) ;//, temp2 =map2.get(key);
                
                int count=0;
                while(h1.size()!=0 || h2.size()!=0)
                {
                    for(Map.Entry<Integer , Boolean> ent2 : h1.entrySet())
                    {
                        int key2 = ent2.getKey();
                        if(h2.containsKey(key2)){
                            bulls++;   h1.remove(key2);   h2.remove(key2);
                        }
                        else  count++;  

                        break;
                    }
                }
                cows+= Math.min(count , Math.min(h1.size() , h2.size()));
                
            }
        }
        
        String res="";
         res+=bulls+"A";
         res+=cows+"B";
        return res;
        
    }
    public static Map<Integer , Map<Integer,Boolean> > conversion(String str)
    {
       Map<Integer , Map<Integer,Boolean>>map = new LinkedHashMap<>();
        
        for(int i=0 ; i<str.length() ; i++)
        {
            int val = str.charAt(i)-'0';
            Map<Integer , Boolean>temp;
            if(map.containsKey(val))   temp=map.get(val);
            else  temp = new LinkedHashMap<>();
            
            temp.put(i , true);
            map.put(val , temp);
        }
        return map;
    }
    
    
    public   static int reverse(int x) {
        long res=0 ;
        res=x%10;
        x/=10;
        while(x!=0){
            int rem=x%10;
            x/=10;
            res=(res * 10) +rem;
            if(res>Integer.MAX_VALUE ||res<Integer.MIN_VALUE)  return 0;
        }
        return (int)res;
    }
    
}


