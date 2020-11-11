
package graph;

import java.util.*;


public class SnakeAndLadder {

    
    static class Ladder
    {
        int min , max;

        public Ladder(int min, int max) {
            this.min = min;
            this.max = max;
        } 
    }
    
    static LinkedList<Ladder>ladder = new LinkedList<>();
    static Map<Integer, Integer>snake = new TreeMap<>();
    static int min=0,max=0,count=0;
        
    public static void main(String[] args) {
        
//        ladder .add(new Ladder(8, 52));    input 1
//        ladder .add(new Ladder(6, 80));
//        ladder .add(new Ladder(26, 42));
//        ladder .add(new Ladder(2, 72));

//          ladder .add(new Ladder(3, 54));           inpu 2
//          ladder .add(new Ladder(37, 100));
//          
//          snake.put(56, 33);           inpu 2
        
        
        
//        snake.put(51, 19);      inpu 1
//        snake.put(39, 11);
//        snake.put(37, 29);
//        snake.put(81, 3);
//        snake.put(59, 5);
//        snake.put(79,23);
//        snake.put(53, 7);
//        snake.put(43, 33);
//        snake.put(77, 21);

         ladder .add(new Ladder(7, 98));
         snake.put(99, 1);

        
        Collections.sort(ladder, Comparator.comparingInt(i-> i.min));
        
        for(Ladder l :ladder)
            System.out.println(l.min +" : "+ l.max);
         snakeLadder();
         
         System.out.println("count is "+ count);
        
    }
    
    private static void snakeLadder() {
        
        Ladder obj;
        int tempMin , tempMax , x , y , tempCount;
        while(!ladder.isEmpty())
        {
            obj = ladder.poll();
            tempMin = obj.min;
            tempMax = obj.max;
            
            if(!snake.containsKey(tempMin) && !snake.containsKey(tempMax)  && tempMax>max)
            {
                if(count!=0)count--;
                x = tempMin/6;   y = tempMin%6;
                

                if(x==0)
                {
                    tempCount=1;
                    if(tempMax-max>=6)
                    {
                        min= tempMin;  max=tempMax;  count+=1;
                    }
                }
            else if(x!=0 && y==0)
                {
                    tempCount=x;
                    if(tempMax-max>=6*tempCount)
                    {
                        min= tempMin;  max=tempMax;  count+=tempCount;
                    }
                }
               else
                {
                    tempCount=x+1;
                    if(tempMax-max>=6*tempCount)
                    {
                        min= tempMin;  max=tempMax;  count+=tempCount;
                    }
                }
            }
        }
        System.out.println("after the the count..."+ count);
        int req = 100-max;
        
        if(req!=0)
        {
            if(req<=6)
            count++;
            else
            {
                for(int i=max ; i<=100 ; )
                {
                    int j=6; 
                    if(i+j>=100) {  count++;  break;  }

                    while(j >0)
                    {
                        if(!snake.containsKey(i+j))
                        {
                             i+=j;   count++;   break;
                        }
                        j--;
                    }
                }
            }
       }
        
   }  
}
