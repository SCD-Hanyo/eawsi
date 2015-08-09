package com.weatherstation.service;

public class HandleQSService {

	public String UpdateParam (String input,String description)
	{
		System.out.println(input);
		System.out.println(description);

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
	
	public static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}

	private String Calculate_SR_Apogee(String input) {

		boolean SingleValueNumeric=isNumeric(input);
		if (SingleValueNumeric==true)
		{			
			double inputdouble=Double.parseDouble(input);
			double outputdouble= (inputdouble*36)/(Math.pow(10, 4));
			outputdouble=((double)Math.round(outputdouble * 10000) / 10000);
			String output=String.valueOf(outputdouble);
			return output;
		}
		else
		{
			return "0.0";
		}		
	}

	private String Calculate_AH_SHT(String input) {
		boolean SingleValueNumeric=isNumeric(input);
		if (SingleValueNumeric==true)
		{			
			int inputInt=Integer.parseInt(input);
			double outputdouble= (((125*inputInt))/(Math.pow(2, 16))-6);
			outputdouble=((double)Math.round(outputdouble * 100) / 100);
			String output=String.valueOf(outputdouble);
			return output;
		}
		else
		{
			return "0.0";
		}		
	}

	private String Calculate_AH_SHT_Avg(String input) {
		boolean SingleValueNumeric=isNumeric(input);
		if (SingleValueNumeric==true)
		{			
			int inputInt=Integer.parseInt(input);
			double outputdouble=inputInt/10;
			outputdouble= (((125*inputInt))/(Math.pow(2, 16))-6);
			outputdouble=((double)Math.round(outputdouble * 100) / 100);
			String output=String.valueOf(outputdouble);
			return output;
		}
		else
		{
			return "0.0";
		}		
	}

	private String Calculate_AT_SHT(String input) {
		boolean SingleValueNumeric=isNumeric(input);
		if (SingleValueNumeric==true)
		{			
			int inputInt=Integer.parseInt(input);
			double outputdouble= (((175.72*inputInt))/(Math.pow(2, 16))-46.85);
			outputdouble=((double)Math.round(outputdouble * 100) / 100);
			String output=String.valueOf(outputdouble);
			return output;
		}
		else
		{
			return "0.0";
		}		
	}

	private String Calculate_AT_SHT_Avg(String input) {
		boolean SingleValueNumeric=isNumeric(input);
		if (SingleValueNumeric==true)
		{			
			int inputInt=Integer.parseInt(input);
			double outputdouble=inputInt/10;
			outputdouble= (((175.72*inputInt))/(Math.pow(2, 16))-46.85);
			outputdouble=((double)Math.round(outputdouble * 100) / 100);
			String output=String.valueOf(outputdouble);
			return output;
		}
		else
		{
			return "0.0";
		}		
	}
}
