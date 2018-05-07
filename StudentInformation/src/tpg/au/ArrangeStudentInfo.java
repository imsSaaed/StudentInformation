package tpg.au;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 * Created by Rahimi, 7/5/2018 
 * Time Start : 10:45am 
 * Time Finish : 11:25am
 * 
 * Question 2
 * You are given a list of student information: ID, FirstName, and GPA. Your task is to rearrange
   them according to their GPA in descending order. If two students have the same GPA, then
   arrange them according to their first name in alphabetical order. If those two students also have
   the same first name, then sort them in ascending order according to their IDs. No two students
   have the same ID.
   Hint: You can use comparators to sort a list of objects.
   Sample Input Sample Output
   
   Input :
   ID Name GPA
   33 Tina 3.68
   85 Louis 3.85
   56 Samil 3.75
   19 Samar 3.75
   22 Lorry 3.76
   
   Output :
   Louis
   Lorry
   Samar
   Samil
   Tina
 * 
 * 
 */
public class ArrangeStudentInfo {

	//main method
    public static void main(String [] args) {
		System.out.println("************** Sample Input ***************");
		//open 
		Scanner in = new Scanner(System.in);
		System.out.println("ID Name GPA");
		
		//set no of student
		int noStudent = 5; 
		
		//set collection Student
		List<Student> studList = new ArrayList<Student>();
		while(noStudent>0){
			int id = in.nextInt();
			String name = in.next();
			double gpa = in.nextDouble();
			
			studList.add(new Student(id,name,gpa));
			
			noStudent--;
		}

        Collections.sort(studList, new SortByName());
        System.out.println();
    	
        //filter out the output
		System.out.println("************** Sample Output ***************");
        for(Student stud: studList){
            System.out.println(stud.getStudentName());        	
        }
    }
}
    //create class for Compare Student Name,gpa & sort by IDs asc, implements Comparator
    class SortByName implements Comparator<Student>{
		@Override
		public int compare(Student s1, Student s2) {
			// TODO Auto-generated method stub
			int compare = s1.getStudentName().compareTo(s2.getStudentName());
			if((s1.getGpa() != s2.getGpa()) && (s1.getGpa() < s2.getGpa())){
				return 1;
			}else if ((s1.getGpa() == s2.getGpa()) && (compare < 0)){
				return -1;
			}else if ((s1.getGpa() == s2.getGpa()) && (compare > 0)){
				return 1;
			}else if  ((s1.getGpa() == s2.getGpa()) && compare == 0 && (s1.getId()<s2.getId())){
				return 1;
			}else {
				return -1;
			}	
		}
    }
    
    //create class for Student
    class Student{
    	
    	private int Id;
    	private String studentName;
    	private double gpa;
    	
		public int getId() {
			return Id;
		}
		public String getStudentName() {
			return studentName;
		}
		public double getGpa() {
			return gpa;
		}
		public Student(int id,String studentName,double gpa){
		    super();
			Id = id;
			this.studentName = studentName;
			this.gpa = gpa;
		}
    }
