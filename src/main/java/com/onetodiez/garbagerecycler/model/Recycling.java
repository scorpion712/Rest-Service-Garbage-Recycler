package com.onetodiez.garbagerecycler.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Recycling {
	
	@JsonProperty("bottles")
	private int bottles;
	@JsonProperty("tetrabriks")
	private int tetrabriks;
	@JsonProperty("paperboard")
	private int paperboard;
	@JsonProperty("glass")
	private int glass;
	@JsonProperty("cans")
	private int cans;

	@JsonProperty("tons")
	private float tons;
	private static final float BOTTLES_WEIGHT = 0.1f; // weights are in Kg
	private static final float TETRABRIKS_WEIGHT = 0.04f;
	private static final float PAPAERBOARD_WEIGHT = 0.02f;
	private static final float GLASS_WEIGHT = 0.3f;
	private static final float CANS_WEIGHT = 0.07f;

	public Recycling(List<UserRecycling> list) {
		for (UserRecycling ur : list) {
			this.addBottles(ur.getBottles());
			this.addTetrabriks(ur.getTetrabriks());
			this.addPaperboard(ur.getPaperboard());
			this.addGlass(ur.getGlass());
			this.addCans(ur.getCans());
		}
		this.calculateTons();
	}

	public int getBottles() {
		return bottles;
	} 
	public int getTetrabriks() {
		return tetrabriks;
	} 

	public int getPaperboard() {
		return paperboard;
	} 

	public int getGlass() {
		return glass;
	} 

	public int getCans() {
		return cans;
	} 

	public float getTons() {
		return tons;
	} 


	public void addBottles(int bottles) {
		this.bottles += bottles;
	}

	public void addTetrabriks(int tetrabriks) {
		this.tetrabriks += tetrabriks;
	}

	public void addPaperboard(int paperboard) {
		this.paperboard += paperboard;
	}

	public void addGlass(int glass) {
		this.glass += glass;
	}

	public void addCans(int cans) {
		this.cans += cans;
	}

	public void calculateTons() {
		tons = bottles * BOTTLES_WEIGHT + tetrabriks * TETRABRIKS_WEIGHT + paperboard * PAPAERBOARD_WEIGHT
				+ glass * GLASS_WEIGHT + cans * CANS_WEIGHT;
		tons = fixNumber(tons / 1000, 5);
	}

	// fix a float number with the format #.#digits
	private static float fixNumber(float num, int digits) {
		float result;
		result = num * (float) Math.pow(10, digits);
		result = Math.round(result);
		result = result / (float) Math.pow(10, digits);
		return result;
	}
}
