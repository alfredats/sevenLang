import { sumUpToMultiplesOf } from './euler1.js'
import { sumEvenFibNumUpTo } from './euler2.js'
import { largestPrimeFactor } from './euler3.js'
import { lowestCommonMultiple, lcmArray } from './euler5.js'


// TODO:
// figure out how to time my code

// question 1
const q1 = sumUpToMultiplesOf(1000, 3, 5)
console.log('q1: ', q1)


// question 2
const q2 = sumEvenFibNumUpTo(4000000)
console.log('q2: ', q2)

const q3 = largestPrimeFactor(600851475143)
console.log('q3: ', q3)


// question 5
const q5Arr: number[] = []
for (let i = 1; i < 20; i++ ) {
    q5Arr.push(i)
}
const q5 = lowestCommonMultiple(q5Arr)
console.log('q5: ', q5)
console.log('q5: ', lcmArray(q5Arr) )