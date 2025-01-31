package com.nipam.infotech.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double price;
	private String description;
	private Long stock;
	@Lob
	@Column(columnDefinition = "longblob")
	private byte[] image;
	@ManyToOne
	@JoinColumn(name = "category_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonBackReference
	private Category category;
}
