
public class KthPermutation {
    
    public static void main(String[] args) {
        
        int n=5 , k=2;
        StringBuffer res=new StringBuffer() ;
        StringBuffer str=new StringBuffer();
        
        for(int i=1 ; i<=n ; i++)str.append(i+"");
        
        solve(str.toString() , n , k , res);
        System.out.println(res);
    }

    static void solve(String str ,int n, int pos, StringBuffer res) 
    {
        if(pos<=0){
            for(int i=str.length()-1 ; i>=0 ; i--)  res.append(str.charAt(i));
            return;
        }
        if(str.length()==1){
            res.append(str.charAt(0));  return ;
        }
        
        int totalSize = fact(n) , grpSize = totalSize/n , count=0;
        
        for(int start=1,end=start+grpSize-1 ; end<=totalSize ; start+=grpSize , end=start+grpSize-1)
        {
            count++;
            if(pos>=start && pos<=end)
            {
                res.append(str.charAt(count-1));
                str = str.substring(0,  count-1) + str.substring(count);
                int newPos = pos%grpSize;
                solve(str, n-1, newPos, res);
            }
        }
    }
    
    static int fact(int n)
    {
        int fact=1;
        for(int i=2 ; i<=n ; i++)  fact*=i;
        
        return fact;
    }
}
