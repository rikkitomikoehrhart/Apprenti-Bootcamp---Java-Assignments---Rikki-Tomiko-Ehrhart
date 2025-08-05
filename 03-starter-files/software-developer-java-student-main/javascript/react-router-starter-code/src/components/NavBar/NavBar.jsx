import Item from "./Item";

const links = ["Home", "About", "Contact"];

function NavBar() {
  return (
    <nav>
      <ul>
        {links.map((link, index) => (
          <Item key={index} link={link} />
        ))}
      </ul>
    </nav>
  );
}
export default NavBar;
