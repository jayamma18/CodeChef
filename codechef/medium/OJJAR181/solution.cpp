import { useState, useRef } from 'react';
import Modal from './Modal';
import './App.css';

function App() {
  const [isModalOpen, setIsModalOpen] = useState(false);
    const openModalButtonRef = useRef(null);

      const handleOpenModal = () => {
          setIsModalOpen(true);
            };

              const handleCloseModal = () => {
                  setIsModalOpen(false);
                    };

                      return (
                          <div className="App">
                                <header className="App-header">
                                        <h1>Accessible Modal Example</h1>
                                                <p>Click the button below to open the modal.</p>
                                                        <button
                                                                  ref={openModalButtonRef}
                                                                            onClick={handleOpenModal}
                                                                                      className="open-button"
                                                                                              >
                                                                                                        Open Confirmation Modal
                                                                                                                </button>
                                                                                                                      </header>

                                                                                                                            {/* Main content */}
                                                                                                                                  <div style={{ height: '150vh', paddingTop: '20px', borderTop: '1px solid #ccc', marginTop: '20px' }}>
                                                                                                                                          <p>Scrollable background content... try scrolling when the modal is open!</p>
                                                                                                                                                </div>

                                                                                                                                                      {/* Conditionally render the Modal */}
                                                                                                                                                            <Modal
                                                                                                                                                                    isOpen={isModalOpen}
                                                                                                                                                                            onClose={handleCloseModal}
                                                                                                                                                                                    title="Confirm Action"
                                                                                                                                                                                          >
                                                                                                                                                                                                  <p>Are you sure you want to proceed with this action? This cannot be undone.</p>
                                                                                                                                                                                                          <div className="modal-actions">
                                                                                                                                                                                                                    <button onClick={handleCloseModal} className="button-secondary">
                                                                                                                                                                                                                                Cancel
                                                                                                                                                                                                                                          </button>
                                                                                                                                                                                                                                                    <button 
                                                                                                                                                                                                                                                                onClick={() => { alert('Action Confirmed!'); handleCloseModal(); }} 
                                                                                                                                                                                                                                                                            className="button-primary"
                                                                                                                                                                                                                                                                                      >
                                                                                                                                                                                                                                                                                                  Confirm
                                                                                                                                                                                                                                                                                                            </button>
                                                                                                                                                                                                                                                                                                                    </div>
                                                                                                                                                                                                                                                                                                                          </Modal>
                                                                                                                                                                                                                                                                                                                              </div>
                                                                                                                                                                                                                                                                                                                                );
                                                                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                                                                export default App;