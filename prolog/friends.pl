likes(wallace,cheese). % these are facts. This line particularly reads like "wallace likes cheese".
likes(grommit,cheese).
likes(wendolene,sheep).

friend(X,Y) :- \+(X = Y),likes(X,Z),likes(Y,Z). % these are rules
% specifically, this rule is known as friend/2 (the friend rule with 2 parameters)
% it consists of 3 subgoals (X & Y cannot be the same, X must like Z, Y must like Z)
% all three must be true for this rule to be true
