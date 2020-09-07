package main;

import accounts.AccountService;
import dbService.DBService;
import dbService.dataSets.UserDataSet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.SignInServlet;
import servlets.SignUpServlet;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args)  throws Exception {
        //System.out.println("I'm alive");
        DBService dbService = new DBService();
        UserDataSet a = dbService.getU(1);
//        dbService.printConnectInfo();

//        try{
//            for(UserDataSet a:dbService.allUsers())
//                System.out.println(a.getLogin() + " " + a.getPassword() + " " + a.getLogin());
//        } catch (DBException e) {
//            e.printStackTrace();
//        }


        AccountService accountService = new AccountService(dbService);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        context.addServlet(new ServletHolder(new SignUpServlet(accountService)), "/signup");
        context.addServlet(new ServletHolder(new SignInServlet(accountService)), "/signin");


        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});
//        handlers.setHandlers(new Handler[]{context, resource_handler});
        Server server = new Server(8080);
        server.setHandler(handlers);

        server.start();
        Logger logger = Logger.getLogger("");
        logger.info("Server started");
        server.join();

    }
}
