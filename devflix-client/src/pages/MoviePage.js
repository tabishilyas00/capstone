import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import DirectorCard from "../components/DirectorCard";
import WriterCard from "../components/WriterCard";
import StarCard from "../components/StarCard";

const URL = 'http://localhost:8080/api/movie/'

export default function MoviePage() {
    const [movie , setMovie] = useState(null);
    const { id } = useParams();
    const navigate = useNavigate();

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

    const [directors , setDirectors] = useState([]);
    useEffect(() => {
        fetch(URL + id + '/director')
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
            .then(setDirectors)
            .catch(error => {
                console.error(error);
                navigate('/error' , {state: {error}});
            })
    } , []);

    const [writers , setWriters] = useState([]);
    useEffect(() => {
        fetch(URL + id + '/writer')
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
            .then(setWriters)
            .catch(error => {
                console.error(error);
                navigate('/error' , {state: {error}});
            })
    } , []);

    const [stars , setStars] = useState([]);
    useEffect(() => {
        fetch(URL + id + '/star')
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
            .then(setStars)
            .catch(error => {
                console.error(error);
                navigate('/error' , {state: {error}});
            })
    } , []);

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

            <div>
                <h1 className = "display-3 text-white">Director(s)</h1>

                <div className = "row row-cols-1 row-cols-md-2 row-cols-lg-3 g-1">
                    {directors.map(director => (
                        <DirectorCard person = {director} key = {movie.movieID} />
                    ))}
                </div>
            </div>

            <div>
                <h1 className = "display-3 text-white">Writer(s)</h1>

                <div className = "row row-cols-1 row-cols-md-2 row-cols-lg-3 g-1">
                    {writers.map(writer => (
                        <WriterCard person = {writer} key = {movie.movieID} />
                    ))}
                </div>
            </div>

            <div>
                <h1 className = "display-3 text-white">Stars</h1>

                <div className = "row row-cols-1 row-cols-md-2 row-cols-lg-3 g-1">
                    {stars.map(star => (
                        <StarCard person = {star} key = {movie.movieID} />
                    ))}
                </div>
            </div>
        </div>
    );
}