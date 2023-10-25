import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

const URL = 'http://localhost:8080/api/movie/'

export default function MoviePage() {
    const [movie , setMovie] = useState(null);
    const { id } = useParams();

    useEffect(() => {
        if (id) {
            fetch(URL + id)
                .then(res => res.json())
                .then(data => setMovie(data))
                .catch(error => {
                    console.error('Error fetching movie:' , error);
                });
        }
    } , [id]);

    if (!movie) {
        return null;
    }

    return (
        <div>
            <div style = {{display: 'flex'}}>
                <div style={{ flex: '1' , padding: '22px'}}>
                    <img 
                        src = {movie.posterURL}
                        alt = {movie.title}
                        style = {{ maxWidth: "100%", maxHeight: "100%" }}
                    />
                </div>

                <div style={{ flex: '7'}}>
                    <h1 className = "display-1 text-white">{movie.title}</h1>

                    <ul className = "list-group list-group-flush">
                        <li className = "list-group-item display-6 text-white bg-black">Year: {movie.year}</li>
                        <li className = "list-group-item display-6 text-white bg-black">Rating: {movie.rating}</li>
                        <li className = "list-group-item display-6 text-white bg-black">Runtime: {movie.runTime}</li>
                    </ul>
                </div>
            </div>
        </div>
    );
}