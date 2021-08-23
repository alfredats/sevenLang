import { sumUpToMultiplesOf } from './euler1.js'
import { sumEvenFibNumUpTo } from './euler2.js'
import { lowestCommonMultiple } from './euler5.js'

// question 1
const q1 = sumUpToMultiplesOf(1000, 3, 5)
console.log('q1: ', q1)


// question 2
const q2 = sumEvenFibNumUpTo(4000000)
console.log('q2: ', q2)

// question 5
const q5Arr: number[] = []
for (let i = 1; i < 20; i++ ) {
    q5Arr.push(i)
}
const q5 = lowestCommonMultiple(q5Arr)
console.log('q5: ', q5)