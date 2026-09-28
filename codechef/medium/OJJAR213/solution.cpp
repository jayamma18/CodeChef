import "./App.css";

// 1. Top-level Page Component (Holds data & composes layout)
function UserProfilePage() {
  const userData = {
      name: "Alice Wonderland",
          bio: "Curious explorer of digital rabbit holes.",
              actionText: "View Profile",
                };

                  return (
                      <MainContentArea>
                            <CardWrapper>
                                    <Card
                                              headerContent={userData.name}
                                                        footerContent={
                                                                    <button onClick={() => alert(`Action for ${userData.name}`)}>
                                                                                  {userData.actionText}
                                                                                              </button>
                                                                                                        }
                                                                                                                >
                                                                                                                          <p>{userData.bio}</p>
                                                                                                                                  </Card>
                                                                                                                                        </CardWrapper>
                                                                                                                                            </MainContentArea>
                                                                                                                                              );
                                                                                                                                              }

                                                                                                                                              // 2. Intermediate Layout Component
                                                                                                                                              function MainContentArea({ children }) {
                                                                                                                                                return (
                                                                                                                                                    <div className="main-content">
                                                                                                                                                          <h2>User Section</h2>
                                                                                                                                                                {children}
                                                                                                                                                                    </div>
                                                                                                                                                                      );
                                                                                                                                                                      }

                                                                                                                                                                      // 3. Another Intermediate Layout Component
                                                                                                                                                                      function CardWrapper({ children }) {
                                                                                                                                                                        return (
                                                                                                                                                                            <div className="card-wrapper">
                                                                                                                                                                                  {children}
                                                                                                                                                                                      </div>
                                                                                                                                                                                        );
                                                                                                                                                                                        }

                                                                                                                                                                                        // 4. Generic Card Component
                                                                                                                                                                                        function Card({ headerContent, children, footerContent }) {
                                                                                                                                                                                          return (
                                                                                                                                                                                              <div className="card">