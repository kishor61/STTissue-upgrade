/**
 *Dec 13, 2014
 *QualityGraphDataPoint.java
 * TODO
 *com.st.qualitypm6.model
 *QualityGraphDataPoint.java
 *Sunil Singh Bora
 */
package com.st.qualitypm6.model;

/**
 * @author sbora
 *
 */
public class QualityGraphDataPoint {
	private String x;
	private double y;

	private String reel;
	/**
	 * 
	 */
	public QualityGraphDataPoint(String reel) {this.reel=reel;}
	public QualityGraphDataPoint(String x,double y) {this.x=x;this.y=y;}
	
	public QualityGraphDataPoint(String x,double y,String reel) {this.x=x;this.y=y;this.reel=reel;}
	
	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getReel() {
		return reel;
	}

	public void setReel(String reel) {
		this.reel = reel;
	}
	
	@Override
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object arg0) {
			QualityGraphDataPoint dataPoint=(QualityGraphDataPoint)arg0;
		return this.getReel().equals(dataPoint.getReel());
	}
}
