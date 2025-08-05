import { colors } from "../data/sampleData.js";

function ColorList() {

    return (
        <>
            <h2>Color List</h2>
            <p>This component uses a map() to render list items.</p>
            <ul>
                {colors.map(c => (
                    // Need a unique key on each mapped element
                    <li key={c}>{c}</li>
                ))}
            </ul>
        </>
    );
};

export default ColorList;