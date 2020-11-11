
package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Comparator_1 {
    
    
    public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
                
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
                        
                        if( (id>=0 && id<=100000 ) &&( fname.length()>=5 && fname.length()<=30)&&( cgpa>=0 && cgpa<=4.0))
                        {
                           Student st = new Student(id, fname, cgpa);
			   studentList.add(st); 
                        }
			
			
			testCases--;
		}
      
                Collections.sort(studentList  ,
                Comparator.comparingDouble(Student ::getCgpa).reversed()
                .thenComparing(Student::getFname) 
                .thenComparingInt(Student::getId));
                
                
      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
        
//         studentList.stream().sorted(
//            Comparator.comparing(Student::getCgpa).reversed()
//            .thenComparing(Student::getFname)
//            .thenComparing(Student::getId))
//            .map(Student::getFname).forEach(System.out::println);
//        
        
	}
}


class Student   //implements Comparable<Student>
{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
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

//    @Override
//    public int compareTo(Student obj) {
//       
//        if(cgpa==obj.cgpa && fname.equals(obj.fname))
//              return id<obj.id? 1: -1;
//        else if(cgpa==obj.cgpa)
//              return fname.length() <obj.fname.length() ? 1:-1;
//        else
//            return cgpa<obj.cgpa ? 1 : -1 ;
//        
//    }
        
        
}
