package com.softeer.caart.domain.composition.dto;

import com.softeer.caart.domain.composition.entity.WheelDrive;

import lombok.Getter;

@Getter
public class WheelDriveDto {

	private final Long wheelDriveId;
	private final String wheelDriveName;
	private final Integer wheelDrivePrice;

	public WheelDriveDto(WheelDrive wheelDrive) {
		this.wheelDriveId = wheelDrive.getId();
		this.wheelDriveName = wheelDrive.getName();
		this.wheelDrivePrice = wheelDrive.getPrice();
	}
}
