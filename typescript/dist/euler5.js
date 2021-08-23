"use strict";
// This is a solution for project euler's question 5
Object.defineProperty(exports, "__esModule", { value: true });
exports.genFactors = exports.lowestCommonMultiple = void 0;
// problem statement:
//  Given an array of numbers [x1, x2, ...], find their lowest common multiple
// example:
//  2520 is the lcm of [1, 2, 3, .., 10]
// general approach: 
//  1. initialize an array "factors"
//  2. for i = 1; i < ulim; i++
//      2a. for each elem in [x1,x2,...]
//          2ai.    initialize an array called "result"
//          2aii.   compute quot = elem/i
//          2aiii.  if quot is whole, append quot to "result"
//          2aiv.   else, append elem to result
//      2b. if array is unchanged after 2a, increment i
//      2c. else, append i to "factors"
//  3. compute cumulative product of "factors"
function lowestCommonMultiple(nums) {
    const factgen = genFactors(nums);
    let lcm = 1;
    let result = factgen.next();
    while (!result.done) {
        lcm = lcm * result.value;
        result = factgen.next();
    }
    return lcm;
}
exports.lowestCommonMultiple = lowestCommonMultiple;
// Man, this took 4 hours to get working...
// I am not proud of the for loop within the do-while loop
function* genFactors(numArr) {
    // 
    let temp = numArr;
    let num = 2;
    do {
        const quots = [];
        for (let i = 0; i < temp.length; i++) {
            const quot = temp[i] / num;
            if (quot % 1 === 0) {
                quots.push(quot);
            }
            else {
                quots.push(temp[i]);
            }
        }
        if (JSON.stringify(quots) === JSON.stringify(temp)) { // in js, `[1] === [1]` yields `false`
            num++;
        }
        else {
            yield num;
        }
        temp = quots.filter((val) => val > 1);
    } while (temp.length > 0);
}
exports.genFactors = genFactors;
//# sourceMappingURL=euler5.js.map