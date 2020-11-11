
package hackerrank;


public class StringRelated {
    
    public static void main(String[] args) {
        String s="iffactsdontfittotheorychangethefacts    ";
        
        int row =(int)Math.floor(Math.sqrt(36));
        int col =(int)Math.ceil(Math.sqrt(36));
        
//        System.out.println("row "+ row);
//        System.out.println("col "+ col);

        System.out.println( encryption(s));
    }
    
    static String encryption(String s) {
//        s = s.replace(" " , "");
//          int len = s.length();
//         int row = (int)Math.floor(Math.sqrt(s.length()));
//         int col = (int)Math.ceil(Math.sqrt(s.length()));
//         System.out.println("row "+ row);
//         System.out.println("colm "+ col);
//        StringBuilder buf = new StringBuilder();
//         
//         if(row*col < len)  row = col;
//         
//         for(int i = 0; i < col; i++){
//            for(int j = i; j < s.length(); j+= col ) {
//                buf.append(s.charAt(j));
//            }
//            buf.append("\n");
//        }
//         return buf.toString();


   char arr[]=s.toCharArray();
        double lenRot=Math.sqrt(s.length());
        int lwrBond=(int)Math.floor(lenRot);
        int uprBond=(int)Math.ceil(lenRot);
        StringBuilder str=new StringBuilder();
        for(int i=0;i<=lwrBond;i++){
            int j=i;
            while(j<=(arr.length-1)){
                str.append(arr[j]);
                j=j+uprBond;
            }
            str.append(" ");
        }
        return str.toString();
    }
}
