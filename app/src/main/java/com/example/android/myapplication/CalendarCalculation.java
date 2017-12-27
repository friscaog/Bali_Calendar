package com.example.android.myapplication;

/**
 * Created by Prana on 21-Dec-17.
 */

public class CalendarCalculation
{
    public void HariTotal(int day, int month, int year)//fungsi input & pemaggilan fungsi
    {
        int i,InputTahun=0,InputBulan=0,InputTanggal=0,JumlahHari=0,JumlahWuku=0;
        for(i=1800;i<year;i++) JumlahHari += TanggalTahun(i);//tahun dimulai dari 1800, InputTahun = variabel tahun "sekarang"
        for(i=1;i<month;i++) JumlahHari += TanggalBulan(i,InputTahun);//InputBulan = variabel bulan "sekarang"
        JumlahHari += day;//IndpuTanggal = variabel tanggal "sekarang"
        for (i=5;i<=JumlahHari;i+=7) JumlahWuku=JumlahWuku+1;//pergantian wuku tiap minggu, siklus 30 minggu
    }

    public int TanggalTahun(int tahun)
    {
        if(tahun%400==0) return 366;
        else if(tahun%100==0) return 365;
        else if(tahun%4==0) return 366;
        else return 365;
    }

    public int TanggalBulan(int bulan, int InputTahun)
    {
        int bln[] ={31,28,31,30,31,30,31,31,30,31,30,31};
        if(TanggalTahun(InputTahun)==366) bln[1]=29;//kabisat
        return bln[bulan-1];
    }

    public int UripPancawara(int JumlahHari)
    {
        switch(JumlahHari%5)
        {
            case 1: return 7;
            case 2: return 4;
            case 3: return 8;
            case 4: return 5;
            case 0: return 9;
            default:return 0;
        }
    }

    public int UripSaptawara(int JumlahHari)
    {
        switch(JumlahHari%7)
        {
            case 1: return 7;
            case 2: return 8;
            case 3: return 6;
            case 4: return 9;
            case 5: return 5;
            case 6: return 4;
            case 0: return 3;
            default: return 0;
        }
    }

    public int wuku(int JumlahWuku)
    {
        switch(JumlahWuku%30)
        {
            case 16 : return 1;//sinta
            case 17 : return 2;//landep
            case 18 : return 3;//ukir
            case 19 : return 4;//kulantir
            case 20 : return 5;//tolu
            case 21 : return 6;//gumbreg
            case 22 : return 7;//wariga
            case 23 : return 8;//warigadian
            case 24 : return 9;//julungwangi
            case 25 : return 10;//sungsang
            case 26 : return 11;//dungulan
            case 27 : return 12;//kuningan
            case 28 : return 13;//langkir
            case 29 : return 14;//medangsia
            case 0 : return 15;//pujut
            case 1 : return 16;//pahang
            case 2 : return 17;//klurut
            case 3 : return 18;//merakih
            case 4 : return 19;//tambir
            case 5 : return 20;//medangkungan
            case 6 : return 21;//matal
            case 7 : return 22;//uye
            case 8 : return 23;//menail
            case 9 : return 24;//prangbakat
            case 10 : return 25;//bala
            case 11 : return 26;//ugu
            case 12 : return 27;//wayang
            case 13 : return 28;//kelawu
            case 14 : return 29;//dukut
            case 15 : return 30;//watugunung
            default : return 0;
        }
    }

    public int ekawara(int JumlahHari)
    {
        switch((UripPancawara(JumlahHari)+UripSaptawara(JumlahHari))%2)
        {
            case 0 : return 1;//ekawara=tidak ada
            case 1 : return 2;//ekawara=luang
            default : return 0;
        }
    }

    public int dwiwara(int JumlahHari)
    {
        switch((UripPancawara(JumlahHari)+UripSaptawara(JumlahHari))%2)
        {
            case 0 : return 1;//dwiwara=menga
            case 1 : return 2;//dwiwara=pepet
            default : return 0;
        }
    }

    public int triwara(int JumlahHari)
    {
        switch(JumlahHari%3)
        {
            case 0 : return 1;//triwara=beteng
            case 1 : return 2;//triwara=kajeng
            case 2 : return 3;//triwara=pasah
            default : return 0;
        }
    }

