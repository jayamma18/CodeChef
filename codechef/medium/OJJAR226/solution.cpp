import { useState } from 'react';
import ListItem from './ListItem';

// TODO: Implement filtering logic
// Requirements:
// 1. Should filter items based on search input
// 2. Should be case-insensitive
// 3. Should show all items when search is empty
function FilterableList({ items }) {
  const [searchTerm, setSearchTerm] = useState('');

    // TODO: Implement filter logic
      const filteredItems = items.filter((item) => {
          const term = searchTerm.toLowerCase();
              return (
                    item.name.toLowerCase().includes(term) ||
                          item.description.toLowerCase().includes(term)
                              );
                                });

                                  return (
                                      <div className="filterable-list">
                                            <input
                                                    type="text"
                                                            placeholder="Search items..."
                                                                    value={searchTerm}
                                                                            onChange={(e) => setSearchTerm(e.target.value)}
                                                                                    className="search-input"
                                                                                          />

                                                                                                <div className="list">
                                                                                                        {filteredItems.length > 0 ? (
                                                                                                                  filteredItems.map((item) => (
                                                                                                                              <ListItem key={item.id} item={item} />
                                                                                                                                        ))
                                                                                                                                                ) : (
                                                                                                                                                          <p className="no-results">No items found</p>
                                                                                                                                                                  )}
                                                                                                                                                                        </div>
                                                                                                                                                                            </div>
                                                                                                                                                                              );
                                                                                                                                                                              }

                                                                                                                                                                              export default FilterableList;