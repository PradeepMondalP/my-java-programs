
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


public class Practise_1_1 {
    
    public static int LEN;
    public static int originalArray[];
    public static ArrayList<MyClass> originialArrayList = new ArrayList<>();
    public static int originalArraySum;
    
    public static void main(String[] args)  throws Exception{
        
        String dir = System.getProperty("user.dir");
        BufferedReader br = new BufferedReader(new FileReader(dir+"/input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(dir+"/output.txt"));
       
        String x , arr[];
         List<Integer> list = new ArrayList<>();
        int max , types , tArr[];
        
        while( (x=br.readLine()) !=null )
        {
             arr = x.split(" ");
             for(String val : arr)
                  list.add(Integer.parseInt(val));  
        }
        
         System.out.println("list us "+ list);
            
         originalArray = new int[list.size()];
        
        for(int k=2; k<list.size();k++)
          originalArray[k] = list.get(k);
        
       
        
        originalArraySum = list.get(0);
        LEN = list.get(1);
        
        ArrayList tempList;
        int tempSum ;
       
         for(int i = 0 ; i<LEN ; i++)
         {
             tempSum=0;
             tempList = new ArrayList();
             tempSum = originalArray[i];
             
               if(tempSum<originalArraySum)
               {
                   tempList.add(i);
                    originialArrayList.add(new MyClass(tempSum, tempList));
               }
               
               for(int j = i+1 ; j<LEN ; j++)
               {
                    int  sum2 =   tempSum + originalArray[j];
                    if(sum2 > originalArraySum)
                             continue;
                    else
                        getSum(tempSum, tempList ,j+1 ,LEN );
                    
                    System.out.println("original list is");
                    
                    Collections.sort(originialArrayList , new Comparator<MyClass>()
                    {
                        @Override
                        public int compare(MyClass o1, MyClass o2) {
                           return o2.sum - o1.sum;
                        }
                        
                    });
                    
                    Iterator<MyClass>it = originialArrayList.iterator();
                    while(it.hasNext())
                    {
                        System.out.print("    " + it.next());
                        System.out.println();
                    }
               }
         } 
    }
    
    

    private static int getSum(int sum, ArrayList list,int start, int end) {
        
        ArrayList tempList;
        int tempSum=0;
        for(int i = start ; i<end ; i++)
        {
            tempSum=0;
            tempList=new ArrayList();
            
             if(i>end)
                   return -1;
             tempSum = sum+ originalArray[start];
             if(tempSum> originalArraySum)
                    return -1;
             else
             {
                  tempList = list;
                  tempList.add(i);
                  
                  originialArrayList.add(new MyClass(tempSum, tempList));
                  
                  return getSum(tempSum, tempList, i+1 ,end);
             }
             
        }
        return tempSum;
    }
    
     
   static class MyClass{
        int sum;
        ArrayList <Integer>list;

        public MyClass(int sum, ArrayList<Integer> list) {
            this.sum = sum;
            this.list = list;
        }

        @Override
        public String toString() {
            return "MyClass{" + "sum=" + sum + ", list=" + list + '}';
        }
    }
   
}
