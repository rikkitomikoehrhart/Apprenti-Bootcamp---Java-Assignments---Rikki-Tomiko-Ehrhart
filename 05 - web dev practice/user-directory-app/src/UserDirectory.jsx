import { useEffect, useState } from "react";

function UserDirectory() {
    const [users, setUsers] = useState([]);
    const [loading, setLoading] = useState(true);
    const [searchTerm, setSearchTerm] = useState("");

    const filteredUsers = users.filter(user => user.name.toLowerCase().includes(searchTerm.toLowerCase()));

    const [error, setError] = useState(null);

    useEffect(() => {
        fetch("https://jsonplaceholder.typicode.com/users")
            .then(res => {
                if (!res.ok) throw new Error("Failed to fetch users.");
                return res.json();
            })
            .then(data => {
                setUsers(data);
                setLoading(false);
            })
            .catch(err => {
                setError(err.message);
                setLoading(false);
            });
    }, []);

    if (error) return <p>Error: {error}</p>;
    if (loading) return <p>Loading...</p>;
    if (filteredUsers.length === 0) return <p>No users found.</p>


    return (
        <div>
            <h2>User Directory</h2>
            <input 
                type="text" 
                placeholder="Search users..." 
                value={searchTerm} 
                onChange={(e) => setSearchTerm(e.target.value)}
                style={{ marginBottom: "20px", padding: "5px" }}
            />

            {filteredUsers.map(user => (
                <div key={user.id} style={{ border: "1px solid #ccc", margin: "10px", padding: "10px"}}>
                    <h3>{user.name}</h3>
                    <p>{user.email}</p>
                </div>
            ))}
        </div>
    );
}

export default UserDirectory;