
public class maxAnd {
    
    public static void main(String[] args) {
        int arr[]={3,4,2,3};
        
        System.out.println(solve(arr , 4));
    }

    private static long solve(int[] arr , int n) {
    
       long maxVal=0;
       int sum[] = new int[32];
	for(int i=0;i<32;i++) sum[i]=1;

         int firstTime=1;
	for(int i=31;i>=0;i--)
	{
		int ones=0;
		for(int j=0 ; j<n ; j++)
		{
                    int curBit= (arr[j]>>i) &1;
                    if(curBit==1)
                    {
                        if(firstTime==1) ones++;
                        else
                        {
                           sum[i]&=curBit;
                           if(sum[i]==1)  ones++;
                        }
                    }
                 }
                
                
		if(ones>=2)
                {
                    if(firstTime==1)
                    {
                        firstTime=0;
                        for(int k=0;k<n;k++){
                            int curBit= (arr[k]>>k) &1;
                            sum[k]=curBit;
                        }
                    }
                    maxVal+=(int)Math.pow(2, i);

                }
               if(ones<2 && firstTime==0) break;
	}


      return maxVal;

    }
}
