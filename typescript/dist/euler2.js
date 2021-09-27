'use strict';
Object.defineProperty(exports, "__esModule", { value: true });
exports.generateFibonacci = exports.sumEvenFibNumUpTo = void 0;
// This is a solution for project euler's question 2
// Question Statement:
//  Considering the terms in the fibonacci seq up to 4 million, find
//  the sum of the even-valued terms
// Approach:
//  0. initialize empty arr
//  1. generate fibonacci numbers 
//  2. if fibNum is even
//      2a. add fibnum to arr
//  3. sum over arr
// Edge cases:
function sumEvenFibNumUpTo(n) {
    return allEvenFibNumUpTo(n).reduce((acc, currVal) => acc + currVal);
}
exports.sumEvenFibNumUpTo = sumEvenFibNumUpTo;
function* generateFibonacci(prev, next) {
    let temp = 0;
    while (true) {
        yield (prev + next);
        temp = prev;
        prev = next;
        next = temp + prev;
    }
}
exports.generateFibonacci = generateFibonacci;
function allEvenFibNumUpTo(n) {
    const arr = [];
    const fibgen = generateFibonacci(1, 1);
    let next;
    do {
        next = fibgen.next().value;
        if ((next % 2) === 0) {
            arr.push(next);
        }
    } while (next < n);
    return arr;
}
//# sourceMappingURL=euler2.js.map