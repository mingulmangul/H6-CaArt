package org.softeer_2nd.caArt.model.factory

import org.softeer_2nd.caArt.model.data.OptionChangePopUpItem
import org.softeer_2nd.caArt.model.data.Persona
import org.softeer_2nd.caArt.model.data.ResultChoiceOption
import org.softeer_2nd.caArt.model.data.UserChoiceBottomsheetState
import org.softeer_2nd.caArt.model.dummy.TrimDescriptionDummyItem


object DummyItemFactory {
    fun createOptionSelectionDummyItems(): MutableList<UserChoiceBottomsheetState> {
        return arrayListOf(
            UserChoiceBottomsheetState(
                "모델",
                "펠리세이드 디젤 2.2 2WD, Le Blanc",
                "7인승",
                "42,450,000원",
                ""
            ),
            UserChoiceBottomsheetState("색상", "외장 - 어비스 블랙펄", "내장 - 어비스 블랙펄", "-원", "-원"),
            UserChoiceBottomsheetState("옵션", "컴포트 II", "내장 어비스 블랙펄", "1,090,000원", "790,000원"),
        )
    }

    fun createInteriorColorOptionChangeDummyItems(): List<OptionChangePopUpItem> {
        return arrayListOf(
            OptionChangePopUpItem("인조 가죽 블랙(블랙)", "0원")
        )
    }

    fun createDefaultOptionChangeDummyItems(): List<OptionChangePopUpItem> {
        return arrayListOf(
            OptionChangePopUpItem("주차 보조 시스템", "400,000원"),
            OptionChangePopUpItem("컴포트 II", "400,000원")
        )
    }

    fun createTrimEngineDescriptionItem(): List<TrimDescriptionDummyItem> {
        return arrayListOf(
            TrimDescriptionDummyItem(
                "디젤 2.2",
                "강한 성능 높은 연비 효율",
                "https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/engine/5.jpg",
                "높은 토크로 파워풀한 드라이빙이 가능하며, 차급대비 연비 효율이 우수합니다.",
                "295/6,000PS/rpm",
                "36.2/5,200kgf-m/rpm"
            ),
            TrimDescriptionDummyItem(
                "가솔린 2.2",
                "강한 성능 높은 연비 효율",
                "https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/engine/6.jpg",
                "고마력의 우수한 가속 성능을 확보하여, 넉넉하고 안정감 있는 주행이 가능합니다. 엔진의 진동이 적어 편안하고 조용한 드라이빙 감성을 제공합니다.",
                "asdasdas",
                "asdas"
            )
        )
    }

    fun createTrimBodyDescriptionItem(): List<TrimDescriptionDummyItem> {
        return arrayListOf(
            TrimDescriptionDummyItem(
                "7인승",
                "7인승 매우 편안",
                "ttps://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/bodytype/7.jpg",
                "기존 8인승 시트(1열 2명, 2열 3명, 3열 3명)에서 2열 가운데 시트를 없애 2열 탑승객의 편의는 물론, 3열 탑승객의 승하차가 편리합니다"
            ),
            TrimDescriptionDummyItem(
                "8인승",
                "8인승 매우 편안",
                "https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/bodytype/8.jpg",
                "1열 2명, 2열 3명, 3열 3명이 탑승할 수 있는 구조로, 많은 인원이 탑승할 수 있도록 배려하였습니다."
            )
        )
    }

    fun createTrimDrivenDescriptionItem(): List<TrimDescriptionDummyItem> {
        return arrayListOf(
            TrimDescriptionDummyItem(
                "2WD",
                "2륜 구동 방식",
                "https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/wd/9.jpg",
                "엔진에서 전달되는 동력이 전/후륜 바퀴 중 한쪽으로만 전달되어 차량을 움직이는 방식입니다. 차체가 가벼워 연료 효율이 높습니다."
            ),
            TrimDescriptionDummyItem(
                "4WD",
                "4륜 구동 방식",
                "https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/model/wd/10.jpg",
                "전자식 상시 4륜 구동 시스템입니다. 도로의 상황이나 주행 환경에 맞춰 전후륜 구동력을 자동배분하여 주행 안전성을 높여줍니다.",
            )
        )
    }

    fun createDescriptionDummyItems(): List<List<TrimDescriptionDummyItem>> {
        return arrayListOf(
            createTrimEngineDescriptionItem(),
            createTrimBodyDescriptionItem(),
            createTrimDrivenDescriptionItem()
        )
    }

    fun createLifestylePersonaListDummyItem(): List<Persona> {
        return List(4) {
            Persona(
                personaId = it,
                coverLetter = "매일 출퇴근해서 경제적이고\n편안한 주행을 원해요",
                profileImage = "https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/lifestyle/persona-2.png",
                tags = listOf("추위/더위", "사용편의")
            )
        }
    }

    fun createResultOptionDummyItem(): List<ResultChoiceOption> {
        return listOf(
            ResultChoiceOption(
                "색상",
                "외장 - 크라미 화이 펄",
                "https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/color/exterior/14.png",
                0,
                "75%의 20~30대 구매자들이 선택했어요",
                "내장 - 인조 가죽(블랙)",
                "https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/color/exterior/14.png",
                0,
                "75%의 20~30대 구매자들이 선택했어요"
            ),
            ResultChoiceOption(
                "색상",
                "외장 - 크라미 화이 펄",
                "https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/color/exterior/14.png",
                0,
                "75%의 20~30대 구매자들이 선택했어요",
                "내장 - 인조 가죽(블랙)",
                "https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/color/exterior/14.png",
                0,
                "75%의 20~30대 구매자들이 선택했어요"
            )
        )
    }

    fun createOrderMoreDetailDummyItem(): List<String> {
        return listOf("탁송", "할인/포인트", "결제방법", "면제 구분 및 등록비")
    }
}
