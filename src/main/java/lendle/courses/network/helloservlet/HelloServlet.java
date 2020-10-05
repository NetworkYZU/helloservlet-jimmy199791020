/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lendle.courses.network.helloservlet;


import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lendle
 */
@WebServlet(name = "HelloServlet", urlPatterns = {"/"})                         // "/" 表根目錄
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        try(PrintWriter out=resp.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProcessServlet</title>");
            out.println("</head>");
            out.println("<body>");
            Enumeration<String> names = request.getParameterNames();
            while(names.hasMoreElements()){
                String name = names.nextElement();
                out.print(name+"=");
                out.print(request.getParameter(name)+"<br/>");
            }
            out.println("</body>");
            out.println("</html>");
            //輸出
            // <html>
            // <body>
            //  <h1>Hello!</h1>
            // </body>
            // </html>
        }
    }
    
}
