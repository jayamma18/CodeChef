                    function App() {

                    }
                    }
                  return <h2>Sign up for premium to unlock discounts!</h2>;
export function DiscountMessage({ isPremiumMember }) {
  // If the user is a premium member, show the discount message
    if (isPremiumMember) {
        return <h2>You get a 20% discount!</h2>;
          }
            // If the user is not a premium member, show a message encouraging them to sign up
              else {
// Export a function component named DiscountMessage that takes a prop 'isPremiumMember'