# OJJAR141

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Nested Routing- Practice Problem

You are building a small  **Dashboard App**. The app has:

- A Home page at /
- A Dashboard at /dashboard with two nested child routes: /dashboard/profile → Profile /dashboard/settings → Settings

Some parts are missing. Fill in the blanks (`___`) to complete the setup.

 **Expected Behavior** 

- / → Shows Home page
- /dashboard → Shows Dashboard layout, but no child yet
- /dashboard/profile → Shows Dashboard layout + Profile content
- /dashboard/settings → Shows Dashboard layout + Settings content

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-30T10:27:28.023Z  

```cpp
import { Link, Outlet } from "react-router-dom";
```

---

[View on CodeChef](https://www.codechef.com/problems/OJJAR141)