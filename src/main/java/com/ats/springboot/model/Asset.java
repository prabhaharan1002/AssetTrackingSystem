package com.ats.springboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document("asset")
public class Asset {
	@JsonProperty("assetNo")
	private long assetNo;
	@Id
	@JsonProperty("serialNo")
	private String serialNo;
	@JsonProperty("brandName")
	private String brandName;
	@JsonProperty("modelName")
	private String modelName;
	@JsonProperty("modelNo")
	private String modelNo;
	@JsonProperty("cpuInfo")
	private String cpuInfo;
	@JsonProperty("memInfo")
	private String memInfo;
	@JsonProperty("storageInfo")
	private String storageInfo;
	@JsonProperty("osInfo")
	private String osInfo;
}
