.auth-form input[type="text"],
.auth-form input[type="password"] {
    width: calc(100% - 20px); /* Adjust for padding */
    padding: 10px;
    border: 1px solid  #ccc;
    border-radius: 5px;
    font-size: 1em;
    box-sizing: border-box; /* Include padding in width */
}

.auth-form button {
    width: 100%;
    padding: 12px;
    background-color:  #007bff;
    color:  white;
    border: none;
    border-radius: 5px;
    font-size: 1.1em;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.auth-form button:hover {
    background-color:  #0056b3;
}

.auth-form button:disabled { /* For future use with loading states */
    background-color:  #cccccc;
    cursor: not-allowed;
}

.error-message { /* For future use with error display */
    color:  #dc3545;
    margin-top: 15px;
    font-size: 0.9em;
}
