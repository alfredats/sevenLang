smallest([Min],Min).
smallest([H1,H2|T],Min) :-
    H3 is min(H1,H2),
    smallest([H3|T],Min).
