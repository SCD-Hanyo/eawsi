package com.weatherstation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectStationServlet
 */
@WebServlet("/SelectStationServlet")
public class SelectStationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectStationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String formIndicator=request.getParameter("form_indicator_flag");
		boolean stationSelectedFlag=true;
		
		if (formIndicator.equals("form_populate_station_list_LOV_01"))
		{
			String Selected_Station_ID=request.getParameter("selected_station_id");
			if (Selected_Station_ID.equals("No_Station"))
			{
				stationSelectedFlag=false;
				request.getSession().setAttribute("selected_station_id", "No_Station");		
			}
			else
			{
				stationSelectedFlag=true;
				request.getSession().setAttribute("selected_station_id", Selected_Station_ID);				
			}
			request.getSession().setAttribute("stationSelectedFlag", stationSelectedFlag);
			response.sendRedirect("Welcome.jsp");
		} 
		
	}

}
