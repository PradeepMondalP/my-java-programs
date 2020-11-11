
package hackerrank;

import java.util.*;



public class JourneyToTheMoon {
    
    public static void main(String[] args) {
        
        ArrayList<Integer> list[];
        Scanner sc = new Scanner(System.in);
        int NoOfAst = sc.nextInt();
        int pairs = sc.nextInt();
                                                 // initiakzig my graph
        list = new ArrayList[NoOfAst];
        for(int i=0 ; i<NoOfAst ; i++)
              list[i] = new ArrayList<>();
        
        while(pairs-- >0)                       // graph is created
        {
            int i = sc.nextInt() , j=sc.nextInt();
            list[i].add(j);
            list[j].add(i);
        }
        
                                                   // need dfs traversal...
        boolean []vis = new boolean[NoOfAst];
        ArrayList<Integer>stk = new ArrayList<>();
        ArrayList<Integer>temp;
        ArrayList<Integer>frq = new ArrayList<>();
        
        for(int i=0 ; i<NoOfAst ; i++)
        {
            int count=0;
            if(!vis[i])
            {
                vis[i]=true; 
                stk.add(i);
   
                while(!stk.isEmpty())
                {
                    int val = stk.get(stk.size()-1);
                    stk.remove(stk.indexOf(stk.get(stk.size()-1)));
                    count++;
                    System.out.print(val+"-> ");
                    temp = list[val];
                    
                    if(!temp.isEmpty())
                    {
                        for(int x : temp)
                        {
                            if(!vis[x])
                            {
                                vis[x]=true;
                                stk.add(x);
                            }
                        }
                    }
                }
                
            }
            System.out.println();
            if(count>0) frq.add(count);  // counting how many separte group is created
        }
        
        Collections.sort(frq);
        System.out.println("frw "+ frq);
        
        LinkedList<Integer>preSum = new LinkedList<>();
        preSum.add(0);
        for(int i=0 ; i<frq.size() ; i++)
            preSum.add(i+1 , preSum.get(i)+frq.get(i) );
        
        preSum.remove(0);
        System.out.println("preSum "+ preSum);
        
        long sum=0;
        for(int i=frq.size()-1 ; i>=1 ; i--)
            sum+= frq.get(i)*preSum.get(i-1);
        
        System.out.println(".....sum  ...."+ sum);
    }
   
}


/*
 .....1..
5 3
0 1
2 3
0 4

.2.......
4 2
1 2
2 3

4 1
0 2      ///5



10 7    
0 2
1 8
1 4
2 8
2 6
3 5
6 9
.......23

11 5
1 2
1 3
2 4
7 8
5 6



 public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int NoOfAs = sc.nextInt();
        int pairs = sc.nextInt();
        Map<Integer , Set<Integer>>map = new TreeMap<>();
     
        while(pairs-- >0)
        {
            int i=sc.nextInt() , j=sc.nextInt();
            if(map.containsKey(i)){
                Set<Integer>set = map.get(i);
                set.add(i);      set.add(j);
                map.put(i, set); 
               
                if(map.containsKey(j)){
                        set=map.get(j);    set.addAll(map.get(i));
                        map.put(j, set);
                    }
                    else
                        map.put(j, map.get(i));
                
            }
            else{
                Set<Integer>set = new LinkedHashSet<>();
                set.add(j);        set.add(i);
                map.put(i, set);   map.put(j, set);
               }
        }
        boolean vis[] = new boolean[NoOfAs];
        Stack<Integer>stk = new Stack<>();
        List<Integer>list = new LinkedList<>();
        
        for(int i=0 ;i<NoOfAs ; i++ )
        {
            int count=0;
            if(!vis[i])
            {
                stk.add(i);   count++;        vis[i]=true;
                while(!stk.isEmpty()){
                    int val=stk.pop();  
                    if(map.containsKey(val)){
                        Set<Integer>temp = map.get(val);
                        for(int x : temp){
                            if(!vis[x]){
                                vis[x]=true;    count++;
                                stk.add(x);
                            }
                        }
                    }
                }
            }
            if(count!=0)
                  list.add(count);
        }
        
        
        Collections.sort(list); 
        
        
        int n=list.size() , sum=0;
        List<Integer>arr= new LinkedList<>();
        arr.add(0);
        for(int i=1 ; i<=n ; i++)
            arr.add(i , (arr.get(i-1)+ list.get(i-1) ) );   
            
        arr.remove(0);
        
        Collections.reverse(list);
        Collections.reverse(arr);
//        System.out.println("list  "+ list);
//        System.out.println("arr "+ arr);
//       
        for(int i=0 ; i<=list.size()-2;i++)
            sum+= list.get(i)*arr.get(i+1);
        
        System.out.println("sum "+ sum);
        
    }


*/