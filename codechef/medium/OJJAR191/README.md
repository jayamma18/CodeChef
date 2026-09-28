# OJJAR191

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Projects Section

Alright, let's move on to the next challenge!

 **Problem Description:** 

Now it’s time to showcase your work! In this step, you'll be creating the  **"Projects"**  section of your portfolio. This section highlights the projects you’ve built or contributed to, along with brief descriptions and links for visitors to explore them further.

You’ve been given a template with an array—simply update that array by adding your own projects. For each project, include a name, a short description, and a link if available.

 **Note:** 

- The main container for this section should be a <section> element. It must have an id attribute set to projects. It must have a className attribute set to projects-section.
- Inside the <section>, there should be a <div> that acts as a container for all your project cards. This div must have the className="projects-grid".
- Each individual project will be displayed in its own <div>. This div must have the className="project-card".
- You'll be mapping over an array (projectData) to generate these project cards dynamically.
- For the "View Project" links (<a> tags), ensure you include target="_blank" and rel="noopener noreferrer" for good practice when opening new tabs.

 **Your app's "projects" section should aim to look something like this (structure and elements):**

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-28T07:24:59.332Z  

```cpp
                                      link: '#',
                                        },
                                        ];

                                        function Projects() {
                                          return (
                                              <section id="projects" className="projects-section">
                                                    {/* Heading for the Projects section */}
                                                          <h2>Projects</h2>

                                                                {/* Grid container for all project cards */}
                                                                      <div className="projects-grid">
                                                                              {projectData.map((project) => (
                                                                                        <div key={project.id} className="project-card">
                                                                                                    <h3>{project.title}</h3>
                                                                                                                <p>{project.description}</p>
                                                                                                                            <a 
                                                                                                                                          href={project.link} 
                                                                                                                                                        target="_blank" 
                                                                                                                                                                      rel="noopener noreferrer"
                                                                                                                                                                                  >
                                                                                                                                                                                                View Project
                                                                                                                                                                                                            </a>
                                                                                                                                                                                                                      </div>
                                                                                                                                                                                                                              ))}
                                                                                                                                                                                                                                    </div>
                                                                                                                                                                                                                                        </section>
                                                                                                                                                                                                                                          );
                                                                                                                                                                                                                                          }

                                                                                                                                                                                                                                          export default Projects;
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR191)