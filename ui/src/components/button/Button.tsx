import classNames from 'classnames';
import { memo } from 'react';

export interface IButton {
  onClick: () => any;
  label: string;
  type: 'primary' | 'danger' | 'light';
}

const Button: React.FC<IButton> = memo((props: IButton) => {
  const { label, onClick, type } = props;

  const renderClassNames = (type: string) => {
    switch (type) {
      case 'primary':
        return 'btn btn-primary';
      case 'light':
        return 'btn btn-light';
      case 'danger':
        return 'btn btn-danger';
      default:
        return 'btn btn-primary';
    }
  };

  return (
    <button
      type="button"
      className={classNames(renderClassNames(type))}
      onClick={onClick}
    >
      {label}
    </button>
  );
});
export default Button;
