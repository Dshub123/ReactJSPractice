import { BASE_API_URL } from '../common/constants';
import axios from 'axios';
import { authHeader } from './base.service';


const BASE_URL = BASE_API_URL + '/todo';

class TodoService {

    listAllTodos(user) {
        return axios.post(BASE_URL + '/list-All-todo', user, { headers: authHeader() });
    }

    createTodo(todo) {
        return axios.post(BASE_URL + '/create', todo, { headers: authHeader() });
    }

    deleteTodo(id) {
        return axios.delete(BASE_URL + `/delete/${id}`, { headers: authHeader() });
    }

    getById(id) {
        return axios.get(BASE_URL + `/${id}`, { headers: authHeader() });
    }

    updateTodo(todo, id) {
        return axios.put(BASE_URL + `/update/${id}`, todo, { headers: authHeader() });
    }

}

export default new TodoService();