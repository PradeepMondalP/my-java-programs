
public class Pattern {
    
    public static void main(String[] args) {
        
        int n=5;
        print(n);
    }
    static void print(int n)
    {
        String arr[] = new String[n];
        int req=2*n+1 , index=0;
        
        for(int i=5 , count=1 ; i>=1 ; i-- , count++)
        {
            StringBuffer sb = new StringBuffer();
            int center = req - 2* count;
            String arr2[] = givePreString(count ,n);
            
            sb.append(arr2[0]);
            //fill remaining String
            while(center-- >0)   sb.append(arr2[1]);
            
            // get pre String and reverse it
            String postString = new StringBuffer(arr2[0]).reverse().toString();
            sb.append(postString);
            
            arr[index++] = sb.toString();
                
        }
        
        //print first half
        for(int i=0 ; i<arr.length ; i++)  System.out.println(arr[i]);
        
        //print next helf , nothing but reverse of 1st half
        for(int i=arr.length-2 ; i>=0 ; i--) System.out.println(arr[i]);
    }
    
    static String[] givePreString(int count , int n)
    {
        String arr[] = new String[2];
        StringBuffer sb = new StringBuffer();
        while(count-- >1)
        {
            sb.append(n-- +"");
        }
        arr[0] = sb.toString();
        arr[1] = n+"";
        return arr;
    }
}
