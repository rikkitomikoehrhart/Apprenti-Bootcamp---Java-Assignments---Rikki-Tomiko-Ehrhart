const book = {
    title: "JavaScript Basics",
        author: {
            name: "John Doe",
            social: {
                twitter: "@johndoe"
        }
    },
    edition: {
        year: 1990,
    },
};

// Use optional chaining to access the Twitter handle
console.log(book.author?.social?.twitter);
// Try accessing a non-existent property using optional chaining
console.log(book.publisher?.name);

console.log(book.edition?.year)