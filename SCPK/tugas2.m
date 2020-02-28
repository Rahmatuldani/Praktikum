% no 4
p4 = 5;
l4 = 3;
t4 = 6.5;

luas4 = 2*(p4*l4 + p4*t4 + l4*t4)
volume4 = p4*l4*t4

% no 5
p5 = input('panjang : ');
l5 = input('lebar : ');
t5 = input('tinggi : ');

luas5 = 2*(p5*l5 + p5*t5 + l5*t5)
volume5 = p5*l5*t5

% no 6
batas = input('Masukkan Angka = ');
a=1;
for i = 0:batas-1
    for j =0:i
        if(j ==0||i==j)
            a=1;
        else
            a=a*(i+1-j)/j;
        end
        fprintf('%d ',a);
    end
    disp(' ');
end

% no 7
awal = input('Masukan awal tgl-bln-thn : ','s');
akhir = input('Masukan akhir tgl-bln-thn : ','s');

mulai = datetime(awal,'InputFormat','dd-MM-yy');
selesai = datetime(akhir,'InputFormat','dd-MM-yy');

jumlah_hari = -1*(datenum(mulai)-datenum(selesai))