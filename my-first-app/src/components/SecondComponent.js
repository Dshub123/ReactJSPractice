import React, { Component } from 'react';

class SecondComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            toggle: true
        };
        // This is to bind context when passing onClick as a callback
        this.onClick = this.onClick.bind(this);
    }
    onClick() {
        this.setState((prevState, props) => ({
            toggle: !prevState.toggle
        }));
    }

}

export default SecondComponent;