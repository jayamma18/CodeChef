# OJJAR187

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Building Blocks

Alright, let's get to the coding part now!

Remember those "building blocks" or  **Components**  we talked about in the last step? (Header, Hero, About, Projects, Contact, and Footer).

Each of these components will live in its own separate file. This helps us keep our code organized. If we need to change something about the Header, we know exactly which file to open!

 **Your Task: Create the Empty Files** 

For this step, your job is to create the actual files for these components. We're not going to put much code in them  *yet*  – just a tiny bit to make sure they exist and React knows about them.

 **Here's what you need to do:** 

- Create a components folder: Inside the src folder, create a new folder and name it components. (Make sure the 'c' is lowercase).
- Create the component files INSIDE the components folder: Now, inside your new components folder, create the following empty files: Header.jsx Hero.jsx About.jsx Projects.jsx Blog.jsx Contact.jsx Footer.jsx
- Add a tiny piece of "placeholder" code to EACH file: Open each of those new.jsx files one by one (e.g., open Header.jsx first). Inside each file, copy and paste the following exact code. The only thing you'll change is the ComponentName part. Template code to put in each file: function ComponentName() { return (<div> <p>This is the ComponentName component.</p> </div>); } export default ComponentName; for Header.jsx, Hero.jsx, About.jsx, Projects.jsx, Blog.jsx, Contact.jsx, and Footer.jsx. Make sure to change ComponentName in all three places for each file!
- Also, connect or render each component one by one according to our flow (import all components in the main.jsx file and render them as well). Make sure to render all components—except the Footer or Header—inside the <main></main> tag. Example - <div className="App"> <Header /> <main> <Hero /> <About />.... </main> <Footer /> </div>

Take your time, and make sure the folder names and file names are exact! This sets the foundation for our website.

 **Your app is should be look like this at the end**

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-28T07:16:27.371Z  

```cpp
        // Inline Blog Component
        function Blog() {
          return <section><h2>Blog Section</h2></section>;
          }

          // Inline Contact Component
          function Contact() {
            return <section><h2>Contact Section</h2></section>;
            }

            // Inline Footer Component
            function Footer() {
              return <footer><p>Footer</p></footer>;
              }

              // Main App Component
              function App() {
                return (
                    <div className="App">
                          <Header />
                                <Hero />
                                      <About />
                                            <Projects />
                                                  <Blog />
                                                        <Contact />
                                                              <Footer />
                                                                  </div>
                                                                    );
                                                                    }

                                                                    export default App;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR187)