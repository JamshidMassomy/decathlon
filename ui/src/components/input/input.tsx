import React, { memo } from 'react';
import { IInput } from '../../type';

const Input: React.FC<IInput> = (props: IInput) => {
  const { type, placeholder, label, value, onChange, name } = props;
  return (
    <div className="form-group w-100 mb-2 d-flex justify-content-center">
      <label className="w-50">{label}</label>
      <input
        name={name}
        onChange={onChange}
        value={value || ''}
        type={type || 'text'}
        className="form-control cw-50"
        placeholder={placeholder}
      />
    </div>
  );
};
export default memo(Input);
