
import java.util.Arrays;
import java.util.Scanner;



public class sample {
    
    public static void main(String[] args) 
    {
               Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- >0)
		{
		    String str=sc.next();
                    int j=str.length() , temp=j;
                    StringBuilder stb=new StringBuilder();
                    
                    while(j-->0)
                    {
                        while(j>=0 && str.charAt(j)!='.') j--;
                        if(j==-1)  System.out.print(str.substring(0, temp) +"\n");
                        else  System.out.print(str.substring(j+1, temp)+".");
                        temp=j;
                    }
                }
          
    }
    
    // important    merging two sorted array
     public static void merge(int a[], int b[], int n, int m) {//n=4 , m=5
        
        int onesCount=0;
        int k = (int)Math.ceil( (m+n+1)/2  );
        
        while(onesCount <2)
        {
            for(int i=0,j=i+k-1 ; j<(m+n); i++,j=i+k-1  )
            {
                if(i-n<0 && j-n<0){
                     if(a[i]>a[j])  swap(a,a,i,j);
                }
                else  if(i-n>=0 && j-n>=0){
                    if(b[i-n] > b[j-n]) swap(b,b,i-n , j-n);
                }
                else{
                    if(a[i] >b[j-n])  swap(a,b,i , j-n);
                }
            }
            k= (int)Math.ceil((k+1)/2);
            if(k==1)  onesCount++;
        }
        Arrays.sort(a);  Arrays.sort(b);
    }
    
    public static  void swap(int a[] , int b[] , int i , int j)
    {
        int temp=a[i];
        a[i]=b[j];
        b[j]=temp;
    }
    
    
}

