import { Link } from "react-router-dom";

export default function MovieCard({movie}) {
    console.log(movie);

    return (
        <div className = "card text-white bg-dark m-2" style = {{width: '250px'}}>
            <div className = "card-header">
                <img
                    className = "card-img-top"
                    style = {{height: '350px' , objectFit: "contain"}}
                    src = {movie.posterURL}
                    alt = {`${movie.title}`}
                />
            </div>

            <div className = "card-body">
                <h2 className = "card-title fs-4">
                    {movie.title}
                </h2>
            </div>

            <div className = "card-footer">
                <h3 className = "card-subtitle fs-5 mb-2 text-white">
                    {movie.year}
                </h3>

                <h3 className = "card-subtitle fs-5 mb-2 text-white">
                    {movie.rating}
                </h3>

                <h3 className = "card-subtitle fs-5 mb-2 text-white">
                    {movie.runTime}
                </h3>
            </div>

            <div className = "card-footer">
                <Link 
                    className = "btn btn-outline-danger container-fluid"
                    to = {`/${movie.movieID}`}
                >
                    Details
                </Link>
            </div>
        </div>
    );
}