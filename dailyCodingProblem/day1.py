# This problem was recently asked by Google.

# Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
# For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

# Bonus: Can you do this in one pass?

import unittest

def bruteforce(l:list, k:int): # Time: O(n^2), Space: O(1)

    for i in range(len(l)):
        left = l[i]
        for j in range(len(l)):
            if j == i:
                continue
            elif (left + l[j] == k):
                return True

    return False


def solution(l: list, k: int): # Time: O(n), Space: O(n)
    leftright = {}
    for i in l:
        if i in leftright.keys():
            return True
        else:
            leftright[k-i] = i

    return False


class TestDay1(unittest.TestCase):
    l1 = [10,15,3,7]
    k1 = 17
    l2 = [1,2,3,4]
    k2 = 99

    def test_bruteforce(self):
        self.assertEqual(bruteforce(self.l1,self.k1), True)
        self.assertEqual(bruteforce(self.l2,self.k2), False)

    def test_solution(self):
        self.assertTrue(solution(self.l1,self.k1))
        self.assertFalse(solution(self.l2,self.k2))

if __name__ == '__main__':
    unittest.main()
