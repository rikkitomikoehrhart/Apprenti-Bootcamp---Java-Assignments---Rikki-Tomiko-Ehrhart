function Welcome4({name="unknown", ...htmlProps}) {
    return(
        <>
            <p className="blue" {...htmlProps}>Welcome, {name}</p>
        </>
    );
};

export default Welcome4;