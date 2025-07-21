import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import ProductSearch from "./ProductSearch";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<ProductSearch />} />
      </Routes>
    </Router>
  );
}

export default App;
