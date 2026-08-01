package graph;

import model.*;

public class DistrictGraphManager {

    // COLOMBO DISTRICT
    public DistrictGraph createColomboDistrict() {

        DistrictGraph graph = new DistrictGraph("Colombo");

        Location fort = new Location("Fort", 6.9344, 79.8428);
        Location slaveIsland = new Location("Slave Island", 6.9218, 79.8478);
        Location kollupitiya = new Location("Kollupitiya", 6.9103, 79.8505);
        Location bambalapitiya = new Location("Bambalapitiya", 6.8886, 79.8563);
        Location wellawatte = new Location("Wellawatte", 6.8741, 79.8603);

        graph.addLocation(fort);
        graph.addLocation(slaveIsland);
        graph.addLocation(kollupitiya);
        graph.addLocation(bambalapitiya);
        graph.addLocation(wellawatte);

        graph.connectLocations(fort, slaveIsland, 2.3);
        graph.connectLocations(slaveIsland, kollupitiya, 1.5);
        graph.connectLocations(kollupitiya, bambalapitiya, 2.8);
        graph.connectLocations(bambalapitiya, wellawatte, 2.2);
        graph.connectLocations(fort, kollupitiya, 3.5);

        Location kandy = new Location("Kandy", 7.2906, 80.6337);

        graph.addLocation(kandy);

        graph.connectLocations(fort, kandy, 115);
        
        return graph;
    }

    // GAMPAHA DISTRICT
    public DistrictGraph createGampahaDistrict() {

        DistrictGraph graph = new DistrictGraph("Gampaha");

        Location negombo = new Location("Negombo", 7.2083, 79.8358);
        Location jaEla = new Location("Ja-Ela", 7.0744, 79.8919);
        Location wattala = new Location("Wattala", 6.9900, 79.8900);
        Location kadawatha = new Location("Kadawatha", 7.0013, 79.9586);
        Location gampaha = new Location("Gampaha", 7.0873, 80.0140);

        graph.addLocation(negombo);
        graph.addLocation(jaEla);
        graph.addLocation(wattala);
        graph.addLocation(kadawatha);
        graph.addLocation(gampaha);

        graph.connectLocations(negombo, jaEla, 18);
        graph.connectLocations(jaEla, wattala, 10);
        graph.connectLocations(wattala, kadawatha, 12);
        graph.connectLocations(kadawatha, gampaha, 8);
        graph.connectLocations(negombo, gampaha, 26);

        return graph;
    }

    // KALUTARA DISTRICT
    public DistrictGraph createKalutaraDistrict() {

        DistrictGraph graph = new DistrictGraph("Kalutara");

        Location panadura = new Location("Panadura", 6.7132, 79.9026);
        Location kalutara = new Location("Kalutara", 6.5854, 79.9607);
        Location horana = new Location("Horana", 6.7156, 80.0626);
        Location beruwala = new Location("Beruwala", 6.4788, 79.9828);
        Location aluthgama = new Location("Aluthgama", 6.4347, 79.9957);

        graph.addLocation(panadura);
        graph.addLocation(kalutara);
        graph.addLocation(horana);
        graph.addLocation(beruwala);
        graph.addLocation(aluthgama);

        graph.connectLocations(panadura, kalutara, 15);
        graph.connectLocations(kalutara, horana, 20);
        graph.connectLocations(kalutara, beruwala, 18);
        graph.connectLocations(beruwala, aluthgama, 4);
        graph.connectLocations(horana, panadura, 22);

        return graph;
    }

    // KANDY DISTRICT
    public DistrictGraph createKandyDistrict() {

        DistrictGraph graph = new DistrictGraph("Kandy");

        Location kandy = new Location("Kandy", 7.2906, 80.6337);
        Location peradeniya = new Location("Peradeniya", 7.2631, 80.5968);
        Location katugastota = new Location("Katugastota", 7.3336, 80.6215);
        Location akurana = new Location("Akurana", 7.3667, 80.6167);
        Location pilimathalawa = new Location("Pilimathalawa", 7.2700, 80.5667);

        graph.addLocation(kandy);
        graph.addLocation(peradeniya);
        graph.addLocation(katugastota);
        graph.addLocation(akurana);
        graph.addLocation(pilimathalawa);

        graph.connectLocations(kandy, peradeniya, 6);
        graph.connectLocations(kandy, katugastota, 5);
        graph.connectLocations(katugastota, akurana, 4);
        graph.connectLocations(peradeniya, pilimathalawa, 5);
        graph.connectLocations(pilimathalawa, akurana, 9);

        return graph;
    }

