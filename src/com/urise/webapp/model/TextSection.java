package com.urise.webapp.model;

import java.io.Serializable;
import java.util.Objects;

 public class TextSection extends Section implements Serializable {
     private static final long serialVersionUID =1L;

    final private String content;

   public TextSection(String content) {
        Objects.requireNonNull(content, "content must be not empty");
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextSection that = (TextSection) o;

        return content.equals(that.content);
    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }

    @Override
    public String toString() {
        return "TextSection{" +
                "content='" + content + '\'' +
                '}';
    }
}
