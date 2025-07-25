import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import ProductSearch from "./questions/ProductSearch";
import UserSearch from "./UserSearch";
import CryptoTable from "./questions/CryptoTable";
import TodoApp from "./questions/ToDoApp";
import MultiStepForm from "./questions/MultiStepForm";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<ProductSearch />} />
        <Route path="/UserSearch" element={<UserSearch />} />
        <Route path="/crypto" element={<CryptoTable />} />
        <Route path="/todo" element={<TodoApp />} />
        <Route path="/MuliteStep" element={<MultiStepForm />} />
      </Routes>
    </Router>
  );
}

export default App;
