import java.util.*;

public class Test {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt() , Q= sc.nextInt();
        MyClass arr[] = new MyClass[N+1];
        
        for(int i=0 ; i<=N; i++)  arr[i]=new MyClass();
        arr[1].data=1;
        
        while(N-- >1)
        {
            int src = sc.nextInt()  , dest = sc.nextInt();
            arr[dest].data=dest;
            arr[dest].next = arr[src];
        }
        while(Q-- >0)
        {
            int src = sc.nextInt() , dest = sc.nextInt();
            MyClass temp = arr[src];
           // MyClass temp2 = arr[src];
            boolean found=true;
            while(dest-->0)
            {
                try{
                    temp=temp.next;
                }catch(Exception e){
                    found=false;
                    System.out.println("-1");
                    break;
                }
            }
            if(found && temp!=null)
                System.out.println(temp.data);
            else System.out.println("-1");
        }
        
    }
    
    static class MyClass
    {
        int data;
        MyClass next;
        MyClass(int x){
            data=x;
            next=null;
        }
        
        MyClass(){
            data=-1;
        }
    }
}


/*
6 5
1 2 
2 3
3 4
2 5
1 6

4 1
3
4 3
1
6 1
1
5 1
2
5 3
-1
*/