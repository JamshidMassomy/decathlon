import React, { memo, useEffect, useRef, useState } from 'react';

export interface ISelect {
  dataset: any[];
  name?: string;
  value: string | any;
  onChange?: (value: any) => void;
}

const Select: React.FC<ISelect> = memo((props: ISelect) => {
  const { dataset, name, onChange } = props;
  const [sports, setSports] = useState<string[]>([]);

  useEffect(() => {
    setSports(dataset);
  }, [dataset]);

  const selectionOptions = () => {
    return sports?.map((option, index) => (
      <option key={index} value={option}>
        {option}
      </option>
    ));
  };

  return (
    <div className="form-group w-100 mb-2">
      <label>Sport*</label>
      <select
        onChange={onChange}
        name={name || ''}
        className="form-control bg-white px-3
        py-2 transition-all cursor-pointer
        hover:border-blue-600/30
        border border-gray-200 rounded-lg outline-blue-600/50 appearance-none  w-64"
      >
        <option>----------------</option>
        {selectionOptions()}
      </select>
    </div>
  );
});
export default Select;
