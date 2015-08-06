package com.weatherstation.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Data")


public class Stations implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3459753766337728880L;
	@Id @GeneratedValue 
	private String RecordIndex;
	private String StationID;
	private String StationName;
	private String Model;
	private String Location;
	private String Latitude;
	private String Longitude;
	private String Altitude;
	private String NumberOfParams;
	private String P01;
	private String P02;
	private String P03;
	private String P04;
	private String P05;
	private String P06;
	private String P07;
	private String P08;
	private String P09;
	private String P10;
	private String P11;
	private String P12;
	private String P13;
	private String P14;
	private String P15;
	private String P16;
	private String P17;
	private String P18;
	private String P19;
	private String P20;
	private String P21;
	private String P22;
	private String P23;
	private String P24;
	private String P25;
	private String P26;
	private String P27;
	private String P28;
	private String P29;
	private String P30;
	private String P31;
	private String P32;
	private String P33;
	private String P34;
	private String P35;
	private String P36;
	private String P37;
	private String P38;
	private String P39;
	private String P40;
	private String P41;
	private String P42;
	private String P43;
	private String P44;
	private String P45;
	private String P46;
	private String P47;
	private String P48;
	private String P49;
	private String P50;
	private String P51;
	private String P52;
	private String P53;
	private String P54;
	private String P55;
	private String P56;
	private String P57;
	private String P58;
	private String P59;
	private String P60;
	private String P61;
	private String P62;
	private String P63;
	private String P64;
	private String P65;
	private String P66;
	private String P67;
	private String P68;
	private String P69;
	private String P70;
	private String P71;
	private String P72;
	private String P73;
	private String P74;
	private String P75;
	private String P76;
	private String P77;
	private String P78;
	private String P79;
	private String P80;
	private String P81;
	private String P82;
	private String P83;
	private String P84;
	private String P85;
	private String P86;
	private String P87;
	private String P88;
	private String P89;
	private String P90;
	private String P91;
	private String P92;
	private String P93;
	private String P94;
	private String P95;
	private String P96;
	private String P97;
	private String P98;
	private String P99;
	


	public Stations()
	{
		
	}



	public Stations(String stationID, String stationName, String model,
			String location, String latitude, String longitude,
			String altitude, String numberOfParams, String p01, String p02,
			String p03, String p04, String p05, String p06, String p07,
			String p08, String p09, String p10, String p11, String p12,
			String p13, String p14, String p15, String p16, String p17,
			String p18, String p19, String p20, String p21, String p22,
			String p23, String p24, String p25, String p26, String p27,
			String p28, String p29, String p30, String p31, String p32,
			String p33, String p34, String p35, String p36, String p37,
			String p38, String p39, String p40, String p41, String p42,
			String p43, String p44, String p45, String p46, String p47,
			String p48, String p49, String p50, String p51, String p52,
			String p53, String p54, String p55, String p56, String p57,
			String p58, String p59, String p60, String p61, String p62,
			String p63, String p64, String p65, String p66, String p67,
			String p68, String p69, String p70, String p71, String p72,
			String p73, String p74, String p75, String p76, String p77,
			String p78, String p79, String p80, String p81, String p82,
			String p83, String p84, String p85, String p86, String p87,
			String p88, String p89, String p90, String p91, String p92,
			String p93, String p94, String p95, String p96, String p97,
			String p98, String p99) {
		super();
		StationID = stationID;
		StationName = stationName;
		Model = model;
		Location = location;
		Latitude = latitude;
		Longitude = longitude;
		Altitude = altitude;
		NumberOfParams = numberOfParams;
		P01 = p01;
		P02 = p02;
		P03 = p03;
		P04 = p04;
		P05 = p05;
		P06 = p06;
		P07 = p07;
		P08 = p08;
		P09 = p09;
		P10 = p10;
		P11 = p11;
		P12 = p12;
		P13 = p13;
		P14 = p14;
		P15 = p15;
		P16 = p16;
		P17 = p17;
		P18 = p18;
		P19 = p19;
		P20 = p20;
		P21 = p21;
		P22 = p22;
		P23 = p23;
		P24 = p24;
		P25 = p25;
		P26 = p26;
		P27 = p27;
		P28 = p28;
		P29 = p29;
		P30 = p30;
		P31 = p31;
		P32 = p32;
		P33 = p33;
		P34 = p34;
		P35 = p35;
		P36 = p36;
		P37 = p37;
		P38 = p38;
		P39 = p39;
		P40 = p40;
		P41 = p41;
		P42 = p42;
		P43 = p43;
		P44 = p44;
		P45 = p45;
		P46 = p46;
		P47 = p47;
		P48 = p48;
		P49 = p49;
		P50 = p50;
		P51 = p51;
		P52 = p52;
		P53 = p53;
		P54 = p54;
		P55 = p55;
		P56 = p56;
		P57 = p57;
		P58 = p58;
		P59 = p59;
		P60 = p60;
		P61 = p61;
		P62 = p62;
		P63 = p63;
		P64 = p64;
		P65 = p65;
		P66 = p66;
		P67 = p67;
		P68 = p68;
		P69 = p69;
		P70 = p70;
		P71 = p71;
		P72 = p72;
		P73 = p73;
		P74 = p74;
		P75 = p75;
		P76 = p76;
		P77 = p77;
		P78 = p78;
		P79 = p79;
		P80 = p80;
		P81 = p81;
		P82 = p82;
		P83 = p83;
		P84 = p84;
		P85 = p85;
		P86 = p86;
		P87 = p87;
		P88 = p88;
		P89 = p89;
		P90 = p90;
		P91 = p91;
		P92 = p92;
		P93 = p93;
		P94 = p94;
		P95 = p95;
		P96 = p96;
		P97 = p97;
		P98 = p98;
		P99 = p99;
	}



	public String getRecordIndex() {
		return RecordIndex;
	}



	public void setRecordIndex(String recordIndex) {
		RecordIndex = recordIndex;
	}



	public String getStationID() {
		return StationID;
	}



	public void setStationID(String stationID) {
		StationID = stationID;
	}



	public String getStationName() {
		return StationName;
	}



	public void setStationName(String stationName) {
		StationName = stationName;
	}



	public String getModel() {
		return Model;
	}



	public void setModel(String model) {
		Model = model;
	}



	public String getLocation() {
		return Location;
	}



	public void setLocation(String location) {
		Location = location;
	}



	public String getLatitude() {
		return Latitude;
	}



	public void setLatitude(String latitude) {
		Latitude = latitude;
	}



	public String getLongitude() {
		return Longitude;
	}



	public void setLongitude(String longitude) {
		Longitude = longitude;
	}



	public String getAltitude() {
		return Altitude;
	}



	public void setAltitude(String altitude) {
		Altitude = altitude;
	}



	public String getNumberOfParams() {
		return NumberOfParams;
	}



	public void setNumberOfParams(String numberOfParams) {
		NumberOfParams = numberOfParams;
	}



	public String getP01() {
		return P01;
	}



	public void setP01(String p01) {
		P01 = p01;
	}



	public String getP02() {
		return P02;
	}



	public void setP02(String p02) {
		P02 = p02;
	}



	public String getP03() {
		return P03;
	}



	public void setP03(String p03) {
		P03 = p03;
	}



	public String getP04() {
		return P04;
	}



	public void setP04(String p04) {
		P04 = p04;
	}



	public String getP05() {
		return P05;
	}



	public void setP05(String p05) {
		P05 = p05;
	}



	public String getP06() {
		return P06;
	}



	public void setP06(String p06) {
		P06 = p06;
	}



	public String getP07() {
		return P07;
	}



	public void setP07(String p07) {
		P07 = p07;
	}



	public String getP08() {
		return P08;
	}



	public void setP08(String p08) {
		P08 = p08;
	}



	public String getP09() {
		return P09;
	}



	public void setP09(String p09) {
		P09 = p09;
	}



	public String getP10() {
		return P10;
	}



	public void setP10(String p10) {
		P10 = p10;
	}



	public String getP11() {
		return P11;
	}



	public void setP11(String p11) {
		P11 = p11;
	}



	public String getP12() {
		return P12;
	}



	public void setP12(String p12) {
		P12 = p12;
	}



	public String getP13() {
		return P13;
	}



	public void setP13(String p13) {
		P13 = p13;
	}



	public String getP14() {
		return P14;
	}



	public void setP14(String p14) {
		P14 = p14;
	}



	public String getP15() {
		return P15;
	}



	public void setP15(String p15) {
		P15 = p15;
	}



	public String getP16() {
		return P16;
	}



	public void setP16(String p16) {
		P16 = p16;
	}



	public String getP17() {
		return P17;
	}



	public void setP17(String p17) {
		P17 = p17;
	}



	public String getP18() {
		return P18;
	}



	public void setP18(String p18) {
		P18 = p18;
	}



	public String getP19() {
		return P19;
	}



	public void setP19(String p19) {
		P19 = p19;
	}



	public String getP20() {
		return P20;
	}



	public void setP20(String p20) {
		P20 = p20;
	}



	public String getP21() {
		return P21;
	}



	public void setP21(String p21) {
		P21 = p21;
	}



	public String getP22() {
		return P22;
	}



	public void setP22(String p22) {
		P22 = p22;
	}



	public String getP23() {
		return P23;
	}



	public void setP23(String p23) {
		P23 = p23;
	}



	public String getP24() {
		return P24;
	}



	public void setP24(String p24) {
		P24 = p24;
	}



	public String getP25() {
		return P25;
	}



	public void setP25(String p25) {
		P25 = p25;
	}



	public String getP26() {
		return P26;
	}



	public void setP26(String p26) {
		P26 = p26;
	}



	public String getP27() {
		return P27;
	}



	public void setP27(String p27) {
		P27 = p27;
	}



	public String getP28() {
		return P28;
	}



	public void setP28(String p28) {
		P28 = p28;
	}



	public String getP29() {
		return P29;
	}



	public void setP29(String p29) {
		P29 = p29;
	}



	public String getP30() {
		return P30;
	}



	public void setP30(String p30) {
		P30 = p30;
	}



	public String getP31() {
		return P31;
	}



	public void setP31(String p31) {
		P31 = p31;
	}



	public String getP32() {
		return P32;
	}



	public void setP32(String p32) {
		P32 = p32;
	}



	public String getP33() {
		return P33;
	}



	public void setP33(String p33) {
		P33 = p33;
	}



	public String getP34() {
		return P34;
	}



	public void setP34(String p34) {
		P34 = p34;
	}



	public String getP35() {
		return P35;
	}



	public void setP35(String p35) {
		P35 = p35;
	}



	public String getP36() {
		return P36;
	}



	public void setP36(String p36) {
		P36 = p36;
	}



	public String getP37() {
		return P37;
	}



	public void setP37(String p37) {
		P37 = p37;
	}



	public String getP38() {
		return P38;
	}



	public void setP38(String p38) {
		P38 = p38;
	}



	public String getP39() {
		return P39;
	}



	public void setP39(String p39) {
		P39 = p39;
	}



	public String getP40() {
		return P40;
	}



	public void setP40(String p40) {
		P40 = p40;
	}



	public String getP41() {
		return P41;
	}



	public void setP41(String p41) {
		P41 = p41;
	}



	public String getP42() {
		return P42;
	}



	public void setP42(String p42) {
		P42 = p42;
	}



	public String getP43() {
		return P43;
	}



	public void setP43(String p43) {
		P43 = p43;
	}



	public String getP44() {
		return P44;
	}



	public void setP44(String p44) {
		P44 = p44;
	}



	public String getP45() {
		return P45;
	}



	public void setP45(String p45) {
		P45 = p45;
	}



	public String getP46() {
		return P46;
	}



	public void setP46(String p46) {
		P46 = p46;
	}



	public String getP47() {
		return P47;
	}



	public void setP47(String p47) {
		P47 = p47;
	}



	public String getP48() {
		return P48;
	}



	public void setP48(String p48) {
		P48 = p48;
	}



	public String getP49() {
		return P49;
	}



	public void setP49(String p49) {
		P49 = p49;
	}



	public String getP50() {
		return P50;
	}



	public void setP50(String p50) {
		P50 = p50;
	}



	public String getP51() {
		return P51;
	}



	public void setP51(String p51) {
		P51 = p51;
	}



	public String getP52() {
		return P52;
	}



	public void setP52(String p52) {
		P52 = p52;
	}



	public String getP53() {
		return P53;
	}



	public void setP53(String p53) {
		P53 = p53;
	}



	public String getP54() {
		return P54;
	}



	public void setP54(String p54) {
		P54 = p54;
	}



	public String getP55() {
		return P55;
	}



	public void setP55(String p55) {
		P55 = p55;
	}



	public String getP56() {
		return P56;
	}



	public void setP56(String p56) {
		P56 = p56;
	}



	public String getP57() {
		return P57;
	}



	public void setP57(String p57) {
		P57 = p57;
	}



	public String getP58() {
		return P58;
	}



	public void setP58(String p58) {
		P58 = p58;
	}



	public String getP59() {
		return P59;
	}



	public void setP59(String p59) {
		P59 = p59;
	}



	public String getP60() {
		return P60;
	}



	public void setP60(String p60) {
		P60 = p60;
	}



	public String getP61() {
		return P61;
	}



	public void setP61(String p61) {
		P61 = p61;
	}



	public String getP62() {
		return P62;
	}



	public void setP62(String p62) {
		P62 = p62;
	}



	public String getP63() {
		return P63;
	}



	public void setP63(String p63) {
		P63 = p63;
	}



	public String getP64() {
		return P64;
	}



	public void setP64(String p64) {
		P64 = p64;
	}



	public String getP65() {
		return P65;
	}



	public void setP65(String p65) {
		P65 = p65;
	}



	public String getP66() {
		return P66;
	}



	public void setP66(String p66) {
		P66 = p66;
	}



	public String getP67() {
		return P67;
	}



	public void setP67(String p67) {
		P67 = p67;
	}



	public String getP68() {
		return P68;
	}



	public void setP68(String p68) {
		P68 = p68;
	}



	public String getP69() {
		return P69;
	}



	public void setP69(String p69) {
		P69 = p69;
	}



	public String getP70() {
		return P70;
	}



	public void setP70(String p70) {
		P70 = p70;
	}



	public String getP71() {
		return P71;
	}



	public void setP71(String p71) {
		P71 = p71;
	}



	public String getP72() {
		return P72;
	}



	public void setP72(String p72) {
		P72 = p72;
	}



	public String getP73() {
		return P73;
	}



	public void setP73(String p73) {
		P73 = p73;
	}



	public String getP74() {
		return P74;
	}



	public void setP74(String p74) {
		P74 = p74;
	}



	public String getP75() {
		return P75;
	}



	public void setP75(String p75) {
		P75 = p75;
	}



	public String getP76() {
		return P76;
	}



	public void setP76(String p76) {
		P76 = p76;
	}



	public String getP77() {
		return P77;
	}



	public void setP77(String p77) {
		P77 = p77;
	}



	public String getP78() {
		return P78;
	}



	public void setP78(String p78) {
		P78 = p78;
	}



	public String getP79() {
		return P79;
	}



	public void setP79(String p79) {
		P79 = p79;
	}



	public String getP80() {
		return P80;
	}



	public void setP80(String p80) {
		P80 = p80;
	}



	public String getP81() {
		return P81;
	}



	public void setP81(String p81) {
		P81 = p81;
	}



	public String getP82() {
		return P82;
	}



	public void setP82(String p82) {
		P82 = p82;
	}



	public String getP83() {
		return P83;
	}



	public void setP83(String p83) {
		P83 = p83;
	}



	public String getP84() {
		return P84;
	}



	public void setP84(String p84) {
		P84 = p84;
	}



	public String getP85() {
		return P85;
	}



	public void setP85(String p85) {
		P85 = p85;
	}



	public String getP86() {
		return P86;
	}



	public void setP86(String p86) {
		P86 = p86;
	}



	public String getP87() {
		return P87;
	}



	public void setP87(String p87) {
		P87 = p87;
	}



	public String getP88() {
		return P88;
	}



	public void setP88(String p88) {
		P88 = p88;
	}



	public String getP89() {
		return P89;
	}



	public void setP89(String p89) {
		P89 = p89;
	}



	public String getP90() {
		return P90;
	}



	public void setP90(String p90) {
		P90 = p90;
	}



	public String getP91() {
		return P91;
	}



	public void setP91(String p91) {
		P91 = p91;
	}



	public String getP92() {
		return P92;
	}



	public void setP92(String p92) {
		P92 = p92;
	}



	public String getP93() {
		return P93;
	}



	public void setP93(String p93) {
		P93 = p93;
	}



	public String getP94() {
		return P94;
	}



	public void setP94(String p94) {
		P94 = p94;
	}



	public String getP95() {
		return P95;
	}



	public void setP95(String p95) {
		P95 = p95;
	}



	public String getP96() {
		return P96;
	}



	public void setP96(String p96) {
		P96 = p96;
	}



	public String getP97() {
		return P97;
	}



	public void setP97(String p97) {
		P97 = p97;
	}



	public String getP98() {
		return P98;
	}



	public void setP98(String p98) {
		P98 = p98;
	}



	public String getP99() {
		return P99;
	}



	public void setP99(String p99) {
		P99 = p99;
	}
	
	


}