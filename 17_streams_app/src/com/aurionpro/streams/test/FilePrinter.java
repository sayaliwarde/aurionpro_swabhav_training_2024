package com.aurionpro.streams.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilePrinter {
	public static void main(String[] args) {
		try(Stream<String>stream=Files.lines(Paths.get("C:\\aurionpro_training\\17_streams_app\\src\\com\\aurionpro\\streams\\test\\test"))){
			stream.forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}


