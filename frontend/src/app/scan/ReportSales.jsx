import React, { useEffect, useState } from 'react';
import axios from '@/api/index';
import { useSearchState } from './SearchContext';
import AreaGraph from '@/components/Graph/AreaGraph';
import ReportSection from './ReportSection';
import PieGraph from '@/components/Graph/PieGraph';
import {
  ageConfig,
  dayConfig,
  genderConfig,
  quaterConfig,
  timeLabel,
} from '@/components/Graph/constants';
import LineGraph from '@/components/Graph/LineGraph';
import BarGraph from '@/components/Graph/BarGraph';
import RadioButton from '@/components/RadioButton';

const radioButtons = [
  { key: 'QUATER', text: '분기별 매출' },
  { key: 'DAY', text: '요일별 매출' },
  { key: 'GENDER', text: '성별 매출' },
  { key: 'TIME', text: '시간대별 매출' },
  { key: 'AGE', text: '연령대별 매출' },
];

function ReportSales() {
  const [salesInfo, setSalesInfo] = useState({
    quarterlySalesAmountResponses: [],
    daySalesAmountResponses: [],
    timeSalesAmountResponses: [],
    genderSalesAmountResponses: [],
    ageSalesAmountResponses: [],
  });

  const [graph, setGraph] = useState('QUATER');

  const GraphMapper = {
    QUATER: (
      <LineGraph
        graphData={salesInfo.quarterlySalesAmountResponses}
        title="분기별 매출"
        config={quaterConfig}
      />
    ),
    DAY: (
      <BarGraph
        graphData={salesInfo.daySalesAmountResponses}
        title="요일별 매출"
        config={dayConfig}
      />
    ),
    TIME: (
      <AreaGraph
        title="시간대별 매출"
        graphData={salesInfo.timeSalesAmountResponses}
        labels={timeLabel}
      />
    ),
    GENDER: (
      <PieGraph
        title="성별 매출"
        graphData={salesInfo.genderSalesAmountResponses}
        config={genderConfig}
      />
    ),
    AGE: (
      <BarGraph
        title="연령대별 매출"
        graphData={salesInfo.ageSalesAmountResponses}
        config={ageConfig}
      />
    ),
  };

  const { careaCode, jcategoryCode } = useSearchState();

  const fetchSalesInfo = async () => {
    const { data } = await axios.get(`/report/sales/amount/${careaCode}/${jcategoryCode}`);
    setSalesInfo(data);
  };

  const onClickRadioButton = (key) => {
    setGraph(key);
  };

  useEffect(() => {
    fetchSalesInfo();
  }, []);

  return (
    <ReportSection title="매출 현황">
      <div className="flex justify-around gap-2">
        {radioButtons.map(({ key, text }) => (
          <RadioButton
            text={text}
            key={key}
            onClick={() => onClickRadioButton(key)}
            isClicked={key === graph}
          />
        ))}
      </div>
      <div className="flex items-center justify-center">
        <div className="w-3/4">{GraphMapper[graph]}</div>
      </div>
    </ReportSection>
  );
}

export default ReportSales;
