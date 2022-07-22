import React from "react";
import cl from "./Modal.module.css";
const Modal = () => {
  return (
    <div className={cl.modal}>
      <div className={cl.body}>
        <h3 className={cl.title}>Details</h3>
        <div className={cl.content}>
          <input type="text" />
          <input type="text" />
          <select name="" id="">
            <option>1</option>
            <option>2</option>
            <option>3</option>
          </select>
          <textarea></textarea>
          <button></button>
          <button></button>
          <button></button>
        </div>
        <span className={`icon icon-close ${cl.close}`}></span>
      </div>
    </div>
  );
};

export default Modal;
