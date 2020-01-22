package com.urise.webapp.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Resume {

    private final String uuid;

    private final String fullName;

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    Map<SectionType, Section> sections = new HashMap<>();

    Map<ContactType, String> contacts = new HashMap<>();

    public void fillSections(){
        sections.put(SectionType.PERSONAL, new TextClass());
        sections.put(SectionType.OBJECTIVE, new TextClass());
        sections.put(SectionType.ACHIEVEMENT, new ListClass());
        sections.put(SectionType.QUALIFICATIONS, new ListClass());
        sections.put(SectionType.EXPERIENCE, new ExperienceSection());
        sections.put(SectionType.EDUCATION, new ExperienceSection());
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) return false;
        return fullName.equals(resume.fullName);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "uuid='" + uuid + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
