import React from "react";
import Content from "../Content";
import Sidebar from "../Sidebar";
import Modal from "../UI/Modal";
import cl from "./Main.module.scss";
const Main = () => {
  return (
    <div className={cl.main}>
      <Sidebar />
      <Content />
      <Modal />
    </div>
  );
};

export default Main;
