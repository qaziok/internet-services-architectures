import JsonTable from "../components/Table/jsonTable";
import {useEffect, useState} from 'react';
import {useNavigate, useSearchParams} from 'react-router-dom'
import {getDirector, getDirectorMovies} from "../components/ApiGateway/director";
import {deleteMovie} from "../components/ApiGateway/movie";

function DirectorView() {
    const [data, setData] = useState([]);
    const [movies, setMovies] = useState([]);
    const [deleted, setDeleted] = useState(0);
    const [searchParams, _] = useSearchParams();
    const id = searchParams.get('id')
    let navigate = useNavigate();

    const notFound = (error) => {
        navigate(`${error.message}`)
    }

    useEffect(() => {
        getDirector(id).catch(reason => notFound(reason)).then(data => {
            setData(data)
            return getDirectorMovies(id)
        }).then(movies => setMovies(movies['movies']));
    }, [deleted, id]);

    const buttons = (row, index) => {
        return (
            <>
                <td>
                    <button onClick={() => {
                        navigate({
                            pathname: "/movie",
                            search: `?id=${row['id']}`
                        })
                    }
                    }>View
                    </button>
                </td>
                <td>
                    <button onClick={() => {
                        navigate({
                            pathname: "/movie/edit",
                            search: `?movie_id=${row['id']}`
                        })
                    }
                    }>Edit
                    </button>
                </td>
                <td>
                    <button onClick={() => {
                        deleteMovie(row['id']).catch(() => {
                        }).then(() => setDeleted(deleted + 1))
                    }}>Delete
                    </button>
                </td>
            </>
        );
    }

    return (
        <div className="App">
            <h1>Director</h1>
            <p>Name: {data['name']}</p>
            <p>Birth Date: {data['birthDate']}</p>
            <h2>Movies</h2>
            <JsonTable theadData={["title"]} tbodyData={movies} buttons={buttons}/>
            <button onClick={() => {
                navigate({
                    pathname: "/director/movie/new",
                    search: `?director_id=${id}`
                })
            }}>Add new movie
            </button>
        </div>
    );
}

export default DirectorView