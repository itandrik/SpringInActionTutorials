package com.springinaction.config;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by 1 on 05.04.2017.
 */
public class MyServletInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        /*ServletRegistration.Dynamic myServlet =
                servletContext.addServlet("myServlet", MyServlet.class);
        myServlet.addMapping("/custom*//**");*/
    }
}
