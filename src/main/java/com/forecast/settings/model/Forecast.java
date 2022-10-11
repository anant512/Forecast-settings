package com.forecast.settings.model;



import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="forecast_settings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Forecast {
	private String setName;
	private String functionName;
	private String parameter;
	private String parameterValue;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tenantId;
	private String updatedBy;
	@CreationTimestamp
	private Timestamp createdOn;
	@UpdateTimestamp
	private  Timestamp updatedOn;
	

}
