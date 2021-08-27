"use strict";
// This is a solution for project euler's question 5
Object.defineProperty(exports, "__esModule", { value: true });
exports.lcmArray = exports.genFactors = exports.lowestCommonMultiple = void 0;
// problem statement:
//  Given an array of numbers [x1, x2, ...], find their lowest common multiple
// example:
//  2520 is the lcm of [1, 2, 3, .., 10]
// general approach: 
//  Given an array [x1,x2,...]
//  1. initialize an array "factors", and an array "quotients"
//  2. while quotients is non-empty
//      2a. initialize an array "results"
//      2b. for each "elem" in [x1,x2,...]
//          2ai.   compute "quot = elem/i"
//          2aii.  if "quot" is whole, append "quot" to "results"
//          2aiii.   else, append "elem" to "results"
//      2c. if "results" == "quotients", increment i
//      2d. else, append i to "factors"
//  3. compute cumulative product of "factors""
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
// Trying out a different approach
function gcd(m, n) {
    // Compute gcd of 2 numbers via Euclid's algorithm
    while (n !== 0) {
        const i = m % n;
        m = n;
        n = i;
    }
    return m;
}
function lcm(m, n) {
    return Math.floor(m * n / gcd(m, n));
}
function lcmArray(nums) {
    if (nums.length === 0) {
        return 1;
    }
    else {
        const head = nums[0];
        const tail = nums.slice(1, nums.length);
        return lcm(head, lcmArray(tail));
    }
}
exports.lcmArray = lcmArray;
//# sourceMappingURL=euler5.js.map