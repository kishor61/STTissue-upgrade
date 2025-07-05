/**
 * 
 */
package com.st.utilitykpimaster.model;

import java.util.Date;

/**
 * @author sbora
 *
 */
public class UtilityData {
	private int id;
	private Date date;
	private int lb60;
	private int consumption1;
	private int lb150;
	private int consumption2;
	private int millWater;
	private int consumption3;
	private int condensate;
	private int consumption4;
	private int riverWater;
	private int riverWaterData;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getLb60() {
		return lb60;
	}
	public void setLb60(int lb60) {
		this.lb60 = lb60;
	}
	public int getConsumption1() {
		return consumption1;
	}
	public void setConsumption1(int consumption1) {
		this.consumption1 = consumption1;
	}
	public int getLb150() {
		return lb150;
	}
	public void setLb150(int lb150) {
		this.lb150 = lb150;
	}
	public int getConsumption2() {
		return consumption2;
	}
	public void setConsumption2(int consumption2) {
		this.consumption2 = consumption2;
	}
	public int getMillWater() {
		return millWater;
	}
	public void setMillWater(int millWater) {
		this.millWater = millWater;
	}
	public int getConsumption3() {
		return consumption3;
	}
	public void setConsumption3(int consumption3) {
		this.consumption3 = consumption3;
	}
	public int getCondensate() {
		return condensate;
	}
	public void setCondensate(int condensate) {
		this.condensate = condensate;
	}
	public int getConsumption4() {
		return consumption4;
	}
	public void setConsumption4(int consumption4) {
		this.consumption4 = consumption4;
	}
	public int getRiverWater() {
		return riverWater;
	}
	public void setRiverWater(int riverWater) {
		this.riverWater = riverWater;
	}
	public int getRiverWaterData() {
		return riverWaterData;
	}
	public void setRiverWaterData(int riverWaterData) {
		this.riverWaterData = riverWaterData;
	}

}
