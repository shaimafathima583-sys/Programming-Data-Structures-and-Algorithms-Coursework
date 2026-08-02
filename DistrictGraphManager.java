package graph;

import model.*;

public class DistrictGraphManager {

    public DistrictGraph createColomboDistrict() {
        DistrictGraph graph = new DistrictGraph("Colombo");
        Location Location1 = new Location("1", 746000, 79.8428);
        Location Location2 = new Location("2", 178500, 79.8997);
        Location Location3 = new Location("3", 136500, 79.8653);
        Location Location4 = new Location("4", 291000, 79.8816);
        Location Location5 = new Location("5", 202500, 79.9265);
        Location Location6 = new Location("6", 238000, 79.9026);
        Location Location7 = new Location("7", 69500, 79.8887);
        Location Location8 = new Location("8", 37000, 79.983);
        Location Location9 = new Location("9", 84000, 80.0025);
        Location Location10 = new Location("10", 86500, 79.9227);
        Location Location11 = new Location("11", 208000, 79.9186);
        Location Location12 = new Location("12", 109000, 79.8973);

        graph.addLocation(Location1);
        graph.addLocation(Location2);
        graph.addLocation(Location3);
        graph.addLocation(Location4);
        graph.addLocation(Location5);
        graph.addLocation(Location6);
        graph.addLocation(Location7);
        graph.addLocation(Location8);
        graph.addLocation(Location9);
        graph.addLocation(Location10);
        graph.addLocation(Location11);
        graph.addLocation(Location12);

        graph.connectLocations(Location1, Location2, 10);
        graph.connectLocations(Location2, Location3, 10);
        graph.connectLocations(Location3, Location4, 10);
        graph.connectLocations(Location4, Location5, 10);
        graph.connectLocations(Location5, Location6, 10);
        graph.connectLocations(Location6, Location7, 10);
        graph.connectLocations(Location7, Location8, 10);
        graph.connectLocations(Location8, Location9, 10);
        graph.connectLocations(Location9, Location10, 10);
        graph.connectLocations(Location10, Location11, 10);
        graph.connectLocations(Location11, Location12, 10);
        return graph;
    }

    public DistrictGraph createGampahaDistrict() {
        DistrictGraph graph = new DistrictGraph("Gampaha");
        Location Location13 = new Location("13", 299000, 79.8358);
        Location Location14 = new Location("14", 43500, 80);
        Location Location15 = new Location("15", 60000, 79.8917);
        Location Location16 = new Location("16", 78500, 79.892);
        Location Location17 = new Location("17", 86500, 79.9219);
        Location Location18 = new Location("18", 7500, 79.9553);
        Location Location19 = new Location("19", 16000, 80.0142);
        Location Location20 = new Location("20", 55500, 79.8838);
        Location Location21 = new Location("21", 30000, 79.9192);

        graph.addLocation(Location13);
        graph.addLocation(Location14);
        graph.addLocation(Location15);
        graph.addLocation(Location16);
        graph.addLocation(Location17);
        graph.addLocation(Location18);
        graph.addLocation(Location19);
        graph.addLocation(Location20);
        graph.addLocation(Location21);

        graph.connectLocations(Location13, Location14, 10);
        graph.connectLocations(Location14, Location15, 10);
        graph.connectLocations(Location15, Location16, 10);
        graph.connectLocations(Location16, Location17, 10);
        graph.connectLocations(Location17, Location18, 10);
        graph.connectLocations(Location18, Location19, 10);
        graph.connectLocations(Location19, Location20, 10);
        graph.connectLocations(Location20, Location21, 10);
        return graph;
    }

    public DistrictGraph createKalutaraDistrict() {
        DistrictGraph graph = new DistrictGraph("Kalutara");
        Location Location22 = new Location("22", 40000, 79.9607);
        Location Location23 = new Location("23", 32000, 79.9026);
        Location Location24 = new Location("24", 15500, 80.063);
        Location Location25 = new Location("25", 42500, 79.9827);
        Location Location26 = new Location("26", 29500, 79.999);
        Location Location27 = new Location("27", 15000, 80.114);

        graph.addLocation(Location22);
        graph.addLocation(Location23);
        graph.addLocation(Location24);
        graph.addLocation(Location25);
        graph.addLocation(Location26);
        graph.addLocation(Location27);

        graph.connectLocations(Location22, Location23, 10);
        graph.connectLocations(Location23, Location24, 10);
        graph.connectLocations(Location24, Location25, 10);
        graph.connectLocations(Location25, Location26, 10);
        graph.connectLocations(Location26, Location27, 10);
        return graph;
    }

