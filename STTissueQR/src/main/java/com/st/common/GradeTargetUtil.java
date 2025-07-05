package com.st.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.st.qualitypm6.model.GradeTarget;

public class GradeTargetUtil {
	
	public static final String GP01="GP01";
	public static final String GP02="GP02";
	public static final String GP03="GP03";
	public static final String GP04="GP04";
	public static final String GP05="GP05";
	public static final String GP06="GP06";
	public static final String GP07="GP07";
	public static final String GP08="GP08";
	public static final String GP09="GP09";
	public static final String GP10="GP10";
	public static final String GP11="GP11";
	public static final String GP12="GP12";
	
	
	
	public static int checkRange(double value,GradeTarget gradeTarget){
		
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
	
	
	public static int checkRange(double value,double minR,double maxR,double minC,double maxC,double targ){
		
		int color=0;

			
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
	
		return color;
	}
	
	
	
	public static Map<String, Object> format(List<GradeTarget> gradeTargets){
		Map<String, Object> map=new HashMap<String, Object>();
		for (GradeTarget gradeTarget : gradeTargets) {
			map.put(gradeTarget.getPhysicalProperty(), gradeTarget);
		}
		return map;
	}
	
	
	public static String getColorClass(List<GradeTarget> gradeTargets,
			double value, String string) {
		
		GradeTarget gradeT=null;
		for (GradeTarget gradeTarget : gradeTargets) {
			if(gradeTarget.getPhysicalProperty().equalsIgnoreCase(string)){
				gradeT=gradeTarget;
			}
		}
		
		int val=GradeTargetUtil.checkRange(value, gradeT);
		
		if(val==CommonProperties.COLOR_RED){
			return "redcolor";
		}else if(val==CommonProperties.COLOR_GREEN){
			return "greencolor";
		}else if(val==CommonProperties.COLOR_YELLOW){
			return "yellowcolor";
		}
		
		return "";
	}

	
	public static GradeTarget getGradeTarget(List<GradeTarget> gradeTargets,String prop){
		GradeTarget gradeTarget=new GradeTarget();
		for (GradeTarget target : gradeTargets) {
			if(target.getPhysicalProperty().equalsIgnoreCase(prop)){
				gradeTarget=target;
				break;
			}
		}
		return gradeTarget;
	}
}

