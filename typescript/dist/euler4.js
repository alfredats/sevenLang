"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.findLargestPalindrome = exports.zipArrays = exports.Tuple = exports.isPalindrome = void 0;
const isPalindrome = (n) => {
    const nStr = n.toString();
    const len = nStr.length;
    const timesToCheck = Math.floor(len / 2);
    for (let i = 0; i < timesToCheck; i++) {
        if (nStr[i] !== nStr[len - 1 - i]) {
            return false;
        }
    }
    return true;
};
exports.isPalindrome = isPalindrome;
class Tuple {
    constructor(left, right) {
        this.left = left;
        this.right = right;
    }
}
exports.Tuple = Tuple;
const zipArrays = (arr1, arr2) => {
    const zipped = [];
    arr1.forEach((val1) => {
        arr2.forEach((val2) => {
            const tup = new Tuple(val1, val2);
            zipped.push(tup);
        });
    });
    return zipped;
};
exports.zipArrays = zipArrays;
const findLargestPalindrome = (n) => {
    const uppLim = (10 ** n) - 1;
    let lowLim = 10 ** (n - 1);
    let curr = 0;
    for (let x = uppLim; x >= lowLim; x--) {
        for (let y = uppLim; y >= lowLim; y--) {
            const xy = x * y;
            if ((0, exports.isPalindrome)(xy) && xy > curr) {
                lowLim = y;
                curr = xy;
            }
        }
    }
    return curr;
};
exports.findLargestPalindrome = findLargestPalindrome;
//# sourceMappingURL=euler4.js.map