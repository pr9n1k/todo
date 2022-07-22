import React from "react";
import cl from "./Sidebar.module.scss";
type SidebarItemProps = {};
const SidebarItem: React.FC<React.PropsWithChildren<SidebarItemProps>> = ({
  children,
}) => {
  return (
    <li className={cl.sidebar_item}>
      {children}
      <span className={`icon icon-more ${cl.sidebar_icon}`}></span>
    </li>
  );
};

export default SidebarItem;
