export default function WriterCard({person}) {
    console.log(person);
    let src = null;

    if (person.writer.imageURL) {
        src = person.writer.imageURL;
    } else {
        src = "../image_not_found.png";
    }

    return (
        <div className = "card text-white bg-dark m-2" style = {{width: '250px'}}>
            <div className = "card-header">
                <img
                    className = "card-img-top"
                    style = {{height: '350px' , objectFit: "contain"}}
                    src = {src}
                    alt = {`${person.writer.name}`}
                />
            </div>

            <div className = "card-body">
                <h2 className = "card-title fs-4">
                    {person.writer.name}
                </h2>
            </div>
        </div>
    );
}