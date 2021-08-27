"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const euler1_js_1 = require("./euler1.js");
const euler2_js_1 = require("./euler2.js");
const euler3_js_1 = require("./euler3.js");
const euler4_js_1 = require("./euler4.js");
const euler5_js_1 = require("./euler5.js");
// TODO:
// figure out how to time my code
// question 1
const q1 = (0, euler1_js_1.sumUpToMultiplesOf)(1000, 3, 5);
console.log('q1: ', q1);
// question 2
const q2 = (0, euler2_js_1.sumEvenFibNumUpTo)(4000000);
console.log('q2: ', q2);
// question 3
const q3 = (0, euler3_js_1.largestPrimeFactor)(600851475143);
console.log('q3: ', q3);
// question 4
const q4 = (0, euler4_js_1.findLargestPalindrome)(3);
console.log('q4: ', q4);
// question 5
const q5Arr = Array.from(Array(10), (_, i) => i + 1);
const q5 = (0, euler5_js_1.lowestCommonMultiple)(q5Arr);
console.log('q5: ', q5);
console.log('q5: ', (0, euler5_js_1.lcmArray)(q5Arr));
//# sourceMappingURL=index.js.map