    // MATALE DISTRICT
    public DistrictGraph createMataleDistrict() {

        DistrictGraph graph = new DistrictGraph("Matale");

        Location matale = new Location("Matale", 7.4675, 80.6234);
        Location dambulla = new Location("Dambulla", 7.8731, 80.6517);
        Location ukuwela = new Location("Ukuwela", 7.4203, 80.6317);
        Location galewela = new Location("Galewela", 7.7592, 80.6580);
        Location rattota = new Location("Rattota", 7.5333, 80.6833);

        graph.addLocation(matale);
        graph.addLocation(dambulla);
        graph.addLocation(ukuwela);
        graph.addLocation(galewela);
        graph.addLocation(rattota);

        graph.connectLocations(matale, ukuwela, 8);
        graph.connectLocations(ukuwela, rattota, 12);
        graph.connectLocations(matale, galewela, 28);
        graph.connectLocations(galewela, dambulla, 16);
        graph.connectLocations(matale, dambulla, 35);

        return graph;
    }

    // NUWARA ELIYA DISTRICT
    public DistrictGraph createNuwaraEliyaDistrict() {

        DistrictGraph graph = new DistrictGraph("Nuwara Eliya");

        Location nuwaraEliya = new Location("Nuwara Eliya", 6.9497, 80.7891);
        Location hatton = new Location("Hatton", 6.8916, 80.5955);
        Location talawakele = new Location("Talawakele", 6.9371, 80.6588);
        Location lindula = new Location("Lindula", 6.9200, 80.6840);
        Location kotagala = new Location("Kotagala", 6.8924, 80.6012);

        graph.addLocation(nuwaraEliya);
        graph.addLocation(hatton);
        graph.addLocation(talawakele);
        graph.addLocation(lindula);
        graph.addLocation(kotagala);

        graph.connectLocations(hatton, kotagala, 3);
        graph.connectLocations(kotagala, talawakele, 6);
        graph.connectLocations(talawakele, lindula, 5);
        graph.connectLocations(lindula, nuwaraEliya, 18);
        graph.connectLocations(hatton, nuwaraEliya, 32);

        return graph;
    }

    // GALLE DISTRICT
    public DistrictGraph createGalleDistrict() {

        DistrictGraph graph = new DistrictGraph("Galle");

        Location galle = new Location("Galle", 6.0329, 80.2168);
        Location hikkaduwa = new Location("Hikkaduwa", 6.1408, 80.1010);
        Location ambalangoda = new Location("Ambalangoda", 6.2355, 80.0537);
        Location baddegama = new Location("Baddegama", 6.1655, 80.1805);
        Location elpitiya = new Location("Elpitiya", 6.2913, 80.1627);

        graph.addLocation(galle);
        graph.addLocation(hikkaduwa);
        graph.addLocation(ambalangoda);
        graph.addLocation(baddegama);
        graph.addLocation(elpitiya);

        graph.connectLocations(galle, hikkaduwa, 18);
        graph.connectLocations(hikkaduwa, ambalangoda, 12);
        graph.connectLocations(galle, baddegama, 17);
        graph.connectLocations(baddegama, elpitiya, 16);
        graph.connectLocations(ambalangoda, elpitiya, 20);

        return graph;
    }

    // MATARA DISTRICT
    public DistrictGraph createMataraDistrict() {

        DistrictGraph graph = new DistrictGraph("Matara");

        Location matara = new Location("Matara", 5.9549, 80.5550);
        Location weligama = new Location("Weligama", 5.9730, 80.4297);
        Location akuressa = new Location("Akuressa", 6.1000, 80.4800);
        Location dickwella = new Location("Dickwella", 5.9667, 80.6833);
        Location devinuwara = new Location("Devinuwara", 5.9333, 80.5833);

        graph.addLocation(matara);
        graph.addLocation(weligama);
        graph.addLocation(akuressa);
        graph.addLocation(dickwella);
        graph.addLocation(devinuwara);

        graph.connectLocations(matara, weligama, 15);
        graph.connectLocations(matara, akuressa, 24);
        graph.connectLocations(matara, devinuwara, 8);
        graph.connectLocations(devinuwara, dickwella, 12);
        graph.connectLocations(weligama, akuressa, 20);

        return graph;
    }

