author(norwegianWood,murakami).
author(oneQ84, murakami).
author(colorlessTsukuru, murakami).
author(neverLetMeGo, ishiguro).
author(devotionOfSuspectX, higashino).
author(doAndroidsDreamOfElectricSheep, philipKdick).

books(Y,L) :- findall(X, author(X,Y), L).
