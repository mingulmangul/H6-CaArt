package com.softeer.caart.domain.common;

import static com.softeer.caart.domain.option.entity.Badge.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.InjectSoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import com.softeer.caart.domain.Image;
import com.softeer.caart.domain.color.entity.AvailableColor;
import com.softeer.caart.domain.color.entity.Color;
import com.softeer.caart.domain.color.entity.ColorPreview;
import com.softeer.caart.domain.composition.entity.BodyType;
import com.softeer.caart.domain.composition.entity.CarEngine;
import com.softeer.caart.domain.composition.entity.WheelDrive;
import com.softeer.caart.domain.model.entity.Model;
import com.softeer.caart.domain.option.entity.AdditionalOptionInfo;
import com.softeer.caart.domain.option.entity.BaseOptionInfo;
import com.softeer.caart.domain.option.entity.SubOptionInfo;
import com.softeer.caart.domain.recommendation.persona.entity.Persona;
import com.softeer.caart.domain.recommendation.persona.entity.Profile;
import com.softeer.caart.domain.recommendation.persona.entity.RecommendationResult;
import com.softeer.caart.domain.tag.entity.Tag;
import com.softeer.caart.domain.trim.entity.Trim;

/**
 * 모든 엔티티는 id를 가지며 영속화 되어있다고 생각한다.
 */
@ExtendWith(MockitoExtension.class)
@ExtendWith(SoftAssertionsExtension.class)
public abstract class ServiceTest {
	protected CarEngine 디젤;
	protected CarEngine 가솔린;
	protected BodyType seven; // 7인승
	protected BodyType eight; // 8인승
	protected WheelDrive WD_2; // 2WD
	protected WheelDrive WD_4; // 4WD
	protected Trim LeBlanc;
	protected Trim Exclusive;
	protected BaseOptionInfo 기본옵션O;
	protected BaseOptionInfo 기본옵션X;
	protected AdditionalOptionInfo 추가옵션_세트O_기본X; // isSetOption true, isBasic false
	protected AdditionalOptionInfo 추가옵션_세트X_기본O; // isSetOption false, isBasic true (예외 케이스)
	protected SubOptionInfo 자식옵션;
	protected Tag 메인태그_우선순위10;
	protected Tag 전체태그_우선순위5;
	protected Model 추가옵션가지는_모델;
	protected Profile profile;
	protected RecommendationResult recommendationResult;
	protected Persona persona;
	protected Color exteriorColor1;
	protected Color exteriorColor2;
	protected Color interiorColor1;
	protected Color interiorColor2;
	protected AvailableColor availableColor1; // 현재 트림(LeBlanc) - 외장 색상(exteriorColor1)
	protected AvailableColor availableColor2; // 현재 트림(LeBlanc) - 내장 색상(interiorColor1)
	protected AvailableColor availableColor3; // 다른 트림(Exclusive) - 외장 색상(exteriorColor2)
	protected AvailableColor availableColor4; // 다른 트림(Exclusive) - 외장 색상(interiorColor2)
	protected Image colorPreviewImage;

	@InjectSoftAssertions
	protected SoftAssertions softly;

	@BeforeEach
	public void initData() {
		initCarEngine();
		initBodyType();
		initWheelDrive();
		initTrim();
		initBaseOptionInfo();
		initSubOptionInfo();
		initAdditionalOptionInfo();
		initTag();
		initModel();
		initProfile();
		initRecommendationResult();
		initPersona();
		initColor();
		initAvailableColor();
	}

	private void initCarEngine() {
		디젤 = CarEngine.builder()
			.name("디젤 2.2")
			.description("높은 토크로 파워풀한 드라이빙이 가능하며, 차급대비 연비 효율이 우수합니다")
			.price(1480000)
			.maxPower("202/3800PS/rpm")
			.maxTorque("45.0/1,750~2,750kgf-m/rpm")
			.imageUrl("image_url")
			.build();
		ReflectionTestUtils.setField(디젤, "id", 1L);

		가솔린 = CarEngine.builder()
			.name("가솔린 3.8")
			.description("고마력의 우수한 가속 성능을 확보하여, 넉넉하고 안정감 있는 주행이 가능합니다\n"
				+ "엔진의 진동이 적어 편안하고 조용한 드라이빙 감성을 제공합니다")
			.price(0)
			.maxPower("295/6,000PS/rpm")
			.maxTorque("36.2/5,200kgf-m/rpm")
			.imageUrl("image_url")
			.build();
		ReflectionTestUtils.setField(가솔린, "id", 2L);
	}

