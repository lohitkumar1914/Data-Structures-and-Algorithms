// function a() {
//   for (var i = 0; i < 3; i++) {
//     setTimeout(function log() {
//       console.log(i);
//     }, 1000 * i);
//   }
// }

// a();

function aWithClousers() {
  for (var i = 0; i < 3; i++) {
    (function (j) {
      setTimeout(function log() {
        console.log(j + 1);
      }, 1000 * j);
    })(i);
  }
}

aWithClousers();
