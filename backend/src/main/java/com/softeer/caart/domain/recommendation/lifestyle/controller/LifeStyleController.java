package com.softeer.caart.domain.recommendation.lifestyle.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softeer.caart.domain.recommendation.lifestyle.dto.request.RecommendationRequest;
import com.softeer.caart.domain.recommendation.lifestyle.dto.response.LifestyleAdditionalQuestionsResponse;
import com.softeer.caart.domain.recommendation.lifestyle.dto.response.LifestyleBaseQuestionsResponse;
import com.softeer.caart.domain.recommendation.lifestyle.dto.response.RecommendationResponse;
import com.softeer.caart.domain.recommendation.lifestyle.service.LifeStyleService;
import com.softeer.caart.global.response.DataResponseDto;
import com.softeer.caart.global.response.ResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/lifestyles")
@RequiredArgsConstructor
@Tag(name = "라이프스타일 API", description = "라이프스타일을 선택하고 이에 따른 추천 차량 견적을 조회한다.")
public class LifeStyleController {

	private final LifeStyleService lifeStyleService;

	@GetMapping("/questions")
	@Operation(summary = "사전 질문 목록을 조회한다.")
	public ResponseDto getBaseQuestions() {
		return DataResponseDto.of(LifestyleBaseQuestionsResponse.create());
	}

	@GetMapping("/questions/additional")
	@Operation(summary = "추가 질문 목록을 조회한다.")
	public ResponseDto getAdditionalQuestions() {
		return DataResponseDto.of(LifestyleAdditionalQuestionsResponse.create());
	}

	@GetMapping("/recommendation")
	@Operation(summary = "선택한 라이프스타일에 따른 추천 차량 견적을 조회한다.")
	public ResponseDto getRecommendation(final @Valid RecommendationRequest request) {
		// TODO: 검증에 따른 예외 처리 추가 (검증 실패 사유를 응답)
		RecommendationResponse response = lifeStyleService.getRecommendationByLifestyle(request);
		return DataResponseDto.of(response);
	}
}