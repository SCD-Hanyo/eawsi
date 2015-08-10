package com.weatherstation.service;

import java.util.GregorianCalendar;
import java.util.List;

import com.weatherstation.model.Data;
import com.weatherstation.model.Stations;

public class ET0CalculatorService {
	String ClaculateET0String (String ID,String Date)
	{
		
		String ET0="blank";
		try
		{
			GenerateTableService queryAssistant = new GenerateTableService();
			Stations station=queryAssistant.FindStationByID(ID);
			List <Data> list=queryAssistant.getListOfDataWhereDate(ID, Date);
			
			double [] ATMinArrayDouble=new double [24];
			double [] ATMaxArrayDouble=new double [24];
			double [] AHMinArrayDouble=new double [24];
			double [] AHMaxArrayDouble=new double [24];
			double [] WSAvgArrayDouble=new double [24];
			double [] SRAvgArrayDouble=new double [24];
			double Lat=Double.parseDouble((station.getLatitude()));
//			double Longi=Double.parseDouble((station.getLongitude()));
			double Alti=Double.parseDouble((station.getAltitude()));
			int Julian=Calc_Julian(Date);
			int loopCntr=0;
			
			//from data:
			//Array of AirTemp Min => min
			//Array of AirTemp Max => max
			//Array of WindSpeed Avg=>getAverage
			//Array of SolarRadiation (in Watt per meter Square)=> get sum
			//Array of Air Hum Min=> min
			//Array of Air Hum Max=> max
			
			
			for(Data d:list)
			{
				if (station.getP01()!=null)
				{

					if ((station.getP01().contains("Air Temperature")) && (station.getP01().contains("Min")))
					{
						boolean test=isNumeric (d.getP01());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP01());						
						}
					}
					if ((station.getP01().contains("Air Temperature")) && (station.getP01().contains("Max")))
					{
						boolean test=isNumeric (d.getP01());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP01());						
						}
					}
					if ((station.getP01().contains("Air Humidity")) && (station.getP01().contains("Min")))
					{
						boolean test=isNumeric (d.getP01());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP01());						
						}
					}
					if ((station.getP01().contains("Air Humidity")) && (station.getP01().contains("Max")))
					{
						boolean test=isNumeric (d.getP01());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP01());						
						}
					}
					if ((station.getP01().contains("Wind Speed")) && (station.getP01().contains("Avg")))
					{
						boolean test=isNumeric (d.getP01());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP01());						
						}
					}				
					if ((station.getP01().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP01());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP01());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP02()!=null)
				{

					if ((station.getP02().contains("Air Temperature")) && (station.getP02().contains("Min")))
					{
						boolean test=isNumeric (d.getP02());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP02());						
						}
					}
					if ((station.getP02().contains("Air Temperature")) && (station.getP02().contains("Max")))
					{
						boolean test=isNumeric (d.getP02());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP02());						
						}
					}
					if ((station.getP02().contains("Air Humidity")) && (station.getP02().contains("Min")))
					{
						boolean test=isNumeric (d.getP02());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP02());						
						}
					}
					if ((station.getP02().contains("Air Humidity")) && (station.getP02().contains("Max")))
					{
						boolean test=isNumeric (d.getP02());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP02());						
						}
					}
					if ((station.getP02().contains("Wind Speed")) && (station.getP02().contains("Avg")))
					{
						boolean test=isNumeric (d.getP02());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP02());						
						}
					}				
					if ((station.getP02().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP02());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP02());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP03()!=null)
				{

					if ((station.getP03().contains("Air Temperature")) && (station.getP03().contains("Min")))
					{
						boolean test=isNumeric (d.getP03());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP03());						
						}
					}
					if ((station.getP03().contains("Air Temperature")) && (station.getP03().contains("Max")))
					{
						boolean test=isNumeric (d.getP03());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP03());						
						}
					}
					if ((station.getP03().contains("Air Humidity")) && (station.getP03().contains("Min")))
					{
						boolean test=isNumeric (d.getP03());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP03());						
						}
					}
					if ((station.getP03().contains("Air Humidity")) && (station.getP03().contains("Max")))
					{
						boolean test=isNumeric (d.getP03());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP03());						
						}
					}
					if ((station.getP03().contains("Wind Speed")) && (station.getP03().contains("Avg")))
					{
						boolean test=isNumeric (d.getP03());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP03());						
						}
					}				
					if ((station.getP03().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP03());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP03());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP04()!=null)
				{

					if ((station.getP04().contains("Air Temperature")) && (station.getP04().contains("Min")))
					{
						boolean test=isNumeric (d.getP04());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP04());						
						}
					}
					if ((station.getP04().contains("Air Temperature")) && (station.getP04().contains("Max")))
					{
						boolean test=isNumeric (d.getP04());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP04());						
						}
					}
					if ((station.getP04().contains("Air Humidity")) && (station.getP04().contains("Min")))
					{
						boolean test=isNumeric (d.getP04());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP04());						
						}
					}
					if ((station.getP04().contains("Air Humidity")) && (station.getP04().contains("Max")))
					{
						boolean test=isNumeric (d.getP04());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP04());						
						}
					}
					if ((station.getP04().contains("Wind Speed")) && (station.getP04().contains("Avg")))
					{
						boolean test=isNumeric (d.getP04());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP04());						
						}
					}				
					if ((station.getP04().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP04());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP04());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP05()!=null)
				{

					if ((station.getP05().contains("Air Temperature")) && (station.getP05().contains("Min")))
					{
						boolean test=isNumeric (d.getP05());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP05());						
						}
					}
					if ((station.getP05().contains("Air Temperature")) && (station.getP05().contains("Max")))
					{
						boolean test=isNumeric (d.getP05());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP05());						
						}
					}
					if ((station.getP05().contains("Air Humidity")) && (station.getP05().contains("Min")))
					{
						boolean test=isNumeric (d.getP05());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP05());						
						}
					}
					if ((station.getP05().contains("Air Humidity")) && (station.getP05().contains("Max")))
					{
						boolean test=isNumeric (d.getP05());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP05());						
						}
					}
					if ((station.getP05().contains("Wind Speed")) && (station.getP05().contains("Avg")))
					{
						boolean test=isNumeric (d.getP05());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP05());						
						}
					}				
					if ((station.getP05().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP05());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP05());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP06()!=null)
				{

					if ((station.getP06().contains("Air Temperature")) && (station.getP06().contains("Min")))
					{
						boolean test=isNumeric (d.getP06());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP06());						
						}
					}
					if ((station.getP06().contains("Air Temperature")) && (station.getP06().contains("Max")))
					{
						boolean test=isNumeric (d.getP06());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP06());						
						}
					}
					if ((station.getP06().contains("Air Humidity")) && (station.getP06().contains("Min")))
					{
						boolean test=isNumeric (d.getP06());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP06());						
						}
					}
					if ((station.getP06().contains("Air Humidity")) && (station.getP06().contains("Max")))
					{
						boolean test=isNumeric (d.getP06());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP06());						
						}
					}
					if ((station.getP06().contains("Wind Speed")) && (station.getP06().contains("Avg")))
					{
						boolean test=isNumeric (d.getP06());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP06());						
						}
					}				
					if ((station.getP06().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP06());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP06());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP07()!=null)
				{

					if ((station.getP07().contains("Air Temperature")) && (station.getP07().contains("Min")))
					{
						boolean test=isNumeric (d.getP07());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP07());						
						}
					}
					if ((station.getP07().contains("Air Temperature")) && (station.getP07().contains("Max")))
					{
						boolean test=isNumeric (d.getP07());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP07());						
						}
					}
					if ((station.getP07().contains("Air Humidity")) && (station.getP07().contains("Min")))
					{
						boolean test=isNumeric (d.getP07());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP07());						
						}
					}
					if ((station.getP07().contains("Air Humidity")) && (station.getP07().contains("Max")))
					{
						boolean test=isNumeric (d.getP07());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP07());						
						}
					}
					if ((station.getP07().contains("Wind Speed")) && (station.getP07().contains("Avg")))
					{
						boolean test=isNumeric (d.getP07());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP07());						
						}
					}				
					if ((station.getP07().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP07());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP07());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP08()!=null)
				{

					if ((station.getP08().contains("Air Temperature")) && (station.getP08().contains("Min")))
					{
						boolean test=isNumeric (d.getP08());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP08());						
						}
					}
					if ((station.getP08().contains("Air Temperature")) && (station.getP08().contains("Max")))
					{
						boolean test=isNumeric (d.getP08());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP08());						
						}
					}
					if ((station.getP08().contains("Air Humidity")) && (station.getP08().contains("Min")))
					{
						boolean test=isNumeric (d.getP08());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP08());						
						}
					}
					if ((station.getP08().contains("Air Humidity")) && (station.getP08().contains("Max")))
					{
						boolean test=isNumeric (d.getP08());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP08());						
						}
					}
					if ((station.getP08().contains("Wind Speed")) && (station.getP08().contains("Avg")))
					{
						boolean test=isNumeric (d.getP08());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP08());						
						}
					}				
					if ((station.getP08().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP08());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP08());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP09()!=null)
				{

					if ((station.getP09().contains("Air Temperature")) && (station.getP09().contains("Min")))
					{
						boolean test=isNumeric (d.getP09());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP09());						
						}
					}
					if ((station.getP09().contains("Air Temperature")) && (station.getP09().contains("Max")))
					{
						boolean test=isNumeric (d.getP09());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP09());						
						}
					}
					if ((station.getP09().contains("Air Humidity")) && (station.getP09().contains("Min")))
					{
						boolean test=isNumeric (d.getP09());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP09());						
						}
					}
					if ((station.getP09().contains("Air Humidity")) && (station.getP09().contains("Max")))
					{
						boolean test=isNumeric (d.getP09());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP09());						
						}
					}
					if ((station.getP09().contains("Wind Speed")) && (station.getP09().contains("Avg")))
					{
						boolean test=isNumeric (d.getP09());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP09());						
						}
					}				
					if ((station.getP09().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP09());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP09());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP10()!=null)
				{

					if ((station.getP10().contains("Air Temperature")) && (station.getP10().contains("Min")))
					{
						boolean test=isNumeric (d.getP10());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP10());						
						}
					}
					if ((station.getP10().contains("Air Temperature")) && (station.getP10().contains("Max")))
					{
						boolean test=isNumeric (d.getP10());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP10());						
						}
					}
					if ((station.getP10().contains("Air Humidity")) && (station.getP10().contains("Min")))
					{
						boolean test=isNumeric (d.getP10());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP10());						
						}
					}
					if ((station.getP10().contains("Air Humidity")) && (station.getP10().contains("Max")))
					{
						boolean test=isNumeric (d.getP10());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP10());						
						}
					}
					if ((station.getP10().contains("Wind Speed")) && (station.getP10().contains("Avg")))
					{
						boolean test=isNumeric (d.getP10());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP10());						
						}
					}				
					if ((station.getP10().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP10());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP10());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP11()!=null)
				{

					if ((station.getP11().contains("Air Temperature")) && (station.getP11().contains("Min")))
					{
						boolean test=isNumeric (d.getP11());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP11());						
						}
					}
					if ((station.getP11().contains("Air Temperature")) && (station.getP11().contains("Max")))
					{
						boolean test=isNumeric (d.getP11());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP11());						
						}
					}
					if ((station.getP11().contains("Air Humidity")) && (station.getP11().contains("Min")))
					{
						boolean test=isNumeric (d.getP11());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP11());						
						}
					}
					if ((station.getP11().contains("Air Humidity")) && (station.getP11().contains("Max")))
					{
						boolean test=isNumeric (d.getP11());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP11());						
						}
					}
					if ((station.getP11().contains("Wind Speed")) && (station.getP11().contains("Avg")))
					{
						boolean test=isNumeric (d.getP11());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP11());						
						}
					}				
					if ((station.getP11().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP11());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP11());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP12()!=null)
				{

					if ((station.getP12().contains("Air Temperature")) && (station.getP12().contains("Min")))
					{
						boolean test=isNumeric (d.getP12());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP12());						
						}
					}
					if ((station.getP12().contains("Air Temperature")) && (station.getP12().contains("Max")))
					{
						boolean test=isNumeric (d.getP12());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP12());						
						}
					}
					if ((station.getP12().contains("Air Humidity")) && (station.getP12().contains("Min")))
					{
						boolean test=isNumeric (d.getP12());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP12());						
						}
					}
					if ((station.getP12().contains("Air Humidity")) && (station.getP12().contains("Max")))
					{
						boolean test=isNumeric (d.getP12());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP12());						
						}
					}
					if ((station.getP12().contains("Wind Speed")) && (station.getP12().contains("Avg")))
					{
						boolean test=isNumeric (d.getP12());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP12());						
						}
					}				
					if ((station.getP12().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP12());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP12());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP13()!=null)
				{

					if ((station.getP13().contains("Air Temperature")) && (station.getP13().contains("Min")))
					{
						boolean test=isNumeric (d.getP13());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP13());						
						}
					}
					if ((station.getP13().contains("Air Temperature")) && (station.getP13().contains("Max")))
					{
						boolean test=isNumeric (d.getP13());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP13());						
						}
					}
					if ((station.getP13().contains("Air Humidity")) && (station.getP13().contains("Min")))
					{
						boolean test=isNumeric (d.getP13());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP13());						
						}
					}
					if ((station.getP13().contains("Air Humidity")) && (station.getP13().contains("Max")))
					{
						boolean test=isNumeric (d.getP13());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP13());						
						}
					}
					if ((station.getP13().contains("Wind Speed")) && (station.getP13().contains("Avg")))
					{
						boolean test=isNumeric (d.getP13());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP13());						
						}
					}				
					if ((station.getP13().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP13());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP13());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP14()!=null)
				{

					if ((station.getP14().contains("Air Temperature")) && (station.getP14().contains("Min")))
					{
						boolean test=isNumeric (d.getP14());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP14());						
						}
					}
					if ((station.getP14().contains("Air Temperature")) && (station.getP14().contains("Max")))
					{
						boolean test=isNumeric (d.getP14());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP14());						
						}
					}
					if ((station.getP14().contains("Air Humidity")) && (station.getP14().contains("Min")))
					{
						boolean test=isNumeric (d.getP14());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP14());						
						}
					}
					if ((station.getP14().contains("Air Humidity")) && (station.getP14().contains("Max")))
					{
						boolean test=isNumeric (d.getP14());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP14());						
						}
					}
					if ((station.getP14().contains("Wind Speed")) && (station.getP14().contains("Avg")))
					{
						boolean test=isNumeric (d.getP14());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP14());						
						}
					}				
					if ((station.getP14().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP14());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP14());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP15()!=null)
				{

					if ((station.getP15().contains("Air Temperature")) && (station.getP15().contains("Min")))
					{
						boolean test=isNumeric (d.getP15());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP15());						
						}
					}
					if ((station.getP15().contains("Air Temperature")) && (station.getP15().contains("Max")))
					{
						boolean test=isNumeric (d.getP15());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP15());						
						}
					}
					if ((station.getP15().contains("Air Humidity")) && (station.getP15().contains("Min")))
					{
						boolean test=isNumeric (d.getP15());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP15());						
						}
					}
					if ((station.getP15().contains("Air Humidity")) && (station.getP15().contains("Max")))
					{
						boolean test=isNumeric (d.getP15());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP15());						
						}
					}
					if ((station.getP15().contains("Wind Speed")) && (station.getP15().contains("Avg")))
					{
						boolean test=isNumeric (d.getP15());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP15());						
						}
					}				
					if ((station.getP15().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP15());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP15());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP16()!=null)
				{

					if ((station.getP16().contains("Air Temperature")) && (station.getP16().contains("Min")))
					{
						boolean test=isNumeric (d.getP16());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP16());						
						}
					}
					if ((station.getP16().contains("Air Temperature")) && (station.getP16().contains("Max")))
					{
						boolean test=isNumeric (d.getP16());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP16());						
						}
					}
					if ((station.getP16().contains("Air Humidity")) && (station.getP16().contains("Min")))
					{
						boolean test=isNumeric (d.getP16());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP16());						
						}
					}
					if ((station.getP16().contains("Air Humidity")) && (station.getP16().contains("Max")))
					{
						boolean test=isNumeric (d.getP16());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP16());						
						}
					}
					if ((station.getP16().contains("Wind Speed")) && (station.getP16().contains("Avg")))
					{
						boolean test=isNumeric (d.getP16());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP16());						
						}
					}				
					if ((station.getP16().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP16());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP16());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP17()!=null)
				{

					if ((station.getP17().contains("Air Temperature")) && (station.getP17().contains("Min")))
					{
						boolean test=isNumeric (d.getP17());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP17());						
						}
					}
					if ((station.getP17().contains("Air Temperature")) && (station.getP17().contains("Max")))
					{
						boolean test=isNumeric (d.getP17());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP17());						
						}
					}
					if ((station.getP17().contains("Air Humidity")) && (station.getP17().contains("Min")))
					{
						boolean test=isNumeric (d.getP17());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP17());						
						}
					}
					if ((station.getP17().contains("Air Humidity")) && (station.getP17().contains("Max")))
					{
						boolean test=isNumeric (d.getP17());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP17());						
						}
					}
					if ((station.getP17().contains("Wind Speed")) && (station.getP17().contains("Avg")))
					{
						boolean test=isNumeric (d.getP17());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP17());						
						}
					}				
					if ((station.getP17().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP17());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP17());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP18()!=null)
				{

					if ((station.getP18().contains("Air Temperature")) && (station.getP18().contains("Min")))
					{
						boolean test=isNumeric (d.getP18());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP18());						
						}
					}
					if ((station.getP18().contains("Air Temperature")) && (station.getP18().contains("Max")))
					{
						boolean test=isNumeric (d.getP18());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP18());						
						}
					}
					if ((station.getP18().contains("Air Humidity")) && (station.getP18().contains("Min")))
					{
						boolean test=isNumeric (d.getP18());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP18());						
						}
					}
					if ((station.getP18().contains("Air Humidity")) && (station.getP18().contains("Max")))
					{
						boolean test=isNumeric (d.getP18());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP18());						
						}
					}
					if ((station.getP18().contains("Wind Speed")) && (station.getP18().contains("Avg")))
					{
						boolean test=isNumeric (d.getP18());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP18());						
						}
					}				
					if ((station.getP18().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP18());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP18());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP19()!=null)
				{

					if ((station.getP19().contains("Air Temperature")) && (station.getP19().contains("Min")))
					{
						boolean test=isNumeric (d.getP19());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP19());						
						}
					}
					if ((station.getP19().contains("Air Temperature")) && (station.getP19().contains("Max")))
					{
						boolean test=isNumeric (d.getP19());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP19());						
						}
					}
					if ((station.getP19().contains("Air Humidity")) && (station.getP19().contains("Min")))
					{
						boolean test=isNumeric (d.getP19());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP19());						
						}
					}
					if ((station.getP19().contains("Air Humidity")) && (station.getP19().contains("Max")))
					{
						boolean test=isNumeric (d.getP19());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP19());						
						}
					}
					if ((station.getP19().contains("Wind Speed")) && (station.getP19().contains("Avg")))
					{
						boolean test=isNumeric (d.getP19());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP19());						
						}
					}				
					if ((station.getP19().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP19());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP19());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP20()!=null)
				{

					if ((station.getP20().contains("Air Temperature")) && (station.getP20().contains("Min")))
					{
						boolean test=isNumeric (d.getP20());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP20());						
						}
					}
					if ((station.getP20().contains("Air Temperature")) && (station.getP20().contains("Max")))
					{
						boolean test=isNumeric (d.getP20());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP20());						
						}
					}
					if ((station.getP20().contains("Air Humidity")) && (station.getP20().contains("Min")))
					{
						boolean test=isNumeric (d.getP20());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP20());						
						}
					}
					if ((station.getP20().contains("Air Humidity")) && (station.getP20().contains("Max")))
					{
						boolean test=isNumeric (d.getP20());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP20());						
						}
					}
					if ((station.getP20().contains("Wind Speed")) && (station.getP20().contains("Avg")))
					{
						boolean test=isNumeric (d.getP20());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP20());						
						}
					}				
					if ((station.getP20().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP20());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP20());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP21()!=null)
				{

					if ((station.getP21().contains("Air Temperature")) && (station.getP21().contains("Min")))
					{
						boolean test=isNumeric (d.getP21());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP21());						
						}
					}
					if ((station.getP21().contains("Air Temperature")) && (station.getP21().contains("Max")))
					{
						boolean test=isNumeric (d.getP21());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP21());						
						}
					}
					if ((station.getP21().contains("Air Humidity")) && (station.getP21().contains("Min")))
					{
						boolean test=isNumeric (d.getP21());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP21());						
						}
					}
					if ((station.getP21().contains("Air Humidity")) && (station.getP21().contains("Max")))
					{
						boolean test=isNumeric (d.getP21());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP21());						
						}
					}
					if ((station.getP21().contains("Wind Speed")) && (station.getP21().contains("Avg")))
					{
						boolean test=isNumeric (d.getP21());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP21());						
						}
					}				
					if ((station.getP21().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP21());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP21());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP22()!=null)
				{

					if ((station.getP22().contains("Air Temperature")) && (station.getP22().contains("Min")))
					{
						boolean test=isNumeric (d.getP22());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP22());						
						}
					}
					if ((station.getP22().contains("Air Temperature")) && (station.getP22().contains("Max")))
					{
						boolean test=isNumeric (d.getP22());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP22());						
						}
					}
					if ((station.getP22().contains("Air Humidity")) && (station.getP22().contains("Min")))
					{
						boolean test=isNumeric (d.getP22());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP22());						
						}
					}
					if ((station.getP22().contains("Air Humidity")) && (station.getP22().contains("Max")))
					{
						boolean test=isNumeric (d.getP22());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP22());						
						}
					}
					if ((station.getP22().contains("Wind Speed")) && (station.getP22().contains("Avg")))
					{
						boolean test=isNumeric (d.getP22());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP22());						
						}
					}				
					if ((station.getP22().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP22());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP22());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP23()!=null)
				{

					if ((station.getP23().contains("Air Temperature")) && (station.getP23().contains("Min")))
					{
						boolean test=isNumeric (d.getP23());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP23());						
						}
					}
					if ((station.getP23().contains("Air Temperature")) && (station.getP23().contains("Max")))
					{
						boolean test=isNumeric (d.getP23());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP23());						
						}
					}
					if ((station.getP23().contains("Air Humidity")) && (station.getP23().contains("Min")))
					{
						boolean test=isNumeric (d.getP23());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP23());						
						}
					}
					if ((station.getP23().contains("Air Humidity")) && (station.getP23().contains("Max")))
					{
						boolean test=isNumeric (d.getP23());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP23());						
						}
					}
					if ((station.getP23().contains("Wind Speed")) && (station.getP23().contains("Avg")))
					{
						boolean test=isNumeric (d.getP23());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP23());						
						}
					}				
					if ((station.getP23().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP23());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP23());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP24()!=null)
				{

					if ((station.getP24().contains("Air Temperature")) && (station.getP24().contains("Min")))
					{
						boolean test=isNumeric (d.getP24());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP24());						
						}
					}
					if ((station.getP24().contains("Air Temperature")) && (station.getP24().contains("Max")))
					{
						boolean test=isNumeric (d.getP24());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP24());						
						}
					}
					if ((station.getP24().contains("Air Humidity")) && (station.getP24().contains("Min")))
					{
						boolean test=isNumeric (d.getP24());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP24());						
						}
					}
					if ((station.getP24().contains("Air Humidity")) && (station.getP24().contains("Max")))
					{
						boolean test=isNumeric (d.getP24());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP24());						
						}
					}
					if ((station.getP24().contains("Wind Speed")) && (station.getP24().contains("Avg")))
					{
						boolean test=isNumeric (d.getP24());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP24());						
						}
					}				
					if ((station.getP24().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP24());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP24());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP25()!=null)
				{

					if ((station.getP25().contains("Air Temperature")) && (station.getP25().contains("Min")))
					{
						boolean test=isNumeric (d.getP25());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP25());						
						}
					}
					if ((station.getP25().contains("Air Temperature")) && (station.getP25().contains("Max")))
					{
						boolean test=isNumeric (d.getP25());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP25());						
						}
					}
					if ((station.getP25().contains("Air Humidity")) && (station.getP25().contains("Min")))
					{
						boolean test=isNumeric (d.getP25());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP25());						
						}
					}
					if ((station.getP25().contains("Air Humidity")) && (station.getP25().contains("Max")))
					{
						boolean test=isNumeric (d.getP25());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP25());						
						}
					}
					if ((station.getP25().contains("Wind Speed")) && (station.getP25().contains("Avg")))
					{
						boolean test=isNumeric (d.getP25());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP25());						
						}
					}				
					if ((station.getP25().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP25());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP25());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP26()!=null)
				{

					if ((station.getP26().contains("Air Temperature")) && (station.getP26().contains("Min")))
					{
						boolean test=isNumeric (d.getP26());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP26());						
						}
					}
					if ((station.getP26().contains("Air Temperature")) && (station.getP26().contains("Max")))
					{
						boolean test=isNumeric (d.getP26());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP26());						
						}
					}
					if ((station.getP26().contains("Air Humidity")) && (station.getP26().contains("Min")))
					{
						boolean test=isNumeric (d.getP26());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP26());						
						}
					}
					if ((station.getP26().contains("Air Humidity")) && (station.getP26().contains("Max")))
					{
						boolean test=isNumeric (d.getP26());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP26());						
						}
					}
					if ((station.getP26().contains("Wind Speed")) && (station.getP26().contains("Avg")))
					{
						boolean test=isNumeric (d.getP26());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP26());						
						}
					}				
					if ((station.getP26().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP26());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP26());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP27()!=null)
				{

					if ((station.getP27().contains("Air Temperature")) && (station.getP27().contains("Min")))
					{
						boolean test=isNumeric (d.getP27());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP27());						
						}
					}
					if ((station.getP27().contains("Air Temperature")) && (station.getP27().contains("Max")))
					{
						boolean test=isNumeric (d.getP27());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP27());						
						}
					}
					if ((station.getP27().contains("Air Humidity")) && (station.getP27().contains("Min")))
					{
						boolean test=isNumeric (d.getP27());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP27());						
						}
					}
					if ((station.getP27().contains("Air Humidity")) && (station.getP27().contains("Max")))
					{
						boolean test=isNumeric (d.getP27());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP27());						
						}
					}
					if ((station.getP27().contains("Wind Speed")) && (station.getP27().contains("Avg")))
					{
						boolean test=isNumeric (d.getP27());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP27());						
						}
					}				
					if ((station.getP27().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP27());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP27());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP28()!=null)
				{

					if ((station.getP28().contains("Air Temperature")) && (station.getP28().contains("Min")))
					{
						boolean test=isNumeric (d.getP28());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP28());						
						}
					}
					if ((station.getP28().contains("Air Temperature")) && (station.getP28().contains("Max")))
					{
						boolean test=isNumeric (d.getP28());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP28());						
						}
					}
					if ((station.getP28().contains("Air Humidity")) && (station.getP28().contains("Min")))
					{
						boolean test=isNumeric (d.getP28());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP28());						
						}
					}
					if ((station.getP28().contains("Air Humidity")) && (station.getP28().contains("Max")))
					{
						boolean test=isNumeric (d.getP28());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP28());						
						}
					}
					if ((station.getP28().contains("Wind Speed")) && (station.getP28().contains("Avg")))
					{
						boolean test=isNumeric (d.getP28());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP28());						
						}
					}				
					if ((station.getP28().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP28());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP28());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP29()!=null)
				{

					if ((station.getP29().contains("Air Temperature")) && (station.getP29().contains("Min")))
					{
						boolean test=isNumeric (d.getP29());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP29());						
						}
					}
					if ((station.getP29().contains("Air Temperature")) && (station.getP29().contains("Max")))
					{
						boolean test=isNumeric (d.getP29());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP29());						
						}
					}
					if ((station.getP29().contains("Air Humidity")) && (station.getP29().contains("Min")))
					{
						boolean test=isNumeric (d.getP29());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP29());						
						}
					}
					if ((station.getP29().contains("Air Humidity")) && (station.getP29().contains("Max")))
					{
						boolean test=isNumeric (d.getP29());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP29());						
						}
					}
					if ((station.getP29().contains("Wind Speed")) && (station.getP29().contains("Avg")))
					{
						boolean test=isNumeric (d.getP29());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP29());						
						}
					}				
					if ((station.getP29().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP29());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP29());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP30()!=null)
				{

					if ((station.getP30().contains("Air Temperature")) && (station.getP30().contains("Min")))
					{
						boolean test=isNumeric (d.getP30());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP30());						
						}
					}
					if ((station.getP30().contains("Air Temperature")) && (station.getP30().contains("Max")))
					{
						boolean test=isNumeric (d.getP30());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP30());						
						}
					}
					if ((station.getP30().contains("Air Humidity")) && (station.getP30().contains("Min")))
					{
						boolean test=isNumeric (d.getP30());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP30());						
						}
					}
					if ((station.getP30().contains("Air Humidity")) && (station.getP30().contains("Max")))
					{
						boolean test=isNumeric (d.getP30());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP30());						
						}
					}
					if ((station.getP30().contains("Wind Speed")) && (station.getP30().contains("Avg")))
					{
						boolean test=isNumeric (d.getP30());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP30());						
						}
					}				
					if ((station.getP30().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP30());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP30());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP31()!=null)
				{

					if ((station.getP31().contains("Air Temperature")) && (station.getP31().contains("Min")))
					{
						boolean test=isNumeric (d.getP31());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP31());						
						}
					}
					if ((station.getP31().contains("Air Temperature")) && (station.getP31().contains("Max")))
					{
						boolean test=isNumeric (d.getP31());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP31());						
						}
					}
					if ((station.getP31().contains("Air Humidity")) && (station.getP31().contains("Min")))
					{
						boolean test=isNumeric (d.getP31());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP31());						
						}
					}
					if ((station.getP31().contains("Air Humidity")) && (station.getP31().contains("Max")))
					{
						boolean test=isNumeric (d.getP31());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP31());						
						}
					}
					if ((station.getP31().contains("Wind Speed")) && (station.getP31().contains("Avg")))
					{
						boolean test=isNumeric (d.getP31());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP31());						
						}
					}				
					if ((station.getP31().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP31());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP31());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP32()!=null)
				{

					if ((station.getP32().contains("Air Temperature")) && (station.getP32().contains("Min")))
					{
						boolean test=isNumeric (d.getP32());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP32());						
						}
					}
					if ((station.getP32().contains("Air Temperature")) && (station.getP32().contains("Max")))
					{
						boolean test=isNumeric (d.getP32());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP32());						
						}
					}
					if ((station.getP32().contains("Air Humidity")) && (station.getP32().contains("Min")))
					{
						boolean test=isNumeric (d.getP32());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP32());						
						}
					}
					if ((station.getP32().contains("Air Humidity")) && (station.getP32().contains("Max")))
					{
						boolean test=isNumeric (d.getP32());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP32());						
						}
					}
					if ((station.getP32().contains("Wind Speed")) && (station.getP32().contains("Avg")))
					{
						boolean test=isNumeric (d.getP32());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP32());						
						}
					}				
					if ((station.getP32().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP32());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP32());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP33()!=null)
				{

					if ((station.getP33().contains("Air Temperature")) && (station.getP33().contains("Min")))
					{
						boolean test=isNumeric (d.getP33());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP33());						
						}
					}
					if ((station.getP33().contains("Air Temperature")) && (station.getP33().contains("Max")))
					{
						boolean test=isNumeric (d.getP33());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP33());						
						}
					}
					if ((station.getP33().contains("Air Humidity")) && (station.getP33().contains("Min")))
					{
						boolean test=isNumeric (d.getP33());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP33());						
						}
					}
					if ((station.getP33().contains("Air Humidity")) && (station.getP33().contains("Max")))
					{
						boolean test=isNumeric (d.getP33());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP33());						
						}
					}
					if ((station.getP33().contains("Wind Speed")) && (station.getP33().contains("Avg")))
					{
						boolean test=isNumeric (d.getP33());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP33());						
						}
					}				
					if ((station.getP33().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP33());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP33());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP34()!=null)
				{

					if ((station.getP34().contains("Air Temperature")) && (station.getP34().contains("Min")))
					{
						boolean test=isNumeric (d.getP34());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP34());						
						}
					}
					if ((station.getP34().contains("Air Temperature")) && (station.getP34().contains("Max")))
					{
						boolean test=isNumeric (d.getP34());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP34());						
						}
					}
					if ((station.getP34().contains("Air Humidity")) && (station.getP34().contains("Min")))
					{
						boolean test=isNumeric (d.getP34());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP34());						
						}
					}
					if ((station.getP34().contains("Air Humidity")) && (station.getP34().contains("Max")))
					{
						boolean test=isNumeric (d.getP34());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP34());						
						}
					}
					if ((station.getP34().contains("Wind Speed")) && (station.getP34().contains("Avg")))
					{
						boolean test=isNumeric (d.getP34());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP34());						
						}
					}				
					if ((station.getP34().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP34());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP34());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP35()!=null)
				{

					if ((station.getP35().contains("Air Temperature")) && (station.getP35().contains("Min")))
					{
						boolean test=isNumeric (d.getP35());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP35());						
						}
					}
					if ((station.getP35().contains("Air Temperature")) && (station.getP35().contains("Max")))
					{
						boolean test=isNumeric (d.getP35());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP35());						
						}
					}
					if ((station.getP35().contains("Air Humidity")) && (station.getP35().contains("Min")))
					{
						boolean test=isNumeric (d.getP35());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP35());						
						}
					}
					if ((station.getP35().contains("Air Humidity")) && (station.getP35().contains("Max")))
					{
						boolean test=isNumeric (d.getP35());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP35());						
						}
					}
					if ((station.getP35().contains("Wind Speed")) && (station.getP35().contains("Avg")))
					{
						boolean test=isNumeric (d.getP35());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP35());						
						}
					}				
					if ((station.getP35().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP35());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP35());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP36()!=null)
				{

					if ((station.getP36().contains("Air Temperature")) && (station.getP36().contains("Min")))
					{
						boolean test=isNumeric (d.getP36());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP36());						
						}
					}
					if ((station.getP36().contains("Air Temperature")) && (station.getP36().contains("Max")))
					{
						boolean test=isNumeric (d.getP36());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP36());						
						}
					}
					if ((station.getP36().contains("Air Humidity")) && (station.getP36().contains("Min")))
					{
						boolean test=isNumeric (d.getP36());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP36());						
						}
					}
					if ((station.getP36().contains("Air Humidity")) && (station.getP36().contains("Max")))
					{
						boolean test=isNumeric (d.getP36());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP36());						
						}
					}
					if ((station.getP36().contains("Wind Speed")) && (station.getP36().contains("Avg")))
					{
						boolean test=isNumeric (d.getP36());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP36());						
						}
					}				
					if ((station.getP36().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP36());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP36());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP37()!=null)
				{

					if ((station.getP37().contains("Air Temperature")) && (station.getP37().contains("Min")))
					{
						boolean test=isNumeric (d.getP37());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP37());						
						}
					}
					if ((station.getP37().contains("Air Temperature")) && (station.getP37().contains("Max")))
					{
						boolean test=isNumeric (d.getP37());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP37());						
						}
					}
					if ((station.getP37().contains("Air Humidity")) && (station.getP37().contains("Min")))
					{
						boolean test=isNumeric (d.getP37());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP37());						
						}
					}
					if ((station.getP37().contains("Air Humidity")) && (station.getP37().contains("Max")))
					{
						boolean test=isNumeric (d.getP37());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP37());						
						}
					}
					if ((station.getP37().contains("Wind Speed")) && (station.getP37().contains("Avg")))
					{
						boolean test=isNumeric (d.getP37());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP37());						
						}
					}				
					if ((station.getP37().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP37());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP37());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP38()!=null)
				{

					if ((station.getP38().contains("Air Temperature")) && (station.getP38().contains("Min")))
					{
						boolean test=isNumeric (d.getP38());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP38());						
						}
					}
					if ((station.getP38().contains("Air Temperature")) && (station.getP38().contains("Max")))
					{
						boolean test=isNumeric (d.getP38());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP38());						
						}
					}
					if ((station.getP38().contains("Air Humidity")) && (station.getP38().contains("Min")))
					{
						boolean test=isNumeric (d.getP38());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP38());						
						}
					}
					if ((station.getP38().contains("Air Humidity")) && (station.getP38().contains("Max")))
					{
						boolean test=isNumeric (d.getP38());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP38());						
						}
					}
					if ((station.getP38().contains("Wind Speed")) && (station.getP38().contains("Avg")))
					{
						boolean test=isNumeric (d.getP38());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP38());						
						}
					}				
					if ((station.getP38().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP38());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP38());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP39()!=null)
				{

					if ((station.getP39().contains("Air Temperature")) && (station.getP39().contains("Min")))
					{
						boolean test=isNumeric (d.getP39());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP39());						
						}
					}
					if ((station.getP39().contains("Air Temperature")) && (station.getP39().contains("Max")))
					{
						boolean test=isNumeric (d.getP39());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP39());						
						}
					}
					if ((station.getP39().contains("Air Humidity")) && (station.getP39().contains("Min")))
					{
						boolean test=isNumeric (d.getP39());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP39());						
						}
					}
					if ((station.getP39().contains("Air Humidity")) && (station.getP39().contains("Max")))
					{
						boolean test=isNumeric (d.getP39());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP39());						
						}
					}
					if ((station.getP39().contains("Wind Speed")) && (station.getP39().contains("Avg")))
					{
						boolean test=isNumeric (d.getP39());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP39());						
						}
					}				
					if ((station.getP39().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP39());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP39());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP40()!=null)
				{

					if ((station.getP40().contains("Air Temperature")) && (station.getP40().contains("Min")))
					{
						boolean test=isNumeric (d.getP40());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP40());						
						}
					}
					if ((station.getP40().contains("Air Temperature")) && (station.getP40().contains("Max")))
					{
						boolean test=isNumeric (d.getP40());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP40());						
						}
					}
					if ((station.getP40().contains("Air Humidity")) && (station.getP40().contains("Min")))
					{
						boolean test=isNumeric (d.getP40());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP40());						
						}
					}
					if ((station.getP40().contains("Air Humidity")) && (station.getP40().contains("Max")))
					{
						boolean test=isNumeric (d.getP40());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP40());						
						}
					}
					if ((station.getP40().contains("Wind Speed")) && (station.getP40().contains("Avg")))
					{
						boolean test=isNumeric (d.getP40());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP40());						
						}
					}				
					if ((station.getP40().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP40());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP40());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP41()!=null)
				{

					if ((station.getP41().contains("Air Temperature")) && (station.getP41().contains("Min")))
					{
						boolean test=isNumeric (d.getP41());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP41());						
						}
					}
					if ((station.getP41().contains("Air Temperature")) && (station.getP41().contains("Max")))
					{
						boolean test=isNumeric (d.getP41());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP41());						
						}
					}
					if ((station.getP41().contains("Air Humidity")) && (station.getP41().contains("Min")))
					{
						boolean test=isNumeric (d.getP41());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP41());						
						}
					}
					if ((station.getP41().contains("Air Humidity")) && (station.getP41().contains("Max")))
					{
						boolean test=isNumeric (d.getP41());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP41());						
						}
					}
					if ((station.getP41().contains("Wind Speed")) && (station.getP41().contains("Avg")))
					{
						boolean test=isNumeric (d.getP41());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP41());						
						}
					}				
					if ((station.getP41().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP41());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP41());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP42()!=null)
				{

					if ((station.getP42().contains("Air Temperature")) && (station.getP42().contains("Min")))
					{
						boolean test=isNumeric (d.getP42());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP42());						
						}
					}
					if ((station.getP42().contains("Air Temperature")) && (station.getP42().contains("Max")))
					{
						boolean test=isNumeric (d.getP42());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP42());						
						}
					}
					if ((station.getP42().contains("Air Humidity")) && (station.getP42().contains("Min")))
					{
						boolean test=isNumeric (d.getP42());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP42());						
						}
					}
					if ((station.getP42().contains("Air Humidity")) && (station.getP42().contains("Max")))
					{
						boolean test=isNumeric (d.getP42());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP42());						
						}
					}
					if ((station.getP42().contains("Wind Speed")) && (station.getP42().contains("Avg")))
					{
						boolean test=isNumeric (d.getP42());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP42());						
						}
					}				
					if ((station.getP42().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP42());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP42());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP43()!=null)
				{

					if ((station.getP43().contains("Air Temperature")) && (station.getP43().contains("Min")))
					{
						boolean test=isNumeric (d.getP43());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP43());						
						}
					}
					if ((station.getP43().contains("Air Temperature")) && (station.getP43().contains("Max")))
					{
						boolean test=isNumeric (d.getP43());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP43());						
						}
					}
					if ((station.getP43().contains("Air Humidity")) && (station.getP43().contains("Min")))
					{
						boolean test=isNumeric (d.getP43());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP43());						
						}
					}
					if ((station.getP43().contains("Air Humidity")) && (station.getP43().contains("Max")))
					{
						boolean test=isNumeric (d.getP43());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP43());						
						}
					}
					if ((station.getP43().contains("Wind Speed")) && (station.getP43().contains("Avg")))
					{
						boolean test=isNumeric (d.getP43());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP43());						
						}
					}				
					if ((station.getP43().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP43());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP43());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP44()!=null)
				{

					if ((station.getP44().contains("Air Temperature")) && (station.getP44().contains("Min")))
					{
						boolean test=isNumeric (d.getP44());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP44());						
						}
					}
					if ((station.getP44().contains("Air Temperature")) && (station.getP44().contains("Max")))
					{
						boolean test=isNumeric (d.getP44());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP44());						
						}
					}
					if ((station.getP44().contains("Air Humidity")) && (station.getP44().contains("Min")))
					{
						boolean test=isNumeric (d.getP44());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP44());						
						}
					}
					if ((station.getP44().contains("Air Humidity")) && (station.getP44().contains("Max")))
					{
						boolean test=isNumeric (d.getP44());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP44());						
						}
					}
					if ((station.getP44().contains("Wind Speed")) && (station.getP44().contains("Avg")))
					{
						boolean test=isNumeric (d.getP44());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP44());						
						}
					}				
					if ((station.getP44().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP44());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP44());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP45()!=null)
				{

					if ((station.getP45().contains("Air Temperature")) && (station.getP45().contains("Min")))
					{
						boolean test=isNumeric (d.getP45());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP45());						
						}
					}
					if ((station.getP45().contains("Air Temperature")) && (station.getP45().contains("Max")))
					{
						boolean test=isNumeric (d.getP45());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP45());						
						}
					}
					if ((station.getP45().contains("Air Humidity")) && (station.getP45().contains("Min")))
					{
						boolean test=isNumeric (d.getP45());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP45());						
						}
					}
					if ((station.getP45().contains("Air Humidity")) && (station.getP45().contains("Max")))
					{
						boolean test=isNumeric (d.getP45());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP45());						
						}
					}
					if ((station.getP45().contains("Wind Speed")) && (station.getP45().contains("Avg")))
					{
						boolean test=isNumeric (d.getP45());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP45());						
						}
					}				
					if ((station.getP45().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP45());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP45());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP46()!=null)
				{

					if ((station.getP46().contains("Air Temperature")) && (station.getP46().contains("Min")))
					{
						boolean test=isNumeric (d.getP46());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP46());						
						}
					}
					if ((station.getP46().contains("Air Temperature")) && (station.getP46().contains("Max")))
					{
						boolean test=isNumeric (d.getP46());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP46());						
						}
					}
					if ((station.getP46().contains("Air Humidity")) && (station.getP46().contains("Min")))
					{
						boolean test=isNumeric (d.getP46());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP46());						
						}
					}
					if ((station.getP46().contains("Air Humidity")) && (station.getP46().contains("Max")))
					{
						boolean test=isNumeric (d.getP46());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP46());						
						}
					}
					if ((station.getP46().contains("Wind Speed")) && (station.getP46().contains("Avg")))
					{
						boolean test=isNumeric (d.getP46());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP46());						
						}
					}				
					if ((station.getP46().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP46());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP46());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP47()!=null)
				{

					if ((station.getP47().contains("Air Temperature")) && (station.getP47().contains("Min")))
					{
						boolean test=isNumeric (d.getP47());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP47());						
						}
					}
					if ((station.getP47().contains("Air Temperature")) && (station.getP47().contains("Max")))
					{
						boolean test=isNumeric (d.getP47());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP47());						
						}
					}
					if ((station.getP47().contains("Air Humidity")) && (station.getP47().contains("Min")))
					{
						boolean test=isNumeric (d.getP47());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP47());						
						}
					}
					if ((station.getP47().contains("Air Humidity")) && (station.getP47().contains("Max")))
					{
						boolean test=isNumeric (d.getP47());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP47());						
						}
					}
					if ((station.getP47().contains("Wind Speed")) && (station.getP47().contains("Avg")))
					{
						boolean test=isNumeric (d.getP47());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP47());						
						}
					}				
					if ((station.getP47().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP47());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP47());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP48()!=null)
				{

					if ((station.getP48().contains("Air Temperature")) && (station.getP48().contains("Min")))
					{
						boolean test=isNumeric (d.getP48());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP48());						
						}
					}
					if ((station.getP48().contains("Air Temperature")) && (station.getP48().contains("Max")))
					{
						boolean test=isNumeric (d.getP48());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP48());						
						}
					}
					if ((station.getP48().contains("Air Humidity")) && (station.getP48().contains("Min")))
					{
						boolean test=isNumeric (d.getP48());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP48());						
						}
					}
					if ((station.getP48().contains("Air Humidity")) && (station.getP48().contains("Max")))
					{
						boolean test=isNumeric (d.getP48());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP48());						
						}
					}
					if ((station.getP48().contains("Wind Speed")) && (station.getP48().contains("Avg")))
					{
						boolean test=isNumeric (d.getP48());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP48());						
						}
					}				
					if ((station.getP48().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP48());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP48());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP49()!=null)
				{

					if ((station.getP49().contains("Air Temperature")) && (station.getP49().contains("Min")))
					{
						boolean test=isNumeric (d.getP49());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP49());						
						}
					}
					if ((station.getP49().contains("Air Temperature")) && (station.getP49().contains("Max")))
					{
						boolean test=isNumeric (d.getP49());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP49());						
						}
					}
					if ((station.getP49().contains("Air Humidity")) && (station.getP49().contains("Min")))
					{
						boolean test=isNumeric (d.getP49());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP49());						
						}
					}
					if ((station.getP49().contains("Air Humidity")) && (station.getP49().contains("Max")))
					{
						boolean test=isNumeric (d.getP49());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP49());						
						}
					}
					if ((station.getP49().contains("Wind Speed")) && (station.getP49().contains("Avg")))
					{
						boolean test=isNumeric (d.getP49());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP49());						
						}
					}				
					if ((station.getP49().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP49());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP49());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP50()!=null)
				{

					if ((station.getP50().contains("Air Temperature")) && (station.getP50().contains("Min")))
					{
						boolean test=isNumeric (d.getP50());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP50());						
						}
					}
					if ((station.getP50().contains("Air Temperature")) && (station.getP50().contains("Max")))
					{
						boolean test=isNumeric (d.getP50());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP50());						
						}
					}
					if ((station.getP50().contains("Air Humidity")) && (station.getP50().contains("Min")))
					{
						boolean test=isNumeric (d.getP50());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP50());						
						}
					}
					if ((station.getP50().contains("Air Humidity")) && (station.getP50().contains("Max")))
					{
						boolean test=isNumeric (d.getP50());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP50());						
						}
					}
					if ((station.getP50().contains("Wind Speed")) && (station.getP50().contains("Avg")))
					{
						boolean test=isNumeric (d.getP50());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP50());						
						}
					}				
					if ((station.getP50().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP50());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP50());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP51()!=null)
				{

					if ((station.getP51().contains("Air Temperature")) && (station.getP51().contains("Min")))
					{
						boolean test=isNumeric (d.getP51());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP51());						
						}
					}
					if ((station.getP51().contains("Air Temperature")) && (station.getP51().contains("Max")))
					{
						boolean test=isNumeric (d.getP51());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP51());						
						}
					}
					if ((station.getP51().contains("Air Humidity")) && (station.getP51().contains("Min")))
					{
						boolean test=isNumeric (d.getP51());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP51());						
						}
					}
					if ((station.getP51().contains("Air Humidity")) && (station.getP51().contains("Max")))
					{
						boolean test=isNumeric (d.getP51());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP51());						
						}
					}
					if ((station.getP51().contains("Wind Speed")) && (station.getP51().contains("Avg")))
					{
						boolean test=isNumeric (d.getP51());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP51());						
						}
					}				
					if ((station.getP51().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP51());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP51());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP52()!=null)
				{

					if ((station.getP52().contains("Air Temperature")) && (station.getP52().contains("Min")))
					{
						boolean test=isNumeric (d.getP52());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP52());						
						}
					}
					if ((station.getP52().contains("Air Temperature")) && (station.getP52().contains("Max")))
					{
						boolean test=isNumeric (d.getP52());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP52());						
						}
					}
					if ((station.getP52().contains("Air Humidity")) && (station.getP52().contains("Min")))
					{
						boolean test=isNumeric (d.getP52());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP52());						
						}
					}
					if ((station.getP52().contains("Air Humidity")) && (station.getP52().contains("Max")))
					{
						boolean test=isNumeric (d.getP52());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP52());						
						}
					}
					if ((station.getP52().contains("Wind Speed")) && (station.getP52().contains("Avg")))
					{
						boolean test=isNumeric (d.getP52());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP52());						
						}
					}				
					if ((station.getP52().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP52());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP52());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP53()!=null)
				{

					if ((station.getP53().contains("Air Temperature")) && (station.getP53().contains("Min")))
					{
						boolean test=isNumeric (d.getP53());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP53());						
						}
					}
					if ((station.getP53().contains("Air Temperature")) && (station.getP53().contains("Max")))
					{
						boolean test=isNumeric (d.getP53());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP53());						
						}
					}
					if ((station.getP53().contains("Air Humidity")) && (station.getP53().contains("Min")))
					{
						boolean test=isNumeric (d.getP53());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP53());						
						}
					}
					if ((station.getP53().contains("Air Humidity")) && (station.getP53().contains("Max")))
					{
						boolean test=isNumeric (d.getP53());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP53());						
						}
					}
					if ((station.getP53().contains("Wind Speed")) && (station.getP53().contains("Avg")))
					{
						boolean test=isNumeric (d.getP53());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP53());						
						}
					}				
					if ((station.getP53().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP53());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP53());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP54()!=null)
				{

					if ((station.getP54().contains("Air Temperature")) && (station.getP54().contains("Min")))
					{
						boolean test=isNumeric (d.getP54());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP54());						
						}
					}
					if ((station.getP54().contains("Air Temperature")) && (station.getP54().contains("Max")))
					{
						boolean test=isNumeric (d.getP54());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP54());						
						}
					}
					if ((station.getP54().contains("Air Humidity")) && (station.getP54().contains("Min")))
					{
						boolean test=isNumeric (d.getP54());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP54());						
						}
					}
					if ((station.getP54().contains("Air Humidity")) && (station.getP54().contains("Max")))
					{
						boolean test=isNumeric (d.getP54());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP54());						
						}
					}
					if ((station.getP54().contains("Wind Speed")) && (station.getP54().contains("Avg")))
					{
						boolean test=isNumeric (d.getP54());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP54());						
						}
					}				
					if ((station.getP54().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP54());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP54());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP55()!=null)
				{

					if ((station.getP55().contains("Air Temperature")) && (station.getP55().contains("Min")))
					{
						boolean test=isNumeric (d.getP55());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP55());						
						}
					}
					if ((station.getP55().contains("Air Temperature")) && (station.getP55().contains("Max")))
					{
						boolean test=isNumeric (d.getP55());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP55());						
						}
					}
					if ((station.getP55().contains("Air Humidity")) && (station.getP55().contains("Min")))
					{
						boolean test=isNumeric (d.getP55());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP55());						
						}
					}
					if ((station.getP55().contains("Air Humidity")) && (station.getP55().contains("Max")))
					{
						boolean test=isNumeric (d.getP55());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP55());						
						}
					}
					if ((station.getP55().contains("Wind Speed")) && (station.getP55().contains("Avg")))
					{
						boolean test=isNumeric (d.getP55());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP55());						
						}
					}				
					if ((station.getP55().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP55());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP55());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP56()!=null)
				{

					if ((station.getP56().contains("Air Temperature")) && (station.getP56().contains("Min")))
					{
						boolean test=isNumeric (d.getP56());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP56());						
						}
					}
					if ((station.getP56().contains("Air Temperature")) && (station.getP56().contains("Max")))
					{
						boolean test=isNumeric (d.getP56());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP56());						
						}
					}
					if ((station.getP56().contains("Air Humidity")) && (station.getP56().contains("Min")))
					{
						boolean test=isNumeric (d.getP56());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP56());						
						}
					}
					if ((station.getP56().contains("Air Humidity")) && (station.getP56().contains("Max")))
					{
						boolean test=isNumeric (d.getP56());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP56());						
						}
					}
					if ((station.getP56().contains("Wind Speed")) && (station.getP56().contains("Avg")))
					{
						boolean test=isNumeric (d.getP56());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP56());						
						}
					}				
					if ((station.getP56().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP56());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP56());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP57()!=null)
				{

					if ((station.getP57().contains("Air Temperature")) && (station.getP57().contains("Min")))
					{
						boolean test=isNumeric (d.getP57());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP57());						
						}
					}
					if ((station.getP57().contains("Air Temperature")) && (station.getP57().contains("Max")))
					{
						boolean test=isNumeric (d.getP57());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP57());						
						}
					}
					if ((station.getP57().contains("Air Humidity")) && (station.getP57().contains("Min")))
					{
						boolean test=isNumeric (d.getP57());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP57());						
						}
					}
					if ((station.getP57().contains("Air Humidity")) && (station.getP57().contains("Max")))
					{
						boolean test=isNumeric (d.getP57());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP57());						
						}
					}
					if ((station.getP57().contains("Wind Speed")) && (station.getP57().contains("Avg")))
					{
						boolean test=isNumeric (d.getP57());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP57());						
						}
					}				
					if ((station.getP57().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP57());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP57());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP58()!=null)
				{

					if ((station.getP58().contains("Air Temperature")) && (station.getP58().contains("Min")))
					{
						boolean test=isNumeric (d.getP58());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP58());						
						}
					}
					if ((station.getP58().contains("Air Temperature")) && (station.getP58().contains("Max")))
					{
						boolean test=isNumeric (d.getP58());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP58());						
						}
					}
					if ((station.getP58().contains("Air Humidity")) && (station.getP58().contains("Min")))
					{
						boolean test=isNumeric (d.getP58());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP58());						
						}
					}
					if ((station.getP58().contains("Air Humidity")) && (station.getP58().contains("Max")))
					{
						boolean test=isNumeric (d.getP58());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP58());						
						}
					}
					if ((station.getP58().contains("Wind Speed")) && (station.getP58().contains("Avg")))
					{
						boolean test=isNumeric (d.getP58());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP58());						
						}
					}				
					if ((station.getP58().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP58());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP58());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP59()!=null)
				{

					if ((station.getP59().contains("Air Temperature")) && (station.getP59().contains("Min")))
					{
						boolean test=isNumeric (d.getP59());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP59());						
						}
					}
					if ((station.getP59().contains("Air Temperature")) && (station.getP59().contains("Max")))
					{
						boolean test=isNumeric (d.getP59());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP59());						
						}
					}
					if ((station.getP59().contains("Air Humidity")) && (station.getP59().contains("Min")))
					{
						boolean test=isNumeric (d.getP59());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP59());						
						}
					}
					if ((station.getP59().contains("Air Humidity")) && (station.getP59().contains("Max")))
					{
						boolean test=isNumeric (d.getP59());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP59());						
						}
					}
					if ((station.getP59().contains("Wind Speed")) && (station.getP59().contains("Avg")))
					{
						boolean test=isNumeric (d.getP59());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP59());						
						}
					}				
					if ((station.getP59().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP59());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP59());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP60()!=null)
				{

					if ((station.getP60().contains("Air Temperature")) && (station.getP60().contains("Min")))
					{
						boolean test=isNumeric (d.getP60());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP60());						
						}
					}
					if ((station.getP60().contains("Air Temperature")) && (station.getP60().contains("Max")))
					{
						boolean test=isNumeric (d.getP60());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP60());						
						}
					}
					if ((station.getP60().contains("Air Humidity")) && (station.getP60().contains("Min")))
					{
						boolean test=isNumeric (d.getP60());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP60());						
						}
					}
					if ((station.getP60().contains("Air Humidity")) && (station.getP60().contains("Max")))
					{
						boolean test=isNumeric (d.getP60());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP60());						
						}
					}
					if ((station.getP60().contains("Wind Speed")) && (station.getP60().contains("Avg")))
					{
						boolean test=isNumeric (d.getP60());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP60());						
						}
					}				
					if ((station.getP60().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP60());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP60());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP61()!=null)
				{

					if ((station.getP61().contains("Air Temperature")) && (station.getP61().contains("Min")))
					{
						boolean test=isNumeric (d.getP61());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP61());						
						}
					}
					if ((station.getP61().contains("Air Temperature")) && (station.getP61().contains("Max")))
					{
						boolean test=isNumeric (d.getP61());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP61());						
						}
					}
					if ((station.getP61().contains("Air Humidity")) && (station.getP61().contains("Min")))
					{
						boolean test=isNumeric (d.getP61());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP61());						
						}
					}
					if ((station.getP61().contains("Air Humidity")) && (station.getP61().contains("Max")))
					{
						boolean test=isNumeric (d.getP61());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP61());						
						}
					}
					if ((station.getP61().contains("Wind Speed")) && (station.getP61().contains("Avg")))
					{
						boolean test=isNumeric (d.getP61());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP61());						
						}
					}				
					if ((station.getP61().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP61());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP61());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP62()!=null)
				{

					if ((station.getP62().contains("Air Temperature")) && (station.getP62().contains("Min")))
					{
						boolean test=isNumeric (d.getP62());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP62());						
						}
					}
					if ((station.getP62().contains("Air Temperature")) && (station.getP62().contains("Max")))
					{
						boolean test=isNumeric (d.getP62());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP62());						
						}
					}
					if ((station.getP62().contains("Air Humidity")) && (station.getP62().contains("Min")))
					{
						boolean test=isNumeric (d.getP62());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP62());						
						}
					}
					if ((station.getP62().contains("Air Humidity")) && (station.getP62().contains("Max")))
					{
						boolean test=isNumeric (d.getP62());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP62());						
						}
					}
					if ((station.getP62().contains("Wind Speed")) && (station.getP62().contains("Avg")))
					{
						boolean test=isNumeric (d.getP62());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP62());						
						}
					}				
					if ((station.getP62().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP62());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP62());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP63()!=null)
				{

					if ((station.getP63().contains("Air Temperature")) && (station.getP63().contains("Min")))
					{
						boolean test=isNumeric (d.getP63());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP63());						
						}
					}
					if ((station.getP63().contains("Air Temperature")) && (station.getP63().contains("Max")))
					{
						boolean test=isNumeric (d.getP63());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP63());						
						}
					}
					if ((station.getP63().contains("Air Humidity")) && (station.getP63().contains("Min")))
					{
						boolean test=isNumeric (d.getP63());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP63());						
						}
					}
					if ((station.getP63().contains("Air Humidity")) && (station.getP63().contains("Max")))
					{
						boolean test=isNumeric (d.getP63());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP63());						
						}
					}
					if ((station.getP63().contains("Wind Speed")) && (station.getP63().contains("Avg")))
					{
						boolean test=isNumeric (d.getP63());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP63());						
						}
					}				
					if ((station.getP63().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP63());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP63());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP64()!=null)
				{

					if ((station.getP64().contains("Air Temperature")) && (station.getP64().contains("Min")))
					{
						boolean test=isNumeric (d.getP64());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP64());						
						}
					}
					if ((station.getP64().contains("Air Temperature")) && (station.getP64().contains("Max")))
					{
						boolean test=isNumeric (d.getP64());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP64());						
						}
					}
					if ((station.getP64().contains("Air Humidity")) && (station.getP64().contains("Min")))
					{
						boolean test=isNumeric (d.getP64());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP64());						
						}
					}
					if ((station.getP64().contains("Air Humidity")) && (station.getP64().contains("Max")))
					{
						boolean test=isNumeric (d.getP64());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP64());						
						}
					}
					if ((station.getP64().contains("Wind Speed")) && (station.getP64().contains("Avg")))
					{
						boolean test=isNumeric (d.getP64());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP64());						
						}
					}				
					if ((station.getP64().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP64());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP64());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP65()!=null)
				{

					if ((station.getP65().contains("Air Temperature")) && (station.getP65().contains("Min")))
					{
						boolean test=isNumeric (d.getP65());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP65());						
						}
					}
					if ((station.getP65().contains("Air Temperature")) && (station.getP65().contains("Max")))
					{
						boolean test=isNumeric (d.getP65());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP65());						
						}
					}
					if ((station.getP65().contains("Air Humidity")) && (station.getP65().contains("Min")))
					{
						boolean test=isNumeric (d.getP65());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP65());						
						}
					}
					if ((station.getP65().contains("Air Humidity")) && (station.getP65().contains("Max")))
					{
						boolean test=isNumeric (d.getP65());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP65());						
						}
					}
					if ((station.getP65().contains("Wind Speed")) && (station.getP65().contains("Avg")))
					{
						boolean test=isNumeric (d.getP65());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP65());						
						}
					}				
					if ((station.getP65().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP65());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP65());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP66()!=null)
				{

					if ((station.getP66().contains("Air Temperature")) && (station.getP66().contains("Min")))
					{
						boolean test=isNumeric (d.getP66());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP66());						
						}
					}
					if ((station.getP66().contains("Air Temperature")) && (station.getP66().contains("Max")))
					{
						boolean test=isNumeric (d.getP66());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP66());						
						}
					}
					if ((station.getP66().contains("Air Humidity")) && (station.getP66().contains("Min")))
					{
						boolean test=isNumeric (d.getP66());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP66());						
						}
					}
					if ((station.getP66().contains("Air Humidity")) && (station.getP66().contains("Max")))
					{
						boolean test=isNumeric (d.getP66());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP66());						
						}
					}
					if ((station.getP66().contains("Wind Speed")) && (station.getP66().contains("Avg")))
					{
						boolean test=isNumeric (d.getP66());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP66());						
						}
					}				
					if ((station.getP66().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP66());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP66());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP67()!=null)
				{

					if ((station.getP67().contains("Air Temperature")) && (station.getP67().contains("Min")))
					{
						boolean test=isNumeric (d.getP67());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP67());						
						}
					}
					if ((station.getP67().contains("Air Temperature")) && (station.getP67().contains("Max")))
					{
						boolean test=isNumeric (d.getP67());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP67());						
						}
					}
					if ((station.getP67().contains("Air Humidity")) && (station.getP67().contains("Min")))
					{
						boolean test=isNumeric (d.getP67());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP67());						
						}
					}
					if ((station.getP67().contains("Air Humidity")) && (station.getP67().contains("Max")))
					{
						boolean test=isNumeric (d.getP67());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP67());						
						}
					}
					if ((station.getP67().contains("Wind Speed")) && (station.getP67().contains("Avg")))
					{
						boolean test=isNumeric (d.getP67());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP67());						
						}
					}				
					if ((station.getP67().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP67());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP67());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP68()!=null)
				{

					if ((station.getP68().contains("Air Temperature")) && (station.getP68().contains("Min")))
					{
						boolean test=isNumeric (d.getP68());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP68());						
						}
					}
					if ((station.getP68().contains("Air Temperature")) && (station.getP68().contains("Max")))
					{
						boolean test=isNumeric (d.getP68());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP68());						
						}
					}
					if ((station.getP68().contains("Air Humidity")) && (station.getP68().contains("Min")))
					{
						boolean test=isNumeric (d.getP68());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP68());						
						}
					}
					if ((station.getP68().contains("Air Humidity")) && (station.getP68().contains("Max")))
					{
						boolean test=isNumeric (d.getP68());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP68());						
						}
					}
					if ((station.getP68().contains("Wind Speed")) && (station.getP68().contains("Avg")))
					{
						boolean test=isNumeric (d.getP68());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP68());						
						}
					}				
					if ((station.getP68().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP68());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP68());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP69()!=null)
				{

					if ((station.getP69().contains("Air Temperature")) && (station.getP69().contains("Min")))
					{
						boolean test=isNumeric (d.getP69());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP69());						
						}
					}
					if ((station.getP69().contains("Air Temperature")) && (station.getP69().contains("Max")))
					{
						boolean test=isNumeric (d.getP69());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP69());						
						}
					}
					if ((station.getP69().contains("Air Humidity")) && (station.getP69().contains("Min")))
					{
						boolean test=isNumeric (d.getP69());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP69());						
						}
					}
					if ((station.getP69().contains("Air Humidity")) && (station.getP69().contains("Max")))
					{
						boolean test=isNumeric (d.getP69());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP69());						
						}
					}
					if ((station.getP69().contains("Wind Speed")) && (station.getP69().contains("Avg")))
					{
						boolean test=isNumeric (d.getP69());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP69());						
						}
					}				
					if ((station.getP69().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP69());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP69());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP70()!=null)
				{

					if ((station.getP70().contains("Air Temperature")) && (station.getP70().contains("Min")))
					{
						boolean test=isNumeric (d.getP70());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP70());						
						}
					}
					if ((station.getP70().contains("Air Temperature")) && (station.getP70().contains("Max")))
					{
						boolean test=isNumeric (d.getP70());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP70());						
						}
					}
					if ((station.getP70().contains("Air Humidity")) && (station.getP70().contains("Min")))
					{
						boolean test=isNumeric (d.getP70());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP70());						
						}
					}
					if ((station.getP70().contains("Air Humidity")) && (station.getP70().contains("Max")))
					{
						boolean test=isNumeric (d.getP70());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP70());						
						}
					}
					if ((station.getP70().contains("Wind Speed")) && (station.getP70().contains("Avg")))
					{
						boolean test=isNumeric (d.getP70());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP70());						
						}
					}				
					if ((station.getP70().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP70());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP70());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP71()!=null)
				{

					if ((station.getP71().contains("Air Temperature")) && (station.getP71().contains("Min")))
					{
						boolean test=isNumeric (d.getP71());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP71());						
						}
					}
					if ((station.getP71().contains("Air Temperature")) && (station.getP71().contains("Max")))
					{
						boolean test=isNumeric (d.getP71());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP71());						
						}
					}
					if ((station.getP71().contains("Air Humidity")) && (station.getP71().contains("Min")))
					{
						boolean test=isNumeric (d.getP71());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP71());						
						}
					}
					if ((station.getP71().contains("Air Humidity")) && (station.getP71().contains("Max")))
					{
						boolean test=isNumeric (d.getP71());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP71());						
						}
					}
					if ((station.getP71().contains("Wind Speed")) && (station.getP71().contains("Avg")))
					{
						boolean test=isNumeric (d.getP71());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP71());						
						}
					}				
					if ((station.getP71().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP71());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP71());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP72()!=null)
				{

					if ((station.getP72().contains("Air Temperature")) && (station.getP72().contains("Min")))
					{
						boolean test=isNumeric (d.getP72());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP72());						
						}
					}
					if ((station.getP72().contains("Air Temperature")) && (station.getP72().contains("Max")))
					{
						boolean test=isNumeric (d.getP72());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP72());						
						}
					}
					if ((station.getP72().contains("Air Humidity")) && (station.getP72().contains("Min")))
					{
						boolean test=isNumeric (d.getP72());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP72());						
						}
					}
					if ((station.getP72().contains("Air Humidity")) && (station.getP72().contains("Max")))
					{
						boolean test=isNumeric (d.getP72());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP72());						
						}
					}
					if ((station.getP72().contains("Wind Speed")) && (station.getP72().contains("Avg")))
					{
						boolean test=isNumeric (d.getP72());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP72());						
						}
					}				
					if ((station.getP72().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP72());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP72());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP73()!=null)
				{

					if ((station.getP73().contains("Air Temperature")) && (station.getP73().contains("Min")))
					{
						boolean test=isNumeric (d.getP73());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP73());						
						}
					}
					if ((station.getP73().contains("Air Temperature")) && (station.getP73().contains("Max")))
					{
						boolean test=isNumeric (d.getP73());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP73());						
						}
					}
					if ((station.getP73().contains("Air Humidity")) && (station.getP73().contains("Min")))
					{
						boolean test=isNumeric (d.getP73());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP73());						
						}
					}
					if ((station.getP73().contains("Air Humidity")) && (station.getP73().contains("Max")))
					{
						boolean test=isNumeric (d.getP73());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP73());						
						}
					}
					if ((station.getP73().contains("Wind Speed")) && (station.getP73().contains("Avg")))
					{
						boolean test=isNumeric (d.getP73());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP73());						
						}
					}				
					if ((station.getP73().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP73());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP73());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP74()!=null)
				{

					if ((station.getP74().contains("Air Temperature")) && (station.getP74().contains("Min")))
					{
						boolean test=isNumeric (d.getP74());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP74());						
						}
					}
					if ((station.getP74().contains("Air Temperature")) && (station.getP74().contains("Max")))
					{
						boolean test=isNumeric (d.getP74());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP74());						
						}
					}
					if ((station.getP74().contains("Air Humidity")) && (station.getP74().contains("Min")))
					{
						boolean test=isNumeric (d.getP74());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP74());						
						}
					}
					if ((station.getP74().contains("Air Humidity")) && (station.getP74().contains("Max")))
					{
						boolean test=isNumeric (d.getP74());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP74());						
						}
					}
					if ((station.getP74().contains("Wind Speed")) && (station.getP74().contains("Avg")))
					{
						boolean test=isNumeric (d.getP74());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP74());						
						}
					}				
					if ((station.getP74().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP74());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP74());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP75()!=null)
				{

					if ((station.getP75().contains("Air Temperature")) && (station.getP75().contains("Min")))
					{
						boolean test=isNumeric (d.getP75());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP75());						
						}
					}
					if ((station.getP75().contains("Air Temperature")) && (station.getP75().contains("Max")))
					{
						boolean test=isNumeric (d.getP75());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP75());						
						}
					}
					if ((station.getP75().contains("Air Humidity")) && (station.getP75().contains("Min")))
					{
						boolean test=isNumeric (d.getP75());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP75());						
						}
					}
					if ((station.getP75().contains("Air Humidity")) && (station.getP75().contains("Max")))
					{
						boolean test=isNumeric (d.getP75());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP75());						
						}
					}
					if ((station.getP75().contains("Wind Speed")) && (station.getP75().contains("Avg")))
					{
						boolean test=isNumeric (d.getP75());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP75());						
						}
					}				
					if ((station.getP75().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP75());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP75());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP76()!=null)
				{

					if ((station.getP76().contains("Air Temperature")) && (station.getP76().contains("Min")))
					{
						boolean test=isNumeric (d.getP76());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP76());						
						}
					}
					if ((station.getP76().contains("Air Temperature")) && (station.getP76().contains("Max")))
					{
						boolean test=isNumeric (d.getP76());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP76());						
						}
					}
					if ((station.getP76().contains("Air Humidity")) && (station.getP76().contains("Min")))
					{
						boolean test=isNumeric (d.getP76());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP76());						
						}
					}
					if ((station.getP76().contains("Air Humidity")) && (station.getP76().contains("Max")))
					{
						boolean test=isNumeric (d.getP76());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP76());						
						}
					}
					if ((station.getP76().contains("Wind Speed")) && (station.getP76().contains("Avg")))
					{
						boolean test=isNumeric (d.getP76());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP76());						
						}
					}				
					if ((station.getP76().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP76());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP76());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP77()!=null)
				{

					if ((station.getP77().contains("Air Temperature")) && (station.getP77().contains("Min")))
					{
						boolean test=isNumeric (d.getP77());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP77());						
						}
					}
					if ((station.getP77().contains("Air Temperature")) && (station.getP77().contains("Max")))
					{
						boolean test=isNumeric (d.getP77());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP77());						
						}
					}
					if ((station.getP77().contains("Air Humidity")) && (station.getP77().contains("Min")))
					{
						boolean test=isNumeric (d.getP77());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP77());						
						}
					}
					if ((station.getP77().contains("Air Humidity")) && (station.getP77().contains("Max")))
					{
						boolean test=isNumeric (d.getP77());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP77());						
						}
					}
					if ((station.getP77().contains("Wind Speed")) && (station.getP77().contains("Avg")))
					{
						boolean test=isNumeric (d.getP77());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP77());						
						}
					}				
					if ((station.getP77().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP77());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP77());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP78()!=null)
				{

					if ((station.getP78().contains("Air Temperature")) && (station.getP78().contains("Min")))
					{
						boolean test=isNumeric (d.getP78());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP78());						
						}
					}
					if ((station.getP78().contains("Air Temperature")) && (station.getP78().contains("Max")))
					{
						boolean test=isNumeric (d.getP78());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP78());						
						}
					}
					if ((station.getP78().contains("Air Humidity")) && (station.getP78().contains("Min")))
					{
						boolean test=isNumeric (d.getP78());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP78());						
						}
					}
					if ((station.getP78().contains("Air Humidity")) && (station.getP78().contains("Max")))
					{
						boolean test=isNumeric (d.getP78());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP78());						
						}
					}
					if ((station.getP78().contains("Wind Speed")) && (station.getP78().contains("Avg")))
					{
						boolean test=isNumeric (d.getP78());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP78());						
						}
					}				
					if ((station.getP78().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP78());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP78());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP79()!=null)
				{

					if ((station.getP79().contains("Air Temperature")) && (station.getP79().contains("Min")))
					{
						boolean test=isNumeric (d.getP79());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP79());						
						}
					}
					if ((station.getP79().contains("Air Temperature")) && (station.getP79().contains("Max")))
					{
						boolean test=isNumeric (d.getP79());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP79());						
						}
					}
					if ((station.getP79().contains("Air Humidity")) && (station.getP79().contains("Min")))
					{
						boolean test=isNumeric (d.getP79());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP79());						
						}
					}
					if ((station.getP79().contains("Air Humidity")) && (station.getP79().contains("Max")))
					{
						boolean test=isNumeric (d.getP79());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP79());						
						}
					}
					if ((station.getP79().contains("Wind Speed")) && (station.getP79().contains("Avg")))
					{
						boolean test=isNumeric (d.getP79());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP79());						
						}
					}				
					if ((station.getP79().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP79());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP79());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP80()!=null)
				{

					if ((station.getP80().contains("Air Temperature")) && (station.getP80().contains("Min")))
					{
						boolean test=isNumeric (d.getP80());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP80());						
						}
					}
					if ((station.getP80().contains("Air Temperature")) && (station.getP80().contains("Max")))
					{
						boolean test=isNumeric (d.getP80());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP80());						
						}
					}
					if ((station.getP80().contains("Air Humidity")) && (station.getP80().contains("Min")))
					{
						boolean test=isNumeric (d.getP80());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP80());						
						}
					}
					if ((station.getP80().contains("Air Humidity")) && (station.getP80().contains("Max")))
					{
						boolean test=isNumeric (d.getP80());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP80());						
						}
					}
					if ((station.getP80().contains("Wind Speed")) && (station.getP80().contains("Avg")))
					{
						boolean test=isNumeric (d.getP80());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP80());						
						}
					}				
					if ((station.getP80().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP80());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP80());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP81()!=null)
				{

					if ((station.getP81().contains("Air Temperature")) && (station.getP81().contains("Min")))
					{
						boolean test=isNumeric (d.getP81());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP81());						
						}
					}
					if ((station.getP81().contains("Air Temperature")) && (station.getP81().contains("Max")))
					{
						boolean test=isNumeric (d.getP81());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP81());						
						}
					}
					if ((station.getP81().contains("Air Humidity")) && (station.getP81().contains("Min")))
					{
						boolean test=isNumeric (d.getP81());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP81());						
						}
					}
					if ((station.getP81().contains("Air Humidity")) && (station.getP81().contains("Max")))
					{
						boolean test=isNumeric (d.getP81());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP81());						
						}
					}
					if ((station.getP81().contains("Wind Speed")) && (station.getP81().contains("Avg")))
					{
						boolean test=isNumeric (d.getP81());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP81());						
						}
					}				
					if ((station.getP81().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP81());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP81());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP82()!=null)
				{

					if ((station.getP82().contains("Air Temperature")) && (station.getP82().contains("Min")))
					{
						boolean test=isNumeric (d.getP82());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP82());						
						}
					}
					if ((station.getP82().contains("Air Temperature")) && (station.getP82().contains("Max")))
					{
						boolean test=isNumeric (d.getP82());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP82());						
						}
					}
					if ((station.getP82().contains("Air Humidity")) && (station.getP82().contains("Min")))
					{
						boolean test=isNumeric (d.getP82());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP82());						
						}
					}
					if ((station.getP82().contains("Air Humidity")) && (station.getP82().contains("Max")))
					{
						boolean test=isNumeric (d.getP82());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP82());						
						}
					}
					if ((station.getP82().contains("Wind Speed")) && (station.getP82().contains("Avg")))
					{
						boolean test=isNumeric (d.getP82());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP82());						
						}
					}				
					if ((station.getP82().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP82());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP82());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP83()!=null)
				{

					if ((station.getP83().contains("Air Temperature")) && (station.getP83().contains("Min")))
					{
						boolean test=isNumeric (d.getP83());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP83());						
						}
					}
					if ((station.getP83().contains("Air Temperature")) && (station.getP83().contains("Max")))
					{
						boolean test=isNumeric (d.getP83());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP83());						
						}
					}
					if ((station.getP83().contains("Air Humidity")) && (station.getP83().contains("Min")))
					{
						boolean test=isNumeric (d.getP83());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP83());						
						}
					}
					if ((station.getP83().contains("Air Humidity")) && (station.getP83().contains("Max")))
					{
						boolean test=isNumeric (d.getP83());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP83());						
						}
					}
					if ((station.getP83().contains("Wind Speed")) && (station.getP83().contains("Avg")))
					{
						boolean test=isNumeric (d.getP83());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP83());						
						}
					}				
					if ((station.getP83().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP83());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP83());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP84()!=null)
				{

					if ((station.getP84().contains("Air Temperature")) && (station.getP84().contains("Min")))
					{
						boolean test=isNumeric (d.getP84());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP84());						
						}
					}
					if ((station.getP84().contains("Air Temperature")) && (station.getP84().contains("Max")))
					{
						boolean test=isNumeric (d.getP84());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP84());						
						}
					}
					if ((station.getP84().contains("Air Humidity")) && (station.getP84().contains("Min")))
					{
						boolean test=isNumeric (d.getP84());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP84());						
						}
					}
					if ((station.getP84().contains("Air Humidity")) && (station.getP84().contains("Max")))
					{
						boolean test=isNumeric (d.getP84());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP84());						
						}
					}
					if ((station.getP84().contains("Wind Speed")) && (station.getP84().contains("Avg")))
					{
						boolean test=isNumeric (d.getP84());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP84());						
						}
					}				
					if ((station.getP84().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP84());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP84());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP85()!=null)
				{

					if ((station.getP85().contains("Air Temperature")) && (station.getP85().contains("Min")))
					{
						boolean test=isNumeric (d.getP85());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP85());						
						}
					}
					if ((station.getP85().contains("Air Temperature")) && (station.getP85().contains("Max")))
					{
						boolean test=isNumeric (d.getP85());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP85());						
						}
					}
					if ((station.getP85().contains("Air Humidity")) && (station.getP85().contains("Min")))
					{
						boolean test=isNumeric (d.getP85());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP85());						
						}
					}
					if ((station.getP85().contains("Air Humidity")) && (station.getP85().contains("Max")))
					{
						boolean test=isNumeric (d.getP85());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP85());						
						}
					}
					if ((station.getP85().contains("Wind Speed")) && (station.getP85().contains("Avg")))
					{
						boolean test=isNumeric (d.getP85());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP85());						
						}
					}				
					if ((station.getP85().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP85());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP85());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP86()!=null)
				{

					if ((station.getP86().contains("Air Temperature")) && (station.getP86().contains("Min")))
					{
						boolean test=isNumeric (d.getP86());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP86());						
						}
					}
					if ((station.getP86().contains("Air Temperature")) && (station.getP86().contains("Max")))
					{
						boolean test=isNumeric (d.getP86());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP86());						
						}
					}
					if ((station.getP86().contains("Air Humidity")) && (station.getP86().contains("Min")))
					{
						boolean test=isNumeric (d.getP86());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP86());						
						}
					}
					if ((station.getP86().contains("Air Humidity")) && (station.getP86().contains("Max")))
					{
						boolean test=isNumeric (d.getP86());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP86());						
						}
					}
					if ((station.getP86().contains("Wind Speed")) && (station.getP86().contains("Avg")))
					{
						boolean test=isNumeric (d.getP86());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP86());						
						}
					}				
					if ((station.getP86().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP86());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP86());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP87()!=null)
				{

					if ((station.getP87().contains("Air Temperature")) && (station.getP87().contains("Min")))
					{
						boolean test=isNumeric (d.getP87());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP87());						
						}
					}
					if ((station.getP87().contains("Air Temperature")) && (station.getP87().contains("Max")))
					{
						boolean test=isNumeric (d.getP87());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP87());						
						}
					}
					if ((station.getP87().contains("Air Humidity")) && (station.getP87().contains("Min")))
					{
						boolean test=isNumeric (d.getP87());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP87());						
						}
					}
					if ((station.getP87().contains("Air Humidity")) && (station.getP87().contains("Max")))
					{
						boolean test=isNumeric (d.getP87());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP87());						
						}
					}
					if ((station.getP87().contains("Wind Speed")) && (station.getP87().contains("Avg")))
					{
						boolean test=isNumeric (d.getP87());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP87());						
						}
					}				
					if ((station.getP87().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP87());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP87());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP88()!=null)
				{

					if ((station.getP88().contains("Air Temperature")) && (station.getP88().contains("Min")))
					{
						boolean test=isNumeric (d.getP88());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP88());						
						}
					}
					if ((station.getP88().contains("Air Temperature")) && (station.getP88().contains("Max")))
					{
						boolean test=isNumeric (d.getP88());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP88());						
						}
					}
					if ((station.getP88().contains("Air Humidity")) && (station.getP88().contains("Min")))
					{
						boolean test=isNumeric (d.getP88());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP88());						
						}
					}
					if ((station.getP88().contains("Air Humidity")) && (station.getP88().contains("Max")))
					{
						boolean test=isNumeric (d.getP88());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP88());						
						}
					}
					if ((station.getP88().contains("Wind Speed")) && (station.getP88().contains("Avg")))
					{
						boolean test=isNumeric (d.getP88());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP88());						
						}
					}				
					if ((station.getP88().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP88());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP88());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP89()!=null)
				{

					if ((station.getP89().contains("Air Temperature")) && (station.getP89().contains("Min")))
					{
						boolean test=isNumeric (d.getP89());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP89());						
						}
					}
					if ((station.getP89().contains("Air Temperature")) && (station.getP89().contains("Max")))
					{
						boolean test=isNumeric (d.getP89());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP89());						
						}
					}
					if ((station.getP89().contains("Air Humidity")) && (station.getP89().contains("Min")))
					{
						boolean test=isNumeric (d.getP89());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP89());						
						}
					}
					if ((station.getP89().contains("Air Humidity")) && (station.getP89().contains("Max")))
					{
						boolean test=isNumeric (d.getP89());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP89());						
						}
					}
					if ((station.getP89().contains("Wind Speed")) && (station.getP89().contains("Avg")))
					{
						boolean test=isNumeric (d.getP89());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP89());						
						}
					}				
					if ((station.getP89().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP89());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP89());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP90()!=null)
				{

					if ((station.getP90().contains("Air Temperature")) && (station.getP90().contains("Min")))
					{
						boolean test=isNumeric (d.getP90());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP90());						
						}
					}
					if ((station.getP90().contains("Air Temperature")) && (station.getP90().contains("Max")))
					{
						boolean test=isNumeric (d.getP90());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP90());						
						}
					}
					if ((station.getP90().contains("Air Humidity")) && (station.getP90().contains("Min")))
					{
						boolean test=isNumeric (d.getP90());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP90());						
						}
					}
					if ((station.getP90().contains("Air Humidity")) && (station.getP90().contains("Max")))
					{
						boolean test=isNumeric (d.getP90());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP90());						
						}
					}
					if ((station.getP90().contains("Wind Speed")) && (station.getP90().contains("Avg")))
					{
						boolean test=isNumeric (d.getP90());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP90());						
						}
					}				
					if ((station.getP90().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP90());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP90());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP91()!=null)
				{

					if ((station.getP91().contains("Air Temperature")) && (station.getP91().contains("Min")))
					{
						boolean test=isNumeric (d.getP91());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP91());						
						}
					}
					if ((station.getP91().contains("Air Temperature")) && (station.getP91().contains("Max")))
					{
						boolean test=isNumeric (d.getP91());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP91());						
						}
					}
					if ((station.getP91().contains("Air Humidity")) && (station.getP91().contains("Min")))
					{
						boolean test=isNumeric (d.getP91());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP91());						
						}
					}
					if ((station.getP91().contains("Air Humidity")) && (station.getP91().contains("Max")))
					{
						boolean test=isNumeric (d.getP91());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP91());						
						}
					}
					if ((station.getP91().contains("Wind Speed")) && (station.getP91().contains("Avg")))
					{
						boolean test=isNumeric (d.getP91());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP91());						
						}
					}				
					if ((station.getP91().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP91());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP91());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP92()!=null)
				{

					if ((station.getP92().contains("Air Temperature")) && (station.getP92().contains("Min")))
					{
						boolean test=isNumeric (d.getP92());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP92());						
						}
					}
					if ((station.getP92().contains("Air Temperature")) && (station.getP92().contains("Max")))
					{
						boolean test=isNumeric (d.getP92());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP92());						
						}
					}
					if ((station.getP92().contains("Air Humidity")) && (station.getP92().contains("Min")))
					{
						boolean test=isNumeric (d.getP92());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP92());						
						}
					}
					if ((station.getP92().contains("Air Humidity")) && (station.getP92().contains("Max")))
					{
						boolean test=isNumeric (d.getP92());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP92());						
						}
					}
					if ((station.getP92().contains("Wind Speed")) && (station.getP92().contains("Avg")))
					{
						boolean test=isNumeric (d.getP92());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP92());						
						}
					}				
					if ((station.getP92().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP92());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP92());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP93()!=null)
				{

					if ((station.getP93().contains("Air Temperature")) && (station.getP93().contains("Min")))
					{
						boolean test=isNumeric (d.getP93());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP93());						
						}
					}
					if ((station.getP93().contains("Air Temperature")) && (station.getP93().contains("Max")))
					{
						boolean test=isNumeric (d.getP93());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP93());						
						}
					}
					if ((station.getP93().contains("Air Humidity")) && (station.getP93().contains("Min")))
					{
						boolean test=isNumeric (d.getP93());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP93());						
						}
					}
					if ((station.getP93().contains("Air Humidity")) && (station.getP93().contains("Max")))
					{
						boolean test=isNumeric (d.getP93());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP93());						
						}
					}
					if ((station.getP93().contains("Wind Speed")) && (station.getP93().contains("Avg")))
					{
						boolean test=isNumeric (d.getP93());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP93());						
						}
					}				
					if ((station.getP93().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP93());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP93());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP94()!=null)
				{

					if ((station.getP94().contains("Air Temperature")) && (station.getP94().contains("Min")))
					{
						boolean test=isNumeric (d.getP94());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP94());						
						}
					}
					if ((station.getP94().contains("Air Temperature")) && (station.getP94().contains("Max")))
					{
						boolean test=isNumeric (d.getP94());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP94());						
						}
					}
					if ((station.getP94().contains("Air Humidity")) && (station.getP94().contains("Min")))
					{
						boolean test=isNumeric (d.getP94());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP94());						
						}
					}
					if ((station.getP94().contains("Air Humidity")) && (station.getP94().contains("Max")))
					{
						boolean test=isNumeric (d.getP94());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP94());						
						}
					}
					if ((station.getP94().contains("Wind Speed")) && (station.getP94().contains("Avg")))
					{
						boolean test=isNumeric (d.getP94());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP94());						
						}
					}				
					if ((station.getP94().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP94());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP94());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP95()!=null)
				{

					if ((station.getP95().contains("Air Temperature")) && (station.getP95().contains("Min")))
					{
						boolean test=isNumeric (d.getP95());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP95());						
						}
					}
					if ((station.getP95().contains("Air Temperature")) && (station.getP95().contains("Max")))
					{
						boolean test=isNumeric (d.getP95());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP95());						
						}
					}
					if ((station.getP95().contains("Air Humidity")) && (station.getP95().contains("Min")))
					{
						boolean test=isNumeric (d.getP95());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP95());						
						}
					}
					if ((station.getP95().contains("Air Humidity")) && (station.getP95().contains("Max")))
					{
						boolean test=isNumeric (d.getP95());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP95());						
						}
					}
					if ((station.getP95().contains("Wind Speed")) && (station.getP95().contains("Avg")))
					{
						boolean test=isNumeric (d.getP95());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP95());						
						}
					}				
					if ((station.getP95().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP95());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP95());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP96()!=null)
				{

					if ((station.getP96().contains("Air Temperature")) && (station.getP96().contains("Min")))
					{
						boolean test=isNumeric (d.getP96());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP96());						
						}
					}
					if ((station.getP96().contains("Air Temperature")) && (station.getP96().contains("Max")))
					{
						boolean test=isNumeric (d.getP96());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP96());						
						}
					}
					if ((station.getP96().contains("Air Humidity")) && (station.getP96().contains("Min")))
					{
						boolean test=isNumeric (d.getP96());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP96());						
						}
					}
					if ((station.getP96().contains("Air Humidity")) && (station.getP96().contains("Max")))
					{
						boolean test=isNumeric (d.getP96());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP96());						
						}
					}
					if ((station.getP96().contains("Wind Speed")) && (station.getP96().contains("Avg")))
					{
						boolean test=isNumeric (d.getP96());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP96());						
						}
					}				
					if ((station.getP96().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP96());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP96());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP97()!=null)
				{

					if ((station.getP97().contains("Air Temperature")) && (station.getP97().contains("Min")))
					{
						boolean test=isNumeric (d.getP97());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP97());						
						}
					}
					if ((station.getP97().contains("Air Temperature")) && (station.getP97().contains("Max")))
					{
						boolean test=isNumeric (d.getP97());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP97());						
						}
					}
					if ((station.getP97().contains("Air Humidity")) && (station.getP97().contains("Min")))
					{
						boolean test=isNumeric (d.getP97());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP97());						
						}
					}
					if ((station.getP97().contains("Air Humidity")) && (station.getP97().contains("Max")))
					{
						boolean test=isNumeric (d.getP97());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP97());						
						}
					}
					if ((station.getP97().contains("Wind Speed")) && (station.getP97().contains("Avg")))
					{
						boolean test=isNumeric (d.getP97());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP97());						
						}
					}				
					if ((station.getP97().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP97());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP97());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP98()!=null)
				{

					if ((station.getP98().contains("Air Temperature")) && (station.getP98().contains("Min")))
					{
						boolean test=isNumeric (d.getP98());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP98());						
						}
					}
					if ((station.getP98().contains("Air Temperature")) && (station.getP98().contains("Max")))
					{
						boolean test=isNumeric (d.getP98());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP98());						
						}
					}
					if ((station.getP98().contains("Air Humidity")) && (station.getP98().contains("Min")))
					{
						boolean test=isNumeric (d.getP98());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP98());						
						}
					}
					if ((station.getP98().contains("Air Humidity")) && (station.getP98().contains("Max")))
					{
						boolean test=isNumeric (d.getP98());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP98());						
						}
					}
					if ((station.getP98().contains("Wind Speed")) && (station.getP98().contains("Avg")))
					{
						boolean test=isNumeric (d.getP98());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP98());						
						}
					}				
					if ((station.getP98().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP98());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP98());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
				if (station.getP99()!=null)
				{

					if ((station.getP99().contains("Air Temperature")) && (station.getP99().contains("Min")))
					{
						boolean test=isNumeric (d.getP99());
						if (test==true)
						{
							ATMinArrayDouble [loopCntr]= Double.parseDouble(d.getP99());						
						}
					}
					if ((station.getP99().contains("Air Temperature")) && (station.getP99().contains("Max")))
					{
						boolean test=isNumeric (d.getP99());
						if (test==true)
						{
							ATMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP99());						
						}
					}
					if ((station.getP99().contains("Air Humidity")) && (station.getP99().contains("Min")))
					{
						boolean test=isNumeric (d.getP99());
						if (test==true)
						{
							AHMinArrayDouble [loopCntr]= Double.parseDouble(d.getP99());						
						}
					}
					if ((station.getP99().contains("Air Humidity")) && (station.getP99().contains("Max")))
					{
						boolean test=isNumeric (d.getP99());
						if (test==true)
						{
							AHMaxArrayDouble [loopCntr]= Double.parseDouble(d.getP99());						
						}
					}
					if ((station.getP99().contains("Wind Speed")) && (station.getP99().contains("Avg")))
					{
						boolean test=isNumeric (d.getP99());
						if (test==true)
						{
							WSAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP99());						
						}
					}				
					if ((station.getP99().contains("Solar Radiation")))
					{
						boolean test=isNumeric (d.getP99());
						if (test==true)
						{
							SRAvgArrayDouble [loopCntr]= Double.parseDouble(d.getP99());						
						}
					}
				}
				//////////////////////////////////////////////////////////////////////////
							
				
				loopCntr++;
			}
			
			double ATMinDouble=getMinArrayOfDoubles(ATMinArrayDouble);
			double ATMaxDouble=getMaxArrayOfDoubles(ATMaxArrayDouble);
			double AHMinDouble=getMinArrayOfDoubles(AHMinArrayDouble);
			double AHMaxDouble=getMaxArrayOfDoubles(AHMaxArrayDouble);
			double WSAvgDouble=getAvgArrayOfDoubles(WSAvgArrayDouble);
			double SRSumDouble=getSumArrayOfDoubles(SRAvgArrayDouble);
			
			double ET0Double=calc_ET0_fromParams(ATMinDouble, ATMaxDouble, WSAvgDouble, SRSumDouble, Lat, Alti, AHMinDouble, AHMaxDouble, Julian);
			ET0=Double.toString(ET0Double);
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			ET0="0.0";
		}
		finally
		{
			return ET0;
		}		
	}
	
	
	
	double getMaxArrayOfDoubles (double [] array)
	{
		double Max=0;
		for (int loopcntr=0;loopcntr<array.length;loopcntr++)
		{
			if (((array[loopcntr]))>Max)
			{
				Max=array[loopcntr];
			}			
		}
		return Max;
	}
	double getMinArrayOfDoubles (double [] array)
	{
		double Min=999999999;
		for (int loopcntr=0;loopcntr<array.length;loopcntr++)
		{
			if (((array[loopcntr]))<Min)
			{
				Min=array[loopcntr];
			}			
		}
		return Min;
	}
	
	double getSumArrayOfDoubles (double [] array)
	{
		double Sum=0;
		for (int loopcntr=0;loopcntr<array.length;loopcntr++)
		{
			Sum+=array[loopcntr];
			
		}
		return Sum;
	}	
	double getAvgArrayOfDoubles (double [] array)
	{
		double Avg=getSumArrayOfDoubles(array);
		Avg/=array.length;
		System.out.println("Array Length= "+array.length);
		return Avg;
	}	
		
	int Calc_Julian(String Date)
	{
		
		int Julian=0;
		
		String yearString= Date.substring(0, 4);
		String monthString=Date.substring(5,7);
		String dayString=Date.substring(8);
		
		int yearInt=Integer.parseInt(yearString);
		int monthInt=Integer.parseInt(monthString);
		monthInt--;
		int dayInt=Integer.parseInt(dayString);
		
		
		GregorianCalendar gc = new GregorianCalendar();
        gc.set(GregorianCalendar.DAY_OF_MONTH, dayInt);
        gc.set(GregorianCalendar.MONTH, monthInt);
        gc.set(GregorianCalendar.YEAR, yearInt);
        Julian=gc.get(GregorianCalendar.DAY_OF_YEAR);		
		return Julian;
		
	}
	
	public static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}	
	
	
	
	double calc_ET0_fromParams(double min_Temp_in_C, double max_Temp_in_C,
			double mean_WS_in_MeterPerSec,
			double total_SR_in_WattPerMeterSquare, double latitude_in_Degrees,
			double elevation_in_Meters, double min_Hum_in_Percent,
			double max_Hum_in_Percent, int julian_Day) {
		// min is the min of the min readings for the day
		// max is the max of the max reading for the day
		// mean is the average of all average readings for the day
		// total SR is the sum of all SR per day
		// julian day is out of 365

		// Main Parameters

		double latitude_in_Rads = Math.toRadians(latitude_in_Degrees);
		double total_SR_in_WattPerMeterSquare_Per_SolarDay = total_SR_in_WattPerMeterSquare;
		double dr = (1 + (0.033 * (Math.cos(2 * Math.PI * julian_Day / 365))));
		double delta = (0.409 * (Math
				.sin((2 * Math.PI * julian_Day / 365) - 1.39)));
		double omegas = (Math.acos((-Math.tan(latitude_in_Rads) * (Math
				.tan(delta)))));
		double Ra_in_Mega_Joule_per_meter2_per_Day = ((24 * 60 / Math.PI) * ((0.082 * dr) * ((omegas
				* Math.sin(delta) * Math.sin(latitude_in_Rads)) + (Math
				.cos(latitude_in_Rads) * Math.cos(delta) * Math.sin(omegas)))));
		double Rso = Ra_in_Mega_Joule_per_meter2_per_Day
				* (0.75 + (elevation_in_Meters * 0.00002));
		double Rns = 0.77 * total_SR_in_WattPerMeterSquare_Per_SolarDay;
		double f = (1.35 * total_SR_in_WattPerMeterSquare_Per_SolarDay / Rso) - (0.35);
		double esx = 0.6108 * Math
				.exp((17.27 * max_Temp_in_C / (max_Temp_in_C + 237.3)));
		double esn = 0.6108 * Math
				.exp((17.27 * min_Temp_in_C / (min_Temp_in_C + 237.3)));
		double ed = ((min_Hum_in_Percent + max_Hum_in_Percent) / 2)
				/ ((50 / esx) + (50 / esn));
		double epsilon = 0.34 - (0.14 * Math.sqrt(ed));
		double Rnl = -f
				* epsilon
				* 0.0000000049
				* ((Math.pow((min_Temp_in_C + 273.5), 4) + Math.pow(
						(max_Temp_in_C + 273.5), 4)) / 2);
		double Rn = Rns + Rnl;
		double beta = 101.3 * (Math.pow(
				((293 - 0.0065 * elevation_in_Meters) / 293), 5.26));
		double gamma = 0.00163 * beta / 2.45;
		double Tm = (min_Temp_in_C + max_Temp_in_C) / 2;
		double ea = (esx + esn) / 2;
		double DELTA = 4099 * ea / (Math.pow(Tm + 237.3, 2));
		double R = (0.408 * DELTA * Rn)
				/ (DELTA + (gamma * (1 + (0.34 * mean_WS_in_MeterPerSec))));
		double A = (900 * gamma / (Tm + 273)) * mean_WS_in_MeterPerSec
				* (ea - ed)
				/ (DELTA + gamma * (1 + 0.34 * mean_WS_in_MeterPerSec));
		double ET0 = R + A;

	
		double ET0_Rounded = ET0 * 10000;
		ET0_Rounded = Math.round(ET0_Rounded);
		ET0_Rounded /= 10000;
		ET0_Rounded *= 1000;
		ET0_Rounded = Math.round(ET0_Rounded);
		ET0_Rounded /= 1000;


		return ET0_Rounded;

	}

}
