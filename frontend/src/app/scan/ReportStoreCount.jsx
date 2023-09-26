import React, { useEffect, useState } from 'react';
import ReportSection from './ReportSection';
import SummaryText from './SummaryText';
import { useSearchState } from './SearchContext';
import axios from '@/api/index';
import { Bar } from 'react-chartjs-2';

import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
} from 'chart.js';

ChartJS.register(CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend);

const labels = ['2022년 1분기', '2022년 2분기', '2022년 3분기', '2022년 4분기', '2023년 1분기'];

function ReportStoreCount() {
  const [storeCountInfo, setStoreCountInfo] = useState();
  const { careaCode, jcategoryCode } = useSearchState();

  const fetchStoreCount = async () => {
    const { data } = await axios.get(`/report/stores/${careaCode}/${jcategoryCode}`);
    setStoreCountInfo(data.quarterlyStore);
  };

  const getLastYearDiff = () => {
    return Math.abs(storeCountInfo[storeCountInfo.length - 1] - storeCountInfo[0]);
  };

  const getLastYearDiffText = () => {
    return storeCountInfo[storeCountInfo.length - 1] - storeCountInfo[0] >= 0 ? '상승' : '하락';
  };

  const getPrevQuaterDiff = () => {
    return Math.abs(
      storeCountInfo[storeCountInfo.length - 1] - storeCountInfo[storeCountInfo.length - 2],
    );
  };

  const getPrevQuaterDiffText = () => {
    return Math.abs(
      storeCountInfo[storeCountInfo.length - 1] - storeCountInfo[storeCountInfo.length - 2],
    ) >= 0
      ? '상승'
      : '하락';
  };

  const options = {
    responsive: true,
    plugins: {
      legend: {
        position: 'top',
      },
      title: {
        display: true,
        text: '분기별 점포수',
      },
    },
  };

  const data = {
    labels,
    datasets: [
      {
        label: '점포수',
        data: storeCountInfo,
        backgroundColor: 'rgba(255, 99, 132, 0.5)',
      },
    ],
  };

  useEffect(() => {
    fetchStoreCount();
  }, []);

  return (
    <ReportSection title="점포수">
      <SummaryText>
        {storeCountInfo &&
          `해당 상권에서 운영 중인 한식 점포수 전년 동분기 대비 ${getLastYearDiff()}개 ${getLastYearDiffText()}
      하였으며,전분기 대비 ${getPrevQuaterDiff()}개 ${getPrevQuaterDiffText()}하였습니다.`}
      </SummaryText>
      <div className="flex items-center justify-center ">
        <div className="w-3/4">
          <Bar options={options} data={data} />
        </div>
      </div>
    </ReportSection>
  );
}

export default ReportStoreCount;
