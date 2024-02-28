import React from 'react';
import { render, fireEvent } from '@testing-library/react';
import { Input } from '.';

describe('Input Component', () => {
  it('should render with the correct placeholder', () => {
    const placeholder = 'Enter your name';
    const { getByPlaceholderText } = render(
      <Input placeholder={placeholder} />
    );
    const inputElement = getByPlaceholderText(placeholder);
    expect(inputElement).toBeInTheDocument();
  });

  it('should set the "value" and "type" attributes correctly', () => {
    const name = 'name';
    const value = 'John Doe';
    const type = 'text';
    const { getByDisplayValue } = render(
      <Input name={name} value={value} type={type} />
    );
    const inputElement = getByDisplayValue(value);
    expect(inputElement).toBeInTheDocument();
    expect(inputElement).toHaveAttribute('name', name);
    expect(inputElement).toHaveAttribute('type', type);
  });

  it('should call the "onChange" function when the input value changes', () => {
    const onChange = jest.fn();
    const { getByPlaceholderText } = render(
      <Input placeholder="Test" onChange={onChange} />
    );
    const inputElement = getByPlaceholderText('Test');
    fireEvent.change(inputElement, { target: { value: 'New Value' } });
    expect(onChange).toHaveBeenCalledTimes(1);
  });
});