    // HAMBANTOTA DISTRICT
    public DistrictGraph createHambantotaDistrict() {

        DistrictGraph graph = new DistrictGraph("Hambantota");

        Location hambantota = new Location("Hambantota", 6.1241, 81.1185);
        Location tangalle = new Location("Tangalle", 6.0231, 80.7974);
        Location tissamaharama = new Location("Tissamaharama", 6.2792, 81.2870);
        Location ambalantota = new Location("Ambalantota", 6.2350, 81.0000);
        Location lunugamvehera = new Location("Lunugamvehera", 6.3500, 81.2000);

        graph.addLocation(hambantota);
        graph.addLocation(tangalle);
        graph.addLocation(tissamaharama);
        graph.addLocation(ambalantota);
        graph.addLocation(lunugamvehera);

        graph.connectLocations(hambantota, ambalantota, 14);
        graph.connectLocations(ambalantota, tangalle, 28);
        graph.connectLocations(hambantota, tissamaharama, 28);
        graph.connectLocations(tissamaharama, lunugamvehera, 18);
        graph.connectLocations(hambantota, tangalle, 45);

        return graph;
    }

    // JAFFNA DISTRICT
    public DistrictGraph createJaffnaDistrict() {

        DistrictGraph graph = new DistrictGraph("Jaffna");

        Location jaffna = new Location("Jaffna", 9.6615, 80.0255);
        Location nallur = new Location("Nallur", 9.6740, 80.0310);
        Location chunnakam = new Location("Chunnakam", 9.7420, 80.0350);
        Location pointPedro = new Location("Point Pedro", 9.8167, 80.2333);
        Location karainagar = new Location("Karainagar", 9.7333, 79.8833);

        graph.addLocation(jaffna);
        graph.addLocation(nallur);
        graph.addLocation(chunnakam);
        graph.addLocation(pointPedro);
        graph.addLocation(karainagar);

        graph.connectLocations(jaffna, nallur, 3);
        graph.connectLocations(nallur, chunnakam, 8);
        graph.connectLocations(chunnakam, pointPedro, 28);
        graph.connectLocations(jaffna, karainagar, 20);
        graph.connectLocations(chunnakam, karainagar, 18);

        return graph;
    }

    // KILINOCHCHI DISTRICT
    public DistrictGraph createKilinochchiDistrict() {

        DistrictGraph graph = new DistrictGraph("Kilinochchi");

        Location kilinochchi = new Location("Kilinochchi", 9.3803, 80.3770);
        Location paranthan = new Location("Paranthan", 9.3975, 80.4030);
        Location pachchilaipalli = new Location("Pachchilaipalli", 9.6100, 80.3500);
        Location punarin = new Location("Poonakary", 9.5500, 80.2200);
        Location dharmapuram = new Location("Dharmapuram", 9.4500, 80.5000);

        graph.addLocation(kilinochchi);
        graph.addLocation(paranthan);
        graph.addLocation(pachchilaipalli);
        graph.addLocation(punarin);
        graph.addLocation(dharmapuram);

        graph.connectLocations(kilinochchi, paranthan, 5);
        graph.connectLocations(paranthan, dharmapuram, 12);
        graph.connectLocations(kilinochchi, pachchilaipalli, 25);
        graph.connectLocations(kilinochchi, punarin, 35);
        graph.connectLocations(pachchilaipalli, punarin, 20);

        return graph;
    }

    // MANNAR DISTRICT
    public DistrictGraph createMannarDistrict() {

        DistrictGraph graph = new DistrictGraph("Mannar");

        Location mannar = new Location("Mannar", 8.9810, 79.9044);
        Location talaimannar = new Location("Talaimannar", 8.9769, 79.9177);
        Location madhu = new Location("Madhu", 8.8550, 80.1770);
        Location nanattan = new Location("Nanattan", 8.9300, 80.0700);
        Location murunkan = new Location("Murunkan", 8.8500, 79.9700);

        graph.addLocation(mannar);
        graph.addLocation(talaimannar);
        graph.addLocation(madhu);
        graph.addLocation(nanattan);
        graph.addLocation(murunkan);

        graph.connectLocations(mannar, talaimannar, 12);
        graph.connectLocations(mannar, nanattan, 18);
        graph.connectLocations(nanattan, murunkan, 10);
        graph.connectLocations(murunkan, madhu, 35);
        graph.connectLocations(mannar, madhu, 45);

        return graph;
    }

