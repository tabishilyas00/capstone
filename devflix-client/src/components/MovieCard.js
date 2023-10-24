export default function MovieCard({movie}) {
    console.log(movie);

    return (
        <div className = "card border-dark m-2" style = {{width: '250px'}}>
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
                <h3 className = "card-subtitle fs-5 mb-2 text-body-secondary">
                    {movie.year}
                </h3>

                <h3 className = "card-subtitle fs-5 mb-2 text-body-secondary">
                    {movie.rating}
                </h3>

                <h3 className = "card-subtitle fs-5 mb-2 text-body-secondary">
                    {movie.runTime}
                </h3>
            </div>
        </div>
    );
}