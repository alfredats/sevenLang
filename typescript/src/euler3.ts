
// this is an implementation of Pollard's Rho algo
export const largestPrimeFactor = (n: number): number => {
    // reduce number to an odd number
    let intermed : number = n
    const factors : Set<number> = new Set() 

    while (intermed % 2 === 0) {
        factors.add(2)
        intermed = intermed / 2
    }

    // generating non-2 prime factors 
    for (let i = 3; i < Math.sqrt(n); i ++) {
        
        if ( intermed % i === 0) {
            factors.add(i)
            intermed = intermed / i
        }
        if (intermed === 1) { // factorization is complete
           break 
        }
    }

    return Array.from(factors).slice(-1)[0]
}