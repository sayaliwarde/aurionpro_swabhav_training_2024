package com.aurionpro.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileReadingTest {
	public static void main(String[] args) {
		try 
		{
			FileInputStream fileInputStream=new FileInputStream("C:\\aurionpro_training\\05_stream_app\\src\\com\\aurionpro\\stream\\text");
			int ch;
			FileOutputStream fileOutputStream=new FileOutputStream("C:\\aurionpro_training\\05_stream_app\\src\\com\\aurionpro\\stream\\text");
			while((ch=fileOutputStream.read())!=-1)
			{
				fileOutputStream.write(ch);
			}
		}
		System.out.println("file copied successfully");
		
        }
	}


