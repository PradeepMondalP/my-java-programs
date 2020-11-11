
package alldatastructure;


public class MergeSort {
    
    static int arr[]={14,33,27,10,35,19,42,44};
     static int count=0;
    
    public static void sort( int l , int r)
    {
        if(l<r)
        {     count++;
            
            int m=(l+r)/2;
            sort( l , m);
            sort( m+1 , r);
            merge( l, m , r);
        }
    }
//
//    private static void merge( int l, int m, int h) {
//       int A[] , B[];
//       int i,j,k;
//       A= new int[m+1];
//       B= new int[h-m];
//       
//       for(int a = 0 ; a<=m ; a++)
//           A[a]= arr[a+l];
//       //        //temp
//        System.out.println("Array A is");
//        for(int y:A)
//            System.out.print("  "+y);
//        System.out.println();
//
//        for(int b = 0 ; b<=h ; b++)
//           B[b]= arr[m+1+b];
//        
//        //        //temp
//        System.out.println("Array A is");
//        for(int y:A)
//            System.out.print("  "+y);
//        System.out.println();
//        
//        i=l; j=m+1 ; k=l;
//        
//        while(i<=m && j<=h)
//        {
//            if(A[i]<B[j])
//                arr[k++]=A[i++]; 
//            
//          else  if(A[i]>B[j])
//                   arr[k++]=B[j++];  
//            
//        }
//        while(i<=A.length)
//            arr[k++]=A[i++];
//        
//         while(j<=B.length)
//            arr[k++]=B[j++];
//        
//    }
//    
    static void print(int arr[])
    {
        for(int x : arr)
            System.out.print(" "+ x);
    }
    
    public static void main(String[] args) {
        
        System.out.println("given array....");
        print(arr);
        System.out.println("............");
        sort( 0, arr.length-1);
        System.out.println("total count ="+count);
        System.out.println("\n\nAfter sorting .............\n");
        print(arr);
    }
    
    

    private static void merge(int l, int m, int h) {
    
        int n1 = m-l+1 ;
        int n2=h-m;
        
        int A[] = new int[n1];
        int B[] = new int[n2];
        
        for(int i=0;i<n1 ;++i)
            A[i] = arr[l+i];
        
        //temp
        System.out.println("Array A is");
        for(int y:A)
            System.out.print("  "+y);
        System.out.println();
        
        for(int j=0;j<n2 ; ++j)
            B[j] = arr[m+1+j];
        
        //temp
          System.out.println("Array B is");
        for(int y:B)
            System.out.print("  "+y);
        System.out.println();
        
        int i=0 , j=0;
        int k=l;
        while(i<n1 && j<n2)
        {
              if(A[i] < B[j])
                  arr[k]=A[i++];
              else 
                  arr[k]=B[j++];
        k++;
        }
        
        while(i<n1)
             arr[k++]=A[i++];
        while(j<n2)
             arr[k++]=B[j++];
    }

}
