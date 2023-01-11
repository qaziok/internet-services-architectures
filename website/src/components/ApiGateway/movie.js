const MOVIES_URL = '/api/movies';

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

export const getMovie = (id) => {
    return fetch(`${MOVIES_URL}/${id}`)
        .then(response => json(response));
}

export const deleteMovie = (id) => {
    const requestOptions = {
        method: 'DELETE',
        headers: { 'Content-Type': 'application/json' },
    };
    return fetch(`${MOVIES_URL}/${id}`, requestOptions)
        .then(response => json(response));
}

export const postMovie = (movie) => {
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(movie)
    };
    return fetch(MOVIES_URL, requestOptions)
        .then(response => json(response));
}

export const putMovie = (id, movie) => {
    const requestOptions = {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(movie)
    };
    return fetch(`${MOVIES_URL}/${id}`, requestOptions)
        .then(response => json(response));
}