	private void initBodyType() {
		seven = BodyType.builder()
			.name("7인승")
			.description("기존 8인승 시트(1열 2명, 2열 3명, 3열 3명)에서 2열 가운데 시트를 없애 2열 탑승객의 편의는 물론, 3열 탑승객의 승하차가 편리합니다")
			.imageUrl("image_url")
			.build();
		ReflectionTestUtils.setField(seven, "id", 1L);
		eight = BodyType.builder()
			.name("8인승")
			.description("1열 2명, 2열 3명, 3열 3명이 탑승할 수 있는 구조로, 많은 인원이 탑승할 수 있도록 배려하였습니다")
			.imageUrl("image_url")
			.build();
		ReflectionTestUtils.setField(eight, "id", 2L);
	}

	private void initWheelDrive() {
		WD_2 = WheelDrive.builder()
			.name("2WD")
			.description("엔진에서 전달되는 동력이 전/후륜 바퀴 중 한쪽으로만 전달되어 차량을 움직이는 방식입니다\n"
				+ "차체가 가벼워 연료 효율이 높습니다")
			.price(0)
			.imageUrl("image_url")
			.build();
		ReflectionTestUtils.setField(WD_2, "id", 1L);
		WD_4 = WheelDrive.builder()
			.name("4WD")
			.description("전자식 상시 4륜 구동 시스템 입니다\n"
				+ "도로의 상황이나 주행 환경에 맞춰 전후륜 구동력을 자동배분하여 주행 안전성을 높여줍니다")
			.price(2370000)
			.imageUrl("image_url")
			.build();
		ReflectionTestUtils.setField(WD_4, "id", 1L);
	}

	private void initTrim() {
		LeBlanc = Trim.builder()
			.name("Le Blanc")
			.description("필수적인 옵션만 모은")
			.price(41980000)
			.imageUrl("tmp")
			.build();
		ReflectionTestUtils.setField(LeBlanc, "id", 1L);
		Exclusive = Trim.builder()
			.name("Exclusive")
			.description("합리적인 당신을 위한")
			.price(38960000)
			.imageUrl("tmp")
			.build();
		ReflectionTestUtils.setField(Exclusive, "id", 2L);
	}

	private void initBaseOptionInfo() {
		기본옵션O = BaseOptionInfo.builder()
			.name("기본옵션")
			.description("기본옵션 설명")
			.isBasic(true)
			.imageUrl("tmp")
			.build();
		ReflectionTestUtils.setField(기본옵션O, "id", 1L);
		기본옵션X = BaseOptionInfo.builder()
			.name("기본옵션X")
			.description("기본옵션X 설명")
			.isBasic(false)
			.imageUrl("tmp")
			.build();
		ReflectionTestUtils.setField(기본옵션X, "id", 2L);
	}

	private void initSubOptionInfo() {
		자식옵션 = SubOptionInfo.builder()
			.details(기본옵션O)
			.superOption(추가옵션_세트O_기본X)
			.build();
	}

	private void initAdditionalOptionInfo() {
		추가옵션_세트O_기본X = AdditionalOptionInfo.builder()
			.details(기본옵션X)
			.price(0)
			.isSetOption(true)
			.badge(NONE)
			.summary("추가옵션_세트O")
			.subOptions(List.of(자식옵션))
			.build();
		ReflectionTestUtils.setField(추가옵션_세트O_기본X, "id", 1L);
		추가옵션_세트X_기본O = AdditionalOptionInfo.builder()
			.details(기본옵션O)
			.price(0)
			.isSetOption(false)
			.badge(NONE)
			.summary("추가옵션_세트X")
			.build();
		ReflectionTestUtils.setField(추가옵션_세트X_기본O, "id", 2L);
	}

	private void initTag() {
		메인태그_우선순위10 = Tag.builder()
			.name("메인태그")
			.imageUrl("메인태그 image")
			.icon("메인태그 icon")
			.iconSelected("메인태그 selectedIcon")
			.priority(10)
			.build();
		ReflectionTestUtils.setField(메인태그_우선순위10, "id", 1L);
		전체태그_우선순위5 = Tag.builder()
			.name("전체태그")
			.imageUrl("전체태그 image")
			.icon("전체태그 icon")
			.iconSelected("전체태그 selectedIcon")
			.priority(5)
			.build();
		ReflectionTestUtils.setField(전체태그_우선순위5, "id", 2L);
	}

