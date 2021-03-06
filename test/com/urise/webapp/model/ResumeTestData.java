package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("Федор Гришин");

        List<String> achievementsList = new ArrayList<>();
        achievementsList.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", " +
                "\"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). " +
                "Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов." +
                " Более 1000 выпускников. ");

        achievementsList.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. " +
                "Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.  ");

        achievementsList.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. " +
                "Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. " +
                "Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера. ");

        achievementsList.add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), " +
                "Commet, HTML5, Highstock для алгоритмического трейдинга. ");

        achievementsList.add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, " +
                "JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента" +
                " для администрирования и мониторинга системы по JMX (Jython/ Django). ");

        achievementsList.add("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк)," +
                " Белоруcсии(Erip, Osmp) и Никарагуа.");

        List<String> qualificationsList = new ArrayList<>();
        qualificationsList.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2 ");
        qualificationsList.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce  ");
        qualificationsList.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle");
        qualificationsList.add("MySQL, SQLite, MS SQL, HSQLDB  ");

        List<Organization> experienceList = new ArrayList<>();

        Organization.Position position1 = new Organization.Position(LocalDate.of(1997, 9, 1),
                LocalDate.of(2005, 1, 1), "Инженер по аппаратному и программному тестированию",
                "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).");

        Organization.Position position2 = new Organization.Position(
                LocalDate.of(2005, 1, 1), LocalDate.of(2007, 2, 1),
                "Разработчик ПО",
                "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе" +
                        " Siemens @vantage (Java, Unix).");

        Organization experience1 = new Organization("Alcatel", "www.alcatel.ru", position1);

        Organization experience2 = new Organization("Siemens AG", "https://new.siemens.com/ru/ru.html", position2);

        experienceList.add(experience1);
        experienceList.add(experience2);

        List<Organization> educationList = new ArrayList<>();

        Organization.Position position3 = new Organization.Position(LocalDate.of(1984, 9, 1),
                LocalDate.of(1987, 6, 1), "Закончил с отличием",
                null);

        Organization.Position position4 = new Organization.Position(LocalDate.of(1993, 9, 1),
                LocalDate.of(1996, 7, 1), "Аспирантура (программист С, С++)",
                null);

        Organization.Position position5 = new Organization.Position(LocalDate.of(1987, 9, 1),
                LocalDate.of(1993, 7, 1), "Инженер (программист Fortran, C)",
                null);

        List<Organization.Position> positions = new ArrayList<>();
        positions.add(position4);
        positions.add(position5);

        Organization education1 = new Organization("Заочная физико-техническая школа при МФТИ",
                "http://www.school.mipt.ru/", new Organization.Position(LocalDate.of(1987, 9, 1),
                LocalDate.of(1993, 7, 1), "Инженер (программист Fortran, C)",
                null));

        Organization education2 = new Organization(new Link("МГИЭМ Московский государственный институт" +
                "электроники и математики",
                "http://www.ifmo.ru/ru/"), positions);

        educationList.add(education1);
        educationList.add(education2);

        Map<SectionType, Section> sections = resume.getSections();
        Section textClassPersonal = new TextSection("Аналитический склад ума");
        Section textClassObjective = new TextSection("Java разработчик");
        Section listClassAchievement = new ListSection(achievementsList);
        Section listClassQualifications = new ListSection(qualificationsList);
        Section listClassExperience = new OrganizationSection(experienceList);
        Section listClassEducation = new OrganizationSection(educationList);

        sections.put(SectionType.PERSONAL, textClassPersonal);
        sections.put(SectionType.OBJECTIVE, textClassObjective);
        sections.put(SectionType.ACHIEVEMENT, listClassAchievement);
        sections.put(SectionType.QUALIFICATIONS, listClassQualifications);
        sections.put(SectionType.EXPERIENCE, listClassExperience);
        sections.put(SectionType.EDUCATION, listClassEducation);

        Map<ContactType, String> contacts = resume.getContacts();

        contacts.put(ContactType.PHONE, "+7(903) 123-4567");
        contacts.put(ContactType.SKYPE, "fedor");
        contacts.put(ContactType.MAIL, "f.grishin@gmail.ru");
        contacts.put(ContactType.LINKEDIN, "https://www.linkedin.com");
        contacts.put(ContactType.GITHUB, "https://github.com");
        contacts.put(ContactType.STATCKOVERFLOW, "https://stackoverflow.com");

        System.out.println(resume);
    }
}