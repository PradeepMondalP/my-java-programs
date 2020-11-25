/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppc1.arrays;

import java.util.*;


public class ReverseArrayINGrps {
    public static void main(String[] args) {
        
     //   List<Integer> list = new ArrayList<>(Arrays.asList(5,6,8,9, 10));
          int arr[] ={1,2,3,7,8,9};
        System.out.println(subarraySum(5,17, arr));
        
        
    }
    
    
    static List<Integer> subarraySum(int n, int sum, int[] arr) {
        
        // Your code here
        ArrayList<Integer>list = new ArrayList<>();
        if(n==0) return list;
        int start=0 , end = 0 , tempSum=0;
        
        for(int i=0 ; i< n ; i++){            
            
            if(tempSum==sum)  break;
            
            tempSum += arr[i];
            
            while(tempSum  > sum)  tempSum -= arr[start++];
                   
            end = i;
        }
        
        list.add(start+1);
        list.add(end +1);
        
        return list;
    }
    
    
    static int transitionPoint(int arr[], int n) {
    // code here
      int start=0 , end=n;
        while(start < end)
        {
            int mid = (start+end)/2;
            if(arr[mid]==0) start = mid+1;
            else end = mid;
        }
        if(start>=n)return -1;
        return start;
}
    
    static void reverseInGroups(List<Integer> list, int n, int k) {
        
        List<Integer>list2 = new ArrayList<>();
        for(int i=0 ; i<n ; i+=k)
        {
            int start=i , end;
            if(start+k <n) end = start+k-1;
            else end = n-1;
            
            while(start <= end)
                  list2.add( list.get(end--));
            
        }
        
        //System.out.println("list2   "+ list2);
        list.clear();
        for(int x : list2)  list.add(x);
    }

}

/*
Input:
50 98
0 14 41 18 30 57 60 30 49 75 23 97 59 34 57 45 33 79 17 15 15 39 98 81 19 61 7 81 84 57 68 64 85 62 29 11 94 81 50 90 34 46 43 24 38 90 96 99 61 21

Its Correct output is:
21 61 99 96 90 38 24 43 46 34 90 50 81 94 11 29 62 85 64 68 57 84 81 7 61 19 81 98 39 15 15 17 79 33 45 57 34 59 97 23 75 49 30 60 57 30 18 41 14 0


Test against custom input
  

And Your Code's output is:
21 61 99 96 90 38 24 43 46 34 30 50 98 94 11 29 62 85 64 68 57 84 81 7 14 19 59 81 39 15 15 17 79 33 45 57 75 81 97 23 34 49 30 60 57 90 18 41 61 0
*/