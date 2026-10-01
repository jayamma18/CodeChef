import { useEffect, useRef } from "react";
import "./App.css";
import InputWithLabel from "./InputWithLabel";

export default function App() {
  const usernameRef = useRef(null);

    useEffect(() => {
        // console.log(usernameRef);
            if (usernameRef.current) {
                  usernameRef.current.focus();
                      }
                        }, []);

                          return (
                              <div className="container">
                                    <h1>Login</h1>
                                          <InputWithLabel ref={usernameRef} label="Username" />
                                              </div>
                                                );
                                                }