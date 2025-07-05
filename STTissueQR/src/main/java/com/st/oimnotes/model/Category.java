/**
 * 
 */
package com.st.oimnotes.model;

/**
 * @author sbora
 *
 */
public class Category {
	private int id;
	private String category;
	
	
	
	/**
	 * 
	 */
	public Category() {}
	public Category(int id) {this.id=id;}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		Category category=(Category)obj;
		return this.getId()==category.getId();
	}
}
