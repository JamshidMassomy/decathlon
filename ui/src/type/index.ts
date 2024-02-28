export interface IInput {
  type?: 'text' | 'number' | 'datetime-local' | 'range' | 'hidden';
  placeholder?: string;
  label?: string;
  value?: any;
  name?: string;
  onChange?: (event: any) => void;
}

export interface IButton {
  onClick: () => any;
  label: string;
  type: 'primary' | 'danger' | 'light';
}
