package com.lijubjohn;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Rest app using jetty server
 *
 */
public class RestApp
{
    public static void main( String[] args ) {
        Server jettyServer = null;
        try {
            // ServletContextHandler for creating the jetty server
            ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
            servletContextHandler.setContextPath("/");

            ServletHolder jerseyServlet = servletContextHandler.addServlet(ServletContainer.class, "/*");
            //set the initialization order of servlet holders
            jerseyServlet.setInitOrder(0);

            // specify the servlet which classes to load
            jerseyServlet.setInitParameter("jersey.config.server.provider.packages", "com.lijubjohn");


            // create embedded jetty server
            jettyServer = new Server(8080);
            jettyServer.setHandler(servletContextHandler);

            // start the server thread pool and join to it
            jettyServer.start();
            jettyServer.join();

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            // called for shutdown of server
            System.out.println("Shutdown called");
            jettyServer.destroy();
        }

    }
}
