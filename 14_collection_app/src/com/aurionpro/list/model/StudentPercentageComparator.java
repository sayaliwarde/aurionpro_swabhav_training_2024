package com.aurionpro.list.model;

import java.util.Comparator;

public class StudentPercentageComparator implements Comparator<Student>{

	public int compare(Student student1, Student student2) {

		return Double.compare(student1.getPercentage(), (student2.getPercentage()));
	}

}
