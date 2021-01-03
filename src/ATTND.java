
import java.util.*;


public class ATTND {
     public static void main(String[] args)throws java.lang.Exception {
        
        try {
            Scanner sc = new Scanner (System.in);
            int t = sc.nextInt();
            while(t-->0)
            {
                int n = sc.nextInt();
                Map<String , LinkedList<String>>map = new LinkedHashMap<>();
                LinkedList<String>temp;
                ArrayList<String>list = new ArrayList<>();

                sc.nextLine();
                
                for(int i=0 ;i<n ; i++){
                      String str = sc.nextLine();
                      String arr[] = str.split(" ");
                      if(map.containsKey(arr[0])) temp=map.get(arr[0]);
                      else  temp=new LinkedList<>();
                      
                     temp.add(arr[1]);
                      
                      map.put(arr[0], temp);
                      list.add(arr[0]);
                 }
                
                //print..
                Set<String>set = new HashSet<>();
                for(String key : list)
                {
                    if(  (map.get(key).size() >1) || set.contains(key) ){
                        temp = map.get(key);
                        System.out.println(key +" " + temp.get(0) +" ");
                        temp.removeFirst();
                        map.put(key, temp);
                        set.add(key);
                    }
                    else System.out.println(key+" ");
                    
                }


            }
        } catch ( Exception e ) { }
    }
}
