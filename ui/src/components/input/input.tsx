import React, { memo } from 'react';

export interface IInput {
  type?: 'text' | 'number' | 'datetime-local' | 'range' | 'hidden';
  placeholder?: string;
  label?: string;
  value?: any;
  name?: string;
  onChange?: (event: any) => void;
}

const Input: React.FC<IInput> = (props: IInput) => {
  const { type, placeholder, label, value, onChange, name } = props;
  return (
    <div className="form-group w-100 mb-2">
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
