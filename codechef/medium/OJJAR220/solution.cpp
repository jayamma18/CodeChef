import { useState } from 'react';
import Modal from './Modal';

function App() {
const [isModalOpen, setIsModalOpen] = useState(false);

const handleOpenModal = () => {
setIsModalOpen(true);
};

const handleCloseModal = () => {
setIsModalOpen(false);
};

return (
<div>
<h1>React Portal Demo App</h1>
<p>
This button is part of the main application rendered inside #root.
Clicking it will open a modal.
</p>
<button onClick={handleOpenModal}>Open Modal</button>

<p style={{ marginTop: '20px' }}>
Notice the light-gray background? That's the #root div.
If you inspect the elements, the modal will appear OUTSIDE this div,
directly inside the body (in #modal-root).
</p>

{isModalOpen && (
<Modal title="My Teleported Modal" onClose={handleCloseModal}>
<p>Hello from inside the portal!</p>
<p>
Even though this Modal component is written here inside App.js,
its actual HTML is rendered into the <code>#modal-root</code> div
in <code>index.html</code>, thanks to <code>createPortal</code>.
</p>
<button onClick={handleCloseModal}>Close From Inside</button>
</Modal>
)}

<div style={{ marginTop: '300px', border: '2px dashed red', padding: '10px' }}>
This content is lower down in the #root div. The modal appears *above* everything,
not stuck inside the flow here.
</div>
</div>
);
}

export default App;