
import java.util.*;


public class FindDuplicatesInArray {
    
    // getting TLE in gfg uff       ,  do in c++
    public static void main(String[] args) {
        int arr[] = {0,3,1,2,2};
        System.out.println(duplicates(arr, 5));
    }
     static ArrayList<Integer> duplicates(int arr[], int n) {
        
        for(int i=0 ; i<n ; i++) arr[arr[i]%n]+=n;
        
        ArrayList<Integer>res = new ArrayList<>();
        
        for(int i=0 ; i<n; i++)
           if(arr[i]>=2*n)  res.add(i);
        
        if(res.size()==0) res.add(-1);
        return res;
    }
}


/*
Map<Integer , Integer>map = new TreeMap<>();
        for(int x : arr)
           map.put(x , map.getOrDefault(x,0)+1 );
        
        ArrayList<Integer>res = new ArrayList<>();
        
        for(Map.Entry<Integer,Integer>ent : map.entrySet() )
           if(ent.getValue()>1 ) res.add(ent.getKey());
        
        if(res.size()==0)  res.add(-1);
        
        return res;
*/

/*
Input:
26
13 9 25 1 1 0 22 13 22 20 3 8 11 25 10 3 15 11 19 20 2 4 25 14 23 14

Its Correct output is:
1 3 11 13 14 20 22 25
*/