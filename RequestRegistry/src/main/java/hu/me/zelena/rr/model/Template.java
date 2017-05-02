package hu.me.zelena.rr.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="templates")
public class Template implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String title;
	
	private String destination;
	private boolean motivation;

	public Template(String title, String destination, boolean motivation) {
		super();
		this.title = title;
		this.destination = destination;
		this.motivation = motivation;
	}
	
	public Template(){}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public boolean isMotivation() {
		return motivation;
	}
	public void setMotivation(boolean motivation) {
		this.motivation = motivation;
	}
	
	@Override
	public String toString() {
		return "Template [title=" + title + ", destination=" + destination + ", motivation=" + motivation + "]";
	}
	
}
