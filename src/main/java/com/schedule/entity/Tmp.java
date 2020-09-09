/**
 * 
 */
package com.schedule.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * @author KhanhBQ3
 *
 */
@Entity
@NamedQuery(name = "findByTop1000", query = "FROM Tmp t WHERE t.startDate >= (SYSDATE -30/1440) ORDER BY t.msisdn DESC")
public class Tmp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int msisdn;
	private float state;
	private Date startDate;
	private Date endDate;

	/**
	 * @return the msisdn
	 */
	public int getMsisdn() {
		return msisdn;
	}

	/**
	 * @param msisdn the msisdn to set
	 */
	public void setMsisdn(int msisdn) {
		this.msisdn = msisdn;
	}

	/**
	 * @return the state
	 */
	public float getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(float state) {
		this.state = state;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Tmp(int msisdn, float state, Date startDate, Date endDate) {
		super();
		this.msisdn = msisdn;
		this.state = state;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Tmp() {
	}

	@Override
	public String toString() {
		return "Tmp [msisdn=" + msisdn + ", state=" + state + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
