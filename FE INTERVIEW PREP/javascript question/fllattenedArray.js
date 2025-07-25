let arr = [
  [1, 2],
  [3, 4],
  [5, [6, 7]],
];

let flattened = [].concat(...arr);
console.log(flattened); // Output: [1, 2, 3, 4, 5, [6, 7]]

console.log(arr.flat(2));

function customFlat(arr, depth = 1) {
  let result = [];
  arr.forEach((arr) => {
    if (Array.isArray(arr) && depth > 0) {
      result.push(...customFlat(arr, depth - 1));
    }
    result.push(arr);
  });
  return result;
}

console.log(customFlat(arr)); // Output: [1, 2, 3, 4, 5, 6, 7]
