// Implement Search functionality by hitting API
// https://dummyjson.com/products/search?q=phone *Tasks:* a. Create an Search box
// where in when the user can search for product form the above API with the user
// search keywords b. Show the retrieved products in a responsive table or grid
// with the Title, Category and Price Bonus: If the user Search persists
// over the URL state

// Declare an object
const response = {
  name: "Manu",
  age: 21,
  characteristics: {
    height: "6 feet",
  },
  techStack: {
    language: "Javascript",
    framework: {
      name: "Nextjs",
      version: "12",
    },
  },
};

const flattenObj = (response) => {
  let result = {};

  for (const i in response) {
    if (typeof response[i] === "object") {
      const temp = flattenObj(response[i]);
      for (const j in temp) {
        result[i + "." + j] = temp[j];
      }
    } else {
      result[i] = response[i];
    }
  }
  return result;
};

console.log(flattenObj(response));
