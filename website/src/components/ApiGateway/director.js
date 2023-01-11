const DIRECTORS_URL = '/api/directors';

async function json(response) {
    if (response.ok) {
        try{
            return await response.json();
        } catch (e) {
            return {};
        }
    }
    return response.status;
}
export const getDirectors = () => {
    return fetch(DIRECTORS_URL)
        .then(response => json(response));
}

export const getDirector = (id) => {
    return fetch(`${DIRECTORS_URL}/${id}`)
        .then(response => json(response));
}

export const getDirectorMovies = (id) => {
    return fetch(`${DIRECTORS_URL}/${id}/movies`)
        .then(response => json(response));
}

export const deleteDirector = (id) => {
    const requestOptions = {
        method: 'DELETE',
        headers: { 'Content-Type': 'application/json' },
    };
    return fetch(`${DIRECTORS_URL}/${id}`, requestOptions)
        .then(response => json(response));
}

export const postDirector = (director) => {
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(director)
    };
    return fetch(DIRECTORS_URL, requestOptions)
        .then(response => json(response))
}

export const putDirector = (id, director) => {
    const requestOptions = {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(director)
    };
    return fetch(`${DIRECTORS_URL}/${id}`, requestOptions)
        .catch(error => console.log(error));
}