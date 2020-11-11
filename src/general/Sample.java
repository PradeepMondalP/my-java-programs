/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;
import static java.lang.System.out;

/**
 *
 * @author Pradeep Mondal
 */
public class Sample {
    public static void main(String[] args) {
       int[]x = {9,7,6,5,4,10,3,2,1,0};
        
      for(int j = 0 ;j<x.length ; j++)
      {
          for(int i = 0 ;i<x.length-1 ; i++)
          {
              if(x[i]> x[i+1])
              {
                  int temp = x[i+1];
                  x[i+1]=x[i];
                  x[i]= temp;
              }
          }
      }
      
      for(int d:x)
            System.out.print(d+" ");
    }
    
}
