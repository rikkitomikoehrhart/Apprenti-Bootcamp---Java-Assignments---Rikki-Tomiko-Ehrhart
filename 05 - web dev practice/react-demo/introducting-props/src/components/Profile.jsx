function Profile(props) {
    return (
        <>
            <p>Name: <strong>{props.name}</strong></p>
            <p>Age: <strong>{props.age}</strong></p>
            <p>Premium User: <strong>{props.isPremium ? "Yes" : "No"}</strong></p>
            <p>Interests: <strong>{props.interests.join(", ")}</strong></p>
        </>
    );
};

export default Profile;