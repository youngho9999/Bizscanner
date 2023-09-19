'use client';

import React from 'react';

function Button({ text, width, height, variant, radius }) {
  const buttonConfig = {
    // Colors
    primary: {
      bgColor: 'bg-primary',
      color: 'text-white',
    },
    disabled: {
      bgColor: 'bg-disabled',
      color: 'text-white',
    },
    //Border-radius
    small: 'rounded-small',
    medium: 'rounded-medium',
    large: 'rounded-large',
  };

  const handleButtonClick = () => {};

  return (
    <div>
      <button
        className={`
        ${buttonConfig[variant].bgColor} 
        ${buttonConfig[variant].color} 
        ${buttonConfig[radius]}`}
        style={{ width: `${width}`, height: `${height}` }}
        onClick={handleButtonClick}
      >
        {text}
      </button>
    </div>
  );
}

export default Button;
