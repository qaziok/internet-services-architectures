import {useState, useEffect} from 'react';
import {useNavigate, useSearchParams} from 'react-router-dom'
import {getDirector, postDirector, putDirector} from "../components/ApiGateway/director";

function DirectorForm() {
    const [name, setName] = useState('');
    const [birthDate, setBirthDate] = useState('');

    const [searchParams] = useSearchParams();
    const id = searchParams.get('id')
    let navigate = useNavigate();

    useEffect(() => {
        if (id) {
            getDirector(id).then(data => {
                if (data === 404){
                    navigate('/director/new')
                } else {
                    setName(data['name'])
                    setBirthDate(data['birthDate'])
                }
            })
        }
    });

    const send = (id, director) => {
        return (id ? putDirector(id, director) : postDirector(director))
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        const formData = new FormData(e.currentTarget)
        let director = {}
        formData.forEach((value, key) => {
            director[key] = value
        })
        send(id, director).then(() => navigate(-1, {replace: true}))
    }

    return (
        <div className="App">
            <h1>Director</h1>

            <form onSubmit={handleSubmit}>
                <p>
                    <label>
                        Name:
                        <input type="text" name="name" defaultValue={name}
                               onChange={(e) => setName(e.target.value)}  required="required"/>
                    </label>
                </p>
                <p>
                    <label>
                        Birth Date:
                        <input type="date" name="birthDate" defaultValue={birthDate}
                               onChange={(e) => setBirthDate(e.target.value)}  required="required"/>
                    </label>
                </p>
                <button type="submit">Submit</button>
            </form>
        </div>

    );
}

export default DirectorForm