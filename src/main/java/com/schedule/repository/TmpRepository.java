/**
 * 
 */
package com.schedule.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.schedule.entity.Tmp;

/**
 * @author KhanhBQ3
 *
 */
@Repository
public interface TmpRepository extends CrudRepository<Tmp, Serializable> {
	
}
