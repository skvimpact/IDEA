package main;


import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import sax.*;
import resources.*;
import servlets.ResourcesPageServlet;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class Main {
    static final Logger logger = LogManager.getLogger(Main.class.getName());
    public static void main(String[] args)  throws Exception {


//        Object d = new Object();
//        Thread t = new Thread();
//        t.w

        if (args.length != 1) {
            logger.error("Use port as the first argument");
            System.exit(1);
        }

        String portString = args[0];
        int port = Integer.valueOf(portString);

        TestResource testResource = new TestResource();

        Server server = new Server(port);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new ResourcesPageServlet(testResource)), ResourcesPageServlet.PAGE_URL);


        ResourcesServerControllerMBean serverStatistics = new ResourcesServerController(testResource);
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("ServerManager:type=ResourceServerController");
        mbs.registerMBean(serverStatistics, name);

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setDirectoriesListed(true);
        resource_handler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});
        server.setHandler(handlers);

        server.start();
        logger.info("Server started");

        server.join();

    }
}
