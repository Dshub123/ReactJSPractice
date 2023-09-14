
import React, { Component } from 'react'

export default class ConditionalRendering extends Component {

    constructor() {
        super();

        this.state = {
            visible: false
        };
    }

    render() {

        return <>
            {this.state.visible ? <h1>☀️</h1> : <h1>🌑</h1>}
            <button onClick={() => { this.setState({ visible: true }) }}>Day</button>
            <button onClick={() => { this.setState({ visible: false }) }}>Night</button>
        </>

    }
}
