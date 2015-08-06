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
		if (formIndicator.equals("form_populate_station_list_LOV_01"))
		{
			String Selected_Station_ID=request.getParameter("selected_station_id");
			if (Selected_Station_ID.equals("0001"))
			{
				response.sendRedirect("0001.jsp");

//				FilterOrDisplayFormInputFlag="Display";
//				request.getSession().setAttribute("FilterOrDisplayFormInputFlag", FilterOrDisplayFormInputFlag);
//				response.sendRedirect("Welcome.jsp");
			}
/*
			else if (filterBy.equals("Filter"))
			{
				FilterOrDisplayFormInputFlag="Filter"; 
				request.getSession().setAttribute("FilterOrDisplayFormInputFlag", FilterOrDisplayFormInputFlag);
				response.sendRedirect("Welcome.jsp");				
			}
			else
			{
				FilterOrDisplayFormInputFlag="Error";
				request.getSession().setAttribute("FilterOrDisplayFormInputFlag", FilterOrDisplayFormInputFlag);
				response.sendRedirect("Welcome.jsp");	
			}
*/
		} 
		
	}

}
