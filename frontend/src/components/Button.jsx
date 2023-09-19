'use client';

import React from 'react';

function Button({ label, width, height, color, radius }) {
  let colorStyle;
  let borderStyle;

  switch (color) {
    case 'primary':
      colorStyle = 'bg-primary';
      break;
    case 'disabled':
      colorStyle = 'bg-disabled';
      break;
  }

  switch (radius) {
    case 'large':
      borderStyle = 'rounded-large';
      break;
    case 'medium':
      borderStyle = 'rounded-medium';
      break;
    case 'small':
      borderStyle = 'rounded-small';
      break;
  }

  const handleButtonClick = () => {};

  return (
    <div>
      <button
        className={colorStyle + ' ' + borderStyle}
        style={{ width: `${width}px`, height: `${height}px` }}
        onClick={handleButtonClick}
      >
        {label}
      </button>
    </div>
  );
}

export default Button;
