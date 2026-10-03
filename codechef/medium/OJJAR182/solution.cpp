import { useContext } from "react";
import { UserProvider, UserContext } from "./context/UserContext";
import useFetchUser from "./hooks/useFetchUser";
import Modal from "./components/Modal";
import "./App.css";

const InnerApp = () => {
const { user, isModalOpen, setIsModalOpen } = useContext(UserContext);

useFetchUser();

return (
<div className="App">
<h1>★ React Welcome Modal</h1>

{user ? <p>You're logged in as <strong>{user.name}</strong>.</p> : <p>Loading user...</p>}

{isModalOpen && user && <Modal />}

{!isModalOpen && user && (
<button className="modal-button" onClick={() => setIsModalOpen(true)}>
Show Welcome Again
</button>
)}
</div>
);
};

const App = () => (
<UserProvider>
<InnerApp />
</UserProvider>
);

export default App;