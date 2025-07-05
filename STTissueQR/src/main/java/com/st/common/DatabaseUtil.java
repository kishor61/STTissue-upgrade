/**
 *May 4, 2015
 *DatabaseUtil.java
 * TODO
 *com.st.common
 *DatabaseUtil.java
 *Sunil Singh Bora
 */
package com.st.common;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sbora
 *
 */
public class DatabaseUtil {
	private static final Logger logger=LoggerFactory.getLogger(DatabaseUtil.class); 
	
	
	public static String getSQL(String file) {
        String sql = null;

        try (InputStream reader = DatabaseUtil.class.getClassLoader().getResourceAsStream(file)) {
            if (reader == null) {
                throw new IllegalArgumentException("File not found: " + file);
            }
            // Convert InputStream to String
            sql = IOUtils.toString(reader, StandardCharsets.UTF_8);
        } catch (IllegalArgumentException e) {
            logger.error("File not found: " + file, e);
        } catch (IOException e) {
            logger.error("Error reading SQL file: " + file, e);
        }

        return sql;
    }
	
	
	public static String createTableName(String tableType){
		SecureRandom random = new SecureRandom();
		String id=new BigInteger(50, random).toString(32);
		return (tableType+id).toUpperCase();
		
	}
	
	
}