    // MULLAITIVU DISTRICT
    public DistrictGraph createMullaitivuDistrict() {

        DistrictGraph graph = new DistrictGraph("Mullaitivu");

        Location mullaitivu = new Location("Mullaitivu", 9.2671, 80.8142);
        Location puttukudiyiruppu = new Location("Puthukkudiyiruppu", 9.2167, 80.7500);
        Location oddusuddan = new Location("Oddusuddan", 9.0833, 80.6833);
        Location manthaiEast = new Location("Manthai East", 9.1500, 80.5500);
        Location maritimepattu = new Location("Maritimepattu", 9.3000, 80.9000);

        graph.addLocation(mullaitivu);
        graph.addLocation(puttukudiyiruppu);
        graph.addLocation(oddusuddan);
        graph.addLocation(manthaiEast);
        graph.addLocation(maritimepattu);

        graph.connectLocations(mullaitivu, maritimepattu, 10);
        graph.connectLocations(mullaitivu, puttukudiyiruppu, 15);
        graph.connectLocations(puttukudiyiruppu, oddusuddan, 30);
        graph.connectLocations(oddusuddan, manthaiEast, 25);
        graph.connectLocations(manthaiEast, mullaitivu, 45);

        return graph;
    }

    // VAVUNIYA DISTRICT
    public DistrictGraph createVavuniyaDistrict() {

        DistrictGraph graph = new DistrictGraph("Vavuniya");

        Location vavuniya = new Location("Vavuniya", 8.7514, 80.4971);
        Location omanthai = new Location("Omanthai", 8.8500, 80.4700);
        Location cheddikulam = new Location("Cheddikulam", 8.7200, 80.2500);
        Location nedunkeni = new Location("Nedunkeni", 8.9500, 80.7000);
        Location sethikulam = new Location("Settikulam", 8.6500, 80.4300);

        graph.addLocation(vavuniya);
        graph.addLocation(omanthai);
        graph.addLocation(cheddikulam);
        graph.addLocation(nedunkeni);
        graph.addLocation(sethikulam);

        graph.connectLocations(vavuniya, omanthai, 15);
        graph.connectLocations(vavuniya, sethikulam, 20);
        graph.connectLocations(omanthai, nedunkeni, 25);
        graph.connectLocations(sethikulam, cheddikulam, 18);
        graph.connectLocations(vavuniya, nedunkeni, 35);

        return graph;
    }

    // TRINCOMALEE DISTRICT
    public DistrictGraph createTrincomaleeDistrict() {

        DistrictGraph graph = new DistrictGraph("Trincomalee");

        Location trincomalee = new Location("Trincomalee", 8.5874, 81.2152);
        Location kantale = new Location("Kantale", 8.0025, 81.0030);
        Location mutur = new Location("Muttur", 8.4760, 81.2680);
        Location kinniya = new Location("Kinniya", 8.4900, 81.1800);
        Location seruvila = new Location("Seruwila", 8.3800, 81.3000);

        graph.addLocation(trincomalee);
        graph.addLocation(kantale);
        graph.addLocation(mutur);
        graph.addLocation(kinniya);
        graph.addLocation(seruvila);

        graph.connectLocations(trincomalee, kinniya, 12);
        graph.connectLocations(kinniya, mutur, 15);
        graph.connectLocations(trincomalee, kantale, 40);
        graph.connectLocations(kantale, seruvila, 35);
        graph.connectLocations(mutur, seruvila, 30);

        return graph;
    }

    // KURUNEGALA DISTRICT
    public DistrictGraph createKurunegalaDistrict() {

        DistrictGraph graph = new DistrictGraph("Kurunegala");

        Location kurunegala = new Location("Kurunegala", 7.4863, 80.3623);
        Location kuliyapitiya = new Location("Kuliyapitiya", 7.4688, 80.0401);
        Location narammala = new Location("Narammala", 7.4333, 80.2167);
        Location mawathagama = new Location("Mawathagama", 7.3667, 80.3167);
        Location dambadeniya = new Location("Dambadeniya", 7.3000, 80.2500);

        graph.addLocation(kurunegala);
        graph.addLocation(kuliyapitiya);
        graph.addLocation(narammala);
        graph.addLocation(mawathagama);
        graph.addLocation(dambadeniya);

        graph.connectLocations(kurunegala, mawathagama, 12);
        graph.connectLocations(kurunegala, kuliyapitiya, 25);
        graph.connectLocations(kuliyapitiya, narammala, 18);
        graph.connectLocations(narammala, dambadeniya, 15);
        graph.connectLocations(kurunegala, dambadeniya, 30);

        return graph;
    }

