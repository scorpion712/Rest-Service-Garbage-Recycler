package com.onetodiez.garbagerecycler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author: Oneto, Fernando
 * @author: Diez, Lautaro
 *
 */

@Entity
@Table
public class Recycling {
	/*
	 * 
	 * Es necesaria??
	 * 
	 */
	
	@Column(name = "bottles", nullable = false)
	private int bottles;

	@Column(name = "tetrabriks", nullable = false)
	private int tetrabriks;

	@Column(name = "glass", nullable = false)
	private int glass;

	@Column(name = "paperboard", nullable = false)
	private int paperboard;

	@Column(name = "cans", nullable = false)
	private int cans;

	@Column(name = "tons", nullable = false)
	private float tons;
}
