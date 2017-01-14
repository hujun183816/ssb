package com.libo.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "goods", catalog = "hujun")

public class Goods implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Double price;
	private String content;
	private String beizhu;
	private String image;
	private Integer status;

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** minimal constructor */
	public Goods(String name, Double price, String content, String beizhu, String image) {
		this.name = name;
		this.price = price;
		this.content = content;
		this.beizhu = beizhu;
		this.image = image;
	}

	/** full constructor */
	public Goods(String name, Double price, String content, String beizhu, String image, Integer status) {
		this.name = name;
		this.price = price;
		this.content = content;
		this.beizhu = beizhu;
		this.image = image;
		this.status = status;
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

	@Column(name = "name", nullable = false, length = 55)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "price", nullable = false, precision = 22, scale = 0)

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "content", nullable = false, length = 200)

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "beizhu", nullable = false, length = 200)

	public String getBeizhu() {
		return this.beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	@Column(name = "image", nullable = false, length = 500)

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "status")

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}