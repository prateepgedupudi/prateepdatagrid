package com.prateep;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class LogLevel
 */
public class LogLevel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(Prateep.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogLevel() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String packageName= request.getParameter("Package");
		String logLevel= request.getParameter("Level");
		//org.apache.log4j.Logger logger4j = org.apache.log4j.Logger.getRootLogger();
		org.apache.log4j.Logger logger4j = org.apache.log4j.Logger.getLogger(packageName);
		//logger4j.setLevel(org.apache.log4j.Level.ERROR);
		logger4j.setLevel(org.apache.log4j.Level.toLevel(logLevel));
		logger.info("Log level has changed to {} ",org.apache.log4j.Level.toLevel(logLevel));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
