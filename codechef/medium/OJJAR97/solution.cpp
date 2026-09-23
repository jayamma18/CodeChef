import React from "react";

function TextInput({ id, label, type = "text" }) {
  let appliedId;
  
  if (!id) {
    appliedId = React.useId(); // ❌ Hook inside condition (incorrect usage)
  } else {
    appliedId = id;
  }

  return (
    <div className="text-input">
      <label htmlFor={appliedId}>{label}</label>
      <input id={appliedId} type={type} className="input-field" />
    </div>
  );
}

export default function App() {
  return <TextInput id="input-id" label="Enter Text:" />;
}