    // ANURADHAPURA DISTRICT
    public DistrictGraph createAnuradhapuraDistrict() {

        DistrictGraph graph = new DistrictGraph("Anuradhapura");

        Location anuradhapura = new Location("Anuradhapura", 8.3114, 80.4037);
        Location mihintale = new Location("Mihintale", 8.3500, 80.5000);
        Location kekirawa = new Location("Kekirawa", 8.0380, 80.6000);
        Location medawachchiya = new Location("Medawachchiya", 8.5500, 80.4833);
        Location thambuttegama = new Location("Thambuttegama", 8.1500, 80.3000);

        graph.addLocation(anuradhapura);
        graph.addLocation(mihintale);
        graph.addLocation(kekirawa);
        graph.addLocation(medawachchiya);
        graph.addLocation(thambuttegama);

        graph.connectLocations(anuradhapura, mihintale, 12);
        graph.connectLocations(anuradhapura, medawachchiya, 30);
        graph.connectLocations(anuradhapura, thambuttegama, 35);
        graph.connectLocations(thambuttegama, kekirawa, 25);
        graph.connectLocations(mihintale, kekirawa, 40);

        return graph;
    }

    // POLONNARUWA DISTRICT
    public DistrictGraph createPolonnaruwaDistrict() {

        DistrictGraph graph = new DistrictGraph("Polonnaruwa");

        Location polonnaruwa = new Location("Polonnaruwa", 7.9403, 81.0188);
        Location hingurakgoda = new Location("Hingurakgoda", 8.0333, 80.9500);
        Location kaduruwela = new Location("Kaduruwela", 7.9333, 81.0000);
        Location medirigiriya = new Location("Medirigiriya", 8.1167, 80.9833);
        Location bakamuna = new Location("Bakamuna", 8.0000, 80.7500);

        graph.addLocation(polonnaruwa);
        graph.addLocation(hingurakgoda);
        graph.addLocation(kaduruwela);
        graph.addLocation(medirigiriya);
        graph.addLocation(bakamuna);

        graph.connectLocations(polonnaruwa, kaduruwela, 5);
        graph.connectLocations(kaduruwela, hingurakgoda, 15);
        graph.connectLocations(hingurakgoda, medirigiriya, 20);
        graph.connectLocations(polonnaruwa, bakamuna, 35);
        graph.connectLocations(medirigiriya, bakamuna, 25);

        return graph;
    }

    // KEGALLE DISTRICT
    public DistrictGraph createKegalleDistrict() {

        DistrictGraph graph = new DistrictGraph("Kegalle");

        Location kegalle = new Location("Kegalle", 7.2513, 80.3464);
        Location mawanella = new Location("Mawanella", 7.2525, 80.4370);
        Location warakapola = new Location("Warakapola", 7.2250, 80.2000);
        Location rambukkana = new Location("Rambukkana", 7.3200, 80.3900);
        Location yatiyantota = new Location("Yatiyantota", 7.0300, 80.3000);

        graph.addLocation(kegalle);
        graph.addLocation(mawanella);
        graph.addLocation(warakapola);
        graph.addLocation(rambukkana);
        graph.addLocation(yatiyantota);

        graph.connectLocations(kegalle, mawanella, 15);
        graph.connectLocations(kegalle, warakapola, 20);
        graph.connectLocations(kegalle, rambukkana, 18);
        graph.connectLocations(mawanella, yatiyantota, 30);
        graph.connectLocations(warakapola, yatiyantota, 35);

        return graph;
    }

    // PUTTALAM DISTRICT
    public DistrictGraph createPuttalamDistrict() {

        DistrictGraph graph = new DistrictGraph("Puttalam");

        Location puttalam = new Location("Puttalam", 8.0362, 79.8283);
        Location chilaw = new Location("Chilaw", 7.5758, 79.7953);
        Location wennappuwa = new Location("Wennappuwa", 7.3417, 79.8386);
        Location anamaduwa = new Location("Anamaduwa", 7.8800, 80.0000);
        Location kalpitiya = new Location("Kalpitiya", 8.2333, 79.7667);

        graph.addLocation(puttalam);
        graph.addLocation(chilaw);
        graph.addLocation(wennappuwa);
        graph.addLocation(anamaduwa);
        graph.addLocation(kalpitiya);

        graph.connectLocations(puttalam, kalpitiya, 25);
        graph.connectLocations(puttalam, anamaduwa, 20);
        graph.connectLocations(puttalam, chilaw, 45);
        graph.connectLocations(chilaw, wennappuwa, 25);
        graph.connectLocations(anamaduwa, chilaw, 50);

        return graph;
    }

}