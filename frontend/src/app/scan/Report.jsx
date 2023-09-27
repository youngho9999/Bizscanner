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
import { createPortal } from 'react-dom';
import { useSearchState } from './SearchContext';
import CloseIcon from '@/assets/icons/close.svg';

function Report({ onClose }) {
  const { jcategoryName, careaName } = useSearchState();

  return createPortal(
    <div className="absolute top-0 left-0 z-30 flex w-[100vw] h-[100vh] bg-background">
      <Tab />
      <div className="flex flex-col flex-grow p-8">
        <div className="flex items-center justify-between mb-8 text-4xl font-bold">
          <div className="flex items-center">
            <LocationIcon className="fill-primary" width="48" height="48"></LocationIcon>
            {`${jcategoryName} | ${careaName}`}
          </div>
          <button onClick={() => onClose()}>
            <CloseIcon width={48} height={48} />
          </button>
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
    </div>,
    document.body,
  );
}

export default Report;
