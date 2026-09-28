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