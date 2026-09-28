# OJJAR213

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Task - Refactor a Card Component using Composition

Imagine you have a `UserProfilePage` that displays user information within a styled `Card`. Currently, the page passes specific data props (`userName`, `userBio`, `profileActionText`) down through intermediate layout components (`MainContentArea`, `CardWrapper`) to the `Card` component itself. The intermediate components don't use this data; they just pass it along (prop drilling).

Your task is to refactor this structure using the  **"Lifting Content Up"**  pattern with the `children` prop (and potentially other specific slot props). The goal is to make `MainContentArea` and `CardWrapper` generic layout components that don't need to know about user-specific data, improving their reusability and cleaning up the prop flow. `UserProfilePage` will become responsible for composing the  *specific content*  that goes inside the `Card`.

 **Step-by-Step Instructions:** 

- Analyze: Identify the components involved in prop drilling: MainContentArea and CardWrapper are passing userName, userBio, and profileActionText without using them. Card consumes these props.
- Refactor Card: Modify the Card component. Instead of accepting userName, userBio, and profileActionText as props, make it more generic. Change it to accept a headerContent prop for what goes in the header section. Change it to accept the standard children prop for the main body content. Change it to accept a footerContent prop for what goes in the footer section. Inside Card, render headerContent, children, and footerContent in their respective divs (card-header, card-body, card-footer).
- Refactor MainContentArea and CardWrapper: Modify these components. Remove the userName, userBio, and profileActionText props they accept and pass down. Change them both to accept and render the standard children prop. MainContentArea should render its children inside its main div, and CardWrapper should render its children inside its main div.
- Refactor UserProfilePage: This component will now be responsible for composing the Card with the specific content. Keep the userData object. Instead of passing individual props down to MainContentArea, you will now construct the UI hierarchy using composition. Inside the UserProfilePage's return statement, render <MainContentArea>. Inside <MainContentArea>, render <CardWrapper>. Inside <CardWrapper>, render the refactored <Card>. Configure the <Card> by passing: The user's name (e.g., {userData.name}) to the headerContent prop. The user's bio (e.g., <p>{userData.bio}</p> or just {userData.bio}) as children between the opening and closing <Card> tags. A button element (e.g., <button>...</button>) constructed using userData.actionText and userData.name to the footerContent prop.
- Verify: Run the application. The output should look identical to the original version, but the code structure should now use composition, and MainContentArea and CardWrapper should be free of user-specific props.

 **Note:**  We're not testing this project—just ensure your refactored code structure matches the solution provided for correctness.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-28T08:41:47.913Z  

```cpp
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
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR213)