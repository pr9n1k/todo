import React from "react";
import cl from "./Header.module.scss";
import list from "./list.png";

const Header = () => {
  return (
    <header className={cl.header}>
      <span className={`icon icon-menu ${cl.header_icon_menu}`}></span>
      <div className={cl.header__img}>
        <img src={list} alt="" />
      </div>
      <div className={cl.header__title}>Your Todo</div>
    </header>
  );
};

export default Header;
