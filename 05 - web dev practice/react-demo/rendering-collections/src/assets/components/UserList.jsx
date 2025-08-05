import { users } from '../data/sampleData.js';

function UserList() {
    return (
        <>
            <h2>Users</h2>
            {users.map(u => (
                <div className="px-3 mb-2 border" key={u.id}>
                    <h3>{u.name}</h3>
                    <p>Email: {u.email}</p>
                    <p>Age: {u.age}</p>
                </div>
            ))}
        </>
    );
};

export default UserList;