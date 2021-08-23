// This is a solution for project euler's problem 1

// Problem statement: Given some number n, and an array of numbers [x1, x2, ...], 
//                    calculate the sum of all multiples of the array elements from 0 to n

// Example given: 
//  With n = 10, and [x1, x2] = [3, 5], the multiples of 3 or 5 that are less than 10
//  are 3, 5, 6, and 9. The sum of these multiples is 23.

// Problem consists of 2 parts:
//  - identifying multiples
//  - summing them up

// edge cases:
//  - n <= 0
//  - n <= some x in array
//  - empty array
//  - n in array


export function sumUpToMultiplesOf(n: number, ...multiplesOf: number[]): number {
  const multiples = findMultiplesOf(n, multiplesOf)   
  const cumsum = (acc: number, currVal: number): number => acc + currVal
  return multiples.reduce(cumsum)
}


const isMultiple = (currNum: number, arrElem: number): boolean => (currNum % arrElem) === 0 

// naive solution: linear search
export function findMultiplesOf(n: number, multiplesOf: number[]): number[] {
  let iHasMultiples: number[]
  const theMultiples: number[] = []

  for (let i = 1; i < n; i++) {
    iHasMultiples = multiplesOf.filter(arrElem => isMultiple(i, arrElem))
    if (iHasMultiples.length !== 0) {
      theMultiples.push(i)
    }
  }
  return theMultiples
}
// complexity breakdown: 
//  l35: loop over n -> O(n)
//  l36: loop over multiplesOf -> O(m)
//
// => complexity of "findMultiplesOf": O(mn) with m = size(multiplesOf)