    public int caturwara(int JumlahHari, int JumlahWuku)
    {
        int wk=wuku(JumlahWuku), sw=saptawara(JumlahHari);
        if(wk<11)
        {
            if(wk==10&&sw>=6)
            {
                if(sw==6) return 1;//caturwara=sri
                else if(sw==7) return 2;//caturwara=laba
            }
            else
            {
                switch(JumlahHari%4)
                {
                    case 0 : return 3;//caturwara=jaya
                    case 1 : return 4;//caturwara=menala
                    case 2 : return 1;//caturwara=sri
                    case 3 : return 2;//caturwara=laba
                    default : return 0;//error
                }
            }

        }
        else if(wk==11)//wuku=dungulan
        {
            if(sw<=3||sw==7) return 3;//caturwara=jaya
            else if(sw==4) return 4;//caturwara=menala
            else if(sw==5) return 1;//caturwara=sri
            else if(sw==6) return 2;//caturwara=laba

        }
        else
        {
            switch(JumlahHari%4)
            {
                case 0 : return 3;//caturwara=jaya
                case 1 : return 4;//caturwara=menala
                case 2 : return 1;//caturwara=sri
                case 3 : return 2;//caturwara=laba
                default : return 0;//error
            }
        }
        return 0;
    }

    public int pancawara(int JumlahHari)
    {
        switch(JumlahHari%5)
        {
            case 1: return 1;//pancawara=pon
            case 2: return 2;//pancawara=wage
            case 3: return 3;//pancawara=kliwon
            case 4: return 4;//pancawara=umanis
            case 0: return 5;//pancawara=paing
            default: return 0;

        }
    }

    public int sadwara(int JumlahHari)
    {
        switch(JumlahHari%6)
        {
            case 1 : return 1;//sadwara=maulu
            case 2 : return 2;//sadwara=tungleh
            case 3 : return 3;//sadwara=aryang
            case 4 : return 4;//sadwara=urukung
            case 5 : return 5;//sadwara=paniron
            case 0 : return 6;//sadwara=was
            default : return 0;
        }
    }

    public int saptawara(int JumlahHari)
    {
        switch(JumlahHari%7)
        {
            case 1: return 1;//saptawara=buda
            case 2: return 2;//saptawara=wraspati
            case 3: return 3;//saptawara=sukra
            case 4: return 4;//saptawara=saniscara
            case 5: return 5;//saptawara=redite
            case 6: return 6;//saptawara=soma
            case 0: return 7;//saptawara=anggara
            default: return 0;
        }
    }

    public int astawara(int JumlahHari, int JumlahWuku)
    {
        int wk=wuku(JumlahWuku),sw=saptawara(JumlahHari);//wk=wuku, sw=saptawara
        if(wk<11)//wuku sebelum dungulan
        {
            if(wk==10&&sw>=6)
            {
                if(sw==6)
                    return 5;//astawara=ludra
                else if(sw==7)
                    return 6;//astawara=brahma
            }
            else
            {
                switch(JumlahHari%8)
                {
                    case 1 : return 4;//astawara=yama
                    case 2 : return 5;//astawara=ludra
                    case 3 : return 6;//astawara=brahma
                    case 4 : return 7;//astawara=kala
                    case 5 : return 8;//astawara=uma
                    case 6 : return 1;//astawara=sri
                    case 7 : return 2;//astawara=indra
                    case 0 : return 3;//astawara=guru
                    default : return 0;
                }
            }

        }
        else if(wk==11)
        {
            if(sw<=3&&sw>0)
                return 7;//astawara=kala
            else if(sw==4)
                return 8;//astawara=uma
        }
        else
        {
            switch(JumlahHari%8)
            {
                case 1 : return 4;//astawara=yama
                case 2 : return 5;//astawara=ludra
                case 3 : return 6;//astawara=brahma
                case 4 : return 7;//astawara=kala
                case 5 : return 8;//astawara=uma
                case 6 : return 1;//astawara=sri
                case 7 : return 2;//astawara=indra
                case 0 : return 3;//astawara=guru
                default : return 0;
            }
        }
        return 0;
    }

    public int sangawara(int JumlahHari,int JumlahWuku)
    {
        int  wk=wuku(JumlahWuku), sw=saptawara(JumlahHari);
        if(wk==1)//wuku=sinta
        {
            if(sw<=4&&sw>0)  return 1;//sangawara=dangu
            else if(sw==5) return 2;//sangawara=jangur
            else if(sw==6) return 3;//sangawara=gigis
            else if(sw==7) return 4;//sangawara=nohan
        }
        else
        {
            switch(JumlahHari%9)
            {
                case 1 : return 6;//sangawara=erangan
                case 2 : return 7;//sangawara=urungan
                case 3 : return 8;//sangawara=tulus
                case 4 : return 9;//sangawara=dadi
                case 5 : return 1;//sangawara=dangu
                case 6 : return 2;//sangawara=jangur
                case 7 : return 3;//sangawara=gigis
                case 8 : return 4;//sangawara=nohan
                case 0 : return 5;//sangawara=ogan
                default : return 0;
            }
        }
        return 0;
    }

