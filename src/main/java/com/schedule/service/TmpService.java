/**
 * 
 */
package com.schedule.service;

import java.util.List;

import com.schedule.entity.Tmp;

/**
 * @author KhanhBQ3
 *
 */
public interface TmpService {
	List<Tmp> getAllTmp30MinsBeforeNow() throws InterruptedException;
	
	boolean updateJobs(Tmp tmp);
}
