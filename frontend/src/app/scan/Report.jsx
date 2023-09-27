'use client';
import React from 'react';
import Tab from './Tab';
import LocationIcon from '@/assets/icons/location_on.svg';
import ReportSummary from './ReportSummary';
import ReportStoreCount from './ReportStoreCount';
import ReportOpenStore from './ReportOpenStore';
import ReportCloseStore from './ReportCloseStore';
import ReportSales from './ReportSales';
import ReportSalesCount from './ReportSalesCount';
import ReportFloatingPopulation from './RepoartFloatingPopulation';

function Report() {
  return (
    <div className="absolute top-0 left-0 z-30 flex w-[100vw] h-[100vh] bg-background">
      <Tab />
      <div className="flex flex-col flex-grow p-8">
        <div className="flex items-center mb-8 text-4xl font-bold">
          <LocationIcon className="fill-primary" width="48" height="48"></LocationIcon>
          한식 | 강남 마이스 관광 특구
        </div>
        <div className="flex flex-grow gap-8 overflow-y-auto">
          <main className="flex flex-col flex-grow max-h-full gap-8 overflow-y-auto">
            <ReportSummary />
            <ReportStoreCount />
            <ReportOpenStore />
            <ReportCloseStore />
            <ReportSales />
            <ReportSalesCount />
            <ReportFloatingPopulation />
          </main>
          <aside className="h-full w-[300px]"></aside>
        </div>
      </div>
    </div>
  );
}

export default Report;
