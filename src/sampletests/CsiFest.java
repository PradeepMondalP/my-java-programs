
package sampletests;

import java.io.*;
import java.util.*;

public class CsiFest {
    public static void main(String[] args) throws Exception {
         String ch;
        String dir = System.getProperty("user.dir");
        List<Integer>list = new ArrayList(); 
        BufferedReader br = new BufferedReader(new FileReader(dir+"/input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(dir+"/output.txt"));
              while(( ch=br.readLine())!=null)
                 list.add(Integer.parseInt(ch));
        Collections.sort(list);
        Iterator<Integer> it = list.iterator();
         while(it.hasNext()){
              bw.write(it.next() +"");
              bw.newLine();
         }
    br.close();
        bw.close();
    }
}
