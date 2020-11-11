package google;

import java.io.*;
import java.util.*;

public class Own_3 {
    
    static  int count = 0 , LEN , SUM , checkSUm=0 , arr[];
    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<Integer> l = new ArrayList<>();
    static int indexArr[] ; 
    static Set<Integer>myBuff =new HashSet<>();
    static ArrayList builder = new ArrayList();    // temporay
    
    public static void main(String[] args) throws Exception {
        
        String dir = System.getProperty("user.dir");
        BufferedReader br = new BufferedReader(new FileReader(dir+"/input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(dir+"/output.txt"));
        
        String x , arrX[];
        while( (x=br.readLine()) !=null )
        {
             arrX = x.split(" ");
             for(String val : arrX)
                  list.add(Integer.parseInt(val));   
        }
        
        // iniializing here all
        SUM = list.get(0);
        arr = new int[list.get(1)];
        LEN = list.size()-2;
        indexArr  = new int[LEN];
        
        for(int i = 0 ; i<LEN ;i++)  
            arr[i] = list.get(i+2); 
        for(int m : arr)             
                l.add(m); 
        
        ArrayList emptyList = new ArrayList();
        getSum(arr,0, LEN-1 , emptyList);
        
       indexArr = new int[myBuff.size()];
       
       
      Iterator<Integer> it = myBuff.iterator();
      while(it.hasNext()){
          builder.add(it.next());
      }
      
      for(int xx = 0 ; xx<builder.size() ; xx++){
           indexArr[xx] = l.indexOf(builder.get(xx));
      }
       
       
       Arrays.sort(indexArr);
       LEN = indexArr.length;
       
       bw.write(LEN+" ");
       bw.newLine();
        System.out.println("my sum is "+ checkSUm);
       for(int y : indexArr)
            bw.write(y+" ");
         bw.close();
        br.close();
      }
    
     private static void getSum(int arr[], int sum, int i, ArrayList<Integer> list2)
      {
        ArrayList<Integer> temp;
        if(i<0 || checkSUm==SUM)   return;
        int sumX = sum+arr[i];

       if(sumX<=SUM)
        {
              temp = new ArrayList(list2);
              temp.add(arr[i]);
              
              if(sumX> checkSUm){
                          checkSUm = sumX;
                          myBuff.clear();
                          temp.forEach( y -> myBuff.add(y) );
                    }
                 getSum(arr, sumX, i-1, temp);
         }
         getSum(arr, sum, i-1, list2);
    }
} 