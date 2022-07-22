import React from "react";
import cl from "./Content.module.css";
export enum type {
  HARD,
  MEDIUM,
  LOW,
}
type ContentItemProps = {
  className?: string;
  item: {
    title: string;
    text: string;
    type: type;
  };
};
const ContentItem: React.FC<ContentItemProps> = ({ className, item }) => {
  const cssType =
    item.type === type.HARD
      ? cl.item_hard
      : item.type === type.MEDIUM
      ? cl.item_medium
      : cl.item_low;
  return (
    <li className={`${className} ${cl.item}`}>
      <h3 className={cl.item_title}>{item.title}</h3>
      <div className={cl.item_text}>{item.text}</div>
    </li>
  );
};

export default ContentItem;
