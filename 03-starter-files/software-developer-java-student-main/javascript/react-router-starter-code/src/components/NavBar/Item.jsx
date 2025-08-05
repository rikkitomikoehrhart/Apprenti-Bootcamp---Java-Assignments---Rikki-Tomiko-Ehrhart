import PropTypes from "prop-types";

function Item({ link }) {
  const lowerCasedLink = link.toLowerCase();
  return (
    <li>
      <a href={lowerCasedLink === "home" ? "/" : `/${lowerCasedLink}`}>
        {link}
      </a>
    </li>
  );
}

Item.propTypes = {
  link: PropTypes.string.isRequired,
};

export default Item;
