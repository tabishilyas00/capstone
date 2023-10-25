import { Link } from "react-router-dom";

const URL = 'http://localhost:8080/api/movie'

export default function Nav() {
    return (
        <div>
            <Link
                to = "/"
                style = {{textDecoration: 'none'}}
            >
                <div>
                    <img 
                        src = "../devflix_header.png"
                        alt = "Devflix Header"
                        style = {{maxWidth: '100%' , maxHeight: '100%'}}
                    />
                </div>
            </Link>
        </div>
    );
}