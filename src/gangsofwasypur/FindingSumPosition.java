
package gangsofwasypur;

// finding the posotion of the two indexes of an array to get paricular su
public class FindingSumPosition {
    
    public static void main(String[] args) 
    {
        int arr[] = {2,3,4,50,96,7};
        int sum =52;
        int arr2[] = getPosition(arr , sum);
        for(int i = 0 ; i<2 ;i++)
              System.out.println(arr2[i] +" ");
    }

    private static int[] getPosition(int[] arr, int sum) { //2 3 4 50 96 7
       int temp[] = new int[2];
       int x=0;
       for(int i = 0 ; i <arr.length-1 ; i++)
           for(int j = i+1 ; j<arr.length ; j++)
               if(arr[i]+arr[j]==sum)
               {
                   temp[x] = i;
                   temp[x+1] = j;
               }
       return temp;
    }
}
