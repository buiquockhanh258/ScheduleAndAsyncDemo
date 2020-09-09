/**
 * 
 */
package com.schedule.service.impl;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.schedule.entity.Tmp;

/**
 * @author KhanhBQ3
 *
 */
@Service
public class UserService {
	@Autowired
	private Executor executor;

	@Autowired
	private TmpServiceImpl tmpServiceImpl;

	Logger logger = LoggerFactory.getLogger(UserService.class);

	/*
	 * @Async to execute task a-synchronized , @Scheduled to run scheduled task,
	 * fixedDelay: start new task after ? ms, initialDelay: start Scheduled after ?
	 * ms use CompletableFuture to make only ONE thread succeed if there is more
	 * than one Thread
	 */
	@Async
	// refresh to get data every 5 minutes, delay on start 10 seconds
	@Scheduled(fixedDelay = 10 * 1000, initialDelay = 10 * 1000)
	public CompletableFuture<List<Tmp>> doJobs() throws InterruptedException {
		List<Tmp> listTmp = tmpServiceImpl.getAllTmp30MinsBeforeNow();
		if (listTmp.size() > 0) {
			executeJobs(listTmp);
			return CompletableFuture.completedFuture(listTmp);
		} else {
			return null;
		}
	}

	@Async
	public CompletableFuture<List<Tmp>> executeJobs(List<Tmp> listJobs) throws InterruptedException {
		for (int i = 0; i < listJobs.size(); i++) {
			// calculate time to run for each jobs
			Date now = new Date();
			long runtime = listJobs.get(i).getEndDate().getTime() - now.getTime();
			// execute job
			if (listJobs.get(i).getState() == 1) {
				System.out.println("Run task after: " + runtime / 1000 + " seconds");
				Tmp tmp = listJobs.get(i);
				tmp.setState(2);
				executor.execute(new Runnable() {
					@Override
					public void run() {
						try {
							logger.info(Thread.currentThread().getName() + " - time now: " + new Date());
							tmpServiceImpl.updateJobs(tmp);
							// delay time
							Thread.sleep(runtime);
							// you can do anything here
							logger.info(Thread.currentThread().getName());
							System.out.println("Works");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				});
			} else {
				logger.info(Thread.currentThread().getName() + " - No task to do");
			}
		}
		return null;
	}
}
