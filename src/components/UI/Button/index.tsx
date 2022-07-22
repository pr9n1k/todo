import React from "react";
import cl from "./Button.module.scss";
type ButtonProps = {
  className?: string;
  disabled?: boolean;
};
const Button: React.FC<React.PropsWithChildren<ButtonProps>> = ({
  className,
  disabled,
  children,
}) => {
  return (
    <button className={`${className} ${cl.button}`} disabled={disabled}>
      {children}
    </button>
  );
};

export default Button;
