package in.ashokit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GreetingServlet")
public class GreetingServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Greeting Message</title></head><body>");

        // Get the current time
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);

        // Determine the greeting based on the time
        String greeting;
        if (hour >= 6 && hour < 12) {
            greeting = "Good Morning";
        } else if (hour >= 12 && hour < 16) {
            greeting = "Good Afternoon";
        } else if (hour >= 16 && hour < 20) {
            greeting = "Good Evening";
        } else {
            greeting = "Good Night";
        }

        // Display the greeting message
        out.println("<h1>" + greeting + "</h1>");

        out.println("</body></html>");
        out.close();
    }
}
