import { useState } from 'react';

function UserCard({ name, role }) {
    const [likes, setLikes] = useState(0)

    function handleLikesClick() {
        setLikes(likes + 1);
    }

    return (
        <div className="card mb-3">
            <div className="card-body">
                <h5 className="card-title">{name}</h5>
                <h6 className="card-subtitle mb-2 text-muted">{role}</h6>

                <button className={`btn ${likes === 0 ? 'btn-outline-secondary' : 'btn-danger'}`} onClick={handleLikesClick}>
                    ♥ {likes}
                </button>
            </div>
        </div>
    );
}

export default UserCard;