% nama variabel berdasarkan jawaban soal dan no soal
% soal no 1

a1 = [10 20 30 40];
b1 = [-5 -15 -40];
c1 = [1 3 5 0;3 1 3 5;5 3 2 3;0 5 3 1];

% soal no 2

a2 = [1 2 3;4 5 6;7 8 -9];
c2 = [2;-5.5;-49];
b2 = inv(a2)*c2;

b2

% soal no 3

M3 = [10 20;5 8]; N3 = [-1 1;1 -1];

a3 = M3+N3
b3 = M3-N3
c3 = N3+9
d3 = M3*N3
f3 = N3*M3

% soal no 4

A4 = [0 5 5]; B4 = [1 1 1];

a4 = dot(A4,B4)
b4 = A4.*B4
c4 = B4.*A4

% soal no 5

A5 = [4 8;2 4]; B5 = [1 1;1 -1];

C5 = [A5 B5]
W5 = [B5 B5;B5 B5]

% soal no 6

identitas = eye(4)
nol = zeros(4)
satu = ones(4)

% soal no 7

vektor = sqrt(0.2)*randn(1,100)+1

% soal no 8

x8 = -10:10
y8 = linspace(7.5,0,16)
z8 = 1:3:100
% w8 = 

% soal no 9

M9 = [1 5 10 15 20;1 2 4 8 16;-3 0 3 6 9;32 16 8 4 2;5 -5 5 -5 5];

a9 = M9(1,:)
b9 = M9(:,3)
c9 = M9(3:5,2:4)
d9 = diag(M9)

% soal no 10

N10 = M9(:,1:4)

a10 = fliplr(N10)
b10 = flipud(N10)
c10 = reshape(N10,10,2)
d10 = reshape(N10,4,5)