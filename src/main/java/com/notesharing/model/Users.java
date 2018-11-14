package com.notesharing.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users", schema = "notesharing")
public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer u_id;// id
	private String u_name;// 姓名
	private String u_password;// 密码
	private String u_gender;// 性别
	private String u_phone;// 电话
	private String u_headportrait;// 头像地址

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String u_name, String u_password, String u_gender, String u_phone, String u_headportrait) {
		super();
		this.u_name = u_name;
		this.u_password = u_password;
		this.u_gender = u_gender;
		this.u_phone = u_phone;
		this.u_headportrait = u_headportrait;
	}

	public Users(int u_id, String u_name, String u_password, String u_gender, String u_phone, String u_headportrait) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_password = u_password;
		this.u_gender = u_gender;
		this.u_phone = u_phone;
		this.u_headportrait = u_headportrait;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UID", unique = true, nullable = false, length = 11)
	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	@Column(name = "USERNAME", nullable = false, length = 255)
	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	@Column(name = "PASSWORD", nullable = false, length = 255)
	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	@Column(name = "GENDER", nullable = true, length = 255)
	public String getU_gender() {
		return u_gender;
	}

	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}

	@Column(name = "PHONE", nullable = true, length = 255)
	public String getU_phone() {
		return u_phone;
	}

	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}

	@Column(name = "HEADPORTRAIT", nullable = true, length = 100)
	public String getU_headportrait() {
		return u_headportrait;
	}

	public void setU_headportrait(String u_headportrait) {
		this.u_headportrait = u_headportrait;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
