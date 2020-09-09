/**
 * 
 */
package com.schedule.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schedule.entity.Tmp;
import com.schedule.repository.TmpRepository;
import com.schedule.service.TmpService;

/**
 * @author KhanhBQ3
 *
 */
@Service
public class TmpServiceImpl implements TmpService {
	@Autowired
	private TmpRepository tmpRepo;

	@PersistenceContext
	private EntityManager manager;

	private static List<Tmp> listTmp = new ArrayList<Tmp>();

	@Override
	@Transactional
	public List<Tmp> getAllTmp30MinsBeforeNow() throws InterruptedException {
		listTmp = manager.createNamedQuery("findByTop1000", Tmp.class).setMaxResults(1000).getResultList();
		return listTmp;
	}

	@Override
	@Transactional
	public boolean updateJobs(Tmp tmp) {
		return tmpRepo.save(tmp) != null;
	}

}
