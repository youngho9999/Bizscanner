import classnames from 'classnames';
import React from 'react';

function ReportSection({ children, title, className }) {
  return (
    <div className={classnames('p-8 bg-white rounded-small ', className)}>
      {title && <div className="mb-8 text-2xl font-bold">{title}</div>}
      {children}
    </div>
  );
}

export default ReportSection;