	private void initModel() {
		추가옵션가지는_모델 = Model.builder()
			.carEngine(디젤)
			.bodyType(seven)
			.wheelDrive(WD_2)
			.trim(Exclusive)
			.build();
		ReflectionTestUtils.setField(추가옵션가지는_모델, "id", 1L);
	}

	private void initProfile() {
		profile = Profile.builder()
			.image("프로필 이미지")
			.name("이름")
			.bio("소개")
			.message("한마디 문구")
			.build();
	}

	private void initRecommendationResult() {
		recommendationResult = RecommendationResult.builder()
			.model(추가옵션가지는_모델)
			.firstOption(추가옵션_세트O_기본X)
			.secondOption(추가옵션_세트O_기본X)
			.build();
	}

	private void initPersona() {
		persona = Persona.builder()
			.id(1L)
			.profile(profile)
			.coverLetter("대표 문구")
			.coverImage("표지 이미지")
			.firstQuestion("첫 번째 질문")
			.firstAnswer("첫 번째 답변")
			.secondQuestion("두 번째 질문")
			.secondAnswer("두 번째 답변")
			.recommendationMessage("추천 문구")
			.recommendationResult(recommendationResult)
			.firstTag(Tag.builder().name("태그1").build())
			.secondTag(Tag.builder().name("태그2").build())
			.build();
	}

	private void initColor() {
		colorPreviewImage = Image.from("image.jpg");

		exteriorColor1 = Color.builder()
			.name("외장 색상1")
			.price(100000)
			.imageUrl("imageUrl")
			.isExterior(true)
			.build();
		ReflectionTestUtils.setField(exteriorColor1, "id", 1L);
		List<ColorPreview> colorPreviews1 = new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			colorPreviews1.add(ColorPreview.builder().color(exteriorColor1).image(colorPreviewImage).build());
		}
		ReflectionTestUtils.setField(exteriorColor1, "colorPreviews", colorPreviews1);

		exteriorColor2 = Color.builder()
			.name("외장 색상2")
			.price(100000)
			.imageUrl("imageUrl")
			.isExterior(true)
			.build();
		ReflectionTestUtils.setField(exteriorColor2, "id", 2L);
		List<ColorPreview> colorPreviews2 = new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			colorPreviews2.add(ColorPreview.builder().color(exteriorColor2).image(colorPreviewImage).build());
		}
		ReflectionTestUtils.setField(exteriorColor2, "colorPreviews", colorPreviews2);

		interiorColor1 = Color.builder()
			.name("내장 색상1")
			.price(100000)
			.imageUrl("imageUrl")
			.isExterior(false)
			.build();
		ReflectionTestUtils.setField(interiorColor1, "id", 3L);
		ReflectionTestUtils.setField(interiorColor1, "colorPreviews",
			List.of(ColorPreview.builder().color(interiorColor1).image(colorPreviewImage).build()));

		interiorColor2 = Color.builder()
			.name("내장 색상2")
			.price(100000)
			.imageUrl("imageUrl")
			.isExterior(false)
			.build();
		ReflectionTestUtils.setField(interiorColor2, "id", 4L);
		ReflectionTestUtils.setField(interiorColor2, "colorPreviews",
			List.of(ColorPreview.builder().color(interiorColor2).image(colorPreviewImage).build()));
	}

	private void initAvailableColor() {
		availableColor1 = AvailableColor.builder().trim(LeBlanc).color(exteriorColor1).build();
		availableColor2 = AvailableColor.builder().trim(LeBlanc).color(interiorColor1).build();
		availableColor3 = AvailableColor.builder().trim(Exclusive).color(exteriorColor2).build();
		availableColor4 = AvailableColor.builder().trim(Exclusive).color(interiorColor2).build();
		ReflectionTestUtils.setField(LeBlanc, "availableColors", List.of(availableColor1, availableColor2));
		ReflectionTestUtils.setField(Exclusive, "availableColors", List.of(availableColor3, availableColor4));
	}
}
