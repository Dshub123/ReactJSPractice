import React, { useState, useEffect } from "react";
import TodoService from "../services/TodoService";
import { useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";

const TodoList = () => {
  const navigate = useNavigate();
  const currentUser = useSelector((state) => state.user);
  const [todos, setTodos] = useState([]);

  const [isDeleted, setIsDeleted] = useState(false);

  // Function to fetch todos
  const fetchTodos = () => {
    TodoService.listAllTodos(currentUser)
      .then((response) => {
        setTodos(response.data);
      })
      .catch((error) => console.log(error));
  };

  // Initial fetch
  useEffect(() => {
    fetchTodos();
  }, []);

  // Function to handle todo deletion
  const deleteHandler = (id) => {
    TodoService.deleteTodo(id)
      .then(() => setIsDeleted(true))
      .catch((error) => console.log(error));
  };

  // Refresh todos when a deletion occurs
  useEffect(() => {
    if (isDeleted) {
      fetchTodos();
      setIsDeleted(false);
    }
  }, [isDeleted]);

  const updateHandler = (id) => {
    sessionStorage.setItem("id", id);
    navigate(`/update/${id}`);
  };

  return (
    <div>
      <h2 className="fw-light mt-2">List Todos</h2>
      <div className="container mt-5">
        <table className="table">
          <thead>
            <tr>
              <th>Description</th>
              <th>Is Completed</th>
              <th>Target Date</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {todos.map((todo) => (
              <tr key={todo.id}>
                <td>{todo.description}</td>
                <td>{todo.isDone ? "True" : "False"}</td>
                <td>{todo.targetDate}</td>
                <td>
                  <button
                    className="btn btn-md btn-danger"
                    onClick={() => deleteHandler(todo.id)}
                  >
                    Delete
                  </button>{" "}
                  <button
                    className="btn btn-md btn-success"
                    onClick={() => updateHandler(todo.id)}
                  >
                    Update
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
        <button
          className="btn btn-md btn-secondary"
          onClick={() => navigate("/create")}
        >
          Create
        </button>
      </div>
    </div>
  );
};

export default TodoList;
