/**
 *May 26, 2015
 *FileModifiedCompartor.java
 * TODO
 *com.st.common
 *FileModifiedCompartor.java
 *Sunil Singh Bora
 */
package com.st.common;

import java.io.File;
import java.util.Comparator;
import java.util.Date;

/**
 * @author sbora
 *
 */
public class FileLastModifiedComparator implements Comparator<File>{

	@Override
	public int compare(File o1, File o2) {
		
		return new Date(o1.lastModified()).compareTo(new java.util.Date(o2.lastModified()));
	}
	
}
