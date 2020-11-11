
import java.util.*;


public class NextPermutation {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0 ; i<n; i++)arr[i]=sc.nextInt();
        
        nextPermutation(arr);
        
        for(int x : arr) System.out.print(x+" ");
    }
    
 static void nextPermutation(int[] arr)
    {
        int n=arr.length;
        if(n==1 || n==0) return;
        
        int i=-99 , j=-99;
        
        //finding i
        for(int ind=n-2 ; ind>=0 ; ind--)
            if(arr[ind]<arr[ind+1])
            {
                i=ind;  
                break;
            }
        // finding next  smallest element but greater than val
        int min=99999999;
        for(int x=n-1 ; x>=i+1 ; x--)
        {
            if(i==-99) break;
            if(arr[x]>arr[i])
            {
                if(min==99999999){
                    min=arr[x]; j=x;
                }
                else
                {
                    if(arr[x] < min)
                    {
                        min=arr[x]; j=x;
                    }
                }
            }
        }
        if(i==-99 ||j==-99)
        {
            Arrays.sort(arr);
            return;
        }
        
        //swap i , j
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        
        // i+1  position se saare elemnts sort it and put it
        List<Integer>list = new ArrayList<>();
        for(int x=i+1; x<n ; x++) 
            list.add(arr[x]);
        Collections.sort(list);
        
        int x=i+1;
        for(int val : list)
            arr[x++]=val;
        
    }
    
    
}