    public int dasawara(int JumlahHari)
    {
        switch((UripPancawara(JumlahHari)+UripSaptawara(JumlahHari))%10)
        {
            case 1 : return 1;//dasawara=pati
            case 2 : return 2;//dasawara=suka
            case 3 : return 3;//dasawara=duka
            case 4 : return 4;//dasawara=sri
            case 5 : return 5;//dasawara=manuh
            case 6 : return 6;//dasawara=manusa
            case 7 : return 7;//dasawara=raja
            case 8 : return 8;//dasawara=dewa
            case 9 : return 9;//dasawara=raksasa
            case 0 : return 10;//dasawara=pandita
            default : return 0;
        }
    }

    public String ramalan(int JumlahHari)
    {
        switch(saptawara(JumlahHari))
        {
            case 1 ://saptawara = buda = rabu
            {
                switch(pancawara(JumlahHari))
                {
                    case 1 ://pancawara = pon
                    {
                       /*
                       Dipengaruhi oleh bintang Lumbung, lakunya bumi, yaitu dalam penampilan pergaulannya sopan santun, hati - hati, waspada,
                       berbudi baik, rejekinya baik, pintar bergaul dan gampang mencari teman, sembarang pekerjaan bisa, tidak mudah putus asa,
                       tahan uji, rajin dalam pekerjaan yang dijalaninya, hanya saja suka pamer, baik kepintaran maupun kekayaannya. Suka
                       dipuji tetapi mudah sekali tersinggung perasaannya.
                       */
                    }break;
                    case 2 ://pancawara = wage
                    {
                       /*
                       Dipengaruhi oleh bintang Kartika. Satria wibawa, berlaku ramah dalam pergaulan, adil dalam menengahi permasalahan,
                       mengerti dengan harga dari uang sehingga sering dianggap pelit, padahal belum tentu demikian. Kelakuannya pantas
                       dengan pembawaan pembicaraannya yang keras, hanya saja kadang - kadang janggal hatinya.
                       */
                    }break;
                    case 3 ://pancawara = kliwon
                    {
                       /*
                       Dipengaruhi oleh bintag Tiwa Tiwa, lakunya matahari, senang dipuji. Penampilan baik dalam pergaulan, pintar menyusun
                       kata - kata, terutama dalam karangan. Apabila menghadapi sesuatu, memikirkannya sampai mendalam, telinganya tipis
                       dengan mudah sekali merasa tersinggung, dan apabila terlibat dalam suatu pertengkaran menjadi rendah budinya.
                       */
                    }break;
                    case 4 : //pancawara = umanis
                    {
                       /*
                       Dipegaruhi oleh bintang Tangis. Berkelakuan sopan, cepat mendapatkan teman, adil bijaksana, sering serta suka memberikan
                       pertolongan sehingga suka pula mencampuri urusan orang lain yang mana kurang memikirkan dirinya sendiri, sering ditimpa
                       kesedihan yang dapat merugikan diri sendiri.
                       */
                    }break;
                    case 5 ://pancawara = paing
                    {
                       /*
                       Dipengaruhi oleh bintang Gajah Mina. Perilakunya seperti air muka yang jernih, murah hati, tetapi tetap waspada serta
                       menimbang dahulu segala persoalan, suatu sifat yang keras degan menampilkan penurutan hawa nafsunya, namun terkadag
                       bersifat apatis.
                       */
                    }break;
                }
            }break;
            case 2 ://saptawara = wraspati = kamis
            {
                switch(pancawara(JumlahHari))
                {
                    case 1 ://pancawara = pon
                    {
                       /*
                       Dipengaruhi oleh bintang Bade, ramah, lemah lembut lembaganya, angan - angannya tinggi, selalu ingin menambah pengalaman
                       dengan mantap mencari kemajuan lahir batin, senang pamer hasil - hasil yang dicapainya / miliknya. Namun apabila cita -
                       citanya berhasil dengan sukses bisa mendapat bencana.
                       */
                    }break;
                    case 2 ://pancawara = wage
                    {
                       /*
                       Dipengaruhi oleh bintang Kumba, lakunya suatu perjodohan, kecocokan, gampang mencari kawan, dan disayangi oleh teman - temannya.
                       Idealis, namun waspada, dan memiliki kecepatan berpikir untuk mengarahkan suatu persoalan, tidak suka dikritik dan kebalikannya
                       menyenangi sanjungan, tetapi ia merupakan seseorang yang keras hati. Apabila persoalannya belum / tidak selesai, dapat membuat
                       perhitungan lain di belakang.
                       */
                    }break;
                    case 3 ://pancawara = kliwon
                    {
                       /*
                       Dipengaruhi oleh bintang Naga, lakunya air, merupakan orang yang pantang menyerah, teguh iman dengan cita - cita yang tinggi,
                       banyak angan - angannya, berhati mulia, cara berpikirnya ulet, hanya saja telinganya tipis sehingga menyebabkan ia cepat
                       tersinggung, dia berpengaruh dan disegani orang / bawahannya, sayangnya orang - orang ini umumnya agak pemalas.
                       */
                    }break;
                    case 4 : //pancawara = umanis
                    {
                       /*
                       Dipengaruhi oleh bintang Sangka Tikel, perilakunya bintang, satria wibawa, tidak banyak bicara, memiliki kemauan yang
                       keras, hanya saja setiap ide atau pekerjaannya jarang berhasil, berangan - angan tinggi, orang - orang ini pandai
                       dalam mencari kawan, bijaksana, hanya saja suka ikut campur urusan orang lain tanpa diminta.
                       */
                    }break;
                    case 5 ://pancawara = paing
                    {
                       /*
                       Dipengaruhi oleh bintang Salah Ukur, berangan - angan tinggi, besar kemauannya untuk mencari kemajuan lahir batin,
                       sering menjadi tempat berlidung orang yang sengsara, sanak saudaranya dekat / rukun dengannya, hanya sayangnya jika
                       mengeluarkan alternatif berpikirnya menyinggung perasaan orang lain, ketus, dan salah menerka argumentasi lawan bicara.

                       */
                    }break;
                }
            }break;
            case 3 ://saptawara = sukra = jumat
            {
                switch(pancawara(JumlahHari))
                {
                    case 1 ://pancawara = pon
                    {
                       /*
                       Dipengaruhi oleh bintang Perahu Pegat, lakunya bintang, pendiam namun lembut hatinya, berkelakuan pantas, tepo seliro
                       serta memiliki sifat tenggang rasa, suka pamer tetapi pikirannya goyah, sering berduka cita, bimbang dan kemauannya
                       putus - putus.
                       */
                    }break;
                    case 2 ://pancawara = wage
                    {
                       /*
                       Dipengaruhi oleh bintang Magelut, lakunya pandita sakti, cerdas, pendiam, hatinya bersih / jujur, sering menjadi korban
                       sanak saudaranya, keras dan kukuh pada pedirian yang kadang - kadang berakhir pada kesusahan.
                       */
                    }break;
                    case 3 ://pancawara = kliwon
                    {
                       /*
                       Dipengaruhi oleh bintang Udang, lakunya bulan, cara berpikirnya luas, penampilannya dalam pergaulan menyenangkan, pintar
                       menyusun kata - kata, termasuk juga dalam penampilan seni sastranya. Sanggup dan mampu memimpin pekerjaan besar,
                       diplomatis, pada waktu belum dewasa keadaannya agak kurang, keberhasilan diperoleh saat dewasa, segala pekerjaan ia
                       pandai, juga dicintai orang, serta besar pengaruhnya, hanya saja sifat malas kadang - kadang menyelimutinya.
                       */
                    }break;
                    case 4 : //pancawara = umanis
                    {
                       /*
                       Dipengaruhi oleh bintang Banyak Angrem, sifat kejujurannya lebih menonjol, berkelakuan pantas serta berterus terang, kebiasaan
                       menolong orang lain menjadikan orang - orag yang lahir pada hari ini terpengaruh kepada pemberian cuma - cuma, tetapi
                       disamping itu juga cenderung mencampuri urusan orang lain. Apabila tidak cocok dengan kemauannya, dapat menimbulkan keras hati
                       hingga berakibat fatal, mengumbar bicara serta sering kecurian / kehilangan
                       */
                    }break;
                    case 5 ://pancawara = paing
                    {
                       /*
                       Dipengaruhi oleh bintang Bubu Boling, lakunya matahari, penampilan pergaulannya ramah tamah, lemah lembut tutur katanya,
                       disenangi oleh orang - orang budiman, pintar menyusun kata - kata, hanya saja orang ini keras hati, bertelinga tipis,
                       mudah tersinggung, mudah memiliki dan mudah kehilangan (boros).
                       */
                    }break;
                }
            }break;
            case 4 : //saptawara = saniscara = sabtu
            {
                switch(pancawara(JumlahHari))
                {
                    case 1 ://pancawara = pon
                    {
                       /*
                       Dipengaruhi oleh bintang Srengenge, lakunya air, bercita - cita agung, banyak angan - angannya, suka pada kemewahan,
                       senang pamer, mendapat perhatian orang agung, berpengaruh dan suka memberi ampun pada yang mengaku salah.
                       */
                    }break;
                    case 2 ://pancawara = wage
                    {
                       /*
                       Dipengaruhi oleh bintang Burung Puyuh Atarung, satria wibawa, senang mengatur hal - hal yang baik, pada umumnya
                       dermawan kepada yang dapat mengambil hati, cemburu, dan kukuh dengan pendapatnya sendiri, sedangkan kalau sampai
                       marah dan tidak tersalurkan dapat mengakibatkan sakit pada dirinya.
                       */
                    }break;
                    case 3 ://pancawara = kliwon
                    {
                       /*
                       Dipengaruhi oleh bintang Pegelangan, lakunya bumi, hati - hati dalam tindakannya, teratur dalam tata bahasanya
                       terutama dalam karya sastranya, juga pengagum yang dianggapnya baik, jaang mau mengambil resiko yang menyebabkan
                       ia cenderung apatis. Apabila tidak dapat menyelesaikan suatu pekerjaan atau persoalan maka akan menjadi putus
                       asa.
                       */
                    }break;
                    case 4 : //pancawara = umanis
                    {
                       /*
                       Dipengaruhi oleh bintang Bogong, lakunya bulan, sembarang pekerjaan ia pandai, luas cara berpikirnya, suka pada
                       kemewahan, bisa menghargai pendapat orang lain, namun ia diselimuti dengan keras hati, kemauannya sukar dicegah, tajam
                       bicaranya, suka campur tangan urusan orang lain, dan kadang - kadang mendapat fitnah.
                       */
                    }break;
                    case 5 ://pancawara = paing
                    {
                       /*
                       Dipengaruhi oleh bintang Ru, lakunya api, satria wibawa, cepat marah, namun tidak begitu mudah terburu nafsu dan mudah
                       memberi maaf, serta pertimbangannya mantap. Mengerti dan berhati - hati dalam urusan uang, pintar mengurus rumah tangga,
                       suka dengan pujian tetapi tidak suka diatasi.
                       */
                    }break;
                }
            }break;
            case 5 ://saptawara = redite = minggu
            {
                switch(pancawara(JumlahHari))
                {
                    case 1 ://pancawara = pon
                    {
                       /*
                       Dipengaruhi oleh bintang Patrem, lakunya bumi, wataknya tidak banyak bicara, terkadang terbawa emosi, pikirannya kurang
                       terarah menghadapi persoalan, tetapi ia dapat menyembunyikan perasaan, suka berbicara berbelit - belit, serta memiliki
                       kebiasaan pamer.
                       */
                    }break;
                    case 2 ://pancawara = wage
                    {
                       /*
                       Dipengaruhi oleh bintang Uluku / Tenggala, lakunya angin, dapat menerangi hati orang yang kesusahan, satria wibawa,
                       suka bekerja keras, dermawan dan murah hati, tetapi sebaliknya berkeras hati pada orang yang menentang pendapatnya.
                       */
                    }break;
                    case 3 ://pancawara = kliwon
                    {
                       /*
                       Dipengaruhi oleh bintang Lawehan, lakunya bintang, pendiam tetapi lembut hatinya, memiliki kemauan yang keras, pintar
                       menyusun kata - kata, diplomatis, mempunyai perasaan yang sulit ditebak dan kadang - kadang tinggal tak menetap.
                       */
                    }break;
                    case 4 : //pancawara = umanis
                    {
                       /*
                       Dipengaruhi oleh bintang Kala Sungsang, lakunya pendita sakti, berwatak pendiam, cerdas, senang di bidang ilmu mistik,
                       kadang - kadang cita - citanya tidak tercapai, tetapi namanya bisa terkenal karena karya sastranya. Mempunyai sifat
                       pengampun, sanggup akan segala pekerjaan, tetapi bisa berpura - pura, terlihat baik secara lahiriah, karena pandai
                       menyembunyikan perasaan hati yang sebenarnya dan kadang - kadang ingin memiliki banyak dengan tidak sadar akan
                       kepentingan orang lain.
                       */
                    }break;
                    case 5 ://pancawara = paing
                    {
                       /*
                       Dipengaruhi oleh bintang Gajah, lakunya bulan, pandai dalam segala pekerjaan / tugas, selalu menyenangkan, luas
                       pandangannya, sesuai dengan lakunya bulan menerangi pelajaran, dikasihi orang, pandai menyembunyikan perasaan,
                       tetapi kukuh dengan pendapatnya diri, hanya saja sayangnya suka menuruti kemauannya sendiri yang bisa membawa
                       kehidupan yang kurang beruntung.
                       */
                    }break;
                }
            }break;
            case 6 ://saptawara = soma = senin
            {
                switch(pancawara(JumlahHari))
                {
                    case 1 ://pancawara = pon
                    {
                       /*
                       Dipengaruhi oleh bintang Kiriman, lakunya sumur sinaba, suka dipuji - puji, senang pamer miliknya ataupun kepintarannya,
                       namun keadaan sebenarnya tidaklah demikian. Sebenarnya ia baik budi, ingin berlaku ramah, sopan serta mengalah, tetapi
                       cara penampilannya seperti orang keras hati, mempunyai kebiasaan ingin memiliki, yang kadang - kadang dengan melawan hak,
                       karena sifat ini menyebabkan ia menjadi seorang pemberani. Apabila dengan sar=dar mereka mengetahui dan membaca sifat -
                       sifat pemberani itu pada hal - hal yang berguna, maka kesuksesan bisa mereka capai.
                       */
                    }break;
                    case 2 ://pancawara = wage
                    {
                       /*
                       Dipengaruhi oleh bintang Lembu, lakunya api, hal ini menyebabkan ia lekas marah, namun tidak mudah terburu nafsu, segala
                       persoalan ditimbangnya baik - baik, pada dasarnya jujur dan dapat mengerti kesusahan orang lain. Hanya keras bicaranya,
                       dan kalau sudah marah maka susah untuk diredakan, sehingga akibatnya sering menimbulkan bencana.
                       */
                    }break;
                    case 3 ://pancawara = kliwon
                    {
                       /*
                       Dipengaruhi oleh bintang Pedati, lakunya suatu perjodohan / kecocokan, jadi mudah mendapatkan kasih sayang orang, pandai
                       serta rajin bekerja, berkelakuan pantas, hanya saja mudah merasa tersinggung dan sakit hati, mudah marah tapi juga
                       mudah memaafkan serta dengan mudah dapat melupakan rasa dendam, dan mempunyai suatu sifat yang senang berkorban.
                       */
                    }break;
                    case 4 : //pancawara = umanis
                    {
                       /*
                       Dipengaruhi bintang Kelapa, lakunya angin, murah hati, mempunyai pembawaan sopan santun tetapi terkandung suka mencampuri
                       urusan orang lain, senang berdebat untuk mempertahankan pendapatnya, dan merupakan orang yang senang merantau.
                       */
                    }break;
                    case 5 ://pancawara = paing
                    {
                       /*
                       Dipengaruhi bintang Kukus, lakunya bintang, kencang bicara namun lembut hatinya, berkelakuan pantas dan jujur, rajin
                       bekerja, bercita - cita tinggi, hemat dan suka menabung. Orang yang lahir pada hari ini setia menepati janji, akan
                       tetapi memiliki pendirian yang keras hati, dan telinga tipis.
                       */
                    }break;
                }
            }break;
            case 7 ://saptawara = anggara = selasa
            {
                switch(pancawara(JumlahHari))
                {
                    case 1 ://pancawara = pon
                    {
                       /*
                       Dipengaruhi oleh bintang Asu, lakunya pandita sakti, satria wibawa, berwatak keras pendiam, cerdas, mempercayai hal - hal yang
                       irrasional, keras kemauannya, berlaku hati - hati, waspada, curiga, sanggup akan segala pekerjaannya, pantang mundur, hanya saja
                       ingin memiliki materi banyak dengan tidak menghiraukan kepentingan orang lain.
                       */
                    }break;
                    case 2 ://pancawara = wage
                    {
                       /*
                       Dipengaruhi oleh bintang Jong Sarat, lakunya bumi, tidak banyak bicara, terkadang lekas marah, lalu pergi, gemar mencari kemajuan,
                       mantap menyelidiki hal - hal yang dianggap penting, kerap kali menjadi tempat perlindungan orang - orang yang kelaraan, keras
                       hatinya, mudah tersinggung, dan cemburu.
                       */
                    }break;
                    case 3 ://pancawara = kliwon
                    {
                       /*
                       Dipengaruhi oleh bintang Depat, mempunyai kepribadian yang lemah lembut, ramah tamah, supel dalam pergaulan, pintar menyusun kata -
                       kata sehingga dapat menyenangkan para pendengarnya, murah hati hanya pada orang yang cocok dengan dirinya, kadang - kadang menjadi
                       keras hati dan tidak mudah percaya pada orang lain, suka mengkoreksi kesalahan orang lain sehingga dihinggapi pikiran yang keruh dan
                       mempunyai kesenangan pada perjudian.
                       */
                    }break;
                    case 4 : //pancawara = umanis
                    {
                       /*
                       Dipengaruhi oleh bintang Kuda, lakunya api, cepat marah, pada dasarnya orang yang lahir pada hari ini berlaku jujur, gemar
                       mencari kemajuan dengan mempunyai cita - cita tinggi. Terampil dalam pekerjaan, pendiriannya kuat, dan tidak suka mengalah,
                       cemburu, dan sangat benci dengan yang menentang dirinya.
                       */
                    }break;
                    case 5 ://pancawara = paing
                    {
                       /*
                       Dipengaruhi oleh bintang Kepiting, lakunya suatu perjodohan / kecocokan, jadi mudah mendapatkan kasih sayang orang lai, gemar
                       memberikan pertolongan kepada orang yang disukainya saja, rezekinya murah, kadang - kadang menjadi serakah dan tidak gampang
                       percaya, pemarah, kadang - kadang sampai mata gelap sehingga kemudian bisa menimbulkan penyesalan pada dirinya.
                       */
                    }break;
                }
            }break;
        }
    }

