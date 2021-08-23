"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const euler1_js_1 = require("./euler1.js");
const euler2_js_1 = require("./euler2.js");
const euler5_js_1 = require("./euler5.js");
// question 1
const q1 = euler1_js_1.sumUpToMultiplesOf(1000, 3, 5);
console.log('q1: ', q1);
// question 2
const q2 = euler2_js_1.sumEvenFibNumUpTo(4000000);
console.log('q2: ', q2);
// question 5
const q5Arr = [];
for (let i = 1; i < 20; i++) {
    q5Arr.push(i);
}
const q5 = euler5_js_1.lowestCommonMultiple(q5Arr);
console.log('q5: ', q5);
//# sourceMappingURL=index.js.map