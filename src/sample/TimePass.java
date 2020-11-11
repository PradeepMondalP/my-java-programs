
package sample;
import java.util.*;



    
public class TimePass {
    public static void main(String[] args) {
        
           long profit = 0L;
           int maxSoFar=0;
           int arr[] ={5,4,6,4,5};
           for(int i=arr.length-1; i>-1;i--)
           {
               if(arr[i]>=maxSoFar)
                   maxSoFar=arr[i];
               profit+=maxSoFar-arr[i];
               System.out.println("we subtracted "+ maxSoFar +" & "+ arr[i] +" totalProfit :"+profit);
           }
           System.out.println("sum = "+ profit);
           
    }
    
    public static class MulMap<K,V>{
        private final Map<K,Set<V>>mulMap = new HashMap<>();
        
        public  void put(K key , V value){
            this.mulMap.computeIfAbsent(key, k->new HashSet<>());
        }
        
        public Set<V>get(K key){
            return this.mulMap.getOrDefault(key,Collections.emptySet());
        }
        public void remove(K key ,V value){
            this.mulMap.compute(key,(k , set)->set.remove(value) && set.isEmpty()?null:set);
        }
        public boolean conntains(K key , V value){
           return this.mulMap.getOrDefault(key,Collections.emptySet()).contains(value);
        }
    }
}