    public String wukuTampilan(int JumlahWuku)
    {
        switch(wuku(JumlahWuku))
        {
            case 1 :
            {
                //tampilkan sinta
            }break;
            case 2 :
            {
                //tampilkan landep
            }break;
            case 3 :
            {
                //tampilkan ukir
            }break;
            case 4 :
            {
                //tampilkan kulantir
            }break;
            case 5 :
            {
                //tampilkan tolu
            }break;
            case 6 :
            {
                //tampilkan gumbreg
            }break;
            case 7 :
            {
                //tampilkan wariga
            }break;
            case 8 :
            {
                //tampilkan warigadian
            }break;
            case 9 :
            {
                //tampilkan julungwangi
            }break;
            case 10 :
            {
                //tampilkan sungsang
            }break;
            case 11:
            {
                //tampilkan dungulan
            }break;
            case 12 :
            {
                //tampilkan kuningan
            }break;
            case 13 :
            {
                //tampilkan langkir
            }break;
            case 14 :
            {
                //tampilkan medangsia
            }break;
            case 15 :
            {
                //tampilkan pujut
            }break;
            case 16 :
            {
                //tampilkan pahang
            }break;
            case 17 :
            {
                //tampilkan klurut
            }break;
            case 18 :
            {
                //tampilkan merakih
            }break;
            case 19 :
            {
                //tampilkan tambir
            }break;
            case 20 :
            {
                //tampilkan medangkungan
            }break;
            case 21 :
            {
                //tampilkan matal
            }break;
            case 22 :
            {
                //tampilkan uye
            }break;
            case 23 :
            {
                //tampilkan menail
            }break;
            case 24 :
            {
                //tampilkan prangbakat
            }break;
            case 25 :
            {
                //tampilkan bala
            }break;
            case 26 :
            {
                //tampilkan ugu
            }break;
            case 27 :
            {
                //tampilkan wayang
            }break;
            case 28 :
            {
                //tampilkan kelawu
            }break;
            case 29 :
            {
                //tampilkan dukut
            }break;
            case 30 :
            {
                //tampilkan watugunung
            }break;
        }
    }

