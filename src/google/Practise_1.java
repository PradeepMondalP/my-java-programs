package google;
import java.io.*;
import java.util.*;

public class Practise_1 {
    
    static  int count = 0 , LEN , REQUIRED_SUM , checkSUm=0 , arr[];
    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<Integer> l = new ArrayList<>();  // 
    static ArrayList<Integer> indexArr=new ArrayList<>() ;
    static ArrayList temp = new ArrayList();
    
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
        REQUIRED_SUM = list.get(0);
        System.out.println("Required sum : "+REQUIRED_SUM);
        list.remove(0);
//        arr = new int[list.get(1)];
        LEN = list.get(0);
        System.out.println("Len : "+LEN);
        list.remove(0);
        System.out.println("list : "+list);
//        indexArr  = new int[LEN];
        
//        for(int i = 0 ; i<LEN ;i++)  // array containing arry elemens
//            arr[i] = list.get(i+2); 
//        for(int m : arr)             // list containing arry elemens
//                l.add(m); 
        
        long StartTime=System.currentTimeMillis();
        getSum(0, LEN-1);// , emptyList);
        long StopTime=System.currentTimeMillis();
        System.out.println("Time taken in ms : "+(StopTime-StartTime));
//       for(int g=0;g<LEN ; g++)
//           if(indexArr[g]>0)      // counting number of elements
//                   count++;
        
        bw.write(temp.size()+" ");      //writing count value to file
        bw.newLine();
        
        for(int h =0 ;h<temp.size();h++)
        {
            bw.write(temp.get(h)+" ");      // writing array elemnts to file
            System.out.println(temp.get(h));
        }
        
        
        System.out.println("total sum i got "+checkSUm);
            
        bw.close();
        br.close();
      }
    
     private static void getSum(int sum, int i)//, ArrayList<Integer> list2)
      {
        
        if(i<0 || checkSUm==REQUIRED_SUM)   return;
        int sumX = sum+list.get(i);
        indexArr.add(i);    
        if(sumX<=REQUIRED_SUM)
        {
//              temp = new ArrayList(list);
//              temp.add(list.get(i));
              
            if(sumX> checkSUm)
            {
                checkSUm = sumX;

//              temp.forEach( y -> indexArr[l.indexOf(y)]=1 );
            }
            getSum( sumX, i-1);
        }
        
//        if(sum==checkSUm)
//        {
//            temp.clear();
//            temp.addAll(indexArr);
//        }
        //indexArr.trimToSize();
        indexArr.remove(indexArr.size()-1);
        getSum(sum, i-1);
    }
} 