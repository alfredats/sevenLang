father(david, job).
father(job, michael).

% a rule can have multiple clauses
ancestor(X,Y) :-
    father(X,Y).
ancestor(X,Y) :-
    father(X,Z),
    ancestor(Z,Y).
