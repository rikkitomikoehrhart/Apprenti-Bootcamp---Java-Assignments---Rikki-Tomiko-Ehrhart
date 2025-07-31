function Welcome3({name, ...htmlProps}) {
    return (
        <>
            <p {...htmlProps}>Welcome {name}</p>
        </>
    );
};

export default Welcome3;