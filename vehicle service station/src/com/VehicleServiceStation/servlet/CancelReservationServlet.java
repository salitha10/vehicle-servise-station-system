/**
 * VEHICLE SERVICE AND FUEL SATATION MANAGEMENT SYSTEM
 * @author yasith wimukthi
 * IT 19966922
 * 
 * Y2S1 2.2
 * OOP
 *
 */


package com.VehicleServiceStation.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.VehicleServiceStation.service.ReservationService;

/**
 * Servlet implementation class CancelReservationServlet
 */
@WebServlet("/CancelReservationServlet")
public class CancelReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/** CREATE ReservationSevice CLASS VARIABLE*/
	private ReservationService reservationSevice;
	
	/** INITIALIZE CLASS VARIABLES*/
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		reservationSevice = new ReservationService();
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public CancelReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/** GET PARAMETERS*/
		String reservationID = request.getParameter("resID");
		
		//CREATE PRINT WRITER FOR GIVING JAVASCRIPT ALERTS
		PrintWriter out = response.getWriter();
		
		/** Confirm before update*/
		out.println("<script type=\"text/javascript\">");
		out.println("let retVal = confirm(\"Do you want to cancel the reservation ?\");");
		out.println("if(!retVal){"
				+ "location='your-details.jsp'};");
		out.println("</script>");
		
		boolean isDelete = reservationSevice.deleteReservation(reservationID);
		
		if(isDelete) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Cancel the reservation Successfully !');");
			out.println("location='view-reservation.jsp';");
			out.println("</script>");
		}
		
		else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Reservation cancel is not completed !');");
			out.println("location='view-reservation.jsp';");
			out.println("</script>");
		}
		
		doGet(request, response);
	}

}
