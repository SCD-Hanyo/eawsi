package com.weatherstation.service;

public class HandleQSService {

	public String UpdateParam (String input,String description)
	{
		String [] ParameterDescriptionArray_SplitArray = description.split(",");
		if (ParameterDescriptionArray_SplitArray[1].equalsIgnoreCase("C"))
		{
			if (ParameterDescriptionArray_SplitArray[0].equalsIgnoreCase("Solar Radiation"))
			{
				input=Calculate_SR_Apogee(input);								
			}
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
			if (outputdouble<0.005)
			{
				outputdouble=0;
			}
			outputdouble=((double)Math.round(outputdouble * 10000) / 10000);
			String output=String.valueOf(outputdouble);
			return output;
		}
		else
		{
			return "0.0";
		}		
	}

	public String Calculate_AH_SHT25(String input) {
		boolean SingleValueNumeric=isNumeric(input);
		if (SingleValueNumeric==true)
		{			
			double inputdouble=Double.parseDouble(input);
			double outputdouble= (((125*inputdouble))/(Math.pow(2, 16))-6);
			outputdouble=((double)Math.round(outputdouble * 100) / 100);
			String output=String.valueOf(outputdouble);
			return output;
		}
		else
		{
			return "0.0";
		}		
	}

	public String Calculate_AH_SHT25_Avg(String input) {
		boolean SingleValueNumeric=isNumeric(input);
		if (SingleValueNumeric==true)
		{			
			double inputdouble=Double.parseDouble(input);			
			double outputdouble;
			inputdouble/=10;
			outputdouble= (((125*inputdouble))/(Math.pow(2, 16))-6);
			outputdouble=((double)Math.round(outputdouble * 100) / 100);
			String output=String.valueOf(outputdouble);
			return output;
		}
		else
		{
			return "0.0";
		}		
	}

	public String Calculate_AT_SHT25(String input) {
		boolean SingleValueNumeric=isNumeric(input);
		if (SingleValueNumeric==true)
		{			
			double inputdouble=Double.parseDouble(input);
			double outputdouble= (((175.72*inputdouble))/(Math.pow(2, 16))-46.85);
			outputdouble=((double)Math.round(outputdouble * 100) / 100);
			String output=String.valueOf(outputdouble);
			return output;
		}
		else
		{
			return "0.0";
		}		
	}

	public String Calculate_AT_SHT25_Avg(String input) {
		boolean SingleValueNumeric=isNumeric(input);
		if (SingleValueNumeric==true)
		{			
			double inputdouble=Double.parseDouble(input);
			double outputdouble;
			inputdouble/=10;
			outputdouble= (((175.72*inputdouble))/(Math.pow(2, 16))-46.85);
			outputdouble=((double)Math.round(outputdouble * 100) / 100);
			String output=String.valueOf(outputdouble);
			return output;
		}
		else
		{
			return "0.0";
		}		
	}
	
	
	
	
	public String Calculate_AT_SHT15_Avg(String input) {
		boolean SingleValueNumeric=isNumeric(input);
		if (SingleValueNumeric==true)
		{			
			double inputdouble=Double.parseDouble(input);
			double outputdouble;
			inputdouble/=10;

			
			outputdouble= ((0.01*inputdouble)-40.1);
			outputdouble=((double)Math.round(outputdouble * 100) / 100);
			String output=String.valueOf(outputdouble);
			return output;
		}
		else
		{
			return "0.0";
		}		
	}

	public String Calculate_AT_SHT15(String input) {
		boolean SingleValueNumeric=isNumeric(input);
		if (SingleValueNumeric==true)
		{			
			double inputdouble=Double.parseDouble(input);
			double outputdouble;
			
			outputdouble= ((0.01*inputdouble)-40.1);
			outputdouble=((double)Math.round(outputdouble * 100) / 100);
			String output=String.valueOf(outputdouble);
			return output;
		}
		else
		{
			return "0.0";
		}		
	}
	
	public String Calculate_AH_SHT15_Avg(String input,String TempInCelString) {				
		boolean SingleValueNumeric=isNumeric(input);
		if (SingleValueNumeric==true)
		{			
			double inputdouble=Double.parseDouble(input);
			double TempInCelDouble=Double.parseDouble(TempInCelString);
			double RHLinear;
			double RHTrue;

			inputdouble/=10;
			
			RHLinear=((-2.0468)+ (0.0367*inputdouble) + (-1.5955* (Math.pow(10, -6))* Math.pow(inputdouble, 2)));
			RHTrue=((TempInCelDouble-25)* (0.01+(0.00008*inputdouble))+RHLinear);
			
			RHTrue=((double)Math.round(RHTrue * 100) / 100);
			String output=String.valueOf(RHTrue);
			return output;
		}
		else
		{
			return "0.0";
		}		
	}

	public String Calculate_AH_SHT15(String input,String TempInCelString) {
		boolean SingleValueNumeric=isNumeric(input);
		if (SingleValueNumeric==true)
		{			
			double inputdouble=Double.parseDouble(input);
			double TempInCelDouble=Double.parseDouble(TempInCelString);
			double RHLinear;
			double RHTrue;
			
			RHLinear=((-2.0468)+ (0.0367*inputdouble) + (-1.5955* (Math.pow(10, -6))* Math.pow(inputdouble, 2)));
			RHTrue=((TempInCelDouble-25)* (0.01+(0.00008*inputdouble))+RHLinear);
			
			RHTrue=((double)Math.round(RHTrue * 100) / 100);
			String output=String.valueOf(RHTrue);
			return output;
		}
		else
		{
			return "0.0";
		}		
	}
	
	public String Calculate_SM_VH400(String input) {
		boolean SingleValueNumeric=isNumeric(input);
		if (SingleValueNumeric==true)
		{			
			double inputdouble=Double.parseDouble(input);
			double vwc=0;
			
			if (inputdouble>= 0 && inputdouble<=337)
			{
				vwc=((0.03/0.92)*inputdouble)-1;
			}
			else if (inputdouble>337 && inputdouble<=398)
			{
				vwc=((0.075/0.92)*inputdouble)-17.5;				
			}
			else if (inputdouble>398 && inputdouble<=558)
			{
				vwc=((0.14424/0.92)*inputdouble)-47.5;								
			}
			else if (inputdouble>558 && inputdouble<674)
			{
				vwc=((0.07896/0.92)*inputdouble)-7.89;												
			}
			else if (inputdouble>=674 && inputdouble<=920)
			{
				vwc=((0.1874475/0.92)*inputdouble)-87.4475;																
			}
			else
			{
				return "0.0";
			}

			
			vwc=((double)Math.round(vwc * 100) / 100);
			String output=String.valueOf(vwc);
			return output;
		}
		else
		{
			return "0.0";
		}		
	}
	
	public String Calculate_SM_VH400_Avg(String input) {
		boolean SingleValueNumeric=isNumeric(input);
		if (SingleValueNumeric==true)
		{
			double inputdouble=Double.parseDouble(input);
			inputdouble/=10;
			String single_input=String.valueOf(inputdouble);
			String output=Calculate_SM_VH400(single_input);
			return output;
		}
		else
		{
			return "0.0";
		}
	}
	
	
	
	
	
}
