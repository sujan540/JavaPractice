import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by sujan on 6/5/16.
 */
public class MyServlet extends HttpServlet {

    private String message;

    public MyServlet(){
        System.out.println("Constructor");
    }

    public void init() throws ServletException
    {
       System.out.println("Init");
        this.message="Hello Sujan";
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    public void destroy()
    {
        System.out.println("Destroy");
    }

    public static void main(String[] args){

    }


}
