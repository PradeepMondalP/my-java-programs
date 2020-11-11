
package google;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Problem_2 {
    
   private static  int count=0 , LIBRARY_COUNT=0 ;
   private static  int TOTAL_NO_BOOKS=0;
   private static int TOTALLIBRARY;
   private static int TOTALDAYS;
   private static int[] costArray;
   private static ArrayList<Library>librayList = new ArrayList();  
   private static boolean[] isInsertion;
   private static ArrayList<Integer> mainList = new ArrayList();     // for storing all the value from files TEMPORARILY
   private static ArrayList<MySeparateClass>extraclassObj = new ArrayList();
     
    static class Library
     {
        private int noOfBook , signUpDays , deliveryPday, index;
        private int bookID[];
       

        public Library(int index, int noOfBook, int signUpDays, int deliveryPday, int[] bookID) {
            this.index=index;
            this.noOfBook = noOfBook;
            this.signUpDays = signUpDays;
            this.deliveryPday = deliveryPday;
            this.bookID = bookID;
                 
        }
      }
    
    public static void main(String[] args) throws Exception{
        
        String currentPath = System.getProperty("user.dir");
   //     BufferedReader br = new BufferedReader(new FileReader(currentPath+"/progx.txt"));
          BufferedWriter bw = new BufferedWriter(new FileWriter(currentPath +"/output2.txt"));
    //    Scanner sc=new Scanner(new File(currentPath+"/a_example.txt"));
   //     Scanner sc=new Scanner(new File(currentPath+"/b_read_on.txt"));
   //     Scanner sc=new Scanner(new File(currentPath+"/c_incunabula.txt"));
 //       Scanner sc=new Scanner(new File(currentPath+"/d_tough_choices.txt"));
   //     Scanner sc=new Scanner(new File(currentPath+"/e_so_many_books.txt"));
        Scanner sc=new Scanner(new File(currentPath+"/f_libraries_of_the_world.txt"));

        String []temp=null ;
        String str;
             
       while(sc.hasNext())
        {
            mainList.add(sc.nextInt());        // mainList here has all elements from the input file
        }
       
         TOTAL_NO_BOOKS =mainList.get(0);            mainList.remove(0);
         TOTALLIBRARY =  mainList.get(0);            mainList.remove(0);
         TOTALDAYS =     mainList.get(0);            mainList.remove(0);
         costArray = new int[TOTAL_NO_BOOKS];
         isInsertion = new boolean[TOTAL_NO_BOOKS];
          
        for(int j = 0; j<TOTAL_NO_BOOKS ; j++){
           costArray[j] = mainList.get(0);
           mainList.remove(0);
       }
              
        //adding values to library list
        for(int index = 0 ; index<TOTALLIBRARY ; index++)
        {
            int noOfBk = mainList.get(0);   mainList.remove(0);
            int signDy = mainList.get(0);   mainList.remove(0);
            int deliVr = mainList.get(0);   mainList.remove(0);
            int arr[] = new int[noOfBk];
            for(int y = 0 ; y<noOfBk ; y++){
                arr[y] = mainList.get(0);   mainList.remove(0);
            }
            librayList.add(new Library(index, noOfBk, signDy, deliVr, arr));
        }
   
        Collections.sort(librayList, new Comparator<Library>()
        {
            @Override
            public int compare(Library l1, Library l2) {
               
                if(l1.noOfBook==l2.noOfBook)
                {
                     if(l1.signUpDays==l2.signUpDays)
                     {
                          return l2.deliveryPday- l1.deliveryPday;
                     }
                     else
                     {
                           return l1.signUpDays - l2.signUpDays;
                     }
                }
                else
                    return l2.noOfBook - l1.noOfBook;
            }
        });
        
        myFunction(count, 0);
        
        bw.write(LIBRARY_COUNT+" ");
        bw.newLine();
        
        for(MySeparateClass obj : extraclassObj){
            bw.write(obj.currentIndexOfLibrary +" "+ obj.numberOfElementsAdded);
            bw.newLine();
            for(int www : obj.list)
                bw.write(www+" ");
            bw.newLine();
        }
        sc.close();
        bw.close();
         }
    
    private static void myFunction(int count ,int currentLibIndex)
    {
        for(;currentLibIndex <librayList.size()&&count <= TOTALDAYS;currentLibIndex++)
        {
            Library mylib = librayList.get(currentLibIndex);

            int signUp = mylib.signUpDays;
            int d = mylib.deliveryPday;
            count+=signUp;

            int LENGTH = mylib.bookID.length;
            int possibleDays = TOTALDAYS - count;
            boolean tempBool = false;
            ArrayList<Integer> tempX = new ArrayList();

            if(possibleDays>0)
              {
                int top=0;
                while(top!=LENGTH)
                {
                    if(d < LENGTH - top)
                    {
                        int x = d;
                        while(x!=0)
                        {
                            if(!isInsertion[mylib.bookID[top]])
                            {
                                tempBool = true;
                                 isInsertion[mylib.bookID[top]] = true;
                                tempX.add(mylib.bookID[top]);
                                top++; x--;  
                            }
                            else{
                                top++;  x--;
                            }
                        }
                    }
                    else
                    {
                        for( ; top<LENGTH ; top++)
                        {
                            if(!isInsertion[mylib.bookID[top]])
                            {
                                isInsertion[mylib.bookID[top]] = true;
                                tempX.add(mylib.bookID[top]);
                                tempBool  =true;
                            }
                        }
                    }
                }

                if(tempBool==true)
                {
                    LIBRARY_COUNT++;
                    mainList.addAll(tempX);
                    extraclassObj.add(new MySeparateClass(tempX, mylib.index));
                }
            }
        }

//        myFunction(count, currentLibIndex+1);
    }
}

class MySeparateClass
{
    int numberOfElementsAdded;
     ArrayList<Integer> list ;
     int currentIndexOfLibrary;

    public MySeparateClass(ArrayList<Integer> list, int currentIndexOfLibrary) {
        this.list = list;
        this.currentIndexOfLibrary = currentIndexOfLibrary;
        numberOfElementsAdded = list.size();
    }
   
}
