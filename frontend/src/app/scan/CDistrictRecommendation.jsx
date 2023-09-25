'use client'

import React from 'react';
import { Modal } from '@/components/Modal';
import Button from '@/components/Button';
import { Reason } from './Reason';
import LocationIcon from '@/assets/icons/location_on.svg'

function Guide() {
  return (
    <div className='flex flex-col items-center mt-2 font-bold text-disabled'>
      <p>LL : 다이나믹</p>
      <p>LH : 상권확장</p>
      <p>HL : 상권축소</p>
      <p>HH : 정체</p>
    </div>
  )
}

function CDistrictRecommendation() {
  const warning = "해당 정보는 추정 데이터를 기반으로 하고 있어 정확하지 않을 수 있기에 사용자의 책임하에 활용하시기 바랍니다."
  const CDistrict = "강남 마이스 관광특구"

  return (
    <Modal isOpen={true}>
      <Modal.Dimmed>
        <Modal.Container className="bg-background" width="1000px" height="90vh">
          <Modal.Close onClick={() => true} />
          <div className='flex flex-col items-center'>
            <Modal.Title>추천 상권</Modal.Title>
            <div className='text-sm text-center text-red-600'>{warning}</div>
            <div className='flex flex-row justify-center my-3'>
              <LocationIcon className="mr-1 fill-primary" style={{ width: '30px', height: '30px' }} />
              <p className='text-2xl'>{CDistrict}</p>
            </div>
            <div className='flex flex-row justify-center w-[900px] h-[340px] bg-white mt-3 rounded-large'>
              <Reason>
                <Reason.Title>추정 순이익</Reason.Title>
                <Reason.Container className="text-white bg-primary">
                  <p>추천 상권</p>
                  <p>XXXXX 원</p>
                </Reason.Container>
                <Reason.Container className="bg-background">
                  <p>평균 추정 순이익</p>
                  <p>XXXXX 원</p>
                </Reason.Container>
              </Reason>
              <Reason>
                <Reason.Title>평균 매출액 변화율</Reason.Title>
                <Reason.Container className="text-white bg-primary">
                  <p>추천 상권</p>
                  <p>XX %</p>
                </Reason.Container>
                <Reason.Container className="bg-background">
                  <p>전체 상권</p>
                  <p>XX %</p>
                </Reason.Container>
              </Reason>
              <Reason>
                <Reason.Title>평균 유동인구</Reason.Title>
                <Reason.Container className="text-white bg-primary">
                  <p>추천 상권</p>
                  <p>XXXXX 명</p>
                </Reason.Container>
                <Reason.Container className="bg-background">
                  <p>전체 상권</p>
                  <p>XXXXX 명</p>
                </Reason.Container>
              </Reason>
              <Reason>
                <Reason.Title>상권 변화지표</Reason.Title>
                <Reason.Container className="text-white bg-primary">
                  <p>LH</p>
                </Reason.Container>
                <Guide />
              </Reason>
            </div>
            <Modal.ButtonList>
              <Button className="text-xl tracking-wide text-white bg-primary rounded-small" width="400px" height="50px">리포트 보기</Button>
            </Modal.ButtonList>
          </div>
        </Modal.Container>
      </Modal.Dimmed>
    </Modal>
  );
}

export default CDistrictRecommendation;
