import JsonTable from "../components/Table/jsonTable";
import {useState, useEffect} from 'react';
import {useNavigate} from "react-router-dom";
import {deleteDirector, getDirectors} from "../components/ApiGateway/director";

function Directors() {
    const [data, setData] = useState([]);
    const [deleted, setDeleted] = useState(0);

    useEffect(() => {
        getDirectors().then(data => setData(data['directors']));
    }, [deleted]);

    let navigate = useNavigate();

    const buttons = (row, index) => {
        return (
            <>
                <td>
                    <button onClick={() => {
                        navigate({
                            pathname: "/director",
                            search: `?id=${row['id']}`
                        })
                    }
                    }>View
                    </button>
                </td>
                <td>
                    <button onClick={() => {
                        navigate({
                            pathname: "/director/edit",
                            search: `?id=${row['id']}`
                        })
                    }
                    }>Edit
                    </button>
                </td>
                <td>
                    <button onClick={() => {
                        deleteDirector(row['id']).then(() => setDeleted(deleted + 1))
                    }}>Delete
                    </button>
                </td>
            </>
        );
    }

    return (
        <div className="App">
            <JsonTable theadData={["name"]} tbodyData={data} buttons={buttons}/>
            <button onClick={() => {
                navigate("/director/new")
            }}>Add
            </button>
        </div>
    );
}

export default Directors