package com.weatherstation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weatherstation.model.Data;
import com.weatherstation.model.Stations;
import com.weatherstation.service.GenerateTableService;
import com.weatherstation.service.HandleQSService;
import com.weatherstation.service.UpdateService;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int loopcntr = 0;
		int numberOfReadingsSameDateTimeStationID;
		String SHT15_temperature_min_buffer = "0";
		String SHT15_temperature_avg_buffer = "0";
		String SHT15_temperature_max_buffer = "0";

		String ID = request.getParameter("ID");
		String date = request.getParameter("Date");
		String time = request.getParameter("Time");
		
		date = "20" + date.substring(0, 2) + "-" + date.substring(2, 4)
				+ "-" + date.substring(4);
		time = time.substring(0, 2) + ":" + time.substring(2);

		GenerateTableService describeByID = new GenerateTableService();
		Stations station = new Stations();
		HandleQSService handle = new HandleQSService();
		numberOfReadingsSameDateTimeStationID = describeByID.checkIfUnique(ID,
				date, time);
		if (numberOfReadingsSameDateTimeStationID == 0) {

			station = describeByID.FindStationByID(ID);
			if (station != null) {

				String[] QSParam = new String[100];

				QSParam[1] = request.getParameter("P01");
				QSParam[2] = request.getParameter("P02");
				QSParam[3] = request.getParameter("P03");
				QSParam[4] = request.getParameter("P04");
				QSParam[5] = request.getParameter("P05");
				QSParam[6] = request.getParameter("P06");
				QSParam[7] = request.getParameter("P07");
				QSParam[8] = request.getParameter("P08");
				QSParam[9] = request.getParameter("P09");
				QSParam[10] = request.getParameter("P10");
				QSParam[11] = request.getParameter("P11");
				QSParam[12] = request.getParameter("P12");
				QSParam[13] = request.getParameter("P13");
				QSParam[14] = request.getParameter("P14");
				QSParam[15] = request.getParameter("P15");
				QSParam[16] = request.getParameter("P16");
				QSParam[17] = request.getParameter("P17");
				QSParam[18] = request.getParameter("P18");
				QSParam[19] = request.getParameter("P19");
				QSParam[20] = request.getParameter("P20");
				QSParam[21] = request.getParameter("P21");
				QSParam[22] = request.getParameter("P22");
				QSParam[23] = request.getParameter("P23");
				QSParam[24] = request.getParameter("P24");
				QSParam[25] = request.getParameter("P25");
				QSParam[26] = request.getParameter("P26");
				QSParam[27] = request.getParameter("P27");
				QSParam[28] = request.getParameter("P28");
				QSParam[29] = request.getParameter("P29");
				QSParam[30] = request.getParameter("P30");
				QSParam[31] = request.getParameter("P31");
				QSParam[32] = request.getParameter("P32");
				QSParam[33] = request.getParameter("P33");
				QSParam[34] = request.getParameter("P34");
				QSParam[35] = request.getParameter("P35");
				QSParam[36] = request.getParameter("P36");
				QSParam[37] = request.getParameter("P37");
				QSParam[38] = request.getParameter("P38");
				QSParam[39] = request.getParameter("P39");
				QSParam[40] = request.getParameter("P40");
				QSParam[41] = request.getParameter("P41");
				QSParam[42] = request.getParameter("P42");
				QSParam[43] = request.getParameter("P43");
				QSParam[44] = request.getParameter("P44");
				QSParam[45] = request.getParameter("P45");
				QSParam[46] = request.getParameter("P46");
				QSParam[47] = request.getParameter("P47");
				QSParam[48] = request.getParameter("P48");
				QSParam[49] = request.getParameter("P49");
				QSParam[50] = request.getParameter("P50");
				QSParam[51] = request.getParameter("P51");
				QSParam[52] = request.getParameter("P52");
				QSParam[53] = request.getParameter("P53");
				QSParam[54] = request.getParameter("P54");
				QSParam[55] = request.getParameter("P55");
				QSParam[56] = request.getParameter("P56");
				QSParam[57] = request.getParameter("P57");
				QSParam[58] = request.getParameter("P58");
				QSParam[59] = request.getParameter("P59");
				QSParam[60] = request.getParameter("P60");
				QSParam[61] = request.getParameter("P61");
				QSParam[62] = request.getParameter("P62");
				QSParam[63] = request.getParameter("P63");
				QSParam[64] = request.getParameter("P64");
				QSParam[65] = request.getParameter("P65");
				QSParam[66] = request.getParameter("P66");
				QSParam[67] = request.getParameter("P67");
				QSParam[68] = request.getParameter("P68");
				QSParam[69] = request.getParameter("P69");
				QSParam[70] = request.getParameter("P70");
				QSParam[71] = request.getParameter("P71");
				QSParam[72] = request.getParameter("P72");
				QSParam[73] = request.getParameter("P73");
				QSParam[74] = request.getParameter("P74");
				QSParam[75] = request.getParameter("P75");
				QSParam[76] = request.getParameter("P76");
				QSParam[77] = request.getParameter("P77");
				QSParam[78] = request.getParameter("P78");
				QSParam[79] = request.getParameter("P79");
				QSParam[80] = request.getParameter("P80");
				QSParam[81] = request.getParameter("P81");
				QSParam[82] = request.getParameter("P82");
				QSParam[83] = request.getParameter("P83");
				QSParam[84] = request.getParameter("P84");
				QSParam[85] = request.getParameter("P85");
				QSParam[86] = request.getParameter("P86");
				QSParam[87] = request.getParameter("P87");
				QSParam[88] = request.getParameter("P88");
				QSParam[89] = request.getParameter("P89");
				QSParam[90] = request.getParameter("P90");
				QSParam[91] = request.getParameter("P91");
				QSParam[92] = request.getParameter("P92");
				QSParam[93] = request.getParameter("P93");
				QSParam[94] = request.getParameter("P94");
				QSParam[95] = request.getParameter("P95");
				QSParam[96] = request.getParameter("P96");
				QSParam[97] = request.getParameter("P97");
				QSParam[98] = request.getParameter("P98");
				QSParam[99] = request.getParameter("P99");

				String[] ParameterDescriptionArray = new String[100];
				ParameterDescriptionArray[0] = null;
				ParameterDescriptionArray[1] = station.getP01();
				ParameterDescriptionArray[2] = station.getP02();
				ParameterDescriptionArray[3] = station.getP03();
				ParameterDescriptionArray[4] = station.getP04();
				ParameterDescriptionArray[5] = station.getP05();
				ParameterDescriptionArray[6] = station.getP06();
				ParameterDescriptionArray[7] = station.getP07();
				ParameterDescriptionArray[8] = station.getP08();
				ParameterDescriptionArray[9] = station.getP09();
				ParameterDescriptionArray[10] = station.getP10();
				ParameterDescriptionArray[11] = station.getP11();
				ParameterDescriptionArray[12] = station.getP12();
				ParameterDescriptionArray[13] = station.getP13();
				ParameterDescriptionArray[14] = station.getP14();
				ParameterDescriptionArray[15] = station.getP15();
				ParameterDescriptionArray[16] = station.getP16();
				ParameterDescriptionArray[17] = station.getP17();
				ParameterDescriptionArray[18] = station.getP18();
				ParameterDescriptionArray[19] = station.getP19();
				ParameterDescriptionArray[20] = station.getP20();
				ParameterDescriptionArray[21] = station.getP21();
				ParameterDescriptionArray[22] = station.getP22();
				ParameterDescriptionArray[23] = station.getP23();
				ParameterDescriptionArray[24] = station.getP24();
				ParameterDescriptionArray[25] = station.getP25();
				ParameterDescriptionArray[26] = station.getP26();
				ParameterDescriptionArray[27] = station.getP27();
				ParameterDescriptionArray[28] = station.getP28();
				ParameterDescriptionArray[29] = station.getP29();
				ParameterDescriptionArray[30] = station.getP30();
				ParameterDescriptionArray[31] = station.getP31();
				ParameterDescriptionArray[32] = station.getP32();
				ParameterDescriptionArray[33] = station.getP33();
				ParameterDescriptionArray[34] = station.getP34();
				ParameterDescriptionArray[35] = station.getP35();
				ParameterDescriptionArray[36] = station.getP36();
				ParameterDescriptionArray[37] = station.getP37();
				ParameterDescriptionArray[38] = station.getP38();
				ParameterDescriptionArray[39] = station.getP39();
				ParameterDescriptionArray[40] = station.getP40();
				ParameterDescriptionArray[41] = station.getP41();
				ParameterDescriptionArray[42] = station.getP42();
				ParameterDescriptionArray[43] = station.getP43();
				ParameterDescriptionArray[44] = station.getP44();
				ParameterDescriptionArray[45] = station.getP45();
				ParameterDescriptionArray[46] = station.getP46();
				ParameterDescriptionArray[47] = station.getP47();
				ParameterDescriptionArray[48] = station.getP48();
				ParameterDescriptionArray[49] = station.getP49();
				ParameterDescriptionArray[50] = station.getP50();
				ParameterDescriptionArray[51] = station.getP51();
				ParameterDescriptionArray[52] = station.getP52();
				ParameterDescriptionArray[53] = station.getP53();
				ParameterDescriptionArray[54] = station.getP54();
				ParameterDescriptionArray[55] = station.getP55();
				ParameterDescriptionArray[56] = station.getP56();
				ParameterDescriptionArray[57] = station.getP57();
				ParameterDescriptionArray[58] = station.getP58();
				ParameterDescriptionArray[59] = station.getP59();
				ParameterDescriptionArray[60] = station.getP60();
				ParameterDescriptionArray[61] = station.getP61();
				ParameterDescriptionArray[62] = station.getP62();
				ParameterDescriptionArray[63] = station.getP63();
				ParameterDescriptionArray[64] = station.getP64();
				ParameterDescriptionArray[65] = station.getP65();
				ParameterDescriptionArray[66] = station.getP66();
				ParameterDescriptionArray[67] = station.getP67();
				ParameterDescriptionArray[68] = station.getP68();
				ParameterDescriptionArray[69] = station.getP69();
				ParameterDescriptionArray[70] = station.getP70();
				ParameterDescriptionArray[71] = station.getP71();
				ParameterDescriptionArray[72] = station.getP72();
				ParameterDescriptionArray[73] = station.getP73();
				ParameterDescriptionArray[74] = station.getP74();
				ParameterDescriptionArray[75] = station.getP75();
				ParameterDescriptionArray[76] = station.getP76();
				ParameterDescriptionArray[77] = station.getP77();
				ParameterDescriptionArray[78] = station.getP78();
				ParameterDescriptionArray[79] = station.getP79();
				ParameterDescriptionArray[80] = station.getP80();
				ParameterDescriptionArray[81] = station.getP81();
				ParameterDescriptionArray[82] = station.getP82();
				ParameterDescriptionArray[83] = station.getP83();
				ParameterDescriptionArray[84] = station.getP84();
				ParameterDescriptionArray[85] = station.getP85();
				ParameterDescriptionArray[86] = station.getP86();
				ParameterDescriptionArray[87] = station.getP87();
				ParameterDescriptionArray[88] = station.getP88();
				ParameterDescriptionArray[89] = station.getP89();
				ParameterDescriptionArray[90] = station.getP90();
				ParameterDescriptionArray[91] = station.getP91();
				ParameterDescriptionArray[92] = station.getP92();
				ParameterDescriptionArray[93] = station.getP93();
				ParameterDescriptionArray[94] = station.getP94();
				ParameterDescriptionArray[95] = station.getP95();
				ParameterDescriptionArray[96] = station.getP96();
				ParameterDescriptionArray[97] = station.getP97();
				ParameterDescriptionArray[98] = station.getP98();
				ParameterDescriptionArray[99] = station.getP99();

				

				for (loopcntr = 1; loopcntr < 100; loopcntr++) {
					if (ParameterDescriptionArray[loopcntr] != null) {
						String[] ParameterDescriptionArray_SplitArray = (ParameterDescriptionArray[loopcntr])
								.split(",");

						if (!(ParameterDescriptionArray_SplitArray[1]
								.equalsIgnoreCase("D"))) // if it is not a
															// display parameter
						{
							/* SHT-15 section */
							if ((ParameterDescriptionArray_SplitArray[1]
									.equalsIgnoreCase("SHT-15"))) {
								if (ParameterDescriptionArray_SplitArray[0]
										.equalsIgnoreCase("Air Temperature")) {
									if (ParameterDescriptionArray_SplitArray[3]
											.equalsIgnoreCase("Avg")) {
										QSParam[loopcntr] = handle
												.Calculate_AT_SHT15_Avg(QSParam[loopcntr]);
										SHT15_temperature_avg_buffer = QSParam[loopcntr];
									} else {
										QSParam[loopcntr] = handle
												.Calculate_AT_SHT15(QSParam[loopcntr]);
										if (ParameterDescriptionArray_SplitArray[3]
												.equalsIgnoreCase("Min"))
											SHT15_temperature_min_buffer = QSParam[loopcntr];
										if (ParameterDescriptionArray_SplitArray[3]
												.equalsIgnoreCase("Max"))
											SHT15_temperature_max_buffer = QSParam[loopcntr];
									}
								} else if (ParameterDescriptionArray_SplitArray[0]
										.equalsIgnoreCase("Air Humidity")) {
									if (ParameterDescriptionArray_SplitArray[3]
											.equalsIgnoreCase("Avg")) {
										QSParam[loopcntr] = handle
												.Calculate_AH_SHT15_Avg(
														QSParam[loopcntr],
														SHT15_temperature_avg_buffer);
									} else {
										if (ParameterDescriptionArray_SplitArray[3]
												.equalsIgnoreCase("Min"))
											QSParam[loopcntr] = handle
													.Calculate_AH_SHT15(
															QSParam[loopcntr],
															SHT15_temperature_min_buffer);
										if (ParameterDescriptionArray_SplitArray[3]
												.equalsIgnoreCase("Max"))
											QSParam[loopcntr] = handle
													.Calculate_AH_SHT15(
															QSParam[loopcntr],
															SHT15_temperature_max_buffer);
									}
								}
							}
							/* End of SHT-15 section */
							/* SHT-25 section */
							else if ((ParameterDescriptionArray_SplitArray[1]
									.equalsIgnoreCase("SHT-25"))) {
								if (ParameterDescriptionArray_SplitArray[0]
										.equalsIgnoreCase("Air Temperature")) {
									if (ParameterDescriptionArray_SplitArray[3]
											.equalsIgnoreCase("Avg")) {
										QSParam[loopcntr] = handle
												.Calculate_AT_SHT25_Avg(QSParam[loopcntr]);
									} else {
										QSParam[loopcntr] = handle
												.Calculate_AT_SHT25(QSParam[loopcntr]);
									}
								} else if (ParameterDescriptionArray_SplitArray[0]
										.equalsIgnoreCase("Air Humidity")) {
									if (ParameterDescriptionArray_SplitArray[3]
											.equalsIgnoreCase("Avg")) {
										QSParam[loopcntr] = handle
												.Calculate_AH_SHT25_Avg(QSParam[loopcntr]);
									} else {
										QSParam[loopcntr] = handle
												.Calculate_AH_SHT25(QSParam[loopcntr]);
									}
								}
							}
							/* End of SHT-25 section */

							/* VH400 section */
							else if ((ParameterDescriptionArray_SplitArray[1]
									.equalsIgnoreCase("VH400"))) {
								if (ParameterDescriptionArray_SplitArray[0]
										.equalsIgnoreCase("Soil Moisture")) {
									if (ParameterDescriptionArray_SplitArray[3]
											.equalsIgnoreCase("Avg")) {
										QSParam[loopcntr] = handle
												.Calculate_SM_VH400_Avg(QSParam[loopcntr]);
									} else {
										QSParam[loopcntr] = handle
												.Calculate_SM_VH400(QSParam[loopcntr]);
									}
								}
							}
							/* End of VH400 section */

							/* Other Sensors */
							else {
								QSParam[loopcntr] = handle.UpdateParam(
										QSParam[loopcntr],
										ParameterDescriptionArray[loopcntr]);
							}
						}
					}
				}
				Data data = new Data(ID, date, time, QSParam[1], QSParam[2],
						QSParam[3], QSParam[4], QSParam[5], QSParam[6],
						QSParam[7], QSParam[8], QSParam[9], QSParam[10],
						QSParam[11], QSParam[12], QSParam[13], QSParam[14],
						QSParam[15], QSParam[16], QSParam[17], QSParam[18],
						QSParam[19], QSParam[20], QSParam[21], QSParam[22],
						QSParam[23], QSParam[24], QSParam[25], QSParam[26],
						QSParam[27], QSParam[28], QSParam[29], QSParam[30],
						QSParam[31], QSParam[32], QSParam[33], QSParam[34],
						QSParam[35], QSParam[36], QSParam[37], QSParam[38],
						QSParam[39], QSParam[40], QSParam[41], QSParam[42],
						QSParam[43], QSParam[44], QSParam[45], QSParam[46],
						QSParam[47], QSParam[48], QSParam[49], QSParam[50],
						QSParam[51], QSParam[52], QSParam[53], QSParam[54],
						QSParam[55], QSParam[56], QSParam[57], QSParam[58],
						QSParam[59], QSParam[60], QSParam[61], QSParam[62],
						QSParam[63], QSParam[64], QSParam[65], QSParam[66],
						QSParam[67], QSParam[68], QSParam[69], QSParam[70],
						QSParam[71], QSParam[72], QSParam[73], QSParam[74],
						QSParam[75], QSParam[76], QSParam[77], QSParam[78],
						QSParam[79], QSParam[80], QSParam[81], QSParam[82],
						QSParam[83], QSParam[84], QSParam[85], QSParam[86],
						QSParam[87], QSParam[88], QSParam[89], QSParam[90],
						QSParam[91], QSParam[92], QSParam[93], QSParam[94],
						QSParam[95], QSParam[96], QSParam[97], QSParam[98],
						QSParam[99]);
				UpdateService addService = new UpdateService();
				addService.AddNewRecord(data);
			}
		}

		// String windSpeedMin= ConvertADCWindSpeedMaxMin(windSpeedMin);
		// String windSpeedAvg= ConvertADCWindSpeedSum(windSpeedAvg);
		// String windSpeedMax= ConvertADCWindSpeedMaxMin(windSpeedMax);

		/*
		 * hours=ExtractHoursFromTimeSting(time);
		 * value1=GenerateSRDoubleFromHours(hours);
		 * value2=GenerateSRDoubleFromHours(hours);
		 * value3=GenerateSRDoubleFromHours(hours);
		 * 
		 * max=value1; if (value2>=max) max=value2; if (value3>=max) max=value3;
		 * 
		 * min=value1; if (value2<=min) min=value2; if (value3<=min) min=value3;
		 * 
		 * avg=value1; if (value1>= value2 && value1<=value3) // value1 is
		 * greater than 2 but less than 3 avg=value1; if (value1>= value3 &&
		 * value1<=value2) // value1 is greater than 3 but less than 2
		 * avg=value1; if (value2>= value1 && value2<=value3) // value2 is
		 * greater than 1 but less than 3 avg=value2; if (value2>= value3 &&
		 * value2<=value1) // value2 is greater than 3 but less than 1
		 * avg=value2; if (value3>= value2 && value3<=value1) // value3 is
		 * greater than 2 but less than 1 avg=value3; if (value3>= value1 &&
		 * value3<=value2) // value3 is greater than 1 but less than 2
		 * avg=value3; String solarRadiationMin = ConvertDoubleToString(min);
		 * String solarRadiationAvg = ConvertDoubleToString(avg); String
		 * solarRadiationMax = ConvertDoubleToString(max);
		 */

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
