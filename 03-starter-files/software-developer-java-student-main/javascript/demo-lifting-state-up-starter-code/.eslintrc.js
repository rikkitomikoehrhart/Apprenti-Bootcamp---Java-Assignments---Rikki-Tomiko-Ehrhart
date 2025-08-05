module.exports = {
  env: {
    browser: true,
    es2022: true,
    jest: true,
  },
  extends: [
    "plugin:react/recommended",
    "plugin:react-hooks/recommended",
    "plugin:jsx-a11y/recommended",
    "airbnb",
    "plugin:react/jsx-runtime",
    "prettier",
  ],
  parserOptions: {
    ecmaFeatures: {
      jsx: true,
    },
    ecmaVersion: "latest",
    sourceType: "module",
  },
  plugins: ["react"],
  rules: {
    "global-require": "off",
    "import/no-extraneous-dependencies": 0,
    "jsx-a11y/label-has-associated-control": ["error", { assert: "either" }],
  },
};
