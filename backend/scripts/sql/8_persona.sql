-- 라이프스타일 페르소나 데이터

-- 페르소나별 추천 결과
INSERT INTO ca_art.recommendation_result (recommendation_result_id, palisage_image, model_id, exterior_color_id,
                                          interior_color_id, recommended_option_id_1, recommended_option_id_2,
                                          recommendation_explanation_1, recommendation_explanation_2)
VALUES (1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/palisade.png', 23, 6, 8, 1, 6,
        '해당 옵션이 후석 승객 알림이 있어서 좋아요. 뒷자리 아이들을 확인할 수 있거든요.', '전방충돌 방지 기능이 있어 안전을 위해서라면 꼭 추가해야하는 옵션이에요.');
INSERT INTO ca_art.recommendation_result (recommendation_result_id, palisage_image, model_id, exterior_color_id,
                                          interior_color_id, recommended_option_id_1, recommended_option_id_2,
                                          recommendation_explanation_1, recommendation_explanation_2)
VALUES (2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/palisade.png', 9, 2, 7, 1, 10,
        '헤드업 디스플레이가 있어 편안한 주행을 위해서 선택하면 좋아요.', '추운 겨울 출퇴근할 때 무릎이 따뜻해서 좋아요.');
INSERT INTO ca_art.recommendation_result (recommendation_result_id, palisage_image, model_id, exterior_color_id,
                                          interior_color_id, recommended_option_id_1, recommended_option_id_2,
                                          recommendation_explanation_1, recommendation_explanation_2)
VALUES (3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/palisade.png', 5, 6, 8, 8, 2,
        '크루즈컨트롤과 고속도로 주행보조기능으로 알아서 똑똑하게 운전해줘요.', '후방 센서와 알림으로 이젠 주차할 때 부딪힐 걱정 없어요.');
INSERT INTO ca_art.recommendation_result (recommendation_result_id, palisage_image, model_id, exterior_color_id,
                                          interior_color_id, recommended_option_id_1, recommended_option_id_2,
                                          recommendation_explanation_1, recommendation_explanation_2)
VALUES (4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/palisade.png', 30, 2, 7, 4, 7,
        '드라이브 갈 때 선루프를 열고 가면 정말 상쾌하고 기분이 좋아요.', '디자인을 신경 쓰는 사람들에겐 머플러 디테일까지 놓칠 수 없죠.');

-- 페르소나
INSERT INTO ca_art.persona (persona_id, profile_image, profile_name, profile_bio, profile_age, profile_message,
                            cover_letter, cover_image, interview_question_1, interview_answer_1, interview_question_2,
                            interview_answer_2, recommendation_message, recommendation_result_id, tag_id_1, tag_id_2)
VALUES (1, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/lifestyle/persona-1.png', '김현대',
        '두 아이의 엄마', 34, '우리 아이들과 함께 타는 차는 항상\\n안전해야 한다고 생각해요', '가족과 함께 타서\\n안전을 중시해요',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/lifestyle/cover.png', '어떤 용도로 차를 사용하세요?',
        '저는 차를 타고 출퇴근도 하지만 주중에 아이들 픽업하거나 마트 갈 때도 자주 타곤 합니다.', '차를 살 때 가장 중요하게 생각하는 부분이 뭔가요?',
        '저는 차를 살 때 안전을 중요하게 생각해요. 가족들이 같이 타는 차라 항상 사고에 경각심을 갖고 있죠. 펠리세이드는 그 점에서 뒷좌석 에어백도 터지는 모델이라 안심이 되는 편이에요.',
        '가족을 생각하는 당신', 1, 5, 7);
INSERT INTO ca_art.persona (persona_id, profile_image, profile_name, profile_bio, profile_age, profile_message,
                            cover_letter, cover_image, interview_question_1, interview_answer_1, interview_question_2,
                            interview_answer_2, recommendation_message, recommendation_result_id, tag_id_1, tag_id_2)
