import React, { useEffect } from 'react';
import TopContainer from '../../components/resultPage/TopContainer';
import { ResultMain } from '../../components/common/result/ResultMain';
import { styled } from 'styled-components';
import SquareButton from '../../components/common/SquareButton';
import BuyCarContainer from '../../components/resultPage/BuyCarContainer';
import { Link } from 'react-router-dom';
import ShareModal from '../../components/resultPage/modal/ShareModal';
import MailModal from '../../components/resultPage/modal/MailModal';
import MakePdf from '../../util/MakePdf';
import { useModalContext } from '../../store/ModalContext';
import LoginModal from '../../components/resultPage/modal/LoginModal';

function ResultPage() {
  const { state, dispatch } = useModalContext();
  const pdf = MakePdf();
  const getPdf = async (e: React.MouseEvent) => {
    e.preventDefault();
    await pdf.viewWithPdf();
  };
  useEffect(() => {
    window.scroll(0, 0);
  }, []);
  return (
    <>
      {<ShareModal />}
      {<MailModal />}
      {<LoginModal />}
      <Wrapper
        share={state.shareModalOpen}
        mail={state.mailModalOpen}
        save={state.saveModalOpen}
      >
        <div className="pdf">
          <TopContainer />
          <MainContainer>
            <ResultMain />
            <ButtonContainer className="body-medium-16 text-grey-200">
              <Button onClick={() => dispatch({ type: 'OPEN_SAVE_MODAL' })}>
                내 계정에 저장
              </Button>
              <Button onClick={getPdf}>PDF로 저장</Button>
              <Button onClick={() => dispatch({ type: 'OPEN_MAIL_MODAL' })}>
                내 메일로 발송
              </Button>
            </ButtonContainer>
          </MainContainer>
        </div>
        <Hr />
        <BuyCarContainer />
        <ButtonContainer className="last">
          <Link to="/estimate/option">
            <SquareButton size="m" color="grey-50" border>
              수정
            </SquareButton>
          </Link>
          <SquareButton size="m" color="grey-1000" bg="primary-blue">
            구매/상담
          </SquareButton>
        </ButtonContainer>
      </Wrapper>
    </>
  );
}

export default ResultPage;

const MainContainer = styled.div`
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  margin-top: 36px;
`;

const ButtonContainer = styled.div`
  display: flex;
  height: 52px;
  justify-content: center;
  align-items: center;
  gap: 8px;
  margin-top: 33px;
  margin-bottom: 52px;
  .last {
    gap: 18px;
    margin-top: 66px;
    margin-bottom: 36px;
  }
`;

const Hr = styled.div`
  margin: 0 auto;
  width: 608px;
  height: 1px;
  background: var(--grey-700);
`;

const Wrapper = styled.div<{ share: boolean; mail: boolean; save: boolean }>`
  overflow-x: hidden;
  ${props => (props.share || props.mail || props.save) && `position: fixed;`}
`;

const Button = styled.div`
  display: flex;
  width: 168px;
  height: 52px;
  justify-content: center;
  align-items: center;
  border: 1px solid var(--grey-600);
  border-radius: 8px;
  transition: all 0.2s linear;
  cursor: pointer;
  &:hover {
    background-color: var(--primary-blue);
    color: var(--grey-1000);
  }
`;
