import React from 'react';
import Card from './Card';
import Button from './Button';
import './App.css';

function HomePage() {
  const handleLearnMore = () => alert('Learn more clicked!');
    const handleSubscribe = () => alert('Subscribe clicked!');

      return (
          <div className="homepage">
                <h1 className="homepage-title">Welcome to Our Platform</h1>

                      {/* Reusable Card with Buttons */}
                            <Card
                                    title="Stay Updated"
                                            content="Get the latest updates and features."
                                                    actionButtons={
                                                              <>
                                                                          <Button text="Learn More" onClick={handleLearnMore} />
                                                                                      <Button text="Subscribe" onClick={handleSubscribe} />
                                                                                                </>
                                                                                                        }
                                                                                                              />
                                                                                                                  </div>
                                                                                                                    );
                                                                                                                    }

                                                                                                                    export default HomePage;