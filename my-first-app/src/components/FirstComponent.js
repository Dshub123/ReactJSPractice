import React, { Component } from 'react';

class FirstComponent extends Component {
    render() {
        return (
            <div>
                Hello, {this.props.name}! I am a FirstClassComponent.
            </div>
        );
    }
}

export default FirstComponent;