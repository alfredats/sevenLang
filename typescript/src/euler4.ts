export const isPalindrome = (n: number): boolean => {
    const nStr = n.toString()
    const len = nStr.length
    const timesToCheck = Math.floor(len / 2)

    for (let i = 0; i < timesToCheck; i++) {
        if (nStr[i] !== nStr[len - 1 - i]) {
            return false
        }
    }
    return true
}

export const findLargestPalindrome = (n: number): number => {
    const uppLim = (10 ** n) - 1
    let lowLim = 10 ** (n - 1)
    let curr = 0

    for (let x = uppLim; x >= lowLim; x--){
        for (let y = uppLim; y >= lowLim; y--) {
            const xy = x * y 
            if (isPalindrome(xy) && xy > curr) {
                lowLim = y
                curr = xy
            }
        }
    }

    return curr 
}




// My intial approach was going to generate an array of tuples 
// from the cartesian product of [999...100] with itself, then traverse 
// through the tuples, computing the products and checking if they were palindromes
// but i realised it wasn't as effecient.

export class Tuple<L, R> {
    left: L
    right: R

    constructor(left: L, right: R) {
        this.left = left;
        this.right = right;
    }
}

export const zipArrays = (arr1: Array<number>, arr2: Array<number>): Array<Tuple<number, number>> => {
    const zipped : Array<Tuple<number,number>> = []
    arr1.forEach((val1) => {
        arr2.forEach((val2) => {
            const tup = new Tuple(val1, val2)
            zipped.push(tup)
        })
    })

    return zipped
}