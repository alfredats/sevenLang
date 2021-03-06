:- use_module(library(clpfd)).
:- debug.

valid([]).
valid([H|T]) :-
    all_distinct(H),
    valid(T).

sudoku(Puzzle, Solution) :-
    Solution = Puzzle,
    Puzzle = [S11, S12, S13, S14,
              S21, S22, S23, S24,
              S31, S32, S33, S34,
              S41, S42, S43, S44],

    Solution ins 1..4,

    Row1 = [S11, S12, S13, S14],
    Row2 = [S21, S22, S23, S24],
    Row3 = [S31, S32, S33, S34],
    Row4 = [S41, S42, S43, S44],

    Col1 = [S11, S21, S31, S41],
    Col2 = [S12, S22, S32, S42],
    Col3 = [S13, S23, S33, S43],
    Col4 = [S14, S24, S34, S44],

    Sq1  = [S11, S12, S21, S22],
    Sq2  = [S13, S14, S23, S24],
    Sq3  = [S31, S32, S41, S42],
    Sq4  = [S33, S34, S43, S44],

    valid([Row1, Row2, Row3, Row4,
           Col1, Col2, Col3, Col4,
           Sq1,  Sq2,  Sq3,  Sq4  ]).


print4([A,B,C,D]) :-
   write('|'), write(A), write(' '), write(B), write(' '), write(C), write(' '), write(D), write('|').

printSudoku([]) :-
    nl.
printSudoku([H, I, J, K|T]) :-
    print4([H,I,J,K]),
    nl,
    printSudoku(T).

sudokuTest(X) :-
    sudoku([_, _, 2, 3,
            _, _, _, _,
            _, _, _, _,
            3, 4, _, _],X),
    printSudoku(X).
