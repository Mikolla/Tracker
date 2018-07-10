package ru.bondarenko.models;

/**
* 
* @author  Bondarenko Nikolay
* @version 01
* @since 02.06.2018
*/

public class Item {
	private String id;	
	public String name;
	public String description;
	public long create;
	
	public Item() {}
	
	public Item(String name, String description, long create) {
	this.name = name;
    this.description = description;
    this.create = create;	
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public long getCreate() {
		return this.create;
	} 
    
	
}
