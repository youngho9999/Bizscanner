import React from 'react';

function TabButton({ Icon, title }) {
  return (
    <button className="flex items-center justify-start w-full gap-1 p-3 text-xl font-bold text-white hover:bg-hover rounded-small">
      <Icon /> {title}
    </button>
  );
}

export default TabButton;
