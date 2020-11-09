package ru.kpfu.itis.listeners;

import ru.kpfu.itis.repository.SimpleDataSource;
import ru.kpfu.itis.repository.SimpleDataSourceConfig;
import ru.kpfu.itis.repository.UserRepositoryImpl;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.service.UserServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        SimpleDataSourceConfig simpleConfig = new SimpleDataSourceConfig();

        simpleConfig.setUrl("jdbc:mysql://localhost:3306/my_bd?serverTimezone=Europe/Moscow");
        simpleConfig.setDriver("com.mysql.cj.jdbc.Driver");
        simpleConfig.setUsername("root");
        simpleConfig.setPassword("ley_ley_ley");

        SimpleDataSource dataSource = new SimpleDataSource(simpleConfig);

        servletContextEvent.getServletContext().setAttribute("datasource", dataSource);

        UserRepositoryImpl userRepository = new UserRepositoryImpl(dataSource);
        UserService userService = new UserServiceImpl(userRepository);
        servletContextEvent.getServletContext().setAttribute("userService", userService);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("datasource", null);
    }

}
