bool(0).
bool(1).

p1(A,B,C,D,E) :- A=1,bool(A),bool(B),bool(C),bool(D),bool(E).
p1(A,B,C,D,E) :- B=1,bool(A),bool(B),bool(C),bool(D),bool(E).

p2(A,B,C,D,E) :- B=0,bool(A),bool(B),bool(C),bool(D),bool(E).
p2(A,B,C,D,E) :- C=1,bool(A),bool(B),bool(C),bool(D),bool(E).
p2(A,B,C,D,E) :- D=0,bool(A),bool(B),bool(C),bool(D),bool(E).

p3(A,B,C,D,E) :- D=1,bool(A),bool(B),bool(C),bool(D),bool(E).
p3(A,B,C,D,E) :- E=0,bool(A),bool(B),bool(C),bool(D),bool(E).

r(A,B,C,D,E) :- p1(A,B,C,D,E),p2(A,B,C,D,E),p3(A,B,C,D,E).
%-----------
sat(A,B,C,D,E) :- r(A,B,C,D,E),bool(A),bool(B),bool(C),bool(D),bool(E).
