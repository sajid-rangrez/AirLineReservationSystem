package com.project.programs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchFlight
 */
@WebServlet("/SearchFlight")
public class SearchFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static Connection con = null;
	public static PreparedStatement pstat = null ;
	public static ResultSet result = null;
	String url = "jdbc:mysql://localhost:3306/ARS";
	String user = "root";
	String pwd = "root";
       
	
	public void init() throws ServletException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String From = req.getParameter("FromCity");
		String To = req.getParameter("ToCity");
		String Departure = req.getParameter("DDate");
		String Return = req.getParameter("RDate");
		String Class = req.getParameter("Class");
		String Day = null;
		String Query = null;
		int Price = 0;
		
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		Day = getDay(Departure);
		if(Return != null) {
			String Rday = getDay(Return);
		}
		try {
			if(Day.equals("MON")) {
				Query = "select * from flights where Departure = ? AND Destination = ? AND  Mon = 'TRUE' ";
			}
			else if(Day.equals("TUE")) {
				Query = "select * from flights where Departure = ? AND Destination = ? AND  TUE = 'TRUE' ";
			} else if(Day.equals("WED")) {
				Query = "select * from flights where Departure = ? AND Destination = ? AND  WED = 'TRUE' ";
			} else if(Day.equals("THU")) {
				Query = "select * from flights where Departure = ? AND Destination = ? AND  THU = 'TRUE' ";
			} else if(Day.equals("FRI")) {
				Query = "select * from flights where Departure = ? AND Destination = ? AND  FRI = 'TRUE' ";
			} else if(Day.equals("SAT")) {
				Query = "select * from flights where Departure = ? AND Destination = ? AND  SAT = 'TRUE' ";
			} else if(Day.equals("SUN")) {
				Query = "select * from flights where Departure = ? AND Destination = ? AND  SUN = 'TRUE' ";
			}
			
			pstat = con.prepareStatement(Query);
			pstat.setString(1, From);
			pstat.setString(2, To);
			
			
			result = pstat.executeQuery();
			
			req.getRequestDispatcher("NavBar.jsp").include(req, resp);
			System.out.println(Day);
			
			while(result.next()) {
				if(Class.equals("Economy")) {
					Price = result.getInt(9);
				}
				else if(Class.equals("Bussiness")) {
					Price = result.getInt(10);
				}
				else if(Class.equals("Premium")) {
					Price = result.getInt(11);
				}
				else if(Class.equals("First-Class")) {
					Price = result.getInt(12);
				}
				out.println(" <box> <container class=\"element\"> <id class=\"element\">"+result.getString(7)+"</id> <from class=\"element\">"+result.getString(1)+"</from> <to class=\"element\">"+result.getString(2)+"</to> <departure class=\"element\">"+result.getString(3)+"</departure> <arival class=\"element\">"+result.getString(4)+"</arival> <price class=\"element\">"+Price+"</price> <button  type=\"button\">Book</button> </container> </box>");
				System.out.println(" <box> <container class=\"element\"> <id class=\"element\">"+result.getString(7)+"</id> <from class=\"element\">"+result.getString(1)+"</from> <to class=\"element\">"+result.getString(2)+"</to> <departure class=\"element\">"+result.getString(3)+"</departure> <arival class=\"element\">"+result.getString(4)+"</arival> <price class=\"element\">5000</price> <button  type=\"button\">Book</button> </container> </box>");

				
				out.println("<br>");
				}

			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("erroer");
		}
		
		
	}
	private static String getDay(String Date) {
		try {
		      java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(Date);
		      Calendar calendar = Calendar.getInstance();
		      calendar.setTime(date);
		      int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		      
//Day will return the day name of the week... 
		      return getDayOfWeek(dayOfWeek);
		    } catch (ParseException e) {
		      System.out.println("Error parsing the input date: " + Date);
		      return "error";
		    }
	}
	 private static String getDayOfWeek(int value) {
		    switch (value) {
		      case Calendar.MONDAY:
		        return "MON";
		      case Calendar.TUESDAY:
		        return "TUE";
		      case Calendar.WEDNESDAY:
		        return "WED";
		      case Calendar.THURSDAY:
		        return "THU";
		      case Calendar.FRIDAY:
		        return "FRI";
		      case Calendar.SATURDAY:
		        return "SAT";
		      case Calendar.SUNDAY:
		        return "SUN";
		      default:
		        return "Unknown";
		    }
		  }


}
