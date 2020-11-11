package general;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveDuplicateCharecter {

    public static void main(String ...a) {

        Scanner obj = new Scanner(System.in);

        System.out.println("Enter a string");
        String str = obj.nextLine();
        char[] ch = str.toCharArray();
        Set set = new LinkedHashSet();

        for (int i = 0; i < ch.length; i++) {
            set.add(ch[i]);
        }

        String x = set.toString().replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
        System.out.println("String is :" + x);

    }

}
