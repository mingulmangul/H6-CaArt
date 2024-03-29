import React, { useState } from 'react';
import { styled } from 'styled-components';
import { Link } from 'react-router-dom';
import { useFetch } from '../../hooks/useFetch';
import ErrorPopup from '../../components/common/ErrorPopup';
import SquareButton from '../../components/common/SquareButton';
import PageNum from '../../components/recommendPage/ageAndLifeStyle/PageNum';
import LifeStyleCard from '../../components/recommendPage/lifeStyleCard/LifeStyleCard';
import LifeStylePeekModal from '../../components/recommendPage/lifeStylePeek/LifeStylePeekModal';
import { RecommendPageProps } from './RecommendPage';
import useScrollTop from '../../hooks/useScrollTop';

export interface lifeStyleProps {
  personaId: number;
  profileImage: string;
  coverLetter: string;
  tags: string[];
}

function RecomendLifeStylePage({ choice, setChoice }: RecommendPageProps) {
  const [openedModalNum, setOpenedModalNum] = useState(0);

  useScrollTop();

  const { data, status, error } = useFetch<lifeStyleProps[]>('/personas');
  if (status === 'loading') {
    return <div></div>;
  } else if (status === 'error') {
    console.error(error);
    return <ErrorPopup></ErrorPopup>;
  }
  if (data === null) return <div></div>;

  const lifeStyleList = data.map(item => {
    return (
      <LifeStyleCard
        key={item.personaId}
        id={item.personaId}
        tag={item.tags}
        text={item.coverLetter}
        imgSrc={item.profileImage}
        selected={choice.lifeStyle === item.personaId}
        setOpenedModalNum={setOpenedModalNum}
        setLifeStyle={id => {
          setChoice({ ...choice, lifeStyle: id });
        }}
      ></LifeStyleCard>
    );
  });

  return (
    <RecomendLifeStylePageBox>
      <RecomendLifeStyleMain>
        <RecomendLifeStylePageTitle>
          <div className="text-grey-0">
            <span className="head-regular-22">유사한 </span>
            <span className="head-medium-22">라이프스타일</span>
            <span className="head-regular-22">
              을 선택하면
              <br />
              차량 조합을 추천해 드려요.
            </span>
          </div>
          <PageNum>2/2</PageNum>
        </RecomendLifeStylePageTitle>
        <Link to="/recommend/custom">
          <RecomendLifeStylePageExit className="body-medium-14 text-secondary-active-blue">
            원하는 라이프스타일이 없다면?
          </RecomendLifeStylePageExit>
        </Link>
        <RecomendLifeStyleCardBox>{lifeStyleList}</RecomendLifeStyleCardBox>
        <Link
          to="/recommend/result"
          onClick={e => {
            choice.lifeStyle === 0 && e.preventDefault();
          }}
        >
          <SquareButton
            size="xl"
            color="grey-1000"
            $bg="primary-blue"
            $disabled={choice.lifeStyle === 0}
          >
            선택 완료
          </SquareButton>
        </Link>
      </RecomendLifeStyleMain>

      {openedModalNum !== 0 && (
        <LifeStylePeekModal
          openedModalNum={openedModalNum}
          setOpenedModalNum={setOpenedModalNum}
        ></LifeStylePeekModal>
      )}
    </RecomendLifeStylePageBox>
  );
}

const RecomendLifeStylePageBox = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const RecomendLifeStyleMain = styled.div`
  width: 608px;
  margin-top: 48px;
  margin-bottom: 36px;
`;

const RecomendLifeStylePageTitle = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-bottom: 16px;
`;

const RecomendLifeStylePageExit = styled.div`
  line-height: 16px;
  letter-spacing: -0.07px;
  text-decoration: underline;
  margin-bottom: 52px;
  cursor: pointer;
`;

const RecomendLifeStyleCardBox = styled.div`
  display: flex;
  flex-wrap: wrap;
  gap: 16px;
  align-content: space-between;
  height: 420px;
  margin-bottom: 40px;
`;

export default RecomendLifeStylePage;
