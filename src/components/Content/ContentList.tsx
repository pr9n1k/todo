import React from "react";
import cl from "./Content.module.css";
import ContentItem, { type } from "./ContentItem";
const ContentList = () => {
  const array = [
    {
      title: "title1",
      text: "Text1",
      type: type.HARD,
    },
    {
      title: "title2",
      text: "Text2",
      type: type.MEDIUM,
    },
    {
      title: "title3",
      text: "Text3",
      type: type.LOW,
    },
  ];
  return (
    <ul className={cl.list}>
      {array.map((item, i) => {
        return <ContentItem key={i} item={item} />;
      })}
    </ul>
  );
};

export default ContentList;
