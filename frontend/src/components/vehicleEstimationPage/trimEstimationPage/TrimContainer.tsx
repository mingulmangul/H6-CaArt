import React from 'react';
import styled from 'styled-components';
import { Trim } from '../../../pages/vehicleEstimationPage/TrimEstimationPage';
import { useModalContext } from '../../../store/ModalContext';
import TrimCard from './TrimCard';

function TrimContainer({ data }: { data: Trim[] }) {
  const trimList = ['Exclusive', 'Le Blanc', 'Prestige', 'Calligraphy'];
  const { dispatch } = useModalContext();

  function setTrimCard(trimLists: string[]) {
    return trimLists.map((trim, index) => (
      <>
        <TrimCard key={`${trim}${index}`} trim={trim} data={data} />
        {index !== trimLists.length && <Hr key={`${index}${trim}`} />}
      </>
    ));
  }

  return (
    <Box>
      <TrimHeader>
        <span className="head-medium-20 text-grey-0">트림</span>
        <CompareButton
          className="body-regular-12 text-grey-0"
          onClick={() => dispatch({ type: 'OPEN_COMPARE_MODAL' })}
        >
          비교하기
        </CompareButton>
      </TrimHeader>
      <>{setTrimCard(trimList)}</>
    </Box>
  );
}

export default TrimContainer;

const Box = styled.div`
  width: 309px;
  flex-shrink: 0;
  display: flex;
  flex-direction: column;
  margin: 34px 0px 48px 0px;
`;

const CompareButton = styled.div`
  display: inline-flex;
  padding: 4px 12px;
  justify-content: center;
  align-items: center;
  gap: 10px;
  border-radius: 20px;
  border: 1px solid var(--grey-scale-grey-700, #ebebeb);
  cursor: pointer;
`;

const TrimHeader = styled.div`
  display: flex;
  justify-content: space-between;
  margin-bottom: 26px;
`;

const Hr = styled.hr`
  width: 308px;
  margin: 16px 0;
  flex-shrink: 0;
  border-width: 1px 0 0 0;
  border-color: var(--primary-blue-10);
`;
