package com.aurionpro.stream;

import java.io.FileInputStream;

public class CountFileCharacters {
	public static void main(String[] args) {
		int characterCount=0;
		try 
		{
			FileInputStream fileInputStream=new FileInputStream("C:\\aurionpro_training\\05_stream_app\\src\\com\\aurionpro\\stream\\text");
			int ch;
			while((ch=fileInputStream.read())!=-1) 
			{
                // Increment character count
                characterCount++;
            }

            // Print the number of characters
            System.out.println("Number of characters: " + characterCount);
           
		}

        } 
		

}
}
