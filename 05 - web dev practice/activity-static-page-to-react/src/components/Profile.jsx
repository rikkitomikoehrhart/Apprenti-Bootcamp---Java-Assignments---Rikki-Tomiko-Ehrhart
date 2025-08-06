import Button from "./Button";

function Profile({ name, job, age, btnClickHandler }) {

    return (
        <section className="profile">
            <h2 id="name">{name}</h2>
            <p id="job">{job}</p>
            <p id="age">Age: {age}</p>
            <Button btnText={"Increase Age"} idText={"incrementAge"} clickHandler={btnClickHandler} />
        </section>
    );
}

export default Profile;