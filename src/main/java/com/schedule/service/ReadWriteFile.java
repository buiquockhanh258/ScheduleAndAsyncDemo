/**
 * 
 */
package com.schedule.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.schedule.entity.Book;

/**
 * @author KhanhBQ3
 *
 */
@Service
public class ReadWriteFile {
	//file path
	private static final String filepath = "C:\\Users\\Laptop\\Desktop\\data.txt";

	//write object to file
	public void WriteObjectToFile(List<Book> listBook) {
		try {
			FileOutputStream fileOut = new FileOutputStream(filepath);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(listBook);
			objectOut.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//read object from file
	public void ReadObjectFromFile(String filepath) {
		try {
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Object obj = objectIn.readObject();
            objectIn.close();
            System.out.println(obj);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
}
