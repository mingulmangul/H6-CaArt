package com.softeer.caart.domain.trim.dto;

import com.softeer.caart.domain.trim.entity.Trim;

import lombok.Getter;

@Getter
public class TrimDto {

	private final Long trimId;
	private final String trimName;
	private final Integer trimPrice;

	public TrimDto(Trim trim) {
		this.trimId = trim.getId();
		this.trimName = trim.getName();
		this.trimPrice = trim.getPrice();
	}
}
