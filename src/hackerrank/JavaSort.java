
package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class JavaSort {
    
    public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Studenta> studentList = new ArrayList<Studenta>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			 
                        if( (id>=0 && id<=100000 ) &&( fname.length()>=5 && 
                        fname.length()<=30)&&( cgpa>=0 && cgpa<=4.0))
                        {
                           Studenta st = new Studenta(id, fname, cgpa);
                            studentList.add(st); 
                        }
			
			testCases--;
		}
                
                StudentComparator sc = new StudentComparator();
                Collections.sort(studentList,sc);
                        
                    for(Studenta st: studentList){
			System.out.println(st.getFname());
		}
	}
    
}

class StudentComparator implements Comparator<Studenta>
{

    @Override
    public int compare(Studenta s1, Studenta s2) {
           if( s1.getCgpa()==s2.getCgpa())
           {
               if(s1.getFname().compareTo(s2.getFname())==1)
               {
                   return s2.getId()-s1.getId();
               }
               else
                   return s1.getFname().compareTo(s2.getFname());
           
           }
           else if(s1.getCgpa() > s2.getCgpa())
                return -1;
           else
               return 1;
    }
    
}

class Studenta  {
	private int id;
	private String fname;
	private double cgpa;
	public Studenta(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}

    
}