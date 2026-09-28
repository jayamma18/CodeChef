# OJJAR226

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Implement Filtering in React!

You are given a partially implemented `FilterableList` component. The component renders a list of items and an input field for searching. Your task is to complete the  **filtering logic**  so that users can filter the list based on their input.

 **Requirements** 

Implement the following behavior:

- Filter items based on the user's search input.
- Filtering must be case-insensitive.
- Users should be able to filter by item name or item description.
- If the search input is empty, show all items.
- If no items match the search, show: "No items found".

 **Example** 

If the items array is:

```
[
  { id: 1, name: 'Apple', description: 'Fresh red apple' },
  { id: 2, name: 'Orange', description: 'Juicy citrus fruit' },
  { id: 3, name: 'Banana', description: 'Ripe yellow banana' }
]

```

- Typing "red" or "apple" or "App" in the input should match "Apple".
- Typing "yellow" should return "Banana".
- Typing "xyz" should show "No items found".

 **What You Need to Do** 

- Replace the placeholder filteredItems = items with a filter expression.
- Use.toLowerCase() to perform a case-insensitive match.
- The filter must check both item.name and item.description.
- If searchTerm is empty, return the full list.
- Render "No items found" when nothing matches.

 **Helpful Resources** 

- React Docs – Handling Forms
- MDN – Array.prototype.filter()
- MDN – String.prototype.toLowerCase()

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-28T09:58:22.462Z  

```cpp
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
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR226)