    public String ekawaraTampilan(int JumlahHari)
    {
        switch (ekawara(JumlahHari)) {
            case 1: {
                return "-";
                //tampilkan -
            }
            break;
            case 2: {
                return "Luang";
                //tampilkan luang
            }
            break;
        }
        return null;
    }

    public String dwiwaraTampilan(int JumlahHari)
    {
        switch(dwiwara(JumlahHari))
        {
            case 1 :
            {
                //tampilkan menga
            }break;
            case 2 :
            {
                //tampilkan pepet
            }break;
        }
    }

    public String triwaraTampilan(int JumlahHari)
    {
        switch(triwara(JumlahHari))
        {
            case 1 :
            {
                //tampilkan beteng
            }break;
            case 2 :
            {
                //tampilkan kajeng
            }break;
            case 3 :
            {
                //tampilkan pasah
            }break;
        }
    }

    public String caturwaraTampilan(int JumlahHari, int JumlahWuku)
    {
        switch(caturwara(JumlahHari,JumlahWuku))
        {
            case 1 :
            {
                //tampilkan sri
            }break;
            case 2 :
            {
                //tampilkan jaya
            }break;
            case 3 :
            {
                //tampilkan laba
            }break;
            case 4 :
            {
                //tampilkan menala
            }break;
        }
    }

