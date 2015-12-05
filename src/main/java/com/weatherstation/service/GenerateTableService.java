package com.weatherstation.service;

import com.weatherstation.model.Stations;
import com.weatherstation.model.Data;
import com.weatherstation.util.HibernateUtil_Stations;
import com.weatherstation.util.HibernateUtil_Data;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GenerateTableService {

	public Stations FindStationByID (String ID) {
		Session session = HibernateUtil_Stations.openSession();
		 Transaction tx = null;
		 Stations station = null;
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			
			 Query query = session.createQuery("from Stations where StationID='" + ID+ "' "); 
			 station = (Stations)query.uniqueResult();
			 tx.commit();
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }
		 return station;
	}
	
	
	public int checkIfUnique (String ID, String Date, String Time)
	{
		 List<Data> list = new ArrayList<Data>();
		 Session session = HibernateUtil_Data.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 list = session.createQuery("from Data where StationID='" + ID+ "' AND Date='"+Date+"' AND Time='"+Time+"'").list();					
			 tx.commit();
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }
		 return list.size();
		
	}

	public List<Data> getListOfData(String ID){
		 List<Data> list = new ArrayList<Data>();
		 Session session = HibernateUtil_Data.openSession();
		 Transaction tx = null;	

		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 //list = session.createQuery("from Data").list();				
			 //list = session.createQuery("from Data ORDER BY RecordIndex desc").list();	
			 list = session.createQuery("from Data where StationID='" + ID+ "' ORDER BY Date desc,Time desc").list();					
			 tx.commit();
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }
		 return list;
	}
	
	public List<Data> getListOfDataWhereDate(String ID, String Date){
		 List<Data> list = new ArrayList<Data>();
		 Session session = HibernateUtil_Data.openSession();
		 Transaction tx = null;	

		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 //list = session.createQuery("from Data").list();				
			 //list = session.createQuery("from Data ORDER BY RecordIndex desc").list();	
			 list = session.createQuery("from Data where StationID='" + ID+ "' AND Date='" +Date+"' ORDER BY Date desc,Time desc").list();					
			 tx.commit();
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }
		 return list;
	}
	
	
	
	
	public String GenerateTableHeadArrayMethod(String ID)
	{
		if (ID !=null)
		{
			
			String Row1 = "<table width=\"85%\" border=\"1\" align=\"center\" cellpadding=\"1\" cellspacing=\"1\"> <thead>   <tr align=\"center\"> <th rowspan=\"2\">Date</th> <th rowspan=\"2\">Time</th>";
			String Row2="</tr> <tr align=\"center\" valign=\"middle\">";
			Stations station2=new Stations();
			station2=FindStationByID(ID);
	
			String [] ParameterDescriptionArray = new String [100];
			ParameterDescriptionArray[0]=null;
			ParameterDescriptionArray[1]=station2.getP01();
			ParameterDescriptionArray[2]=station2.getP02();
			ParameterDescriptionArray[3]=station2.getP03();
			ParameterDescriptionArray[4]=station2.getP04();
			ParameterDescriptionArray[5]=station2.getP05();
			ParameterDescriptionArray[6]=station2.getP06();
			ParameterDescriptionArray[7]=station2.getP07();
			ParameterDescriptionArray[8]=station2.getP08();
			ParameterDescriptionArray[9]=station2.getP09();
			ParameterDescriptionArray[10]=station2.getP10();
			ParameterDescriptionArray[11]=station2.getP11();
			ParameterDescriptionArray[12]=station2.getP12();
			ParameterDescriptionArray[13]=station2.getP13();
			ParameterDescriptionArray[14]=station2.getP14();
			ParameterDescriptionArray[15]=station2.getP15();
			ParameterDescriptionArray[16]=station2.getP16();
			ParameterDescriptionArray[17]=station2.getP17();
			ParameterDescriptionArray[18]=station2.getP18();
			ParameterDescriptionArray[19]=station2.getP19();
			ParameterDescriptionArray[20]=station2.getP20();
			ParameterDescriptionArray[21]=station2.getP21();
			ParameterDescriptionArray[22]=station2.getP22();
			ParameterDescriptionArray[23]=station2.getP23();
			ParameterDescriptionArray[24]=station2.getP24();
			ParameterDescriptionArray[25]=station2.getP25();
			ParameterDescriptionArray[26]=station2.getP26();
			ParameterDescriptionArray[27]=station2.getP27();
			ParameterDescriptionArray[28]=station2.getP28();
			ParameterDescriptionArray[29]=station2.getP29();
			ParameterDescriptionArray[30]=station2.getP30();
			ParameterDescriptionArray[31]=station2.getP31();
			ParameterDescriptionArray[32]=station2.getP32();
			ParameterDescriptionArray[33]=station2.getP33();
			ParameterDescriptionArray[34]=station2.getP34();
			ParameterDescriptionArray[35]=station2.getP35();
			ParameterDescriptionArray[36]=station2.getP36();
			ParameterDescriptionArray[37]=station2.getP37();
			ParameterDescriptionArray[38]=station2.getP38();
			ParameterDescriptionArray[39]=station2.getP39();
			ParameterDescriptionArray[40]=station2.getP40();
			ParameterDescriptionArray[41]=station2.getP41();
			ParameterDescriptionArray[42]=station2.getP42();
			ParameterDescriptionArray[43]=station2.getP43();
			ParameterDescriptionArray[44]=station2.getP44();
			ParameterDescriptionArray[45]=station2.getP45();
			ParameterDescriptionArray[46]=station2.getP46();
			ParameterDescriptionArray[47]=station2.getP47();
			ParameterDescriptionArray[48]=station2.getP48();
			ParameterDescriptionArray[49]=station2.getP49();
			ParameterDescriptionArray[50]=station2.getP50();
			ParameterDescriptionArray[51]=station2.getP51();
			ParameterDescriptionArray[52]=station2.getP52();
			ParameterDescriptionArray[53]=station2.getP53();
			ParameterDescriptionArray[54]=station2.getP54();
			ParameterDescriptionArray[55]=station2.getP55();
			ParameterDescriptionArray[56]=station2.getP56();
			ParameterDescriptionArray[57]=station2.getP57();
			ParameterDescriptionArray[58]=station2.getP58();
			ParameterDescriptionArray[59]=station2.getP59();
			ParameterDescriptionArray[60]=station2.getP60();
			ParameterDescriptionArray[61]=station2.getP61();
			ParameterDescriptionArray[62]=station2.getP62();
			ParameterDescriptionArray[63]=station2.getP63();
			ParameterDescriptionArray[64]=station2.getP64();
			ParameterDescriptionArray[65]=station2.getP65();
			ParameterDescriptionArray[66]=station2.getP66();
			ParameterDescriptionArray[67]=station2.getP67();
			ParameterDescriptionArray[68]=station2.getP68();
			ParameterDescriptionArray[69]=station2.getP69();
			ParameterDescriptionArray[70]=station2.getP70();
			ParameterDescriptionArray[71]=station2.getP71();
			ParameterDescriptionArray[72]=station2.getP72();
			ParameterDescriptionArray[73]=station2.getP73();
			ParameterDescriptionArray[74]=station2.getP74();
			ParameterDescriptionArray[75]=station2.getP75();
			ParameterDescriptionArray[76]=station2.getP76();
			ParameterDescriptionArray[77]=station2.getP77();
			ParameterDescriptionArray[78]=station2.getP78();
			ParameterDescriptionArray[79]=station2.getP79();
			ParameterDescriptionArray[80]=station2.getP80();
			ParameterDescriptionArray[81]=station2.getP81();
			ParameterDescriptionArray[82]=station2.getP82();
			ParameterDescriptionArray[83]=station2.getP83();
			ParameterDescriptionArray[84]=station2.getP84();
			ParameterDescriptionArray[85]=station2.getP85();
			ParameterDescriptionArray[86]=station2.getP86();
			ParameterDescriptionArray[87]=station2.getP87();
			ParameterDescriptionArray[88]=station2.getP88();
			ParameterDescriptionArray[89]=station2.getP89();
			ParameterDescriptionArray[90]=station2.getP90();
			ParameterDescriptionArray[91]=station2.getP91();
			ParameterDescriptionArray[92]=station2.getP92();
			ParameterDescriptionArray[93]=station2.getP93();
			ParameterDescriptionArray[94]=station2.getP94();
			ParameterDescriptionArray[95]=station2.getP95();
			ParameterDescriptionArray[96]=station2.getP96();
			ParameterDescriptionArray[97]=station2.getP97();
			ParameterDescriptionArray[98]=station2.getP98();
			ParameterDescriptionArray[99]=station2.getP99();
	
			String [] Next01_Split = new String [4];
			String [] Next02_Split = new String [4];
			String NumberofParamsString=station2.getNumberOfParams();
			int NumberofParamsInt= Integer.parseInt(NumberofParamsString);
			
			for ( char loopcntr=1;loopcntr<=NumberofParamsInt;loopcntr++)
			{
				if (((ParameterDescriptionArray[loopcntr])!=null))
				{
					String [] ParameterDescriptionArray_SplitArray = (ParameterDescriptionArray[loopcntr]).split(",");
					if (ParameterDescriptionArray_SplitArray[2].equalsIgnoreCase("3"))
					{
						String Next01=ParameterDescriptionArray[loopcntr+1];
						String Next02=ParameterDescriptionArray[loopcntr+2];
	
						Next01_Split = Next01.split(",");
						Next02_Split = Next02.split(",");				
						Row1+="<th colspan=\"3\">"+ParameterDescriptionArray_SplitArray[0];
						Row1+="<br>["+ParameterDescriptionArray_SplitArray[4]+"]</th>";
						Row2+="<th bgcolor=\"#E8E6E6\">"+ParameterDescriptionArray_SplitArray[3]+"</th> <th bgcolor=\"#D3D1D1\">"+Next01_Split[3]+"</th><th bgcolor=\"#B7B7B7\">"+Next02_Split[3]+"</th>";
						loopcntr+=2;
					}
					else
					{
						Row1+="<th rowspan=\"2\">"+ParameterDescriptionArray_SplitArray[0];
						Row1+="<br>["+ParameterDescriptionArray_SplitArray[4]+"]</th>";
					}
				}
				else
				{  
					break;
				}
			}
			boolean ET0_Support_Flag=(station2.getModel()).contains("ET0 Supported");
			if (ET0_Support_Flag)
			{
				Row1+="<th rowspan=\"2\">"+"ET0"+"</th>";				
			}
			return Row1+Row2+"</tr>	</thead>";
		}
		else
		{
			return "";
		}
	}
	
	public String GenerateTableBodyArrayMethod(String ID)
	{
		String Row1 = "<tbody> <tr>";

		Stations station=new Stations();
		station=FindStationByID(ID);
			
		
		
		
		List <Data> list=getListOfData(ID);
		for(Data d:list)
		{
			if ((d.getDate())!=null)			
			{
				Row1+="<td height=\"21\">"+d.getDate()+"</td>";				
			}
			if ((d.getTime())!=null)			
			{
				Row1+="<td>"+d.getTime()+"</td>";				
			}
			
			if ((d.getP01())!=null)
			{
				if (station.getP01().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP01()+"</td>";
				}
				else if (station.getP01().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP01()+"</td>";
				}
				else if (station.getP01().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP01()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP01()+"</td>";
				}
			}
			if ((d.getP02())!=null)
			{
				if (station.getP02().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP02()+"</td>";
				}
				else if (station.getP02().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP02()+"</td>";
				}
				else if (station.getP02().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP02()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP02()+"</td>";
				}
			}
			if ((d.getP03())!=null)
			{
				if (station.getP03().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP03()+"</td>";
				}
				else if (station.getP03().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP03()+"</td>";
				}
				else if (station.getP03().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP03()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP03()+"</td>";
				}
			}
			if ((d.getP04())!=null)
			{
				if (station.getP04().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP04()+"</td>";
				}
				else if (station.getP04().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP04()+"</td>";
				}
				else if (station.getP04().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP04()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP04()+"</td>";
				}
			}
			if ((d.getP05())!=null)
			{
				if (station.getP05().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP05()+"</td>";
				}
				else if (station.getP05().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP05()+"</td>";
				}
				else if (station.getP05().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP05()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP05()+"</td>";
				}
			}
			if ((d.getP06())!=null)
			{
				if (station.getP06().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP06()+"</td>";
				}
				else if (station.getP06().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP06()+"</td>";
				}
				else if (station.getP06().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP06()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP06()+"</td>";
				}
			}
			if ((d.getP07())!=null)
			{
				if (station.getP07().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP07()+"</td>";
				}
				else if (station.getP07().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP07()+"</td>";
				}
				else if (station.getP07().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP07()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP07()+"</td>";
				}
			}
			if ((d.getP08())!=null)
			{
				if (station.getP08().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP08()+"</td>";
				}
				else if (station.getP08().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP08()+"</td>";
				}
				else if (station.getP08().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP08()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP08()+"</td>";
				}
			}
			if ((d.getP09())!=null)
			{
				if (station.getP09().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP09()+"</td>";
				}
				else if (station.getP09().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP09()+"</td>";
				}
				else if (station.getP09().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP09()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP09()+"</td>";
				}
			}
			if ((d.getP10())!=null)
			{
				if (station.getP10().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP10()+"</td>";
				}
				else if (station.getP10().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP10()+"</td>";
				}
				else if (station.getP10().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP10()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP10()+"</td>";
				}
			}
			if ((d.getP11())!=null)
			{
				if (station.getP11().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP11()+"</td>";
				}
				else if (station.getP11().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP11()+"</td>";
				}
				else if (station.getP11().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP11()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP11()+"</td>";
				}
			}
			if ((d.getP12())!=null)
			{
				if (station.getP12().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP12()+"</td>";
				}
				else if (station.getP12().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP12()+"</td>";
				}
				else if (station.getP12().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP12()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP12()+"</td>";
				}
			}
			if ((d.getP13())!=null)
			{
				if (station.getP13().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP13()+"</td>";
				}
				else if (station.getP13().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP13()+"</td>";
				}
				else if (station.getP13().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP13()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP13()+"</td>";
				}
			}
			if ((d.getP14())!=null)
			{
				if (station.getP14().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP14()+"</td>";
				}
				else if (station.getP14().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP14()+"</td>";
				}
				else if (station.getP14().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP14()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP14()+"</td>";
				}
			}
			if ((d.getP15())!=null)
			{
				if (station.getP15().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP15()+"</td>";
				}
				else if (station.getP15().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP15()+"</td>";
				}
				else if (station.getP15().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP15()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP15()+"</td>";
				}
			}
			if ((d.getP16())!=null)
			{
				if (station.getP16().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP16()+"</td>";
				}
				else if (station.getP16().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP16()+"</td>";
				}
				else if (station.getP16().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP16()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP16()+"</td>";
				}
			}
			if ((d.getP17())!=null)
			{
				if (station.getP17().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP17()+"</td>";
				}
				else if (station.getP17().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP17()+"</td>";
				}
				else if (station.getP17().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP17()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP17()+"</td>";
				}
			}
			if ((d.getP18())!=null)
			{
				if (station.getP18().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP18()+"</td>";
				}
				else if (station.getP18().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP18()+"</td>";
				}
				else if (station.getP18().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP18()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP18()+"</td>";
				}
			}
			if ((d.getP19())!=null)
			{
				if (station.getP19().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP19()+"</td>";
				}
				else if (station.getP19().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP19()+"</td>";
				}
				else if (station.getP19().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP19()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP19()+"</td>";
				}
			}
			if ((d.getP20())!=null)
			{
				if (station.getP20().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP20()+"</td>";
				}
				else if (station.getP20().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP20()+"</td>";
				}
				else if (station.getP20().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP20()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP20()+"</td>";
				}
			}
			if ((d.getP21())!=null)
			{
				if (station.getP21().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP21()+"</td>";
				}
				else if (station.getP21().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP21()+"</td>";
				}
				else if (station.getP21().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP21()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP21()+"</td>";
				}
			}
			if ((d.getP22())!=null)
			{
				if (station.getP22().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP22()+"</td>";
				}
				else if (station.getP22().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP22()+"</td>";
				}
				else if (station.getP22().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP22()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP22()+"</td>";
				}
			}
			if ((d.getP23())!=null)
			{
				if (station.getP23().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP23()+"</td>";
				}
				else if (station.getP23().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP23()+"</td>";
				}
				else if (station.getP23().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP23()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP23()+"</td>";
				}
			}
			if ((d.getP24())!=null)
			{
				if (station.getP24().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP24()+"</td>";
				}
				else if (station.getP24().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP24()+"</td>";
				}
				else if (station.getP24().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP24()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP24()+"</td>";
				}
			}
			if ((d.getP25())!=null)
			{
				if (station.getP25().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP25()+"</td>";
				}
				else if (station.getP25().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP25()+"</td>";
				}
				else if (station.getP25().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP25()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP25()+"</td>";
				}
			}
			if ((d.getP26())!=null)
			{
				if (station.getP26().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP26()+"</td>";
				}
				else if (station.getP26().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP26()+"</td>";
				}
				else if (station.getP26().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP26()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP26()+"</td>";
				}
			}
			if ((d.getP27())!=null)
			{
				if (station.getP27().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP27()+"</td>";
				}
				else if (station.getP27().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP27()+"</td>";
				}
				else if (station.getP27().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP27()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP27()+"</td>";
				}
			}
			if ((d.getP28())!=null)
			{
				if (station.getP28().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP28()+"</td>";
				}
				else if (station.getP28().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP28()+"</td>";
				}
				else if (station.getP28().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP28()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP28()+"</td>";
				}
			}
			if ((d.getP29())!=null)
			{
				if (station.getP29().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP29()+"</td>";
				}
				else if (station.getP29().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP29()+"</td>";
				}
				else if (station.getP29().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP29()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP29()+"</td>";
				}
			}
			if ((d.getP30())!=null)
			{
				if (station.getP30().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP30()+"</td>";
				}
				else if (station.getP30().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP30()+"</td>";
				}
				else if (station.getP30().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP30()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP30()+"</td>";
				}
			}
			if ((d.getP31())!=null)
			{
				if (station.getP31().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP31()+"</td>";
				}
				else if (station.getP31().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP31()+"</td>";
				}
				else if (station.getP31().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP31()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP31()+"</td>";
				}
			}
			if ((d.getP32())!=null)
			{
				if (station.getP32().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP32()+"</td>";
				}
				else if (station.getP32().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP32()+"</td>";
				}
				else if (station.getP32().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP32()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP32()+"</td>";
				}
			}
			if ((d.getP33())!=null)
			{
				if (station.getP33().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP33()+"</td>";
				}
				else if (station.getP33().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP33()+"</td>";
				}
				else if (station.getP33().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP33()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP33()+"</td>";
				}
			}
			if ((d.getP34())!=null)
			{
				if (station.getP34().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP34()+"</td>";
				}
				else if (station.getP34().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP34()+"</td>";
				}
				else if (station.getP34().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP34()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP34()+"</td>";
				}
			}
			if ((d.getP35())!=null)
			{
				if (station.getP35().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP35()+"</td>";
				}
				else if (station.getP35().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP35()+"</td>";
				}
				else if (station.getP35().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP35()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP35()+"</td>";
				}
			}
			if ((d.getP36())!=null)
			{
				if (station.getP36().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP36()+"</td>";
				}
				else if (station.getP36().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP36()+"</td>";
				}
				else if (station.getP36().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP36()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP36()+"</td>";
				}
			}
			if ((d.getP37())!=null)
			{
				if (station.getP37().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP37()+"</td>";
				}
				else if (station.getP37().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP37()+"</td>";
				}
				else if (station.getP37().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP37()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP37()+"</td>";
				}
			}
			if ((d.getP38())!=null)
			{
				if (station.getP38().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP38()+"</td>";
				}
				else if (station.getP38().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP38()+"</td>";
				}
				else if (station.getP38().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP38()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP38()+"</td>";
				}
			}
			if ((d.getP39())!=null)
			{
				if (station.getP39().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP39()+"</td>";
				}
				else if (station.getP39().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP39()+"</td>";
				}
				else if (station.getP39().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP39()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP39()+"</td>";
				}
			}
			if ((d.getP40())!=null)
			{
				if (station.getP40().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP40()+"</td>";
				}
				else if (station.getP40().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP40()+"</td>";
				}
				else if (station.getP40().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP40()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP40()+"</td>";
				}
			}
			if ((d.getP41())!=null)
			{
				if (station.getP41().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP41()+"</td>";
				}
				else if (station.getP41().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP41()+"</td>";
				}
				else if (station.getP41().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP41()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP41()+"</td>";
				}
			}
			if ((d.getP42())!=null)
			{
				if (station.getP42().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP42()+"</td>";
				}
				else if (station.getP42().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP42()+"</td>";
				}
				else if (station.getP42().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP42()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP42()+"</td>";
				}
			}
			if ((d.getP43())!=null)
			{
				if (station.getP43().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP43()+"</td>";
				}
				else if (station.getP43().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP43()+"</td>";
				}
				else if (station.getP43().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP43()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP43()+"</td>";
				}
			}
			if ((d.getP44())!=null)
			{
				if (station.getP44().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP44()+"</td>";
				}
				else if (station.getP44().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP44()+"</td>";
				}
				else if (station.getP44().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP44()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP44()+"</td>";
				}
			}
			if ((d.getP45())!=null)
			{
				if (station.getP45().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP45()+"</td>";
				}
				else if (station.getP45().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP45()+"</td>";
				}
				else if (station.getP45().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP45()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP45()+"</td>";
				}
			}
			if ((d.getP46())!=null)
			{
				if (station.getP46().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP46()+"</td>";
				}
				else if (station.getP46().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP46()+"</td>";
				}
				else if (station.getP46().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP46()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP46()+"</td>";
				}
			}
			if ((d.getP47())!=null)
			{
				if (station.getP47().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP47()+"</td>";
				}
				else if (station.getP47().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP47()+"</td>";
				}
				else if (station.getP47().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP47()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP47()+"</td>";
				}
			}
			if ((d.getP48())!=null)
			{
				if (station.getP48().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP48()+"</td>";
				}
				else if (station.getP48().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP48()+"</td>";
				}
				else if (station.getP48().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP48()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP48()+"</td>";
				}
			}
			if ((d.getP49())!=null)
			{
				if (station.getP49().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP49()+"</td>";
				}
				else if (station.getP49().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP49()+"</td>";
				}
				else if (station.getP49().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP49()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP49()+"</td>";
				}
			}
			if ((d.getP50())!=null)
			{
				if (station.getP50().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP50()+"</td>";
				}
				else if (station.getP50().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP50()+"</td>";
				}
				else if (station.getP50().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP50()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP50()+"</td>";
				}
			}
			if ((d.getP51())!=null)
			{
				if (station.getP51().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP51()+"</td>";
				}
				else if (station.getP51().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP51()+"</td>";
				}
				else if (station.getP51().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP51()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP51()+"</td>";
				}
			}
			if ((d.getP52())!=null)
			{
				if (station.getP52().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP52()+"</td>";
				}
				else if (station.getP52().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP52()+"</td>";
				}
				else if (station.getP52().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP52()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP52()+"</td>";
				}
			}
			if ((d.getP53())!=null)
			{
				if (station.getP53().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP53()+"</td>";
				}
				else if (station.getP53().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP53()+"</td>";
				}
				else if (station.getP53().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP53()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP53()+"</td>";
				}
			}
			if ((d.getP54())!=null)
			{
				if (station.getP54().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP54()+"</td>";
				}
				else if (station.getP54().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP54()+"</td>";
				}
				else if (station.getP54().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP54()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP54()+"</td>";
				}
			}
			if ((d.getP55())!=null)
			{
				if (station.getP55().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP55()+"</td>";
				}
				else if (station.getP55().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP55()+"</td>";
				}
				else if (station.getP55().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP55()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP55()+"</td>";
				}
			}
			if ((d.getP56())!=null)
			{
				if (station.getP56().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP56()+"</td>";
				}
				else if (station.getP56().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP56()+"</td>";
				}
				else if (station.getP56().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP56()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP56()+"</td>";
				}
			}
			if ((d.getP57())!=null)
			{
				if (station.getP57().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP57()+"</td>";
				}
				else if (station.getP57().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP57()+"</td>";
				}
				else if (station.getP57().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP57()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP57()+"</td>";
				}
			}
			if ((d.getP58())!=null)
			{
				if (station.getP58().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP58()+"</td>";
				}
				else if (station.getP58().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP58()+"</td>";
				}
				else if (station.getP58().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP58()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP58()+"</td>";
				}
			}
			if ((d.getP59())!=null)
			{
				if (station.getP59().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP59()+"</td>";
				}
				else if (station.getP59().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP59()+"</td>";
				}
				else if (station.getP59().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP59()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP59()+"</td>";
				}
			}
			if ((d.getP60())!=null)
			{
				if (station.getP60().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP60()+"</td>";
				}
				else if (station.getP60().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP60()+"</td>";
				}
				else if (station.getP60().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP60()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP60()+"</td>";
				}
			}
			if ((d.getP61())!=null)
			{
				if (station.getP61().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP61()+"</td>";
				}
				else if (station.getP61().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP61()+"</td>";
				}
				else if (station.getP61().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP61()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP61()+"</td>";
				}
			}
			if ((d.getP62())!=null)
			{
				if (station.getP62().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP62()+"</td>";
				}
				else if (station.getP62().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP62()+"</td>";
				}
				else if (station.getP62().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP62()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP62()+"</td>";
				}
			}
			if ((d.getP63())!=null)
			{
				if (station.getP63().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP63()+"</td>";
				}
				else if (station.getP63().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP63()+"</td>";
				}
				else if (station.getP63().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP63()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP63()+"</td>";
				}
			}
			if ((d.getP64())!=null)
			{
				if (station.getP64().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP64()+"</td>";
				}
				else if (station.getP64().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP64()+"</td>";
				}
				else if (station.getP64().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP64()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP64()+"</td>";
				}
			}
			if ((d.getP65())!=null)
			{
				if (station.getP65().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP65()+"</td>";
				}
				else if (station.getP65().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP65()+"</td>";
				}
				else if (station.getP65().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP65()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP65()+"</td>";
				}
			}
			if ((d.getP66())!=null)
			{
				if (station.getP66().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP66()+"</td>";
				}
				else if (station.getP66().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP66()+"</td>";
				}
				else if (station.getP66().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP66()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP66()+"</td>";
				}
			}
			if ((d.getP67())!=null)
			{
				if (station.getP67().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP67()+"</td>";
				}
				else if (station.getP67().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP67()+"</td>";
				}
				else if (station.getP67().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP67()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP67()+"</td>";
				}
			}
			if ((d.getP68())!=null)
			{
				if (station.getP68().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP68()+"</td>";
				}
				else if (station.getP68().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP68()+"</td>";
				}
				else if (station.getP68().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP68()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP68()+"</td>";
				}
			}
			if ((d.getP69())!=null)
			{
				if (station.getP69().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP69()+"</td>";
				}
				else if (station.getP69().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP69()+"</td>";
				}
				else if (station.getP69().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP69()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP69()+"</td>";
				}
			}
			if ((d.getP70())!=null)
			{
				if (station.getP70().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP70()+"</td>";
				}
				else if (station.getP70().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP70()+"</td>";
				}
				else if (station.getP70().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP70()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP70()+"</td>";
				}
			}
			if ((d.getP71())!=null)
			{
				if (station.getP71().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP71()+"</td>";
				}
				else if (station.getP71().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP71()+"</td>";
				}
				else if (station.getP71().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP71()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP71()+"</td>";
				}
			}
			if ((d.getP72())!=null)
			{
				if (station.getP72().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP72()+"</td>";
				}
				else if (station.getP72().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP72()+"</td>";
				}
				else if (station.getP72().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP72()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP72()+"</td>";
				}
			}
			if ((d.getP73())!=null)
			{
				if (station.getP73().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP73()+"</td>";
				}
				else if (station.getP73().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP73()+"</td>";
				}
				else if (station.getP73().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP73()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP73()+"</td>";
				}
			}
			if ((d.getP74())!=null)
			{
				if (station.getP74().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP74()+"</td>";
				}
				else if (station.getP74().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP74()+"</td>";
				}
				else if (station.getP74().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP74()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP74()+"</td>";
				}
			}
			if ((d.getP75())!=null)
			{
				if (station.getP75().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP75()+"</td>";
				}
				else if (station.getP75().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP75()+"</td>";
				}
				else if (station.getP75().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP75()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP75()+"</td>";
				}
			}
			if ((d.getP76())!=null)
			{
				if (station.getP76().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP76()+"</td>";
				}
				else if (station.getP76().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP76()+"</td>";
				}
				else if (station.getP76().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP76()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP76()+"</td>";
				}
			}
			if ((d.getP77())!=null)
			{
				if (station.getP77().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP77()+"</td>";
				}
				else if (station.getP77().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP77()+"</td>";
				}
				else if (station.getP77().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP77()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP77()+"</td>";
				}
			}
			if ((d.getP78())!=null)
			{
				if (station.getP78().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP78()+"</td>";
				}
				else if (station.getP78().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP78()+"</td>";
				}
				else if (station.getP78().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP78()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP78()+"</td>";
				}
			}
			if ((d.getP79())!=null)
			{
				if (station.getP79().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP79()+"</td>";
				}
				else if (station.getP79().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP79()+"</td>";
				}
				else if (station.getP79().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP79()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP79()+"</td>";
				}
			}
			if ((d.getP80())!=null)
			{
				if (station.getP80().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP80()+"</td>";
				}
				else if (station.getP80().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP80()+"</td>";
				}
				else if (station.getP80().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP80()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP80()+"</td>";
				}
			}
			if ((d.getP81())!=null)
			{
				if (station.getP81().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP81()+"</td>";
				}
				else if (station.getP81().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP81()+"</td>";
				}
				else if (station.getP81().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP81()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP81()+"</td>";
				}
			}
			if ((d.getP82())!=null)
			{
				if (station.getP82().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP82()+"</td>";
				}
				else if (station.getP82().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP82()+"</td>";
				}
				else if (station.getP82().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP82()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP82()+"</td>";
				}
			}
			if ((d.getP83())!=null)
			{
				if (station.getP83().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP83()+"</td>";
				}
				else if (station.getP83().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP83()+"</td>";
				}
				else if (station.getP83().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP83()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP83()+"</td>";
				}
			}
			if ((d.getP84())!=null)
			{
				if (station.getP84().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP84()+"</td>";
				}
				else if (station.getP84().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP84()+"</td>";
				}
				else if (station.getP84().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP84()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP84()+"</td>";
				}
			}
			if ((d.getP85())!=null)
			{
				if (station.getP85().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP85()+"</td>";
				}
				else if (station.getP85().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP85()+"</td>";
				}
				else if (station.getP85().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP85()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP85()+"</td>";
				}
			}
			if ((d.getP86())!=null)
			{
				if (station.getP86().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP86()+"</td>";
				}
				else if (station.getP86().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP86()+"</td>";
				}
				else if (station.getP86().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP86()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP86()+"</td>";
				}
			}
			if ((d.getP87())!=null)
			{
				if (station.getP87().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP87()+"</td>";
				}
				else if (station.getP87().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP87()+"</td>";
				}
				else if (station.getP87().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP87()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP87()+"</td>";
				}
			}
			if ((d.getP88())!=null)
			{
				if (station.getP88().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP88()+"</td>";
				}
				else if (station.getP88().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP88()+"</td>";
				}
				else if (station.getP88().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP88()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP88()+"</td>";
				}
			}
			if ((d.getP89())!=null)
			{
				if (station.getP89().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP89()+"</td>";
				}
				else if (station.getP89().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP89()+"</td>";
				}
				else if (station.getP89().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP89()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP89()+"</td>";
				}
			}
			if ((d.getP90())!=null)
			{
				if (station.getP90().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP90()+"</td>";
				}
				else if (station.getP90().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP90()+"</td>";
				}
				else if (station.getP90().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP90()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP90()+"</td>";
				}
			}
			if ((d.getP91())!=null)
			{
				if (station.getP91().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP91()+"</td>";
				}
				else if (station.getP91().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP91()+"</td>";
				}
				else if (station.getP91().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP91()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP91()+"</td>";
				}
			}
			if ((d.getP92())!=null)
			{
				if (station.getP92().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP92()+"</td>";
				}
				else if (station.getP92().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP92()+"</td>";
				}
				else if (station.getP92().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP92()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP92()+"</td>";
				}
			}
			if ((d.getP93())!=null)
			{
				if (station.getP93().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP93()+"</td>";
				}
				else if (station.getP93().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP93()+"</td>";
				}
				else if (station.getP93().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP93()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP93()+"</td>";
				}
			}
			if ((d.getP94())!=null)
			{
				if (station.getP94().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP94()+"</td>";
				}
				else if (station.getP94().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP94()+"</td>";
				}
				else if (station.getP94().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP94()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP94()+"</td>";
				}
			}
			if ((d.getP95())!=null)
			{
				if (station.getP95().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP95()+"</td>";
				}
				else if (station.getP95().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP95()+"</td>";
				}
				else if (station.getP95().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP95()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP95()+"</td>";
				}
			}
			if ((d.getP96())!=null)
			{
				if (station.getP96().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP96()+"</td>";
				}
				else if (station.getP96().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP96()+"</td>";
				}
				else if (station.getP96().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP96()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP96()+"</td>";
				}
			}
			if ((d.getP97())!=null)
			{
				if (station.getP97().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP97()+"</td>";
				}
				else if (station.getP97().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP97()+"</td>";
				}
				else if (station.getP97().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP97()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP97()+"</td>";
				}
			}
			if ((d.getP98())!=null)
			{
				if (station.getP98().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP98()+"</td>";
				}
				else if (station.getP98().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP98()+"</td>";
				}
				else if (station.getP98().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP98()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP98()+"</td>";
				}
			}
			if ((d.getP99())!=null)
			{
				if (station.getP99().contains("3,Min"))
				{
					Row1+="<td bgcolor=\"#E8E6E6\">"+d.getP99()+"</td>";
				}
				else if (station.getP99().contains("3,Avg"))
				{
					Row1+="<td bgcolor=\"#D3D1D1\">"+d.getP99()+"</td>";
				}
				else if (station.getP99().contains("3,Max"))
				{
					Row1+="<td bgcolor=\"#B7B7B7\">"+d.getP99()+"</td>";
				}
				else
				{
					Row1+="<td>"+d.getP99()+"</td>";
				}
			}						
			boolean ET0_Support_Flag=(station.getModel()).contains("ET0 Supported");
			if (ET0_Support_Flag)
			{
				if (d.getTime().equals("23:00"))
				{
					ET0CalculatorService et0_Calc_Service= new ET0CalculatorService ();
					String ET0=et0_Calc_Service.ClaculateET0String(ID,d.getDate());
					
					Row1+="<td>"+ET0+"</td>";				
				}
			}												
			
			
			Row1+="</tr>";
		}
		return Row1+"</tbody> </table>";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
