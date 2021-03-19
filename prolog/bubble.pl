bubblesort([H1,H2|T],Sorted) :-
    do_bsort([H2|T],[H1], Sorted).

do_bsort([],SL,SL).
do_bsort(SL,[],SL).
do_bsort([H|T],[H2|T2],SL) :-
    H =< H2,
    do_bsort(T,[H,H2|T2],SL).
do_bsort([H|T],[H2|T2],SL) :-
    H > H2,
    do_bsort([H],T2,TN), % bruh im stuck
    do_bsort(T,[H2|TN],SL).
