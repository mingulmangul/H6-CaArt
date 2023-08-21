package com.softeer.caart.domain.option.dto;

import com.softeer.caart.domain.option.entity.AdditionalOptionInfo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class AdditionalOptionSummaryResponse {
	private Long optionId;
	private String optionName;

	// FIXME : N+1
	private AdditionalOptionSummaryResponse(AdditionalOptionInfo option) {
		this.optionId = option.getId();
		this.optionName = option.getDetails().getName();
	}

	public static AdditionalOptionSummaryResponse from(AdditionalOptionInfo option) {
		return new AdditionalOptionSummaryResponse(option);
	}
}
