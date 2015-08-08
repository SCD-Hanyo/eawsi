package com.weatherstation.service;

public class HandleQSService {

	public String UpdateParam (String input,String description)
	{
		String [] ParameterDescriptionArray_SplitArray = description.split(",");
		if (ParameterDescriptionArray_SplitArray[1].equalsIgnoreCase("Air Temperature"))
		{
			if (ParameterDescriptionArray_SplitArray[3].equalsIgnoreCase("Avg"))
			{
				input=Calculate_AT_SHT_Avg(input);
			}
			else
			{
				input=Calculate_AT_SHT(input);
				
			}
			
		}
		else if (ParameterDescriptionArray_SplitArray[1].equalsIgnoreCase("Air Humidity"))
		{
			if (ParameterDescriptionArray_SplitArray[3].equalsIgnoreCase("Avg"))
			{
				input=Calculate_AH_SHT_Avg(input);				
			}
			else
			{
				input=Calculate_AH_SHT(input);				
				
			}
			
		}
		else if (ParameterDescriptionArray_SplitArray[1].equalsIgnoreCase("Solar Radiation"))
		{
			input=Calculate_SR_Apogee(input);				
			
		}
		
		return input;
	}

	private String Calculate_SR_Apogee(String input) {
		// TODO Auto-generated method stub
		return input;
	}

	private String Calculate_AH_SHT(String input) {
		// TODO Auto-generated method stub
		return input;
	}

	private String Calculate_AH_SHT_Avg(String input) {
		// TODO Auto-generated method stub
		return input;
	}

	private String Calculate_AT_SHT(String input) {
		// TODO Auto-generated method stub
		return input;
	}

	private String Calculate_AT_SHT_Avg(String input) {
		// TODO Auto-generated method stub
		return input;
	}
}
