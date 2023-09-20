'use clinet';
import classnames from 'classnames';
import { createContext, useState, useContext } from 'react';
import ArrowDown from '@/assets/icons/arrowDown.svg';

const DropdownContext = createContext(null);

function DropdownContainer({ children, className }) {
  const [isOpen, setIsOpen] = useState(false);

  const onChange = () => {
    setIsOpen((prev) => !prev);
  };

  return (
    <DropdownContext.Provider
      value={{
        isOpen,
        onChange,
      }}
    >
      <div className={classnames(className)}>{children}</div>
    </DropdownContext.Provider>
  );
}

function DropdownLabel({ children }) {
  return <div className="text-disabled">{children}</div>;
}

function DropdownTrigger({ children }) {
  const dropdownContext = useContext(DropdownContext);

  const { onChange, isOpen } = dropdownContext;

  const onClick = () => {
    onChange();
  };

  return (
    <button
      className={classnames(
        'flex justify-between w-full text-left border-b-2',
        isOpen ? 'border-primary' : 'border-underline',
      )}
      onClick={onClick}
    >
      <span className="text-2xl">{children}</span>
      <ArrowDown
        className={classnames(
          'duration-100 ease-linear',
          isOpen ? 'fill-primary rotate-180' : 'fill-black',
        )}
      />
    </button>
  );
}

function DropdownOptionContainer({ children }) {
  const dropdownContext = useContext(DropdownContext);

  const { isOpen } = dropdownContext;

  return (
    isOpen && (
      <div className="mt-2 overflow-hidden rounded-small text-disabled shadow-dropdown">
        {children}
      </div>
    )
  );
}

function DropdownOption({ children, onSelect, ...props }) {
  const dropdownContext = useContext(DropdownContext);

  const { onChange } = dropdownContext;

  const onClick = () => {
    onChange();
    onSelect?.(props);
  };

  return (
    <div className="py-2 pl-2 hover:bg-outline hover:text-black" onClick={onClick}>
      {children}
    </div>
  );
}

export const Dropdown = Object.assign(DropdownContainer, {
  Trigger: DropdownTrigger,
  OptionContainer: DropdownOptionContainer,
  Option: DropdownOption,
  Label: DropdownLabel,
});
