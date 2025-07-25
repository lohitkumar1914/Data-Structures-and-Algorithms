import React, { useState, useEffect } from "react";

const TodoApp = () => {
  const [tasks, setTasks] = useState([]);
  const [input, setInput] = useState("");
  const [filter, setFilter] = useState("all"); // all | completed | incomplete

  // Load from localStorage
  useEffect(() => {
    const stored = localStorage.getItem("todo-tasks");
    if (stored) {
      setTasks(JSON.parse(stored));
    }
  }, []);

  // Save to localStorage on tasks change
  useEffect(() => {
    localStorage.setItem("todo-tasks", JSON.stringify(tasks));
  }, [tasks]);

  const addTask = () => {
    if (input.trim() === "") return;
    const newTask = {
      id: Date.now(),
      text: input.trim(),
      completed: false,
    };
    console.log("Adding task:", newTask);
    setTasks([newTask, ...tasks]);
    setInput("");
  };

  const toggleTask = (id) => {
    setTasks(
      tasks.map((task) =>
        task.id === id ? { ...task, completed: !task.completed } : task
      )
    );
  };

  const deleteTask = (id) => {
    setTasks(tasks.filter((task) => task.id !== id));
  };

  const filteredTasks = tasks.filter((task) => {
    if (filter === "completed") return task.completed;
    if (filter === "incomplete") return !task.completed;
    return true;
  });

  return (
    <div
      style={{ maxWidth: "500px", margin: "0 auto", fontFamily: "sans-serif" }}
    >
      <h2>📝 To-Do List</h2>

      {/* Input and Add Button */}
      <div style={{ display: "flex", marginBottom: "10px" }}>
        <input
          type="text"
          value={input}
          onChange={(e) => setInput(e.target.value)}
          placeholder="Add new task..."
          style={{ flex: 1, padding: "10px" }}
        />
        <button onClick={addTask} style={{ padding: "10px 15px" }}>
          Add
        </button>
      </div>

      {/* Filter Buttons */}
      <div style={{ marginBottom: "15px" }}>
        <button
          onClick={() => setFilter("all")}
          style={{
            marginRight: "5px",
            fontWeight: filter === "all" ? "bold" : "normal",
          }}
        >
          All
        </button>
        <button
          onClick={() => setFilter("completed")}
          style={{
            marginRight: "5px",
            fontWeight: filter === "completed" ? "bold" : "normal",
          }}
        >
          Completed
        </button>
        <button
          onClick={() => setFilter("incomplete")}
          style={{ fontWeight: filter === "incomplete" ? "bold" : "normal" }}
        >
          Incomplete
        </button>
      </div>

      {/* Task List */}
      {filteredTasks.length === 0 ? (
        <p>No tasks.</p>
      ) : (
        <ul style={{ listStyle: "none", padding: 0 }}>
          {filteredTasks.map((task) => (
            <li
              key={task.id}
              style={{
                display: "flex",
                justifyContent: "space-between",
                alignItems: "center",
                marginBottom: "8px",
                padding: "10px",
                border: "1px solid #ddd",
                borderRadius: "5px",
                backgroundColor: task.completed ? "#e0ffe0" : "#fff",
              }}
            >
              <span
                style={{
                  textDecoration: task.completed ? "line-through" : "none",
                  flex: 1,
                  cursor: "pointer",
                }}
                onClick={() => toggleTask(task.id)}
              >
                {task.text}
              </span>
              <button
                onClick={() => deleteTask(task.id)}
                style={{ marginLeft: "10px" }}
              >
                ❌
              </button>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default TodoApp;
