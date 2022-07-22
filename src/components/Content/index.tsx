import React from "react";
import Button from "../UI/Button";
import cl from "./Content.module.css";
import ContentList from "./ContentList";
const Content = () => {
  return (
    <div className={cl.content}>
      <h1 className={cl.title}>title</h1>
      <Button className={cl.button}>New Item</Button>
      <ContentList />
    </div>
  );
};

export default Content;
