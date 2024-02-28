import React from 'react';
import { render, fireEvent } from '@testing-library/react';
import { Button } from '.';

describe('Button Component', () => {
  it('should render a button with the correct label', () => {
    const label = 'Click Me';
    const { getByText } = render(
      <Button label={label} onClick={jest.fn()} type={'primary'} />
    );
    const button = getByText(label);
    expect(button).toBeInTheDocument();
  });

  it('should apply the correct CSS classes based on the "type" prop', () => {
    const { container } = render(
      <Button label="Test" type="primary" onClick={jest.fn()} />
    );
    const button = container.querySelector('button');
    expect(button).toHaveClass('btn', 'btn-primary');
  });

  it('should call the onClick function when the button is clicked', () => {
    const onClick = jest.fn();
    const { getByText } = render(
      <Button label="Click Me" onClick={onClick} type="primary" />
    );
    const button = getByText('Click Me');
    fireEvent.click(button);

    expect(onClick).toHaveBeenCalledTimes(1);
  });
});
