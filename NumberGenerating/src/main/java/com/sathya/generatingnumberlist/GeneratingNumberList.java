package com.sathya.generatingnumberlist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GeneratingNumberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		//Get the request from client
	      int startNumber = Integer.parseInt(request.getParameter("startNumber"));
	      int endNumber = Integer.parseInt(request.getParameter("endNumber"));
	      String category = request.getParameter("category");
	      RequestDispatcher dispatcher = request.getRequestDispatcher("numbergenerating.html");
	      dispatcher.include(request, response);
	      writer.println("your" +category+ " "+"result....");
	        
	      
	      // process the data
	      processRequest(writer,startNumber,endNumber,category);
	}
	private void processRequest(PrintWriter writer, int start, int end, String category) {
		switch (category.toLowerCase()) {
		case "even":
            getEvenNumbers(writer, start, end);
            break;
        case "odd":
            getOddNumbers(writer, start, end);
            break;
        case "prime":
        	getPrimeNumbers(writer,start,end);
        	break;
        case "perfect":
        	getPerfectumbers(writer,start,end);
        	break;
        case "amstrong":
        	getAmstrongNumbers(writer,start,end);
        	break;
		default:
			 writer.println("Invalid category selected");
		}
		
	}
	private void getPerfectumbers(PrintWriter writer, int start, int end) {
		for(int i=start ; i<=end ; i++) {
			int sum =0;
			for(int j=1; j <= i/2 ; j++) {
				if(i % j == 0) {
					sum = sum +j;				
			}
		}
		if(i == sum) {
			writer.println(i + " ");
		}
	}
}
	private void getPrimeNumbers(PrintWriter writer, int start, int end) {
		for(int i=start;i<=end;i++) {
			int c=0;
			for(int j=2;j<i;j++) {
				if(i%j==0) {
					c++;
					break;
				}
			}
			if(c==0) {
				writer.println(i+" ");
			}
		}
	}
	private void getAmstrongNumbers(PrintWriter writer, int start, int end) {
		for (int i = start; i <= end; i++) {
            if (isArmstrong(i)) {
                writer.println(i + " ");
            }
        }
	}
	// Helper method to check number is Armstrong  
	private boolean isArmstrong(int num) {
		int originalNum = num;
		int sum =0;
		int numberofDigits = String.valueOf(num).length();
		
		while (num > 0) {
			int digit = num % 10;
			sum += Math.pow(digit, numberofDigits);
			num /= 10 ;
		}
		
		return sum == originalNum;
	}
	private void getOddNumbers(PrintWriter writer, int start, int end) {
		 for (int i = start; i <= end; i ++) {
	        	if(i%2 !=0) {
	        		writer.print(i + " ");
	        		}
	            
	        }
	       
	}
	private void getEvenNumbers(PrintWriter writer, int start, int end) {
		 for (int i = start; i <= end; i ++) {
	        	if(i%2==0) {
	        		writer.print(i + " ");
	        		}
	            
	        }
	       
	}

}
