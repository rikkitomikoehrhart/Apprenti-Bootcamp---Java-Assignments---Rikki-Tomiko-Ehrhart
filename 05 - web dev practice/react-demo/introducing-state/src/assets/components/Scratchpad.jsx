import { useState } from 'react';

function Scratchpad() {
    const [person, setPerson] = useState({
        firstName: "Joe",
        lastName: "Schmoe"
    });

    function handleClick() {
        const newPerson = {
            ...person,
            lastName: "Smith"
        }

        setPerson(newPerson);
    }

    return (
        <>
            <h1>Welcome {person.firstName} {person.lastName}</h1>
            <button onClick={handleClick}>Mutate</button>
        </>
    );
};

export default Scratchpad;