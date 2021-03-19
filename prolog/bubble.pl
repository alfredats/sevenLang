bubblesort([H|T],Sorted) :-
    bubblesort([H|T],[H], Sorted).

bubblesort([],SL,SL).
bubblesort([H|T],[H2|T2],SL) :-
    H =< H2,
    bubblesort(T,[H,H2|T2],SL).
bubblesort([H|T],[H2|T2],SL) :-
    H > H2,
    bubblesort([H],T2,TN),
    bubblesort(T,[H2|TN],SL).
