package com.libo.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * SysOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_order", catalog = "hujun")

public class Order implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer status;
	private String phone;
	private String adress;
	private String money;
	private String company;
	private String num;
	private String remark;
	private String paytime;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(String name, Integer status, String phone, String adress, String money, String company, String num,
			String remark, String paytime) {
		this.name = name;
		this.status = status;
		this.phone = phone;
		this.adress = adress;
		this.money = money;
		this.company = company;
		this.num = num;
		this.remark = remark;
		this.paytime = paytime;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 32)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "status")

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "phone", length = 222)

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "adress", length = 222)

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Column(name = "money", length = 222)

	public String getMoney() {
		return this.money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	@Column(name = "company", length = 222)

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "num", length = 222)

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	@Column(name = "remark", length = 222)

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "paytime", length = 222)

	public String getPaytime() {
		return this.paytime;
	}

	public void setPaytime(String paytime) {
		this.paytime = paytime;
	}

}