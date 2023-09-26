'use client';
import React from 'react';
import SelectButton from './SearchSelectButton';
import LocationIcon from '@/assets/icons/location_on.svg';
import StoreIcon from '@/assets/icons/local_convenience_store.svg';
import ControllerTitle from './ControllerTitle';

function SearchSelection({onChangeStage}) {
  const onClickPlace = () => {
    onChangeStage("PLACE")
  }

  const onClickBiz = () => {
    onChangeStage("BIZ")
  }
  
  return (
    <>
      <ControllerTitle title={"무엇으로 검색하시겠어요?"} />
      <div className="flex gap-10 mb-10">
        <SelectButton text="상권" Icon={LocationIcon} onClick={onClickPlace} className="w-[70px] h-[70px]"/>
        <SelectButton text="업종" Icon={StoreIcon} onClick={onClickBiz} className="w-[70px] h-[70px]"/>
      </div>
    </>
  );
}

export default SearchSelection;
