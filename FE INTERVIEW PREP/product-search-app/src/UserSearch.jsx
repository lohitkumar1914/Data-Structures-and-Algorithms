import React, { useState, useEffect } from "react";
import { useSearchParams } from "react-router-dom";

const UserSearch = () => {
  const [searchParams, setSearchParams] = useSearchParams();

  // Get query & page from URL
  const queryParam = searchParams.get("q") || "";
  const pageParam = parseInt(searchParams.get("page")) || 1;

  // Local state
  const [query, setQuery] = useState(queryParam);
  const [debouncedQuery, setDebouncedQuery] = useState(queryParam);
  const [currentPage, setCurrentPage] = useState(pageParam);
  const [results, setResults] = useState([]);
  const [loading, setLoading] = useState(false);
  const limit = 10;

  // Sync query/page to URL
  useEffect(() => {
    const params = {};
    if (query.trim()) params.q = query;
    if (currentPage > 1) params.page = currentPage;
    setSearchParams(params);
  }, [query, currentPage]);

  // Debounce query input (300ms)
  useEffect(() => {
    const timer = setTimeout(() => {
      setDebouncedQuery(query);
    }, 300);
    return () => clearTimeout(timer);
  }, [query]);

  // Fetch users when debounced query or page changes
  useEffect(() => {
    if (debouncedQuery.trim() === "") {
      setResults([]);
      return;
    }

    const fetchUsers = async () => {
      setLoading(true);
      try {
        const skip = (currentPage - 1) * limit;
        const response = await fetch(
          `https://dummyjson.com/users/search?q=${debouncedQuery}&limit=${limit}&skip=${skip}`
        );
        const data = await response.json();
        setResults(data.users);
      } catch (error) {
        console.error("Error fetching users:", error);
        setResults([]);
      } finally {
        setLoading(false);
      }
    };

    fetchUsers();
  }, [debouncedQuery, currentPage]);

  return (
    <div
      style={{ maxWidth: "600px", margin: "0 auto", fontFamily: "sans-serif" }}
    >
      <h2>User Directory Search</h2>
      <input
        type="text"
        placeholder="Search users by name..."
        value={query}
        onChange={(e) => {
          setQuery(e.target.value);
          setCurrentPage(1); // Reset to page 1 on new search
        }}
        style={{
          width: "100%",
          padding: "10px",
          fontSize: "16px",
          marginBottom: "20px",
        }}
      />

      {loading && <p>Loading...</p>}
      {!loading && results.length === 0 && debouncedQuery && (
        <p>No users found.</p>
      )}

      {!loading && results.length > 0 && (
        <>
          <ul style={{ listStyle: "none", padding: 0 }}>
            {results.map((user) => (
              <li
                key={user.id}
                style={{
                  padding: "10px",
                  border: "1px solid #ddd",
                  marginBottom: "10px",
                  borderRadius: "5px",
                }}
              >
                <strong>
                  {user.firstName} {user.lastName}
                </strong>
                <br />
                <small>{user.email}</small>
              </li>
            ))}
          </ul>

          {/* Pagination Controls */}
          <div style={{ display: "flex", justifyContent: "space-between" }}>
            <button
              onClick={() => setCurrentPage((prev) => Math.max(prev - 1, 1))}
              disabled={currentPage === 1}
            >
              Previous
            </button>
            <span>Page {currentPage}</span>
            <button
              onClick={() => setCurrentPage((prev) => prev + 1)}
              disabled={results.length < limit}
            >
              Next
            </button>
          </div>
        </>
      )}
    </div>
  );
};

export default UserSearch;

//without any change in url
// import React, { useState, useEffect } from "react";

// const UserSearch = () => {
//   const [query, setQuery] = useState("");              // Text input
//   const [results, setResults] = useState([]);          // User results
//   const [loading, setLoading] = useState(false);       // Loading indicator
//   const [debouncedQuery, setDebouncedQuery] = useState(""); // For debounced search
//   const [currentPage, setCurrentPage] = useState(1);   // Page number
//   const limit = 10; // Number of users per page

//   // 1. Handle debounce logic (300ms)
//   useEffect(() => {
//     const timer = setTimeout(() => {
//       setDebouncedQuery(query);
//       setCurrentPage(1); // Reset to page 1 on new search
//     }, 300);
//     return () => clearTimeout(timer);
//   }, [query]);

//   // 2. Fetch from API whenever debouncedQuery or currentPage changes
//   useEffect(() => {
//     if (debouncedQuery.trim() === "") {
//       setResults([]);
//       return;
//     }

//     const fetchUsers = async () => {
//       setLoading(true);
//       try {
//         const skip = (currentPage - 1) * limit;
//         const response = await fetch(
//           https://dummyjson.com/users/search?q=${debouncedQuery}&limit=${limit}&skip=${skip}
//         );
//         const data = await response.json();
//         setResults(data.users);
//       } catch (error) {
//         console.error("Error fetching users:", error);
//         setResults([]);
//       } finally {
//         setLoading(false);
//       }
//     };

//     fetchUsers();
//   }, [debouncedQuery, currentPage]);

//   // 3. Render UI
//   return (
//     <div style={{ maxWidth: "600px", margin: "0 auto", fontFamily: "sans-serif" }}>
//       <h2>User Directory Search</h2>
//       <input
//         type="text"
//         placeholder="Search users by name..."
//         value={query}
//         onChange={(e) => setQuery(e.target.value)}
//         style={{ width: "100%", padding: "10px", fontSize: "16px", marginBottom: "20px" }}
//       />

//       {loading && <p>Loading...</p>}
//       {!loading && results.length === 0 && debouncedQuery && <p>No users found.</p>}

//       {!loading && results.length > 0 && (
//         <>
//           <ul style={{ listStyle: "none", padding: 0 }}>
//             {results.map((user) => (
//               <li
//                 key={user.id}
//                 style={{
//                   padding: "10px",
//                   border: "1px solid #ddd",
//                   marginBottom: "10px",
//                   borderRadius: "5px",
//                 }}
//               >
//                 <strong>{user.firstName} {user.lastName}</strong><br />
//                 <small>{user.email}</small>
//               </li>
//             ))}
//           </ul>

//           {/* Pagination Controls */}
//           <div style={{ display: "flex", justifyContent: "space-between" }}>
//             <button
//               onClick={() => setCurrentPage((prev) => Math.max(prev - 1, 1))}
//               disabled={currentPage === 1}
//             >
//               Previous
//             </button>
//             <span>Page {currentPage}</span>
//             <button
//               onClick={() => setCurrentPage((prev) => prev + 1)}
//               disabled={results.length < limit} // disable if less than limit = no more results
//             >
//               Next
//             </button>
//           </div>
//         </>
//       )}
//     </div>
//   );
// };

// export default UserSearch;
