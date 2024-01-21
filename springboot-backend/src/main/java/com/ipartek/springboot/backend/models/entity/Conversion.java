package com.ipartek.springboot.backend.models.entity;

import java.io.Serial;
import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "conversions")
public class Conversion implements Serializable {

	@Serial
	private static final long serialVersionUID = 8852854363773260187L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column
	private Float cuantity;
	@Column
	private String unity;
	@Column
	private Float result;
	@Column(name="unity_con")
	private String unityCon;
	
	


}
