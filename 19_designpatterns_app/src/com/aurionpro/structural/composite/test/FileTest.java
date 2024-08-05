package com.aurionpro.structural.composite.test;

import com.aurionpro.structural.composite.model.File;
import com.aurionpro.structural.composite.model.Folder;

public class FileTest {
    public static void main(String[] args) {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");

        Folder folder1 = new Folder("folder1");
        folder1.addComponent(file1);

        Folder folder2 = new Folder("folder2");
        folder2.addComponent(file2);
        folder2.addComponent(folder1);

        Folder rootFolder = new Folder("rootFolder");
        rootFolder.addComponent(folder2);

        rootFolder.showDetails();
    }
	
}
