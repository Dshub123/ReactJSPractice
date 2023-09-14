// src/components/TodoList.js
import React from "react";
import { connect } from "react-redux";
import { addTodo, removeTodo } from "../actions/todoActions";

const TodoList = ({ todos, addTodo, removeTodo }) => {
    const handleAddTodo = () => {
        const newTodo = { id: Math.random(), text: "New Task" };
        addTodo(newTodo);
    };

    const handleRemoveTodo = (todoId) => {
        removeTodo(todoId);
    };

    return (
        <div>
            <button onClick={handleAddTodo}>Add Todo</button>
            <ul>
                {todos.map((todo) => (
                    <li key={todo.id}>
                        {todo.text}
                        <button onClick={() => handleRemoveTodo(todo.id)}>Remove</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

const mapStateToProps = (state) => ({
    todos: state.todo.todos,
});

export default connect(mapStateToProps, { addTodo, removeTodo })(TodoList);
