# This problem was asked by Uber.

# Given an array of integers, return a new array such that each element 
# at index i of the new array is the product of all the numbers in the 
# original array except the one at i.

# For example, if our input was [1, 2, 3, 4, 5], the expected output 
# would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the 
# expected output would be [2, 3, 6].

# Follow-up: what if you can't use division?

import unittest
import copy

class TestDay2(unittest.TestCase):
    l1 = [1,2,3,4,5]
    a1 = [120,60,40,30,24]
    l2 = [3,2,1]
    a2 = [2,3,6]
    l3 = [1]
    a3 = [1]

    def test_solution(self):
        self.assertEqual(solution(self.l1), self.a1)
        self.assertEqual(solution(self.l2), self.a2)
        self.assertEqual(solution(self.l3), self.a3)

    def test_noDiv(self):
        self.assertEqual(noDiv(self.l1), self.a1)
        self.assertEqual(noDiv(self.l2), self.a2)
        self.assertEqual(noDiv(self.l3), self.a3)

    def test_noDiv_recursive(self):
        c1 = copy.copy(self.l1)
        noDiv_recursive(c1, len(c1))
        self.assertEqual(c1, self.a1)
        c2 = copy.copy(self.l2)
        noDiv_recursive(c2, len(c2))
        self.assertEqual(c2, self.a2)
        c3 = copy.copy(self.l3)
        noDiv_recursive(c3, len(c3))
        self.assertEqual(c3, self.a3)

def solution(l):
    # Pseudo-code
    #   1) Calculate cumulative multiple of array, store in "cumprod"
    #   2) Construct new array "output"
    #   3) For each element in l,
    #       3a) Append quotient of cumprod & element into output
    #   4) Done

    # Complexity analysis:
    #   Time: O(2n) ~> O(n)
    #   Space: O(n)
    
    cumprod = 1
    for elem in l:
        cumprod *= elem

    output = []
    for elem in l:
        output.append(cumprod/elem)

    return output

def noDiv(l):
    # Crux:
    #   The cumulative sum (excluding the element itself can be expressed
    #   as such:
    #       [a[1]*a[2], a[0]*a[2], a[0]*a[1]]
    #   We decompose the above into two arrays, top & bottom
    #       [1,             a[0],       a[0]*a[1]]
    #       [a[1]*a[2],     a[2],       1        ]
    #   Therefore, by getting the two solutions & computing the products
    #   element-wise, we can get our answer
    
    n = len(l)
    top = [1] * n
    bot = [1] * n

    for i in range(1,n):
        top[i] = top[i-1] * l[i-1]
    for j in reversed(range(n-1)):
        bot[j] = bot[j+1] * l[j+1]

    output = []
    for k in range(n):
        output.append(top[k]*bot[k])

    return output

def noDiv_recursive(l, n, left=1, i=0):
    if i == n:
        return 1

    curr = l[i]

    right = noDiv_recursive(l,n,left*l[i],i+1)

    l[i] = left*right

    return curr*right


if __name__ == "__main__":
    unittest.main()
