export default function DirectorCard({person}) {
    console.log(person);
    let src = null;

    if (person.director.imageURL) {
        src = person.director.imageURL;
    } else {
        src = '../image_not_found.png';
    }

    return (
        <div className = "card text-white bg-dark m-2" style = {{width: '250px'}}>
            <div className = "card-header">
                <img
                    className = "card-img-top"
                    style = {{height: '350px' , objectFit: "contain"}}
                    src = {src}
                    alt = {`${person.director.name}`}
                />
            </div>

            <div className = "card-body">
                <h2 className = "card-title fs-4">
                    {person.director.name}
                </h2>
            </div>
        </div>
    );
}