    public DistrictGraph createKandyDistrict() {
        DistrictGraph graph = new DistrictGraph("Kandy");
        Location Location28 = new Location("28", 206500, 80.6337);
        Location Location29 = new Location("29", 29000, 80.5977);
        Location Location30 = new Location("30", 66500, 80.6221);
        Location Location31 = new Location("31", 16000, 80.5745);
        Location Location32 = new Location("32", 22000, 80.534);
        Location Location33 = new Location("33", 8000, 80.6686);

        graph.addLocation(Location28);
        graph.addLocation(Location29);
        graph.addLocation(Location30);
        graph.addLocation(Location31);
        graph.addLocation(Location32);
        graph.addLocation(Location33);

        graph.connectLocations(Location28, Location29, 10);
        graph.connectLocations(Location29, Location30, 10);
        graph.connectLocations(Location30, Location31, 10);
        graph.connectLocations(Location31, Location32, 10);
        graph.connectLocations(Location32, Location33, 10);
        return graph;
    }

    public DistrictGraph createMataleDistrict() {
        DistrictGraph graph = new DistrictGraph("Matale");
        Location Location34 = new Location("34", 83500, 80.6234);
        Location Location35 = new Location("35", 71500, 80.6517);
        Location Location36 = new Location("36", 23000, 80.5642);

        graph.addLocation(Location34);
        graph.addLocation(Location35);
        graph.addLocation(Location36);

        graph.connectLocations(Location34, Location35, 10);
        graph.connectLocations(Location35, Location36, 10);
        return graph;
    }

    public DistrictGraph createNuwaraEliyaDistrict() {
        DistrictGraph graph = new DistrictGraph("Nuwara Eliya");
        Location Location37 = new Location("37", 54500, 80.7891);
        Location Location38 = new Location("38", 16500, 80.5958);
        Location Location39 = new Location("39", 9500, 80.6572);
        Location Location40 = new Location("40", 12000, 80.7614);

        graph.addLocation(Location37);
        graph.addLocation(Location38);
        graph.addLocation(Location39);
        graph.addLocation(Location40);

        graph.connectLocations(Location37, Location38, 10);
        graph.connectLocations(Location38, Location39, 10);
        graph.connectLocations(Location39, Location40, 10);
        return graph;
    }

    public DistrictGraph createGalleDistrict() {
        DistrictGraph graph = new DistrictGraph("Galle");
        Location Location41 = new Location("41", 271500, 80.221);
        Location Location42 = new Location("42", 81000, 80.1);
        Location Location43 = new Location("43", 40500, 80.054);
        Location Location44 = new Location("44", 14000, 80.1667);

        graph.addLocation(Location41);
        graph.addLocation(Location42);
        graph.addLocation(Location43);
        graph.addLocation(Location44);

        graph.connectLocations(Location41, Location42, 10);
        graph.connectLocations(Location42, Location43, 10);
        graph.connectLocations(Location43, Location44, 10);
        return graph;
    }

    public DistrictGraph createMataraDistrict() {
        DistrictGraph graph = new DistrictGraph("Matara");
        Location Location45 = new Location("45", 90500, 80.555);
        Location Location46 = new Location("46", 76000, 80.4297);
        Location Location47 = new Location("47", 6000, 80.487);
        Location Location48 = new Location("48", 22000, 80.5658);

        graph.addLocation(Location45);
        graph.addLocation(Location46);
        graph.addLocation(Location47);
        graph.addLocation(Location48);

        graph.connectLocations(Location45, Location46, 10);
        graph.connectLocations(Location46, Location47, 10);
        graph.connectLocations(Location47, Location48, 10);
        return graph;
    }

    public DistrictGraph createHambantotaDistrict() {
        DistrictGraph graph = new DistrictGraph("Hambantota");
        Location Location49 = new Location("49", 53000, 81.1185);
        Location Location50 = new Location("50", 13000, 80.7942);
        Location Location51 = new Location("51", 16500, 81.2861);
        Location Location52 = new Location("52", 21000, 81.0203);

        graph.addLocation(Location49);
        graph.addLocation(Location50);
        graph.addLocation(Location51);
        graph.addLocation(Location52);

        graph.connectLocations(Location49, Location50, 10);
        graph.connectLocations(Location50, Location51, 10);
        graph.connectLocations(Location51, Location52, 10);
        return graph;
    }

