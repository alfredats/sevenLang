import { sumUpToMultiplesOf } from '../src/euler1'
import { sumEvenFibNumUpTo } from '../src/euler2'
import { largestPrimeFactor } from '../src/euler3'
import { lowestCommonMultiple, lcmArray } from '../src/euler5'


// TODO:
// figure out how to time my code

// question 1
test("Q1 returns 23 for all natural numbers below 10", () => {
    const out = sumUpToMultiplesOf(10, 3, 5)
    expect(out).toBe(23)
})

// question 2
test("Q2 returns 19 for all fibonacci numbers < 10 that are even", () => {
    const out = sumEvenFibNumUpTo(10)
    expect(out).toBe(10)
})

// q3
test("Q3 returns 29 for largest prime factor of 13195", () => {
    const q3 = largestPrimeFactor(13195)
    expect(q3).toBe(29)
})

// q5
test("Q5 returns 2520 as lcm of Array.from(Array(10),(_,i) => i", () =>{
    const q5Arr = Array.from(Array(10), (_,i) => i+1)
    const q5b = lcmArray(q5Arr)
    expect(q5b).toBe(2520)
})

test("Both methods for Q5 returns same value", () =>{
    const q5Arr = Array.from(Array(10), (_,i) => i+1)
    const q5a = lowestCommonMultiple(q5Arr)
    const q5b = lcmArray(q5Arr)
    expect(q5b).toBe(q5a)
})