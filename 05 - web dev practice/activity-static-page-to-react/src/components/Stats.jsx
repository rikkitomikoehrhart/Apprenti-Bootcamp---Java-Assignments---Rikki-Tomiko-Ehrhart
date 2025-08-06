
function Stats({ followers, posts }) {

    return (
        <section className="stats">
            <p>Followers: <span>{followers}</span></p>
            <p>Posts: <span>{posts}</span></p>
        </section>
    );
}

export default Stats;