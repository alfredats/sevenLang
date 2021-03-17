instrument(hendrix, guitar).
instrument(eddieVanHalen, guitar).
instrument(axelRose, guitar).
instrument(dukeEllington, piano).
instrument(theloniousMonk, piano).
instrument(louisArmstrong, trumpet).

genre(hendrix,rock).
genre(eddieVanHalen, rock).
genre(axelRose, rock).
genre(dukeEllington, jazz).
genre(theloniousMonk, jazz).
genre(louisArmstrong, jazz).


instrumentalists(Y,L) :- findall(X, instrument(X,Y), L).
