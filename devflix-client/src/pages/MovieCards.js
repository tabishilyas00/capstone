import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

import MovieCard from "../components/MovieCard";

const URL = 'http://localhost:8080/api/movie'

export default function MovieCards() {
    const [movies , setMovies] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        fetch(URL)
            .then(res => {
                if (res.ok) {
                    return res.json();
                } else if (res.status >= 500) {
                    return res
                        .json()
                        .then(error =>
                            Promise.reject(new Error(error.message))    
                        );
                } else {
                    return Promise.reject(new Error(res.status));
                }
            })
            .then(setMovies)
            .catch(error => {
                console.error(error);
                navigate('/error' , {state: {error}});
            })
    } , []);

    return (
        <div className = "row row-cols-1 row-cols-md-2 row-cols-lg-3 g-1 justify-content-center">
            {movies.map(movie => (
                <MovieCard movie = {movie} key = {movie.movieID} />
            ))}
        </div>
    );
}