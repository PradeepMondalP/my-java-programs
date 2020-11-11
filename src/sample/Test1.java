
package sample;


public class Test1 {
     static  int arr[][] = {
                        {0,1,1,1,0,1,1,1,1,1 },
                        {1,1,1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1,0,1},
                        {1,1,1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,0,1,1,1,1},
                        {1,1,1,1,1,1,1,1,1,1},
                        {1,0,1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1,1,0},
                        {1,1,1,1,1,0,1,1,1,1},
                        {1,1,1,1,1,1,1,1,1,1},
                      };
     
    static int N = arr.length;
    static int x[] = {-1,0,0,1,-1,1,1,-1};
    static int y[] = {0,-1,1,0,1,-1,1,-1};
    
    
    public static void main(String[] args) 
    {
        print(arr);
          long time1 = System.currentTimeMillis(); 
        for(int i = 0;i <N ; i++)
        {
            for(int j =0;j<N ;j++)
            {
                  if(arr[i][j]==0)
                  {
                      for(int m=0 ; m<8; m++)
                          if( isValid(i+x[m],j+y[m], arr) )
                                 arr[i+x[m]][j+y[m]]=9;
                  }
            }
        }
        
          for(int i = 0 ; i <N ;i++)
              for(int j = 0 ; j<N;j++)
                  if(arr[i][j]==9)
                      arr[i][j]=0;
        
        System.out.println();
        print(arr);
         
    }
    
    
    
        public static void print(int arr[][])
        {
                for(int i = 0 ; i<N ; i++)
                {
                    for(int j = 0 ;j<N ; j++)
                        System.out.print(arr[i][j]+" ");
                       
                     System.out.println();
                }
       }
        
        
        public static boolean isValid(int x , int y , int arr[][])
             {
                 return (x>=0 && x<N && y>=0 && y<N);
             }
        
}
  

