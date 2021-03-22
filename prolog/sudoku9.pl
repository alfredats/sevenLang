:- use_module(library(clpfd)).

valid([]).
valid([H|T]) :-
    all_distinct(H),
    valid(T).

sudoku(Puzzle, Solution) :-
    Solution = Puzzle,
    Puzzle = [A1, A2, A3, A4, A5, A6, A7, A8, A9,
              B1, B2, B3, B4, B5, B6, B7, B8, B9,
              C1, C2, C3, C4, C5, C6, C7, C8, C9,
              D1, D2, D3, D4, D5, D6, D7, D8, D9,
              E1, E2, E3, E4, E5, E6, E7, E8, E9,
              F1, F2, F3, F4, F5, F6, F7, F8, F9,
              G1, G2, G3, G4, G5, G6, G7, G8, G9,
              H1, H2, H3, H4, H5, H6, H7, H8, H9,
              I1, I2, I3, I4, I5, I6, I7, I8, I9],

    Solution ins 1..9,

    Row1 = [A1, A2, A3, A4, A5, A6, A7, A8, A9],
    Row2 = [B1, B2, B3, B4, B5, B6, B7, B8, B9],
    Row3 = [C1, C2, C3, C4, C5, C6, C7, C8, C9],
    Row4 = [D1, D2, D3, D4, D5, D6, D7, D8, D9],
    Row5 = [E1, E2, E3, E4, E5, E6, E7, E8, E9],
    Row6 = [F1, F2, F3, F4, F5, F6, F7, F8, F9],
    Row7 = [G1, G2, G3, G4, G5, G6, G7, G8, G9],
    Row8 = [H1, H2, H3, H4, H5, H6, H7, H8, H9],
    Row9 = [I1, I2, I3, I4, I5, I6, I7, I8, I9],

    Col1 = [A1, B1, C1, D1, E1, F1, G1, H1, I1],
    Col2 = [A2, B2, C2, D2, E2, F2, G2, H2, I2],
    Col3 = [A3, B3, C3, D3, E3, F3, G3, H3, I3],
    Col4 = [A4, B4, C4, D4, E4, F4, G4, H4, I4],
    Col5 = [A5, B5, C5, D5, E5, F5, G5, H5, I5],
    Col6 = [A6, B6, C6, D6, E6, F6, G6, H6, I6],
    Col7 = [A7, B7, C7, D7, E7, F7, G7, H7, I7],
    Col8 = [A8, B8, C8, D8, E8, F8, G8, H8, I8],
    Col9 = [A9, B9, C9, D9, E9, F9, G9, H9, I9],

    Sqr1 = [A1, A2, A3, B1, B2, B3, C1, C2, C3],
    Sqr2 = [A4, A5, A6, B4, B5, B6, C4, C5, C6],
    Sqr3 = [A7, A8, A9, B7, B8, B9, C7, C8, C9],
    Sqr4 = [D1, D2, D3, E1, E2, E3, F1, F2, F3],
    Sqr5 = [D4, D5, D6, E4, E5, E6, F4, F5, F6],
    Sqr6 = [D7, D8, D9, E7, E8, E9, F7, F8, F9],
    Sqr7 = [G1, G2, G3, H1, H2, H3, I1, I2, I3],
    Sqr8 = [G4, G5, G6, H4, H5, H6, I4, I5, I6],
    Sqr9 = [G7, G8, G9, H7, H8, H9, I7, I8, I9],

    valid([Row1, Row2, Row3, Row4, Row5, Row6, Row7, Row8, Row9,
           Col1, Col2, Col3, Col4, Col5, Col6, Col7, Col8, Col9,
           Sqr1, Sqr2, Sqr3, Sqr4, Sqr5, Sqr6, Sqr7, Sqr8, Sqr9 ]).


printElms([], _, _) :- write('|'), write(' '), nl.
printElms([H|T],Count, Buffer) :-
    Sep is Count mod Buffer,
    (  Sep == 0
    -> write('|'), write(' ')
    ;  ! ),
    write(H), write(' '),
    NC is Count + 1,
    printElms(T,NC,Buffer).

print9(X) :-
    printElms(X,0,3).


printSudoku(X) :-
    printSudoku(X,0).
printSudoku([A,B,C,D,E,F,G,H,I|T],X) :-
    Sep is X mod 3,
    ( Sep == 0
    -> write('--------+-------+-------'), nl
    ; ! ),
    print9([A,B,C,D,E,F,G,H,I]),
    printSudoku(T, X + 1).

sudokuTest(X) :-
    sudoku([ 2, 1, 9, _, 4, 6, _, 3, _,
             _, _, 5, 1, _, _, _, _, _,
             _, 3, 4, _, _, _, 2, 6, _,
             _, 2, 6, _, _, 7, 5, _, 3,
             _, _, 1, _, 9, _, _, _, 7,
             4, 7, 3, _, 6, 5, _, _, 8,
             _, 6, _, 4, _, 2, 3, 1, _,
             3, 4, _, _, _, _, 7, 8, _,
             1, _, _, _, _, _, 4, 5, _ ],X),
    printSudoku(X),
    true.
