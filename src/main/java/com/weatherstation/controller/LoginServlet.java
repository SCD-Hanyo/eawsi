package com.weatherstation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weatherstation.model.Users;
import com.weatherstation.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		String userName =request.getParameter("UserName");
		String passWord =request.getParameter("Password");
		String logOutFlag=request.getParameter("logout");
		LoginService loginService = new LoginService ();
		Users user= new Users();
		
		if (logOutFlag.equals("logout"))
		{
			request.getSession().invalidate();
			response.sendRedirect("Login.jsp");
		}
		
		else {
		
		boolean foundFlag = loginService.FindUser(userName,passWord);
		boolean tryAgainFlag= false;
		boolean stationSelectedFlag=false;
		if(foundFlag == true){
			user=loginService.CheckDB(userName, passWord);
			request.getSession().setAttribute("currentUser", user.getUserName());
			request.getSession().setAttribute("organization", user.getOrganization());
			request.getSession().setAttribute("role", user.getRole());
			request.getSession().setAttribute("loggedInFlag", foundFlag);
			request.getSession().setAttribute("tryAgainFlag", tryAgainFlag);
				/*Clear all session flags*/
			request.getSession().setAttribute("stationSelectedFlag", stationSelectedFlag);
			request.getSession().setAttribute("selected_station_id", "No_Station");		
			response.sendRedirect("Welcome.jsp");
		 }
		 else{
			 tryAgainFlag=true;
			 request.getSession().setAttribute("loggedInFlag", "false");
			 request.getSession().setAttribute("tryAgainFlag", tryAgainFlag);
			 request.getSession().setAttribute("stationSelectedFlag", stationSelectedFlag);
			 response.sendRedirect("Login.jsp");
		 }
		
		}	

	}

}
