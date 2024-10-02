package org.example.finaljavaeeproject.util;

import org.example.finaljavaeeproject.entity.horse.HorsePhoto;
import org.example.finaljavaeeproject.entity.horse.HorseStatus;
import org.example.finaljavaeeproject.entity.horse.Horse;
import org.example.finaljavaeeproject.entity.stable.StableAddress;
import org.example.finaljavaeeproject.entity.stable.StableContactInfo;
import org.example.finaljavaeeproject.entity.stable.Stable;
import org.example.finaljavaeeproject.entity.user.Role;
import org.example.finaljavaeeproject.entity.user.User;
import org.example.finaljavaeeproject.entity.user.UserAddress;
import org.example.finaljavaeeproject.entity.user.UserPhoto;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.HashMap;
import java.util.Map;

public class HibernateAnnotationUtil {

    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    /**
     * Utility class
     */
    private HibernateAnnotationUtil() {
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    private static SessionFactory buildSessionFactory() {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(dbSettings())
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Role.class)
                .addAnnotatedClass(StableAddress.class)
                .addAnnotatedClass(StableContactInfo.class)
                .addAnnotatedClass(Horse.class)
                .addAnnotatedClass(Stable.class)
                .addAnnotatedClass(HorseStatus.class)
                .addAnnotatedClass(UserAddress.class)
                .addAnnotatedClass(UserPhoto.class)
                .addAnnotatedClass(HorsePhoto.class)


// Сюда включить классы!
                .buildMetadata();

        return metadata.buildSessionFactory();
    }

    private static Map<String, Object> dbSettings() {
        Map<String, Object> dbSettings = new HashMap<>();
        dbSettings.put(Environment.URL, "jdbc:mysql://localhost:3308/final_project_db");
        dbSettings.put(Environment.USER, "root");
        dbSettings.put(Environment.PASS, "");
        dbSettings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        dbSettings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        dbSettings.put(Environment.SHOW_SQL, "true");
        dbSettings.put(Environment.HBM2DDL_AUTO, "create");
        return dbSettings;
    }

    public static void close() {
        SESSION_FACTORY.close();
    }
}
