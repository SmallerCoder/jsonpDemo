package com.example.jsonpDemo.pojo;

/**
 * 
 * The class User.
 *
 * Description:User实体
 *
 * @author: huangjiawei
 * @since: 2018年6月12日
 * @version: $Revision$ $Date$ $LastChangedBy$
 *
 */
public class User {

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "{\"name\":\"" + name + "\",\"age\":\"" + age + "\"}";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

}
