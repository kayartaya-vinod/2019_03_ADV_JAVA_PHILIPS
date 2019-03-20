package com.philips.springboottraining;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "categories")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Integer categoryId;
	@Column(name = "category_name")
	private String categoryName;
	private String description;

	@XmlTransient
	@JsonIgnore
	@Transient
	private String createdBy; // this is not mapped to any column of the table
	
	// JoinColumn + OneToMany makes this column as a foreign key in the other table
	// JoinColumn + ManyToOne makes this column as a foreign in this table itself.
	@OneToMany(mappedBy = "category") // category is the member in Product.class with @JoinColumn
	// @JoinColumn(name="category_id") // this is not FKey in this table, but in products table
	@JsonIgnore
	@XmlTransient
	private List<Product> products;
}









