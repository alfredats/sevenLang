import { sumUpToMultiplesOf } from './euler1.js'
import { sumEvenFibNumUpTo } from './euler2.js'
import { largestPrimeFactor } from './euler3.js'
import { findLargestPalindrome } from './euler4.js'
import { lowestCommonMultiple, lcmArray } from './euler5.js'


// TODO:
// figure out how to time my code

// question 1
const q1 = sumUpToMultiplesOf(1000, 3, 5)
console.log('q1: ', q1)


// question 2
const q2 = sumEvenFibNumUpTo(4000000)
console.log('q2: ', q2)

// question 3
const q3 = largestPrimeFactor(600851475143)
console.log('q3: ', q3)

// question 4
const q4 = findLargestPalindrome(3)
console.log('q4: ', q4)


// question 5
const q5Arr = Array.from(Array(10), (_,i) => i + 1)
const q5 = lowestCommonMultiple(q5Arr)
console.log('q5: ', q5)
console.log('q5: ', lcmArray(q5Arr) )