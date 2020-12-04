
import java.util.*;


public class MinSwapToSortArray {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        for(int i=0 ;i<n ; i++) arr[i] =sc.nextInt();
        
        
        System.out.println(minSwap(arr));
    }

    private static int minSwap(int[] arr) {
        int count=0 , n=arr.length;
        
        Map<Integer,Integer>map = new HashMap<>();
        List<Integer>list = new ArrayList<>();
        
        for(int i=0 ; i<n; i++){
             map.put(arr[i], i);
             list.add(arr[i]);
        }
        
        Collections.sort(list);
        System.out.println(list);
        
        for(int i =0 ;i<n ; i++)
        {
            int minEle = list.get(0);
            list.remove(0);
            if(minEle ==  arr[i]) continue;
            
            count++;
            int swapIndex = map.get(minEle);
            
            //swap
            int temp = arr[i];
            arr[i] = arr[swapIndex];
            arr[swapIndex] = temp;
            
            //update the map also
            map.put(arr[i] , i);
            map.put(arr[swapIndex] , swapIndex);
            
           
         }
        return count;
    }
}

/*
8
101 758 315 730 472 619 460 479

0/p :  5

9
957 56 131 977 47 220 75 840 205  

o/p : 6
*/