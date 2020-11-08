package ru.kpfu.itis.controller.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class ContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        SimpleDataSourceConfig simpleConfig = new SimpleDataSourceConfig();

        simpleConfig.setUrl("jdbc:mysql://localhost:3306/mashina_ru?serverTimezone=UTC");
        simpleConfig.setDriver("com.mysql.cj.jdbc.Driver");
        simpleConfig.setUsername("root");
        simpleConfig.setPassword("Кщще");

        SimpleDataSource dataSource = new SimpleDataSource(simpleConfig);

        servletContextEvent.getServletContext().setAttribute("datasource", dataSource);

        UserRepositoryJdbcImpl userRepository = new UserRepositoryJdbcImpl(dataSource);
        UserService userService = new UserServiceImpl(userRepository);
        servletContextEvent.getServletContext().setAttribute("userService", userService);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("datasource", null);
    }


    private static DbConnection instance;
        private Connection connection;

        /**
         * Основные этапы работы с базой данных при использовании JDBC:
         * 1) Регистрация драйверов ( Class.forName("org.postgresql.Driver") - 34 строка )
         * 2.jpg) Установление соединения с базой данных (this.connection = DriverManager.getConnection(url, username, password) - 44 строка)
         * 3) Создание запроса(ов) к базе данных;
         * 4) Выполнение запроса(ов) к базе данных;
         * 5) Обработка результата(ов);
         * 6) Закрытие соединения с базой данных.
         */

        /** Конструктор, который формирует connection (соединение) для выполнения запросов */
        public DbConnection() throws SQLException {
            try {
                //С помощью механизма рефлексии ищём класс драйвера
                //JDBC-драйвер, компонент, специфичный для каждой базы данных.
                Class.forName("org.mysql.Driver");
                //JDBC URL, jdbc - протокол подключения, postgresql - это имя драйвера или имя механизма соединения с базой данных
                //localhost - адрес, 5432 - порт, web_chat - название базы данных
                String url = "jdbc:mysql://localhost:3036/my_bd";
                //Пароль, который вы указывали при скачивании PostgreSQL
                String password = "ley_ley_ley";
                //Пользователь, который имеется в PostgreSQL по-умолчанию
                String username = "root";
                //DriverManager - позволяет загрузить и зарегистрировать необходимый JDBC-драйвер,
                // а затем получить соединение с базой данных.
                this.connection = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException ex) {
                System.out.println("Database Connection Creation Failed : " + ex.getMessage());
            }
        }

        /**
         * Регистрацию драйвера можно осуществить несколькими способами:
         * 1) java.sql.DriverManager.registerDriver(%объект класса драйвера%);
         * 2.jpg) Class.forName(«полное имя класса драйвера»).newInstance();
         * 3) Class.forName(«полное имя класса драйвера»);
         */

        /**
         * Способы установки соединения с базой данных:
         * Для установки соединения с базой данных используется статический вызов java.sql.DriverManager.getConnection(...)
         * В качестве параметра может передаваться:
         * 1) URL базы данных:
         *    static Connection getConnection(String url);
         * 2.jpg) URL базы данных и набор свойств для инициализации:
         *    static Connection getConnection(String url, Properties info);
         * 3) URL базы данных, имя пользователя и пароль;
         *    static Connection getConnection(String url, String user, String password);
         * В результате вызова будет установлено соединение с базой данных и создан объект
         * класса java.sql.Connection - своеобразная «сессия», внутри контекста которой
         * и будет происходить дальнейшая работа с базой данных.
         */

        /** Метод, который возращает connection */
        private Connection getConnection() {
            return connection;
        }

        /** Метод, который возращает единственный объект класса */
        private static DbConnection getInstance() throws SQLException {
            //Если единственный экземпляр класса ещё не был создан, то он его создаст
            if (instance == null) {
                instance = new DbConnection();
            }
            //Если единственный экземпляр класса был создан, то возратит его
            else if (instance.getConnection().isClosed()) {
                instance = new DbConnection();
            }
            return instance;
        }
    }

}
