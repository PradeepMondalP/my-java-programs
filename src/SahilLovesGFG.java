
import java.util.*;

public class SahilLovesGFG {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int k= sc.nextInt() ;
            char arr[][] = new char[8][8];
            for(char a[] :arr)   Arrays.fill(a, 'z');
            
            arr[0][0]='O';
            //  adding king moving boxes stuff..............
            for(int i=0; i<8 ; i++){
                boolean done=false;
                for(int j=0 ; j<8 ; j++)
                {
                    if(k-->0)  arr[i][j]='.';
                    else  {
                        done=true;
                        break;
                    }
                    if(done) break;    
                }
            }
          //  add border to left  , up ..
          for(int i=0 ; i<8 ; i++)
          {
              for(int j=0 ; j<8 ; j++)
              {
                  if(arr[i][j]=='O' || arr[i][j]=='.') continue;
                  // checking left colom has border or not
                  if(j-1 >=0 ) {
                      if(arr[i][j-1]=='O' || arr[i][j-1]=='.'){
                          arr[i][j]='X';  continue;
                      }
                  }
                  //  checking above row has border or not
                  if(i-1>=0 ) {
                      if(arr[i-1][j]=='O' || arr[i-1][j]=='.'){
                          arr[i][j]='X';  continue;
                      }
                  }
                  //  checking top left colum has border or not
                  if(i-1>=0 && j-1>=0){
                      if(arr[i-1][j-1]=='O' || arr[i-1][j-1]=='.'){
                          arr[i][j]='X';  continue;
                      }
                  }
              }
          }
         for(int i=0 ; i<8 ; i++)
          for(int j=0 ; j<8 ; j++)
              if(arr[i][j]=='z')System.out.print('.');
              else System.out.print(arr[i][j]);
        }
    }
}
