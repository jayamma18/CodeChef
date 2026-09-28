import { useState } from 'react';
import AccordionItem from './AccordionItem';

// USER IMPLEMENTATION AREA
function Accordion({ items }) {
  const [activeIndex, setActiveIndex] = useState(null);

    const handleClick = (index) => {
        setActiveIndex(activeIndex === index ? null : index);
          };

            return (
                <div className="accordion">
                      {items.map((item, index) => (
                              <AccordionItem
                                        key={index}
                                                  title={item.title}
                                                            content={item.content}
                                                                      isActive={index === activeIndex}
                                                                                onClick={() => handleClick(index)}
                                                                                        />
                                                                                              ))}
                                                                                                  </div>
                                                                                                    );
                                                                                                    }

                                                                                                    export default Accordion;