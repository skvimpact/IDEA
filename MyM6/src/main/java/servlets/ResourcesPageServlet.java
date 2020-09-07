package servlets;


//import accountServer.AccountServer;
import resources.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sax.ReadXMLFileSAX;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResourcesPageServlet  extends HttpServlet {
    static final Logger logger = LogManager.getLogger(ResourcesPageServlet.class.getName());
    public static final String PAGE_URL = "/resources";
    private final TestResource testResource;

    public ResourcesPageServlet(TestResource testResource) {
        this.testResource = testResource;
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
//        logger.info("Return users limit = " + limit);
        response.getWriter().println(testResource.toString());
        response.setStatus(HttpServletResponse.SC_OK);
        return;





    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        final String path = request.getParameter("path");


        if (path == null) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
//        testResource.setAge(6500);
//        testResource.setName(path);
        final TestResource testResourceFromXML = (TestResource) ReadXMLFileSAX.readXML(path);
//        final TestResource testResourceFromXML = (TestResource) ReadXMLFileSAX.readXML("./data/MyResource.xdb");
        testResource.setAge(testResourceFromXML.getAge());
        testResource.setName(testResourceFromXML.getName());

        //accountService.addNewUser(new UserProfile(login, password));
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
