import React from "react";
import Button from "../UI/Button";
import SidebarItem from "./SidebarItem";
import cl from "./Sidebar.module.scss";

const SidebarList = () => {
  const array = ["Заголовок1", "Заголовок2", "Заголовок3"];
  return (
    <>
      <Button className={cl.sidebar_button}>New Project</Button>
      <ul>
        {array.map((item, i) => {
          return <SidebarItem>{item}</SidebarItem>;
        })}
      </ul>
    </>
  );
};

export default SidebarList;
