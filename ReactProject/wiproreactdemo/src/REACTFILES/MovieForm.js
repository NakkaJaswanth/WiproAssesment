import React, { Component } from "react";

// MovieForm is a React Class Component
class MovieForm extends Component {
  constructor(props) {
    super(props);
    console.log("constructor executed");

    // contains one movie form and a list of submitted movies
    this.state = {
      movie: {
        title: "",
        director: "",
        year: "",
        genre: "Action", // default selected genre
        rating: "",
        description: "",
        platforms: {
          Netflix: false,
          "Amazon Prime": false,
          "Disney+": false,
          Others: false,
        },
      },
      movieList: [], // this will hold the list of added movies
    };
  }

  // called before render
  static getDerivedStateFromProps(props, state) {
    console.log("getDerivedStateFromProps executed");
    return null; // we're not updating state from props, so we return null
  }

  // runs once after the component is added to the page
  componentDidMount() {
    console.log("componentDidMount executed");
  }

  //  decides whether the component should re-render
  shouldComponentUpdate(nextProps, nextState) {
    console.log("shouldComponentUpdate executed");
    return true; // always re-render when something changes
  }

  // called before the DOM is updated
  getSnapshotBeforeUpdate(prevProps, prevState) {
    console.log("getSnapshotBeforeUpdate executed");
    return null;
  }

  // runs after component updates on screen
  componentDidUpdate(prevProps, prevState, snapshot) {
    console.log("componentDidUpdate executed");
  }

  // called just before the component is removed from screen
  componentWillUnmount() {
    console.log("componentWillUnmount executed");
  }

  // This function runs whenever a form field changes
  handleChange = (e) => {
    const { name, value, type, checked } = e.target;

    // If the changed input is a checkbox related to platforms (Netflix, etc.)
    if (type === "checkbox" && name in this.state.movie.platforms) {
      this.setState((prevState) => ({
        movie: {
          ...prevState.movie,
          platforms: {
            ...prevState.movie.platforms,
            [name]: checked, // update checkbox state (true/false)
          },
        },
      }));
    } else {
      // For all other inputs (text, number, radio, select, etc.)
      this.setState((prevState) => ({
        movie: {
          ...prevState.movie,
          [name]: value, // update the field by name
        },
      }));
    }
  };

  // This function runs when the form is submitted
  handleSubmit = (e) => {
    e.preventDefault(); // prevent the page from refreshing

    // Add the current movie to the movie list, then reset the form
    this.setState((prevState) => ({
      movieList: [...prevState.movieList, prevState.movie],
      movie: {
        title: "",
        director: "",
        year: "",
        genre: "Action",
        rating: "",
        description: "",
        platforms: {
          Netflix: false,
          "Amazon Prime": false,
          "Disney+": false,
          Others: false,
        },
      },
    }));
  };

  // This method displays the form and the movie list
  render() {
    console.log("render executed");

    const { movie, movieList } = this.state;

    return (
      <div className="container my-5">
        {/* Form Card */}
        <div className="card p-4">
          <h4>Add a Movie</h4>
          <form onSubmit={this.handleSubmit}>
            {/* Title */}
            <div className="mb-3">
              <label className="form-label">Movie Title</label>
              <input
                type="text"
                className="form-control"
                name="title"
                value={movie.title}
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Director */}
            <div className="mb-3">
              <label className="form-label">Director</label>
              <input
                type="text"
                className="form-control"
                name="director"
                value={movie.director}
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Release Year */}
            <div className="mb-3">
              <label className="form-label">Release Year</label>
              <input
                type="number"
                className="form-control"
                name="year"
                value={movie.year}
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Genre Dropdown */}
            <div className="mb-3">
              <label className="form-label">Genre</label>
              <select
                className="form-select"
                name="genre"
                value={movie.genre}
                onChange={this.handleChange}
              >
                <option>Action</option>
                <option>Comedy</option>
                <option>Drama</option>
                <option>Sci-Fi</option>
                <option>Horror</option>
              </select>
            </div>

            {/* Rating Radio Buttons */}
            <div className="mb-3">
              <label className="form-label">Rating</label>
              <div>
                {[1, 2, 3, 4, 5].map((rate) => (
                  <div className="form-check form-check-inline" key={rate}>
                    <input
                      className="form-check-input"
                      type="radio"
                      name="rating"
                      value={rate}
                      checked={movie.rating === String(rate)}
                      onChange={this.handleChange}
                      required
                    />
                    <label className="form-check-label">{rate}</label>
                  </div>
                ))}
              </div>
            </div>

            {/* Description Textarea */}
            <div className="mb-3">
              <label className="form-label">Description</label>
              <textarea
                className="form-control"
                name="description"
                value={movie.description}
                onChange={this.handleChange}
                rows="3"
              />
            </div>

            {/* Platforms Checkboxes */}
            <div className="mb-3">
              <label className="form-label">Available On</label>
              <div className="form-check">
                {/* Loop through platform names */}
                {Object.keys(movie.platforms).map((platform) => (
                  <div className="form-check" key={platform}>
                    <input
                      className="form-check-input"
                      type="checkbox"
                      name={platform}
                      checked={movie.platforms[platform]}
                      onChange={this.handleChange}
                    />
                    <label className="form-check-label">{platform}</label>
                  </div>
                ))}
              </div>
            </div>

            {/* Submit Button */}
            <button type="submit" className="btn btn-primary">
              Add Movie
            </button>
          </form>
        </div>

        {/* Movie List Table - Shows only if at least one movie is added */}
        {movieList.length > 0 && (
          <div className="mt-5">
            <h4>Movie List</h4>
            <table className="table table-bordered">
              <thead className="table-light">
                <tr>
                  <th>Title</th>
                  <th>Director</th>
                  <th>Year</th>
                  <th>Genre</th>
                  <th>Rating</th>
                  <th>Description</th>
                  <th>Platforms</th>
                </tr>
              </thead>
              <tbody>
                {/* Loop through each movie in movieList and show in table row */}
                {movieList.map((m, index) => (
                  <tr key={index}>
                    <td>{m.title}</td>
                    <td>{m.director}</td>
                    <td>{m.year}</td>
                    <td>{m.genre}</td>
                    <td>{m.rating}</td>
                    <td>{m.description}</td>
                    <td>
                      {/*display only the selected streaming platforms  */}
                      {/*{/*display only the selected streaming platforms  */} 
                    {/* convert object to array , filter-keep only platforms where value is true*/}
                      {Object.entries(m.platforms)
                        .filter(([_, val]) => val)
                        .map(([key]) => key)
                        .join(", ") || "None"}
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}
      </div>
    );
  }
}

export default MovieForm;