    public String pancawaraTampilan(int JumlahHari)
    {
        switch (pancawara(JumlahHari))
        {
            case 1 :
            {
                //tampilkan pon
            }break;
            case 2 :
            {
                //tampilkan wage
            }break;
            case 3 :
            {
                //tampilkan kliwon
            }break;
            case 4 :
            {
                //tampilkan umanis
            }break;
            case 5 :
            {
                //tampilkan pahing
            }break;
        }
    }

    public String sadwaraTampilan (int JumlahHari)
    {
        switch(sadwara(JumlahHari))
        {
            case 1 :
            {
                //tampilkan maulu
            }break;
            case 2 :
            {
                //tampilkan tungleh
            }break;
            case 3 :
            {
                //tampilkan aryang
            }break;
            case 4 :
            {
                //tampilkan urukung
            }break;
            case 5 :
            {
                //tampilkan paniron
            }break;
            case 6 :
            {
                //tampilkan was
            }break;
        }
    }

    public String saptawaraTampilan(int JumlahHari)
    {
        switch(saptawara(JumlahHari))
        {
            case 1 :
            {
                //tampilkan buda
            }break;
            case 2 :
            {
                //tampilkan wraspati
            }break;
            case 3 :
            {
                //tampilkan sukra
            }break;
            case 4 :
            {
                //tampilkan saniscara
            }break;
            case 5 :
            {
                //tampilkan redite
            }break;
            case 6 :
            {
                //tampilkan soma
            }break;
            case 7 :
            {
                //tampilkan anggara
            }break;
        }
    }

