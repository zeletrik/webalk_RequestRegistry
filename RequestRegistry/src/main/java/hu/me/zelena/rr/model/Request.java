package hu.me.zelena.rr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

public class Request implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String user;
	private String reviewer;
	private String template;
	private String status;
	private String motivate;
	private Date date;

}
