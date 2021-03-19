% base cases
fibonacci(0,0).
fibonacci(1,1).

% general recursive case.
fibonacci(N,X) :-
    N > 1,
    succ(N1,N),
    succ(N2,N1),
    fibonacci(N1,S1),
    fibonacci(N2,S2),
    X is S1+S2.
