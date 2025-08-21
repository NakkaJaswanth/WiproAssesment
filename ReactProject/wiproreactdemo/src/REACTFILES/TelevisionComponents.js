import React, { Component } from 'react';

// Functional component to display TV models
export const TelevisionList = ({ models }) => {
  return (
    <ul>
      {models.map((model, index) => (
        <li key={index}>{model}</li>
      ))}
    </ul>
  );
};

// Class component to manage TV models and input
export class TelevisionManager extends Component {
  constructor(props) {
    super(props);
    this.state = {
      tvModels: ['MI', 'LG'],
      newModel: ''
    };
  }

  handleInputChange = (e) => {
    this.setState({ newModel: e.target.value });
  };

  addModel = () => {
    const { newModel, tvModels } = this.state;
    if (newModel.trim() !== '') {
      this.setState({
        tvModels: [...tvModels, newModel],
        newModel: ''
      });
    }
  };

  render() {
    return (
      <div>
        <h2>Television Models</h2>
        <input
          type="text"
          value={this.state.newModel}
          onChange={this.handleInputChange}
          placeholder="Enter TV model"
        />
        <button onClick={this.addModel}>Add Model</button>
        <TelevisionList models={this.state.tvModels} />
      </div>
    );
  }
}
