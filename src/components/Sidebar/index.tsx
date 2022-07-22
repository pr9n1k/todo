import React from "react";
import SidebarList from "./SidbarList";
import cl from "./Sidebar.module.scss";

const Sidebar = () => {
  return (
    <div className={cl.sidebar}>
      <h2 className={cl.sidebar_title}>Project</h2>
      <SidebarList />
    </div>
  );
};

export default Sidebar;
