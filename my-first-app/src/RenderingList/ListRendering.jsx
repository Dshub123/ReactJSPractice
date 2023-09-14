import React, { Component } from 'react'

export default class ListRendering extends Component {

    constructor() {
        super();
        this.state = {
            list: [{ id: 1, name: "Shubham" }, { id: 2, name: "Chetan" }, { id: 2, name: "Gaurav" }]
        }
    }

    render() {
        return (
            <div>
                {this.state.list.map((e) => <h1 key={e.id}>{e.name}</h1>)}
            </div>
        )
    }
}
