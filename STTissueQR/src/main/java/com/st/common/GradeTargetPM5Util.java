/**
 *Dec 22, 2017
 *GradeTargetPM5Util.java
 * TODO
 *com.st.common
 *GradeTargetPM5Util.java
 *Roshan Lal Tailor
 */
package com.st.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.st.qualitypm5.model.GradeTargetPM5;
import com.st.qualitypm6.model.GradeTarget;

/**
 * @author roshan
 *
 */
public class GradeTargetPM5Util {

	public static String getColorClass(List<GradeTargetPM5> gradeTargets,
			double value, String string) {
		
		GradeTargetPM5 gradeT=null;
		for (GradeTargetPM5 gradeTarget : gradeTargets) {
			if(gradeTarget.getPhysicalProperty().equalsIgnoreCase(string)){
				gradeT=gradeTarget;
			}
		}
		
		int val=GradeTargetPM5Util.checkRange(value, gradeT);
		
		if(val==CommonProperties.COLOR_RED){
			return "redcolor";
		}else if(val==CommonProperties.COLOR_GREEN){
			return "greencolor";
		}else if(val==CommonProperties.COLOR_YELLOW){
			return "yellowcolor";
		}
		
		return "";
	}

	/**
	 * @param value
	 * @param gradeT
	 * @return
	 */
	public static int checkRange(double value,GradeTargetPM5 gradeTarget){
		
		int color=0;
		
		if(gradeTarget!=null){
		
			double minR=gradeTarget.getRejectMin();
			double maxR=gradeTarget.getRejectMax();
			double minC=gradeTarget.getControlMin();
			double maxC=gradeTarget.getControlMax();
			double targ=gradeTarget.getTarget();
			
		//	System.out.println("minR="+minR+"\tminC="+minC+"\ttarg="+targ+"\tmaxC="+maxC+"\tmaxR="+maxR);
			
			if(value!=0){
				if(targ!=0){

					
					if(minR!=0 && value<=minR){
						color=CommonProperties.COLOR_RED;
					}
					
					if(maxR!=0 && value>=minR){
						color=CommonProperties.COLOR_RED;
					}
						
					
					
					if(minR!=0 && maxR!=0){
						if(value>minR && (minC!=0 && value<=minC)){
							color=CommonProperties.COLOR_YELLOW;
						}else if(value>minR && (targ!=0 && value<=targ)){
							color=CommonProperties.COLOR_YELLOW;
						}else if(value<maxR && (maxC!=0 && value>=maxC)){
							color=CommonProperties.COLOR_YELLOW;
						}else if(value<maxR && (targ!=0 && value>=targ)){
							color=CommonProperties.COLOR_YELLOW;
						}
						
					}
					if(minR!=0){
						
						if(value>minR && (minC!=0 && value<=minC)){
							color=CommonProperties.COLOR_YELLOW;
						}else if(value>minR && (targ!=0 && value<=targ)){
							color=CommonProperties.COLOR_YELLOW;
						}
					}
					
					if(maxR!=0){
						if(value<maxR && (maxC!=0 && value>=maxC)){
							color=CommonProperties.COLOR_YELLOW;
						}else if(value<maxR && (targ!=0 && value>=targ)){
							color=CommonProperties.COLOR_YELLOW;
						}
					}
					
					if(maxR==0 && (maxC!=0 && value>=maxC)){
						color=CommonProperties.COLOR_YELLOW;
					}
					
					if(minR==0 && (minC!=0 && value<=minC)){
						color=CommonProperties.COLOR_YELLOW;
					}
					
				//	System.out.println(color);
					
					//Check Green Range
					
					if(minC!=0 && maxC!=0){
						if(value>minC && value<maxC){
							//Within control range
							color=CommonProperties.COLOR_GREEN;
						}
					}
					
					if(minC!=0 && (value>minC && value<=targ)){
						//Within control range
						color=CommonProperties.COLOR_GREEN;
					}
					
					if(maxC!=0 && (value<maxC && value>=targ)){
						//Within control range
						color=CommonProperties.COLOR_GREEN;
					}
					
					
					//Changes
					if(maxC==0 && (value<maxR && value>=targ)){
						color=CommonProperties.COLOR_GREEN;
					}
					if(minC==0 && (value>minR && value<=targ)){
						color=CommonProperties.COLOR_GREEN;
					}
					
					
					if(maxC==0 && maxR==0 && minR==0 && minC==0){
						color=CommonProperties.COLOR_NONE;
					}

				}
			}
			
		}
		return color;
	}

	/**
	 * @param gradeTargets
	 * @return
	 */
	public static Map<String, Object> format(List<GradeTargetPM5> gradeTargets) {
		Map<String, Object> map=new HashMap<String, Object>();
		for (GradeTargetPM5 gradeTarget : gradeTargets) {
			map.put(gradeTarget.getPhysicalProperty(), gradeTarget);
		}
		return map;
	}
}
