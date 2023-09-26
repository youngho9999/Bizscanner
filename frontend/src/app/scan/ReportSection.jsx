import React from 'react';

function ReportSection({ children, title }) {
  return (
    <div className="p-8 bg-white rounded-small">
      {title && <div className="text-2xl font-bold ">{title}</div>}
      {children}
    </div>
  );
}

export default ReportSection;
