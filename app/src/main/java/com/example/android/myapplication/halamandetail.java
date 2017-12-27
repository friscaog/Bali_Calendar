package com.example.android.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class halamandetail extends AppCompatActivity{

    private String currentDateString;
    private Integer day, month, year;
    private List<String> nama;
    private List<String> hasil;
    private int wuku,inputbln=0,no_tri_wara,panca_wara,sapta_wara,urip_pancawara,urip_saptawara,jumlah_hari_global;
    private LinearLayoutManager layout;
    private PawukonAdapter pawukonAdater;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halamandetail);
        currentDateString = getIntent().getStringExtra("currentDateString");
        day = getIntent().getIntExtra("day",0);
        month = getIntent().getIntExtra("month",0) + 1;
        year = getIntent().getIntExtra("year",0);
        TextView tanggal = (TextView) findViewById(R.id.tanggal);
        tanggal.setText(currentDateString);
        nama = new ArrayList<>();
        hasil = new ArrayList<>();
        nama.add("Eka Wara");
        nama.add("Dwi Wara");
        nama.add("Tri Wara");
        nama.add("Catur Wara");
        nama.add("Panca Wara");
        nama.add("Sad Wara");
        nama.add("Sapta Wara");
        nama.add("Asta Wara");
        nama.add("Sanga Wara");
        nama.add("Dasa Wara");
        nama.add("Wuku");

        Toast.makeText(this, day+"-"+month+"-"+year, Toast.LENGTH_SHORT).show();

        if (day==0)
        {
            hasil.add("-");
            hasil.add("-");
            hasil.add("-");
            hasil.add("-");
            hasil.add("-");
            hasil.add("-");
            hasil.add("-");
            hasil.add("-");
            hasil.add("-");
            hasil.add("-");
            hasil.add("-");
            TextView ramalan = (TextView)findViewById(R.id.ramalan);
            ramalan.setText("-");
        }
        else
        {
            int jumlah_hari = 0;
            for(int i=1800;i<year;i++) jumlah_hari += cektahun(i);
            for(int i=1;i<month;i++) jumlah_hari += cekbulan(i,year);
            jumlah_hari += day;
            jumlah_hari_global=jumlah_hari;
            wuku=0;
            for (int i=5;i<=jumlah_hari;i+=7) wuku=wuku+1;
            jumlah_urip(jumlah_hari);

            hasil.add(eka_wara(jumlah_urip(jumlah_hari_global)));
            hasil.add(dwi_wara(jumlah_urip(jumlah_hari_global)));
            hasil.add(tri_wara(jumlah_hari_global));
            hasil.add(catur_wara(jumlah_hari_global));
            hasil.add(nama_panca_wara(jumlah_hari_global));
            hasil.add(sad_wara(jumlah_hari_global));
            hasil.add(nama_sapta_wara(jumlah_hari_global));
            hasil.add(asta_wara(jumlah_hari_global));
            hasil.add(sanga_wara(jumlah_hari_global));
            hasil.add(dasa_wara(jumlah_urip(jumlah_hari_global)));
            hasil.add(namawuku(wuku));
            TextView ramalan = (TextView)findViewById(R.id.ramalan);
            ramalan.setText(ramalan());
        }


        pawukonAdater = new PawukonAdapter(nama,hasil);
        layout = new LinearLayoutManager(this);
        recyclerView = (RecyclerView)findViewById(R.id.listPawukon);

        recyclerView.setLayoutManager(layout);
        recyclerView.setAdapter(pawukonAdater);

    }

    private String namawuku(int jumlah_hari)
    {
        String hasil = "";
        switch(jumlah_hari%30)
        {
            case 0 : hasil = "Pujut";
                wuku = 15;
                break;
            case 1 : hasil = "Pahang";
                wuku = 16;
                break;
            case 2 : hasil = "Klurut";
                wuku = 17;
                break;
            case 3 : hasil = "Merakih";
                wuku = 18;
                break;
            case 4 : hasil = "Tambir";
                wuku = 19;
                break;
            case 5 : hasil = "Medangkungan";
                wuku = 20;
                break;
            case 6 : hasil = "Matal";
                wuku = 21;
                break;
            case 7 : hasil = "Uye";
                wuku = 22;
                break;
            case 8 : hasil = "Menail";
                wuku = 23;
                break;
            case 9 : hasil = "Prangbakat";
                wuku = 24;
                break;
            case 10 : hasil = "Bala";
                wuku = 25;
                break;
            case 11 : hasil = "Ugu";
                wuku = 26;
                break;
            case 12 : hasil = "Wayang";
                wuku = 27;
                break;
            case 13 : hasil = "Kelawu";
                wuku = 28;
                break;
            case 14 : hasil = "Dukut";
                wuku = 29;
                break;
            case 15 : hasil = "Watugunung";
                wuku = 30;
                break;
            case 16 : hasil = "Sinta";
                wuku = 1;
                break;
            case 17 : hasil = "Landep";
                wuku = 2;
                break;
            case 18 : hasil = "Ukir";
                wuku = 3;
                break;
            case 19 : hasil = "Kulantir";
                wuku = 4;
                break;
            case 20 : hasil = "Tolu";
                wuku = 5;
                break;
            case 21 : hasil = "Gumbreg";
                wuku = 6;
                break;
            case 22 : hasil = "Wariga";
                wuku = 7;
                break;
            case 23 : hasil = "Warigadian";
                wuku = 8;
                break;
            case 24 : hasil = "Julungwangi";
                wuku = 9;
                break;
            case 25 : hasil = "Sungsang";
                wuku = 10;
                break;
            case 26 : hasil = "Dungulan";
                wuku = 11;
                break;
            case 27 : hasil = "Kuningan";
                wuku = 12;
                break;
            case 28 : hasil = "Langkir";
                wuku = 13;
                break;
            case 29 : hasil = "Medangsia";
                wuku = 14;
                break;
        }
        return hasil;
    }
    private int jumlah_urip(int jumlah_hari)
    {
        switch(jumlah_hari%5)
        {
            case 1: urip_pancawara=7;
                panca_wara=1;
                break;
            case 2: urip_pancawara=4;
                panca_wara=2;
                break;
            case 3: urip_pancawara=8;
                panca_wara=3;
                break;
            case 4: urip_pancawara=5;
                panca_wara=4;
                break;
            case 0: urip_pancawara=9;
                panca_wara=5;
                break;
        }
        switch(jumlah_hari%7)
        {
            case 1: sapta_wara=1;
                urip_saptawara=7;
                break;
            case 2: sapta_wara=2;
                urip_saptawara=8;
                break;
            case 3: sapta_wara=3;
                urip_saptawara=6;
                break;
            case 4: sapta_wara=4;
                urip_saptawara=9;
                break;
            case 5: sapta_wara=5;
                urip_saptawara=5;
                break;
            case 6: sapta_wara=6;
                urip_saptawara=4;
                break;
            case 0: sapta_wara=7;
                urip_saptawara=3;
                break;
        }
        return urip_pancawara+urip_saptawara;
    }
    private String eka_wara(int jumlah_urip)
    {
        String hasil = "";
        switch(jumlah_urip%2)
        {
            case 0 : hasil = "-";
                break;
            case 1 : hasil = "Luang";
                break;
        }
        return hasil;

    }
    private String dwi_wara(int jumlah_urip)
    {
        String hasil = "";
        switch(jumlah_urip%2)
        {
            case 0 : hasil = "Menga";
                break;
            case 1 : hasil = "Pepet";
                break;
        }
        return hasil;
    }

    private String tri_wara(int hari)
    {
        String hasil = "";
        switch(hari%3)
        {
            case 0 : hasil = "Beteng";
                no_tri_wara=1;
                break;
            case 1 : hasil = "Kajeng";
                no_tri_wara=2;
                break;
            case 2 : hasil = "Pasah";
                no_tri_wara=3;
                break;
        }

        return hasil;
    }

    private String catur_wara(int hari)
    {
        String hasil ="";
        int cek_catur_wara = 0;
        if(wuku<11)
        {
            if(wuku==10&&sapta_wara>=6)
            {
                if(sapta_wara==6)
                    cek_catur_wara=1;
                else if(sapta_wara==7)
                    cek_catur_wara=2;
            }
            else
            {
                switch(hari%4)
                {
                    case 0 : cek_catur_wara=3;
                        break;
                    case 1 : cek_catur_wara=4;
                        break;
                    case 2 : cek_catur_wara=1;
                        break;
                    case 3 : cek_catur_wara=2;
                        break;
                    default : cek_catur_wara=0;
                        break;
                }
            }

        }
        else if(wuku==11)
        {
            if(sapta_wara==1||sapta_wara==2||sapta_wara==3||sapta_wara==7)
                cek_catur_wara=3;
            else if(sapta_wara==4)
                cek_catur_wara=4;
            else if(sapta_wara==5)
                cek_catur_wara=1;
            else if(sapta_wara==6)
                cek_catur_wara=2;

        }
        else
        {
            switch(hari%4)
            {
                case 0 : cek_catur_wara=3;
                    break;
                case 1 : cek_catur_wara=4;
                    break;
                case 2 : cek_catur_wara=1;
                    break;
                case 3 : cek_catur_wara=2;
                    break;
                default : cek_catur_wara=0;
                    break;
            }
        }
        switch(cek_catur_wara)
        {
            case 1 : hasil = "Sri";
                break;
            case 2 : hasil = "Laba";
                break;
            case 3 : hasil = "Jaya";
                break;
            case 4 : hasil = "Menala";
                break;
        }
        return hasil;
    }

    private String nama_panca_wara(int jumlah_hari)
    {
        String hasil = "";
        switch(jumlah_hari%5)
        {
            case 1: hasil = "Pon";
                break;
            case 2: hasil = "Wage";
                break;
            case 3: hasil = "Kliwon";
                break;
            case 4: hasil = "Umanis";
                break;
            case 0: hasil = "Paing";
                break;
        }
        return hasil;
    }

    private String sad_wara(int jumlah_hari)
    {
        String hasil = "";
        switch(jumlah_hari%6)
        {
            case 1 : hasil = "Maulu";
                break;
            case 2 : hasil = "Tungleh";
                break;
            case 3 : hasil = "Aryang";
                break;
            case 4 : hasil = "Urukung";
                break;
            case 5 : hasil = "Paniron";
                break;
            case 0 : hasil = "Was";
                break;
        }
        return hasil;
    }

    private String nama_sapta_wara(int jumlah_hari)
    {
        String hasil = "";
        switch(jumlah_hari%7)
        {
            case 1: hasil = "Buda";
                break;
            case 2: hasil = "Wraspati";
                break;
            case 3: hasil = "Sukra";
                break;
            case 4: hasil = "Saniscara";
                break;
            case 5: hasil = "Redite";
                break;
            case 6: hasil = "Soma";
                break;
            case 0: hasil = "Anggara";
                break;
        }
        return hasil;
    }

    private String asta_wara(int hari)
    {
        String hasil = "";
        int cek_asta_wara = 0;
        if(wuku<11)
        {
            if(wuku==10&&sapta_wara>=6)
            {
                if(sapta_wara==6)
                    cek_asta_wara=5;
                else if(sapta_wara==7)
                    cek_asta_wara=6;
            }
            else
            {
                switch(hari%8)
                {
                    case 1 : cek_asta_wara=4;
                        break;
                    case 2 : cek_asta_wara=5;
                        break;
                    case 3 : cek_asta_wara=6;
                        break;
                    case 4 : cek_asta_wara=7;
                        break;
                    case 5 : cek_asta_wara=8;
                        break;
                    case 6 : cek_asta_wara=1;
                        break;
                    case 7 : cek_asta_wara=2;
                        break;
                    case 0 : cek_asta_wara=3;
                        break;
                    default : cek_asta_wara=0;
                        break;
                }
            }

        }
        else if(wuku==11)
        {
            if(sapta_wara==1||sapta_wara==2||sapta_wara==3)
                cek_asta_wara=7;
            else if(sapta_wara==4)
                cek_asta_wara=8;
        }
        else
        {
            switch(hari%8)
            {
                case 1 : cek_asta_wara=4;
                    break;
                case 2 : cek_asta_wara=5;
                    break;
                case 3 : cek_asta_wara=6;
                    break;
                case 4 : cek_asta_wara=7;
                    break;
                case 5 : cek_asta_wara=8;
                    break;
                case 6 : cek_asta_wara=1;
                    break;
                case 7 : cek_asta_wara=2;
                    break;
                case 0 : cek_asta_wara=3;
                    break;
                default : cek_asta_wara=0;
                    break;
            }
        }
        switch(cek_asta_wara)
        {
            case 1 : hasil = "Sri";
                break;
            case 2 : hasil = "Indra";
                break;
            case 3 : hasil = "Guru";
                break;
            case 4 : hasil = "Yama";
                break;
            case 5 : hasil = "Ludra";
                break;
            case 6 : hasil = "Brahma";
                break;
            case 7 : hasil = "Kala";
                break;
            case 8 : hasil = "Uma";
                break;
        }
        return hasil;
    }

    private String sanga_wara(int hari)
    {
        String hasil = "";
        int cek_sanga_wara = 0;
        if(wuku==1)
        {
            if(sapta_wara==1||sapta_wara==2||sapta_wara==3||sapta_wara==4)
                cek_sanga_wara=1;
            else if(sapta_wara==5)
                cek_sanga_wara=2;
            else if(sapta_wara==6)
                cek_sanga_wara=3;
            else if(sapta_wara==7)
                cek_sanga_wara=4;
        }
        else
        {
            switch(hari%9)
            {
                case 1 : cek_sanga_wara=6;
                    break;
                case 2 : cek_sanga_wara=7;
                    break;
                case 3 : cek_sanga_wara=8;
                    break;
                case 4 : cek_sanga_wara=9;
                    break;
                case 5 : cek_sanga_wara=1;
                    break;
                case 6 : cek_sanga_wara=2;
                    break;
                case 7 : cek_sanga_wara=3;
                    break;
                case 8 : cek_sanga_wara=4;
                    break;
                case 0 : cek_sanga_wara=5;
                    break;
                default : cek_sanga_wara=0;
                    break;
            }
        }
        switch(cek_sanga_wara)
        {
            case 1 : hasil = "Dangu";
                break;
            case 2 : hasil = "Jangur";
                break;
            case 3 : hasil = "Gigis";
                break;
            case 4 : hasil = "Nohan";
                break;
            case 5 : hasil = "Ogan";
                break;
            case 6 : hasil = "Erangan";
                break;
            case 7 : hasil = "Urungan";
                break;
            case 8 : hasil = "Tulus";
                break;
            case 9 : hasil = "Dadi";
                break;
        }
        return hasil;
    }

    private String dasa_wara(int jumlah_urip)
    {
        String hasil = "";
        switch(jumlah_urip%10)
        {
            case 1 : hasil = "Pati";
                break;
            case 2 : hasil = "Suka";
                break;
            case 3 : hasil = "Duka";
                break;
            case 4 : hasil = "Sri";
                break;
            case 5 : hasil = "Manuh";
                break;
            case 6 : hasil = "Manusa";
                break;
            case 7 : hasil = "Raja";
                break;
            case 8 : hasil = "Dewa";
                break;
            case 9 : hasil = "Raksasa";
                break;
            case 0 : hasil = "Pandita";
                break;
        }
        return hasil;
    }
    private int cektahun(int tahun)
    {
        int jmlhari;
        if(tahun%400==0)
            jmlhari=366;
        else if(tahun%100==0)
            jmlhari=365;
        else if(tahun%4==0)
            jmlhari=366;
        else
            jmlhari=365;

        return jmlhari;

    }

    private int cekbulan(int bulan, int tahun)
    {
        List<Integer> bln = new ArrayList<>();
        bln.add(31);
        bln.add(28);
        bln.add(31);
        bln.add(30);
        bln.add(31);
        bln.add(30);
        bln.add(31);
        bln.add(31);
        bln.add(30);
        bln.add(31);
        bln.add(30);
        bln.add(31);
        if(cektahun(tahun)==366)bln.set(1,29);
        return bln.get(bulan-1);
    }

    public String ramalan() {
        String hasil = "";
        switch (sapta_wara) {
            case 1://saptawara = buda = rabu
            {
                switch (panca_wara) {
                    case 1://pancawara = pon
                    {
                       hasil = "Dipengaruhi oleh bintang Lumbung, lakunya bumi, yaitu dalam penampilan pergaulannya sopan santun, hati - hati, waspada,"+
                       "berbudi baik, rejekinya baik, pintar bergaul dan gampang mencari teman, sembarang pekerjaan bisa, tidak mudah putus asa,"+
                       "tahan uji, rajin dalam pekerjaan yang dijalaninya, hanya saja suka pamer, baik kepintaran maupun kekayaannya. Suka"+
                       "dipuji tetapi mudah sekali tersinggung perasaannya.";

                    }
                    break;
                    case 2://pancawara = wage
                    {
                       hasil = "Dipengaruhi oleh bintang Kartika. Satria wibawa, berlaku ramah dalam pergaulan, adil dalam menengahi permasalahan,"+
                       "mengerti dengan harga dari uang sehingga sering dianggap pelit, padahal belum tentu demikian. Kelakuannya pantas"+
                       "dengan pembawaan pembicaraannya yang keras, hanya saja kadang - kadang janggal hatinya.";

                    }
                    break;
                    case 3://pancawara = kliwon
                    {
                       hasil = "Dipengaruhi oleh bintag Tiwa Tiwa, lakunya matahari, senang dipuji. Penampilan baik dalam pergaulan, pintar menyusun"+
                       "kata - kata, terutama dalam karangan. Apabila menghadapi sesuatu, memikirkannya sampai mendalam, telinganya tipis"+
                       "dengan mudah sekali merasa tersinggung, dan apabila terlibat dalam suatu pertengkaran menjadi rendah budinya.";
                    }
                    break;
                    case 4: //pancawara = umanis
                    {
                       hasil = "Dipegaruhi oleh bintang Tangis. Berkelakuan sopan, cepat mendapatkan teman, adil bijaksana, sering serta suka memberikan"+
                       "pertolongan sehingga suka pula mencampuri urusan orang lain yang mana kurang memikirkan dirinya sendiri, sering ditimpa"+
                       "kesedihan yang dapat merugikan diri sendiri.";
                    }
                    break;
                    case 5://pancawara = paing
                    {
                       hasil = "Dipengaruhi oleh bintang Gajah Mina. Perilakunya seperti air muka yang jernih, murah hati, tetapi tetap waspada serta"+
                       "menimbang dahulu segala persoalan, suatu sifat yang keras degan menampilkan penurutan hawa nafsunya, namun terkadang"+
                       "bersifat apatis.";
                    }
                    break;
                }
            }
            break;
            case 2://saptawara = wraspati = kamis
            {
                switch (panca_wara) {
                    case 1://pancawara = pon
                    {
                       hasil = "Dipengaruhi oleh bintang Bade, ramah, lemah lembut lembaganya, angan - angannya tinggi, selalu ingin menambah pengalaman"+
                       "dengan mantap mencari kemajuan lahir batin, senang pamer hasil - hasil yang dicapainya / miliknya. Namun apabila cita -"+
                       "citanya berhasil dengan sukses bisa mendapat bencana.";
                    }
                    break;
                    case 2://pancawara = wage
                    {
                       hasil = "Dipengaruhi oleh bintang Kumba, lakunya suatu perjodohan, kecocokan, gampang mencari kawan, dan disayangi oleh teman - temannya."+
                       "Idealis, namun waspada, dan memiliki kecepatan berpikir untuk mengarahkan suatu persoalan, tidak suka dikritik dan kebalikannya"+
                       "menyenangi sanjungan, tetapi ia merupakan seseorang yang keras hati. Apabila persoalannya belum / tidak selesai, dapat membuat"+
                       "perhitungan lain di belakang.";
                    }
                    break;
                    case 3://pancawara = kliwon
                    {
                       hasil = "Dipengaruhi oleh bintang Naga, lakunya air, merupakan orang yang pantang menyerah, teguh iman dengan cita - cita yang tinggi,"+
                       "banyak angan - angannya, berhati mulia, cara berpikirnya ulet, hanya saja telinganya tipis sehingga menyebabkan ia cepat"+
                       "tersinggung, dia berpengaruh dan disegani orang / bawahannya, sayangnya orang - orang ini umumnya agak pemalas.";
                    }
                    break;
                    case 4: //pancawara = umanis
                    {
                       hasil = "Dipengaruhi oleh bintang Sangka Tikel, perilakunya bintang, satria wibawa, tidak banyak bicara, memiliki kemauan yang"+
                       "keras, hanya saja setiap ide atau pekerjaannya jarang berhasil, berangan - angan tinggi, orang - orang ini pandai"+
                       "dalam mencari kawan, bijaksana, hanya saja suka ikut campur urusan orang lain tanpa diminta.";
                    }
                    break;
                    case 5://pancawara = paing
                    {
                       hasil = "Dipengaruhi oleh bintang Salah Ukur, berangan - angan tinggi, besar kemauannya untuk mencari kemajuan lahir batin,"+
                       "sering menjadi tempat berlidung orang yang sengsara, sanak saudaranya dekat / rukun dengannya, hanya sayangnya jika"+
                       "mengeluarkan alternatif berpikirnya menyinggung perasaan orang lain, ketus, dan salah menerka argumentasi lawan bicara.";
                    }
                    break;
                }
            }
            break;
            case 3://saptawara = sukra = jumat
            {
                switch (panca_wara) {
                    case 1://pancawara = pon
                    {
                       hasil = "Dipengaruhi oleh bintang Perahu Pegat, lakunya bintang, pendiam namun lembut hatinya, berkelakuan pantas, tepo seliro"+
                       "serta memiliki sifat tenggang rasa, suka pamer tetapi pikirannya goyah, sering berduka cita, bimbang dan kemauannya"+
                       "putus - putus.";

                    }
                    break;
                    case 2://pancawara = wage
                    {
                       hasil = "Dipengaruhi oleh bintang Magelut, lakunya pandita sakti, cerdas, pendiam, hatinya bersih / jujur, sering menjadi korban"+
                       "sanak saudaranya, keras dan kukuh pada pedirian yang kadang - kadang berakhir pada kesusahan.";
                    }
                    break;
                    case 3://pancawara = kliwon
                    {
                       hasil = "Dipengaruhi oleh bintang Udang, lakunya bulan, cara berpikirnya luas, penampilannya dalam pergaulan menyenangkan, pintar"+
                       "menyusun kata - kata, termasuk juga dalam penampilan seni sastranya. Sanggup dan mampu memimpin pekerjaan besar,"+
                       "diplomatis, pada waktu belum dewasa keadaannya agak kurang, keberhasilan diperoleh saat dewasa, segala pekerjaan ia"+
                       "pandai, juga dicintai orang, serta besar pengaruhnya, hanya saja sifat malas kadang - kadang menyelimutinya.";
                    }
                    break;
                    case 4: //pancawara = umanis
                    {
                       hasil = "Dipengaruhi oleh bintang Banyak Angrem, sifat kejujurannya lebih menonjol, berkelakuan pantas serta berterus terang, kebiasaan"+
                       "menolong orang lain menjadikan orang - orag yang lahir pada hari ini terpengaruh kepada pemberian cuma - cuma, tetapi"+
                       "disamping itu juga cenderung mencampuri urusan orang lain. Apabila tidak cocok dengan kemauannya, dapat menimbulkan keras hati"+
                       "hingga berakibat fatal, mengumbar bicara serta sering kecurian / kehilangan";
                    }
                    break;
                    case 5://pancawara = paing
                    {
                       hasil = "Dipengaruhi oleh bintang Bubu Boling, lakunya matahari, penampilan pergaulannya ramah tamah, lemah lembut tutur katanya,"+
                       "disenangi oleh orang - orang budiman, pintar menyusun kata - kata, hanya saja orang ini keras hati, bertelinga tipis,"+
                       "mudah tersinggung, mudah memiliki dan mudah kehilangan (boros).";
                    }
                    break;
                }
            }
            break;
            case 4: //saptawara = saniscara = sabtu
            {
                switch (panca_wara) {
                    case 1://pancawara = pon
                    {
                       hasil = "Dipengaruhi oleh bintang Srengenge, lakunya air, bercita - cita agung, banyak angan - angannya, suka pada kemewahan,"+
                       "senang pamer, mendapat perhatian orang agung, berpengaruh dan suka memberi ampun pada yang mengaku salah.";
                    }
                    break;
                    case 2://pancawara = wage
                    {
                       hasil = "Dipengaruhi oleh bintang Burung Puyuh Atarung, satria wibawa, senang mengatur hal - hal yang baik, pada umumnya"+
                       "dermawan kepada yang dapat mengambil hati, cemburu, dan kukuh dengan pendapatnya sendiri, sedangkan kalau sampai"+
                       "marah dan tidak tersalurkan dapat mengakibatkan sakit pada dirinya.";

                    }
                    break;
                    case 3://pancawara = kliwon
                    {
                       hasil = "Dipengaruhi oleh bintang Pegelangan, lakunya bumi, hati - hati dalam tindakannya, teratur dalam tata bahasanya"+
                       "terutama dalam karya sastranya, juga pengagum yang dianggapnya baik, jaang mau mengambil resiko yang menyebabkan"+
                       "ia cenderung apatis. Apabila tidak dapat menyelesaikan suatu pekerjaan atau persoalan maka akan menjadi putus"+
                       "asa.";
                    }
                    break;
                    case 4: //pancawara = umanis
                    {
                       hasil = "Dipengaruhi oleh bintang Bogong, lakunya bulan, sembarang pekerjaan ia pandai, luas cara berpikirnya, suka pada"+
                       "kemewahan, bisa menghargai pendapat orang lain, namun ia diselimuti dengan keras hati, kemauannya sukar dicegah, tajam"+
                       "bicaranya, suka campur tangan urusan orang lain, dan kadang - kadang mendapat fitnah.";
                    }
                    break;
                    case 5://pancawara = paing
                    {
                       hasil = "Dipengaruhi oleh bintang Ru, lakunya api, satria wibawa, cepat marah, namun tidak begitu mudah terburu nafsu dan mudah"+
                       "memberi maaf, serta pertimbangannya mantap. Mengerti dan berhati - hati dalam urusan uang, pintar mengurus rumah tangga,"+
                       "suka dengan pujian tetapi tidak suka diatasi.";
                    }
                    break;
                }
            }
            break;
            case 5://saptawara = redite = minggu
            {
                switch (panca_wara) {
                    case 1://pancawara = pon
                    {
                       hasil = "Dipengaruhi oleh bintang Patrem, lakunya bumi, wataknya tidak banyak bicara, terkadang terbawa emosi, pikirannya kurang"+
                       "terarah menghadapi persoalan, tetapi ia dapat menyembunyikan perasaan, suka berbicara berbelit - belit, serta memiliki"+
                       "kebiasaan pamer.";
                    }
                    break;
                    case 2://pancawara = wage
                    {
                       hasil = "Dipengaruhi oleh bintang Uluku / Tenggala, lakunya angin, dapat menerangi hati orang yang kesusahan, satria wibawa,"+
                       "suka bekerja keras, dermawan dan murah hati, tetapi sebaliknya berkeras hati pada orang yang menentang pendapatnya.";
                    }
                    break;
                    case 3://pancawara = kliwon
                    {
                       hasil = "Dipengaruhi oleh bintang Lawehan, lakunya bintang, pendiam tetapi lembut hatinya, memiliki kemauan yang keras, pintar"+
                       "menyusun kata - kata, diplomatis, mempunyai perasaan yang sulit ditebak dan kadang - kadang tinggal tak menetap.";
                    }
                    break;
                    case 4: //pancawara = umanis
                    {
                       hasil = "Dipengaruhi oleh bintang Kala Sungsang, lakunya pendita sakti, berwatak pendiam, cerdas, senang di bidang ilmu mistik,"+
                        "kadang - kadang cita - citanya tidak tercapai, tetapi namanya bisa terkenal karena karya sastranya. Mempunyai sifat"+
                       "pengampun, sanggup akan segala pekerjaan, tetapi bisa berpura - pura, terlihat baik secara lahiriah, karena pandai"+
                       "menyembunyikan perasaan hati yang sebenarnya dan kadang - kadang ingin memiliki banyak dengan tidak sadar akan"+
                       "kepentingan orang lain.";
                    }
                    break;
                    case 5://pancawara = paing
                    {
                       hasil = "Dipengaruhi oleh bintang Gajah, lakunya bulan, pandai dalam segala pekerjaan / tugas, selalu menyenangkan, luas"+
                       "pandangannya, sesuai dengan lakunya bulan menerangi pelajaran, dikasihi orang, pandai menyembunyikan perasaan,"+
                       "tetapi kukuh dengan pendapatnya diri, hanya saja sayangnya suka menuruti kemauannya sendiri yang bisa membawa"+
                       "kehidupan yang kurang beruntung.";
                    }
                    break;
                }
            }
            break;
            case 6://saptawara = soma = senin
            {
                switch (panca_wara) {
                    case 1://pancawara = pon
                    {
                       hasil = "Dipengaruhi oleh bintang Kiriman, lakunya sumur sinaba, suka dipuji - puji, senang pamer miliknya ataupun kepintarannya,"+
                       "namun keadaan sebenarnya tidaklah demikian. Sebenarnya ia baik budi, ingin berlaku ramah, sopan serta mengalah, tetapi"+
                       "cara penampilannya seperti orang keras hati, mempunyai kebiasaan ingin memiliki, yang kadang - kadang dengan melawan hak,"+
                       "karena sifat ini menyebabkan ia menjadi seorang pemberani. Apabila dengan sar=dar mereka mengetahui dan membaca sifat -"+
                       "sifat pemberani itu pada hal - hal yang berguna, maka kesuksesan bisa mereka capai.";
                    }
                    break;
                    case 2://pancawara = wage
                    {
                       hasil = "Dipengaruhi oleh bintang Lembu, lakunya api, hal ini menyebabkan ia lekas marah, namun tidak mudah terburu nafsu, segala"+
                       "persoalan ditimbangnya baik - baik, pada dasarnya jujur dan dapat mengerti kesusahan orang lain. Hanya keras bicaranya,"+
                       "dan kalau sudah marah maka susah untuk diredakan, sehingga akibatnya sering menimbulkan bencana.";
                    }
                    break;
                    case 3://pancawara = kliwon
                    {
                       hasil = "Dipengaruhi oleh bintang Pedati, lakunya suatu perjodohan / kecocokan, jadi mudah mendapatkan kasih sayang orang, pandai"+
                       "serta rajin bekerja, berkelakuan pantas, hanya saja mudah merasa tersinggung dan sakit hati, mudah marah tapi juga"+
                       "mudah memaafkan serta dengan mudah dapat melupakan rasa dendam, dan mempunyai suatu sifat yang senang berkorban.";
                    }
                    break;
                    case 4: //pancawara = umanis
                    {
                       hasil = "Dipengaruhi bintang Kelapa, lakunya angin, murah hati, mempunyai pembawaan sopan santun tetapi terkandung suka mencampuri"+
                       "urusan orang lain, senang berdebat untuk mempertahankan pendapatnya, dan merupakan orang yang senang merantau.";
                    }
                    break;
                    case 5://pancawara = paing
                    {
                       hasil = "Dipengaruhi bintang Kukus, lakunya bintang, kencang bicara namun lembut hatinya, berkelakuan pantas dan jujur, rajin"+
                       "bekerja, bercita - cita tinggi, hemat dan suka menabung. Orang yang lahir pada hari ini setia menepati janji, akan"+
                       "tetapi memiliki pendirian yang keras hati, dan telinga tipis.";
                    }
                    break;
                }
            }
            break;
            case 7://saptawara = anggara = selasa
            {
                switch (panca_wara) {
                    case 1://pancawara = pon
                    {
                       hasil = "Dipengaruhi oleh bintang Asu, lakunya pandita sakti, satria wibawa, berwatak keras pendiam, cerdas, mempercayai hal - hal yang"+
                       "irrasional, keras kemauannya, berlaku hati - hati, waspada, curiga, sanggup akan segala pekerjaannya, pantang mundur, hanya saja"+
                       "ingin memiliki materi banyak dengan tidak menghiraukan kepentingan orang lain.";
                    }
                    break;
                    case 2://pancawara = wage
                    {
                       hasil = "Dipengaruhi oleh bintang Jong Sarat, lakunya bumi, tidak banyak bicara, terkadang lekas marah, lalu pergi, gemar mencari kemajuan,"+
                       "mantap menyelidiki hal - hal yang dianggap penting, kerap kali menjadi tempat perlindungan orang - orang yang kelaraan, keras"+
                       "hatinya, mudah tersinggung, dan cemburu.";
                    }
                    break;
                    case 3://pancawara = kliwon
                    {
                       hasil = "Dipengaruhi oleh bintang Depat, mempunyai kepribadian yang lemah lembut, ramah tamah, supel dalam pergaulan, pintar menyusun kata -"+
                       "kata sehingga dapat menyenangkan para pendengarnya, murah hati hanya pada orang yang cocok dengan dirinya, kadang - kadang menjadi"+
                       "keras hati dan tidak mudah percaya pada orang lain, suka mengkoreksi kesalahan orang lain sehingga dihinggapi pikiran yang keruh dan"+
                       "mempunyai kesenangan pada perjudian.";
                    }
                    break;
                    case 4: //pancawara = umanis
                    {
                       hasil = "Dipengaruhi oleh bintang Kuda, lakunya api, cepat marah, pada dasarnya orang yang lahir pada hari ini berlaku jujur, gemar"+
                       "mencari kemajuan dengan mempunyai cita - cita tinggi. Terampil dalam pekerjaan, pendiriannya kuat, dan tidak suka mengalah,"+
                       "cemburu, dan sangat benci dengan yang menentang dirinya.";
                    }
                    break;
                    case 5://pancawara = paing
                    {
                       hasil = "Dipengaruhi oleh bintang Kepiting, lakunya suatu perjodohan / kecocokan, jadi mudah mendapatkan kasih sayang orang lai, gemar"+
                       "memberikan pertolongan kepada orang yang disukainya saja, rezekinya murah, kadang - kadang menjadi serakah dan tidak gampang"+
                       "percaya, pemarah, kadang - kadang sampai mata gelap sehingga kemudian bisa menimbulkan penyesalan pada dirinya.";
                    }
                    break;
                }
            }
            break;
        }
        return hasil;
    }
}