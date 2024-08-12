package com.practice.annotations;

import java.lang.reflect.Field;

public class AnnotationDemo {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student(123, "Aryan", 545);
        System.out.println(getXMLString(s1));
    }

    private static String getXMLString(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        StringBuilder sb = new StringBuilder();

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(XMLElement.class)) {
                String fieldTag = getTag(field);
                sb.append("\t<").append(fieldTag).append(">")
                        .append(field.get(obj).toString())
                        .append("</").append(fieldTag).append(">\n");
            }
        }
        String classTag = getTag(clazz);
        return "<" + classTag + ">\n" + sb + "</" + classTag + ">";
    }

    private static String getTag(Field field) {
        String val = field.getAnnotation(XMLElement.class).tag();
        return val.isEmpty() ? field.getName() : val;
    }

    private static String getTag(Class<?> clazz) {
        String val = clazz.getAnnotation(XMLSerializable.class).tag();
        return val.isEmpty() ? clazz.getSimpleName() : val;
    }
}
