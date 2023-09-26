'use client';
import React from 'react';
import Tab from './Tab';
import LocationIcon from '@/assets/icons/location_on.svg';
import ReportSummary from './ReportSummary';
import ReportStoreCount from './ReportStoreCount';

function Report() {
  return (
    <div className="absolute top-0 left-0 z-30 flex w-full h-full bg-background">
      <Tab />
      <div className="flex flex-col w-full h-full p-8">
        <div className="flex items-center mb-8 text-4xl font-bold">
          <LocationIcon className="fill-primary" width="48" height="48"></LocationIcon>
          한식 | 강남 마이스 관광 특구
        </div>
        <div className="flex flex-grow gap-8 ">
          <main className="grow-[3] flex flex-col gap-8 flex-nowrap max-h-full">
            <ReportSummary />
            <ReportStoreCount />
          </main>
          <aside className="flex-grow h-full "></aside>
        </div>
      </div>
    </div>
  );
}

export default Report;