VALUES (2, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/lifestyle/persona-2.png', '양현모', '사회 초년생',
        27, '출퇴근길을 편안하게 달리다보니\\n하루의 시작이 상쾌해요', '매일 출퇴근해서 경제적이고\\n편안한 주행을 원해요',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/lifestyle/cover.png', '어떤 용도로 차를 사용하세요?',
        '저는 매일 차를 타고 출퇴근을 해요. 그 외에는 잘 사용하지 않는 것 같아요.', '차를 살 때 가장 중요하게 생각하는 부분이 뭔가요?',
        '차를 구매할 때 가장 중요하게 고려하는 부분은 편안함이에요. 매일 출퇴근 길이 즐겁기 위해선 편안한 시트와 조용한 내부 공간이 필요해요. 또한, 길이나 교통 상황에 구애받지 않고 부드러운 주행이 가능한 차를 찾고 있습니다. 펠리세이드 익스클루시브 트림과 컴포트 1 옵션 조합은 충분히 경제적이고 편안하더라고요.',
        '매일 출퇴근해서 피곤한 당신', 2, 3, 7);
INSERT INTO ca_art.persona (persona_id, profile_image, profile_name, profile_bio, profile_age, profile_message,
                            cover_letter, cover_image, interview_question_1, interview_answer_1, interview_question_2,
                            interview_answer_2, recommendation_message, recommendation_result_id, tag_id_1, tag_id_2)
VALUES (3, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/lifestyle/persona-3.png', '남정은',
        '면허딴지 6개월', 30, '차를 끌고 갈 때 항상 걱정이 앞섰는데\\n이젠 오히려 설레요', '운전 경력이 짧아\\n똑똑한 주행을 원해요',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/lifestyle/cover.png', '어떤 용도로 차를 사용하세요?',
        '주로 주말에 친구들과 놀러갈 때 자주 이용해요. 아직 출퇴근 길은 차가 막히는게 답답하기도 하고 운전실력이 부족해서 대중교통을 이용하고 있어요.',
        '차를 살 때 가장 중요하게 생각하는 부분이 뭔가요?',
        '저는 아직 운전 경력이 짧기 때문에 똑똑한 주행이 가능한 차를 찾고 있었어요. 주행 중에 차가 주변 상황을 인식하고 자율주행과 같은 기술들이 도와준다면 더 안전하고 쾌적한 주행을 할 수 있을 것 같아요. 이번에 현대 스마트 센스 1을 장착한 후로는 자동으로 차선을 바꿔주고 하더라고요.',
        '아직은 운전이 어려운 당신', 3, 2, 5);
INSERT INTO ca_art.persona (persona_id, profile_image, profile_name, profile_bio, profile_age, profile_message,
                            cover_letter, cover_image, interview_question_1, interview_answer_1, interview_question_2,
                            interview_answer_2, recommendation_message, recommendation_result_id, tag_id_1, tag_id_2)
VALUES (4, 'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/lifestyle/persona-4.png', '김유나',
        'MZ세대 대표', 29, '저는 항상 뻔하지 않은\\n남들과 다른 선택지를 추구하려 해요', '트렌드에 민감해\\n디자인과 성능이 중요해요',
        'https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/lifestyle/cover.png', '어떤 용도로 차를 사용하세요?',
        '저는 차를 다양한 용도로 사용합니다. 주로 일상적인 출퇴근용으로 이용하지만 주말에는 차박이나 캠핑을 자주 가는 것 같네요.', '차를 살 때 가장 중요하게 생각하는 부분이 뭔가요?',
        '차를 살 때 가장 중요하게 생각하는 부분은 디자인과 성능이에요. 시선을 사로잡는 멋진 디자인과 현대적인 스타일의 차를 찾고, 뛰어난 성능과 반응성을 갖춘 차를 선호해요. 속도와 가속력, 조작의 편의성을 고려하여 쾌적하면서도 재미있게 주행할 수 있는 차를 선택하는 것이 제게 가장 중요해요.',
        '트렌디하고 까다로운 당신', 4, 4, 6);