femme(mia).
femme(jody).
femme(yolande).
homme(vincent).
homme(pierre).
homme(marcellus).
animal(lapin).
animal(mon_chou).

aime(vincent,mia).
aime(vincent,pierre).
aime(marcellus,mia).
aime(mon_chou,lapin).
aime(lapin,mon_chou).

est_jaloux_de(X,Y) :- aime(X,Z),aime(Y,Z),Y\=X.
