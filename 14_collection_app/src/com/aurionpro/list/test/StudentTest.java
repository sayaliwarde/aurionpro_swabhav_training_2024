package com.aurionpro.list.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.list.model.Student;
import com.aurionpro.list.model.StudentComparator;
import com.aurionpro.list.model.StudentRollNumberComparator;

public class StudentTest {
	public static void main(String[] args) {
//		Scanner scanner=new Scanner(System.in);
//		List<Student> students=new ArrayList<Student>();
//		readStudent(students,scanner);
//		printStudent(students,scanner);
//		
//		
//	}
//		
//		private static void readStudent(List<Student> students, Scanner scanner) {
//			for(int i=0;i<students.size();i++) {
//				System.out.println("enter the roll number of the student:");
//				int rollNumber=scanner.nextInt();
//				System.out.println("enter the name of the student:");
//				String name=scanner.next();
//				System.out.println("enter the percentage of the student:");
//				double percentage=scanner.nextDouble();
//			}
//		}
//			private static void printStudent(List<Student> students, Scanner scanner) {
//				for (Student student:students)
//					System.out.println(student);
//				
//		}
//	}
		List<Student> students =new ArrayList<Student>();
		students.add(new Student(2, "Namrata", 80));
		students.add(new Student(5, "Aagya", 85));
		students.add(new Student(8, "Neha", 83));
		students.add(new Student(2, "Sayali", 81));
		
		System.out.println("students not sorted");
		for(Student student:students) {
			System.out.println(student);
			
		}
		System.out.println("Students in sorted roll number order");
		Collections.sort(students, new StudentComparator.StudentRollNumberComparator());
		for(Student student:students) {
		System.out.println(student);
		}
		
		System.out.println("Students in sorted name order");
		Collections.sort(students, new StudentComparator.StudentNameComparator());
		for(Student student:students) {
		System.out.println(student);
		}
		
	}
}


