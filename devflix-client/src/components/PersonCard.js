export default function PersonCard({person}) {
    console.log(person);

    return (
        <div className = "card text-white bg-dark m-2" style = {{width: '250px'}}>
            <div className = "card-header">
                <img
                    className = "card-img-top"
                    style = {{height: '350px' , objectFit: "contain"}}
                    src = {person.imageURL}
                    alt = {`${person.name}`}
                />
            </div>

            <div className = "card-body">
                <h2 className = "card-title fs-4">
                    {person.name}
                </h2>
            </div>
        </div>
    );
}