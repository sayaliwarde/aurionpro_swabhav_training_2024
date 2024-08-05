

package com.aurionpro.streams.test;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class FilePrinterUsingFileReader {
	public static void main(String[] args) {
		FileReader fileReader;
		try {
			fileReader=new FileReader("C:\\aurionpro_training\\17_streams_app\\src\\com\\aurionpro\\streams\\test\\test");
			int ch;
			StringBuilder stringbuilder=new StringBuilder();
			try {
				while((ch=fileReader.read()) != -1) {
					if (ch=='\n') {
						System.out.println(stringbuilder.toString());
					}
					else {
						stringbuilder.append((char)(ch));
					}
				}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(stringbuilder.length()>0) {
				System.out.println(stringbuilder.toString());
			} 
		}catch(FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
}


