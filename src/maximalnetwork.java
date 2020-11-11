
import java.util.*;


public class maximalnetwork {
    public static void main(String[] args) {
        
        int arr[][] ={  {0,1} , {0,3} , {1,2} , {2,4} ,{1,3} , {2,3}};
        System.out.println(maximalNetworkRank(5, arr));
    }
    
    static int maximalNetworkRank(int n, int[][] roads) {
        int res=0;
        Map<Integer ,Set<Integer> > map = new LinkedHashMap<>();
        Set<Integer>temp;
        
        for(int arr[] : roads)
        {
            int key=arr[0] , val = arr[1];
            if(map.containsKey(key))  temp = map.get(key);
            else  temp = new HashSet<>();
            temp.add(val);
            map.put(key , temp);
            
            temp.clear();
            if(map.containsKey(val))  temp=map.get(val);
            else temp=new HashSet<>();
            temp.add(key);
            map.put(val, temp);
        }
        
        int maxSize=0;
        for(Map.Entry<Integer,Set<Integer>> ent : map.entrySet())  maxSize = Math.max(maxSize , ent.getValue().size()  );
        
        List<Integer>maxValList=new ArrayList<>();
        for(Map.Entry<Integer,Set<Integer>> ent : map.entrySet())
            if(ent.getValue().size()==maxSize)
                maxValList.add(ent.getKey() );
        
        
        boolean duplicate=true;
        for(int i=0 ; i<maxValList.size() ; i++)
        {
            int curVal = maxValList.get(i);
            temp  = map.get(curVal);
            for( int j=0 ; j<maxValList.size() ; j++)
            {
                if(i==j)  continue;
                int nextVal = maxValList.get(j);
                if(!temp.contains(nextVal)){
                    duplicate=false;
                    break;
                }
            }
            if(!duplicate) break;
        }
        
        if(!duplicate) return 2*maxSize;
        return (2*maxSize)-1;
    }
}
