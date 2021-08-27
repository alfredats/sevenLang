"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.largestPrimeFactor = void 0;
const largestPrimeFactor = (n) => {
    // reduce number to an odd number
    let intermed = n;
    const factors = new Set();
    while (intermed % 2 === 0) {
        factors.add(2);
        intermed = intermed / 2;
    }
    // generating new prime numbers, 
    for (let i = 3; i < Math.sqrt(n); i++) {
        if (intermed % i === 0) {
            factors.add(i);
            intermed = intermed / i;
        }
        if (intermed === 1) { // factorization is complete
            break;
        }
    }
    return Array.from(factors).slice(-1)[0];
};
exports.largestPrimeFactor = largestPrimeFactor;
//# sourceMappingURL=euler3.js.map