    public DistrictGraph createJaffnaDistrict() {
        DistrictGraph graph = new DistrictGraph("Jaffna");
        Location Location53 = new Location("53", 141500, 80.0255);
        Location Location54 = new Location("54", 18000, 80.159);
        Location Location55 = new Location("55", 10000, 80.2333);
        Location Location56 = new Location("56", 71500, 80.0234);

        graph.addLocation(Location53);
        graph.addLocation(Location54);
        graph.addLocation(Location55);
        graph.addLocation(Location56);

        graph.connectLocations(Location53, Location54, 10);
        graph.connectLocations(Location54, Location55, 10);
        graph.connectLocations(Location55, Location56, 10);
        return graph;
    }

    public DistrictGraph createKilinochchiDistrict() {
        DistrictGraph graph = new DistrictGraph("Kilinochchi");
        Location Location57 = new Location("57", 26000, 80.3982);

        graph.addLocation(Location57);

        return graph;
    }

    public DistrictGraph createMannarDistrict() {
        DistrictGraph graph = new DistrictGraph("Mannar");
        Location Location58 = new Location("58", 24500, 79.9044);

        graph.addLocation(Location58);

        return graph;
    }

    public DistrictGraph createVavuniyaDistrict() {
        DistrictGraph graph = new DistrictGraph("Vavuniya");
        Location Location59 = new Location("59", 63000, 80.4971);

        graph.addLocation(Location59);

        return graph;
    }

    public DistrictGraph createMullaitivuDistrict() {
        DistrictGraph graph = new DistrictGraph("Mullaitivu");
        Location Location60 = new Location("60", 16000, 80.8142);

        graph.addLocation(Location60);

        return graph;
    }

    public DistrictGraph createBatticaloaDistrict() {
        DistrictGraph graph = new DistrictGraph("Batticaloa");
        Location Location61 = new Location("61", 51500, 81.7);
        Location Location62 = new Location("62", 63000, 81.7333);
        Location Location63 = new Location("63", 15500, 81.6067);

        graph.addLocation(Location61);
        graph.addLocation(Location62);
        graph.addLocation(Location63);

        graph.connectLocations(Location61, Location62, 10);
        graph.connectLocations(Location62, Location63, 10);
        return graph;
    }

    public DistrictGraph createAmparaDistrict() {
        DistrictGraph graph = new DistrictGraph("Ampara");
        Location Location64 = new Location("64", 27000, 81.6747);
        Location Location65 = new Location("65", 78500, 81.8167);
        Location Location66 = new Location("66", 30000, 81.85);
        Location Location67 = new Location("67", 6500, 81.8167);

        graph.addLocation(Location64);
        graph.addLocation(Location65);
        graph.addLocation(Location66);
        graph.addLocation(Location67);

        graph.connectLocations(Location64, Location65, 10);
        graph.connectLocations(Location65, Location66, 10);
        graph.connectLocations(Location66, Location67, 10);
        return graph;
    }

    public DistrictGraph createTrincomaleeDistrict() {
        DistrictGraph graph = new DistrictGraph("Trincomalee");
        Location Location68 = new Location("68", 36500, 81.2152);
        Location Location69 = new Location("69", 13500, 81.1917);
        Location Location70 = new Location("70", 8500, 81.0083);

        graph.addLocation(Location68);
        graph.addLocation(Location69);
        graph.addLocation(Location70);

        graph.connectLocations(Location68, Location69, 10);
        graph.connectLocations(Location69, Location70, 10);
        return graph;
    }

    public DistrictGraph createKurunegalaDistrict() {
        DistrictGraph graph = new DistrictGraph("Kurunegala");
        Location Location71 = new Location("71", 180000, 80.3647);
        Location Location72 = new Location("72", 21500, 80.0403);
        Location Location73 = new Location("73", 19000, 80.2317);
        Location Location74 = new Location("74", 27000, 80.1167);

        graph.addLocation(Location71);
        graph.addLocation(Location72);
        graph.addLocation(Location73);
        graph.addLocation(Location74);

        graph.connectLocations(Location71, Location72, 10);
        graph.connectLocations(Location72, Location73, 10);
        graph.connectLocations(Location73, Location74, 10);
        return graph;
    }

