
import java.util.Scanner;


public class MinimumNoofJumps {
    
    public static void main(String[] args) {
      
        int xSum= 2^3^4^2;
        System.out.println(xSum);
    }
}

/*
    // c++ code
#include <iostream>
using namespace std;

int solve(int arr[] , int N)
{
   int  count=0 , nextShiftMaxVal  , start=0; 
   nextShiftMaxVal = arr[0];
    
    while(true)
    {
        if(start+nextShiftMaxVal >= N-1){
            count++;  break;
        }
        if(nextShiftMaxVal==0) return -1;
        int maxVal = -999 , maxValInd=-99;	        
        for(int i=1 ; i<=nextShiftMaxVal ; i++)
        {
            if(arr[i+start]+(i+start) > maxVal )
            {
                 maxVal=arr[i+start] +(i+start);
                 maxValInd = i+start;
            }
        }
        count++;
        nextShiftMaxVal=arr[maxValInd];
        start=maxValInd;
    }
 
    return count;
}

int main() {
	int t;  cin>>t;
	while(t--)
	{
	    int N ;    cin>>N;
	    int arr[N];
	    for(int i=0 ; i<N ; i++) cin>>arr[i];
	    
	    cout<<solve(arr , N)<<endl;
	}
	return 0;
}
*/
