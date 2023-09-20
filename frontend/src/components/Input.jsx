import React from 'react';

function Input({ width, height }) {
  return (
    <div className="w-full h-full bg-white rounded-medium" style={{ width, height }}>
      <div className="relative flex justify-between	px-6">
        <div className="w-full h-full flex flex-col pt-[33px] pb-[11px]">
          <label className="absolute top-1 left-6 text-disabled text-small font-semibold">
            닉네임
          </label>
          <input
            className="w-full bg-transparent text-black text-xl font-bold placeholder-lightgray focus:outline-0"
            type="text"
            placeholder="입력하세요"
          />
        </div>
      </div>
    </div>
  );
}

export default Input;
