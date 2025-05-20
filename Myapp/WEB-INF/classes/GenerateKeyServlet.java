import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;

public class GenerateKeyServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String fname = request.getParameter("fname");

        out.println("<html>");
        out.println("<head><title>Generated Key</title></head>");
        out.println("<body>");

        if (fname != null && fname.length() >= 2) {
            String key = fname.substring(0, 2).toUpperCase();

            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
            String date = sdf.format(new Date());

            String generatedKey = key + date;

            out.println("<h2>Name:</h2>");
            out.println("<p><strong>" + fname + "</strong></p>");
            out.println("<h2>Generated Key:</h2>");
            out.println("<p><strong>" + generatedKey + "</strong></p>");
        } else {
            out.println("<h3 style='color:red;'>Error: Name must be at least 2 characters long.</h3>");
        }

        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
