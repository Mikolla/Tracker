package ru.bondarenko.models;

/**
* Class Calculate Решение задачи 001 урок 1-й
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
  
     
	 
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
	
	 /**
     * Method echo.
     * @param name Your name.
     * @return Echo plus your name.
     */
    public String echo(String name) {
        return "Echo, echo, echo : " + name;
    }
	
}
