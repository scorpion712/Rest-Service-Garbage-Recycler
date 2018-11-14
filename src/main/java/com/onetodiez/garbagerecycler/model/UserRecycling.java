package com.onetodiez.garbagerecycler.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author: Oneto, Fernando
 * @author: Diez, Lautaro
 *
 */
@Entity
@Table
public class UserRecycling { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "fecha", nullable = false)
	private Date date;

	@Column(name = "bottles", nullable = false)
	private int bottles;

	@Column(name = "tetrabriks", nullable = false)
	private int tetrabriks;

	@Column(name = "paperboard", nullable = false)
	private int paperboard;

	@Column(name = "glass", nullable = false)
	private int glass;
	
	@Column(name = "cans", nullable = false)
	private int cans;
	
	/**
	 *  Como el usuario?? 
	 * Seria id_user una fk a user ? Como se hace?
	 * Si guardo el id del user creo una columna id_user y,
	 * en save de UserRecycling le seteo a userRecycling
	 *  el id del getUserByUsername? 
	 *  
	 *  
	 *  Si pongo que tenga un User y que matchee con User.id  en el json puedo enviar "User":{} ?
	*/
	
	// Defining Many to One relationship between UserRecyling and User entities
	//@ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
	//@JoinColumn(name = "user_id", insertable = false, updatable = false) 
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	} 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}
	
	@PrePersist
	public void setDate() {
		this.date = new Date(new java.util.Date().getTime());
	}

	public int getBottles() {
		return bottles;
	}

	public void setBottles(int bottles) {
		this.bottles = bottles;
	}

	public int getTetrabriks() {
		return tetrabriks;
	}

	public void setTetrabriks(int tetrabriks) {
		this.tetrabriks = tetrabriks;
	}

	public int getPaperboard() {
		return paperboard;
	}

	public void setPaperboard(int paperboard) {
		this.paperboard = paperboard;
	}

	public int getGlass() {
		return glass;
	}

	public void setGlass(int glass) {
		this.glass = glass;
	}

	public int getCans() {
		return cans;
	}

	public void setCans(int cans) {
		this.cans = cans;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		//result = prime * result + (( == null) ? 0 : id.hashCode());
		return result;
	}
}
