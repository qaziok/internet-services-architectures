import {useEffect, useState} from 'react';
import {useNavigate, useSearchParams} from 'react-router-dom'
import {getMovie, postMovie, putMovie} from "../components/ApiGateway/movie";
import {getDirector} from "../components/ApiGateway/director";

const MovieForm = () => {
    const [title, setTitle] = useState('');
    const [releaseDate, setReleaseDate] = useState('');
    const [genre, setGenre] = useState('');
    const [director, setDirector] = useState('');

    const [searchParams, _] = useSearchParams();
    const [notFound, setNotFound] = useState(false);
    const movie_id = searchParams.get('movie_id')
    const director_id = searchParams.get('director_id')

    let navigate = useNavigate();

    useEffect(() => {
        if (movie_id) {
            getMovie(movie_id).then(data => {
                if (data === 404) {
                    setNotFound(true)
                } else {
                    setTitle(data['title'])
                    setReleaseDate(data['releaseDate'])
                    setGenre(data['genre'])
                    setDirector(data['director'])
                    return getDirector(data['director'])
                }
            }).then(dir => setDirector(dir));
        } else {
            getDirector(director_id).then(dir => {
                if (dir === 404) {
                    setNotFound(true)
                } else {
                    setDirector(dir)
                }
            });
        }
    }, [director_id, movie_id, navigate]);

    if (notFound) {
        return (
        <div className="App">
            <h1>404</h1>
            <h2>Movie not found</h2>
        </div>
        )
    }

    const send = (id, movie) => {
        return (id ? putMovie(id, movie) : postMovie(movie))
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        const movie = {
            title: title,
            releaseDate: releaseDate,
            genre: genre,
            director: director.id
        }
        send(movie_id, movie).then(() => navigate(-1, {replace: true}))
    }

    return (
        <div className="App">
            <form onSubmit={handleSubmit}>
                <h1>Movie</h1>
                <p>
                    Director: {director['name']}
                </p>
                <p>
                    <label>
                        Title:
                        <input type="text" name="title" defaultValue={title}
                               onChange={(e) => setTitle(e.target.value)} required="required"/>
                    </label>
                </p>
                <p>
                    <label>
                        Release Date:
                        <input type="date" name="releaseDate" defaultValue={releaseDate}
                               onChange={(e) => setReleaseDate(e.target.value)} required="required"/>
                    </label>
                </p>
                <p>
                    <label>
                        Genre:
                        <input type="text" name="genre" defaultValue={genre}
                               onChange={(e) => setGenre(e.target.value)} required="required"/>
                    </label>
                </p>
                <button type="submit">Submit</button>
            </form>
        </div>
    );
};

export default MovieForm;



