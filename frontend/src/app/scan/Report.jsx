'use client';
import React from 'react';
import Tab from './Tab';
import LocationIcon from '@/assets/icons/location_on.svg';

function Report() {
  return (
    <div className="absolute top-0 left-0 z-30 flex w-full h-full bg-background">
      <Tab />
      <div className="w-full h-full p-8 ">
        <div className="flex items-center mb-8 text-4xl font-bold">
          <LocationIcon className="fill-primary"></LocationIcon>
          한식 | 강남 마이스 관광 특구
        </div>
      </div>
    </div>
  );
}

export default Report;
