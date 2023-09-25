import React from 'react';
import classnames from 'classnames';

function ReasonMain({ children }) {
  return (
    <div className='flex flex-col items-center my-7'>{children}</div>
  );
}

function ReasonTitle({ children }) {
  return (
    <h1 className='text-lg font-semibold'>{children}</h1>
  );
}

function ReasonContainer({ children, className }) {
  return (
    <div className={classnames("flex flex-col items-center justify-evenly rounded-xl w-[200px] h-[100px] m-3 font-bold", className)}>
      {children}
    </div>
  )
}

export const Reason = Object.assign(ReasonMain, {
  Title: ReasonTitle,
  Container: ReasonContainer,
});