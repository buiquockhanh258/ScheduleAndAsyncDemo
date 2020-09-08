/**
 * 
 */
package com.schedule.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.schedule.entity.Book;

/**
 * @author KhanhBQ3
 *
 */
@Service
public class UserService {
	@Autowired
	private ReadWriteFile readWriteFile;
	List<Book> listBooks = new ArrayList<Book>();
	Logger logger = LoggerFactory.getLogger(UserService.class);

	//@Async to execute task a-synchronized , @Scheduled to run scheduled task, fixedDelay: start new task after ? ms, initialDelay: start Scheduled after ? ms 
	@Async
	@Scheduled(fixedDelay = 1 * 1000, initialDelay = 5 * 1000)
	//use CompletableFuture to make only ONE thread succeed if there is more than one Thread
	public CompletableFuture<List<Book>> saveBook() {
		listBooks.add(new Book("a", "book", Math.random()));
		listBooks.add(new Book("a", "book", Math.random()));
		//write to file
		readWriteFile.WriteObjectToFile(listBooks);
		//log to console
		logger.info("Saved to file {}", listBooks.size() + " by " + Thread.currentThread().getName());
		//read file and print to console
		readWriteFile.ReadObjectFromFile("C:\\Users\\Laptop\\Desktop\\data.txt");
		//log to console
		logger.info("Readed from file {} by " + Thread.currentThread().getName());
		return CompletableFuture.completedFuture(listBooks);
	}
}
