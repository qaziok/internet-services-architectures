
import {useEffect, useState} from 'react';
import {useNavigate, useParams, useSearchParams} from "react-router-dom";
import {getDirector} from "../components/ApiGateway/director";
import {getMovie} from "../components/ApiGateway/movie";

const MovieView = () => {
    const [data, setData] = useState('');
    const [director, setDirector] = useState('');
    const [searchParams, setSearchParams] = useSearchParams();
    const id = searchParams.get('id')
    let navigate = useNavigate();

    const notFound = (error) => {
        navigate(`${error.message}`)
    }

    useEffect(() => {
        getMovie(id).catch(reason => notFound(reason)).then(data => {
            setData(data)
            return getDirector(data['director'])
        }).then(dir => setDirector(dir));
    },[id]);

    return (
        <div className="App">
            <h1>Movie</h1>
            <p>Title: {data.title}</p>
            <p>Genre: {data.genre}</p>
            <p>Release Date: {data.releaseDate}</p>
            <p>Director: {director.name}</p>
        </div>
    );
};

export default MovieView;