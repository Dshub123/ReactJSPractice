import { createStore } from "redux";
import { combineReducers } from "redux";
import todoReducer from "./reducers/todoReducer";

const rootReducer = combineReducers({
    todo: todoReducer,
});

const store = createStore(rootReducer);

export default store;