    public String astawaraTampilan(int JumlahHari, int JumlahWuku)
    {
        switch(astawara(JumlahHari,JumlahWuku))
        {
            case 1 :
            {
                //tampilkan sri
            }break;
            case 2 :
            {
                //tampilkan indra
            }break;
            case 3 :
            {
                //tampilkan guru
            }break;
            case 4 :
            {
                //tampilkan yama
            }break;
            case 5 :
            {
                //tampilkan ludra
            }break;
            case 6 :
            {
                //tampilkan brahma
            }break;
            case 7 :
            {
                //tampilkan kala
            }break;
            case 8 :
            {
                //tampilkan uma
            }break;
        }
    }

    public String sangawaraTampilan(int JumlahHari, int JumlahWuku)
    {
        switch(sangawara(JumlahHari,JumlahWuku))
        {
            case 1 :
            {
                //tampilkan dangu
            }break;
            case 2 :
            {
                //tampilkan jangur
            }break;
            case 3 :
            {
                //tampilkan gigis
            }break;
            case 4 :
            {
                //tampilkan nohan
            }break;
            case 5 :
            {
                //tampilkan ogan
            }break;
            case 6 :
            {
                //tampilkan erangan
            }break;
            case 7 :
            {
                //tampilkan urungan
            }break;
            case 8 :
            {
                //tampilkan tulus
            }break;
            case 9 :
            {
                //tampilkan dadi
            }break;
        }
    }

    public String dasawaraTampilan(int JumlahHari)
    {
        switch(dasawara(JumlahHari))
        {
            case 1 :
            {
                //tampilkan pati
            }break;
            case 2 :
            {
                //tampilkan suka
            }break;
            case 3 :
            {
                //tampilkan duka
            }break;
            case 4 :
            {
                //tampilkan sri
            }break;
            case 5 :
            {
                //tampilkan manuh
            }break;
            case 6 :
            {
                //tampilkan manusa
            }break;
            case 7 :
            {
                //tampilkan raja
            }break;
            case 8 :
            {
                //tampilkan dewa
            }break;
            case 9 :
            {
                //tampilkan raksasa
            }break;
            case 10 :
            {
                //tampilkan pandita
            }break;
        }
    }

}
