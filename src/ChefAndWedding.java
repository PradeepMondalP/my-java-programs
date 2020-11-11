
import java.util.*;


public class ChefAndWedding {
    
          static Scanner sc = new Scanner(System.in);
	public static void main (String[] args) throws java.lang.Exception
	{
		try 
		{
		      byte t = sc.nextByte();
		      while(t-- >0)
		      {
		            int N , K , sum=0;
		            N = sc.nextInt(); 
		            K = sc.nextInt();
		             byte arr[] = new byte[N];
                            for(int i=0; i<N ; i++)
                            {
                                arr[i]= sc.nextByte();
                                sum+=arr[i];
                            }
                            if(sum<=5000)
		                System.out.println( solve( arr,N , K) );
                           // else System.out.println("0");
		            
		      }
		      
		} catch(Exception e) {
		}
	}
	public static int solve(byte []Arr , int n , int k)
	{
	     Map<Byte , Set<Byte>>map = new TreeMap<>();
             byte arr[] = new byte[1001];
             Arrays.sort(Arr);
             Set<Byte>tempSet;
             for(int i=0 ; i<n ; i++)
             {
                 byte input = Arr[i];
                 if(!map.containsKey(arr[input])){
                     tempSet = new TreeSet<>();
                     tempSet.add(input);
                     map.put(arr[input], tempSet);
                     arr[input]++;
                 }
                 else{
                     tempSet = map.get(arr[input]);
                     tempSet.add(input);
                     arr[input]++;
                 }
             }
          System.out.println("map "+ map);
          int cost1=k*map.size() , cost2=k,i=0;
          for(Map.Entry<Byte,Set<Byte>> ent : map.entrySet())
          {
           //   System.out.println("cost2 "+ cost2);
           //   System.out.println("key "+ent.getKey() +"   val "+ent.getValue());
              
                if(i==0) {i++ ; continue; }
           
                if(i==1) {i++; cost2+= ent.getValue().size()*2; continue;}
                
                cost2+=ent.getValue().size();
                
                
          }
          //  System.out.println("cost2 "+cost2);
          return Math.min(cost1 , cost2);
          
	}
}
