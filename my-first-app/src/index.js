import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
//import App from './App';
import { Provider } from 'react-redux';
import { createStore } from 'redux';
import rootReducer from './ReduxExample/rootReducer';
import App2 from './App2';

const store = createStore(rootReducer); // Create the Redux store

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <Provider store={store}>
    <App2 />
  </Provider>

);