    public DistrictGraph createPuttalamDistrict() {
        DistrictGraph graph = new DistrictGraph("Puttalam");
        Location Location75 = new Location("75", 40000, 79.8283);
        Location Location76 = new Location("76", 31000, 79.7953);
        Location Location77 = new Location("77", 8000, 79.8394);

        graph.addLocation(Location75);
        graph.addLocation(Location76);
        graph.addLocation(Location77);

        graph.connectLocations(Location75, Location76, 10);
        graph.connectLocations(Location76, Location77, 10);
        return graph;
    }

    public DistrictGraph createAnuradhapuraDistrict() {
        DistrictGraph graph = new DistrictGraph("Anuradhapura");
        Location Location78 = new Location("78", 246500, 80.4037);
        Location Location79 = new Location("79", 19000, 80.5983);
        Location Location80 = new Location("80", 13000, 80.4956);

        graph.addLocation(Location78);
        graph.addLocation(Location79);
        graph.addLocation(Location80);

        graph.connectLocations(Location78, Location79, 10);
        graph.connectLocations(Location79, Location80, 10);
        return graph;
    }

    public DistrictGraph createPolonnaruwaDistrict() {
        DistrictGraph graph = new DistrictGraph("Polonnaruwa");
        Location Location81 = new Location("81", 93000, 81.0188);
        Location Location82 = new Location("82", 17500, 80.95);
        Location Location83 = new Location("83", 8000, 80.95);

        graph.addLocation(Location81);
        graph.addLocation(Location82);
        graph.addLocation(Location83);

        graph.connectLocations(Location81, Location82, 10);
        graph.connectLocations(Location82, Location83, 10);
        return graph;
    }

    public DistrictGraph createBadullaDistrict() {
        DistrictGraph graph = new DistrictGraph("Badulla");
        Location Location84 = new Location("84", 78500, 81.055);
        Location Location85 = new Location("85", 94500, 80.9903);
        Location Location86 = new Location("86", 22000, 80.9553);
        Location Location87 = new Location("87", 11500, 80.9153);

        graph.addLocation(Location84);
        graph.addLocation(Location85);
        graph.addLocation(Location86);
        graph.addLocation(Location87);

        graph.connectLocations(Location84, Location85, 10);
        graph.connectLocations(Location85, Location86, 10);
        graph.connectLocations(Location86, Location87, 10);
        return graph;
    }

    public DistrictGraph createMonaragalaDistrict() {
        DistrictGraph graph = new DistrictGraph("Monaragala");
        Location Location88 = new Location("88", 71500, 81.351);
        Location Location89 = new Location("89", 10000, 81.1);
        Location Location90 = new Location("90", 28500, 81.2167);

        graph.addLocation(Location88);
        graph.addLocation(Location89);
        graph.addLocation(Location90);

        graph.connectLocations(Location88, Location89, 10);
        graph.connectLocations(Location89, Location90, 10);
        return graph;
    }

    public DistrictGraph createRatnapuraDistrict() {
        DistrictGraph graph = new DistrictGraph("Ratnapura");
        Location Location91 = new Location("91", 109000, 80.4012);
        Location Location92 = new Location("92", 7000, 80.7011);
        Location Location93 = new Location("93", 18000, 80.8478);
        Location Location94 = new Location("94", 13000, 80.2606);
        Location Location95 = new Location("95", 15500, 80.55);

        graph.addLocation(Location91);
        graph.addLocation(Location92);
        graph.addLocation(Location93);
        graph.addLocation(Location94);
        graph.addLocation(Location95);

        graph.connectLocations(Location91, Location92, 10);
        graph.connectLocations(Location92, Location93, 10);
        graph.connectLocations(Location93, Location94, 10);
        graph.connectLocations(Location94, Location95, 10);
        return graph;
    }

    public DistrictGraph createKegalleDistrict() {
        DistrictGraph graph = new DistrictGraph("Kegalle");
        Location Location96 = new Location("96", 78000, 80.3464);
        Location Location97 = new Location("97", 9000, 80.4497);
        Location Location98 = new Location("98", 30000, 80.3833);
        Location Location99 = new Location("99", 12500, 80.1997);

        graph.addLocation(Location96);
        graph.addLocation(Location97);
        graph.addLocation(Location98);
        graph.addLocation(Location99);

        graph.connectLocations(Location96, Location97, 10);
        graph.connectLocations(Location97, Location98, 10);
        graph.connectLocations(Location98, Location99, 10);
        return graph;
    }

}
