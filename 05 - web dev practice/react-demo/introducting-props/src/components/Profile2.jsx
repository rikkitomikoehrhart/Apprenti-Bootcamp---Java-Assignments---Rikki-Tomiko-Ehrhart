// Destructuring

function Profile2({name, age, isPremium, interests}) {
    return (
        <>
            <p>Name: <strong>{name}</strong></p>
            <p>Age: <strong>{age}</strong></p>
            <p>Premium User: <strong>{isPremium ? "Yes" : "No"}</strong></p>
            <p>Interests: <strong>{interests.join(", ")}</strong></p>
        </>
    );
};

export default Profile2;