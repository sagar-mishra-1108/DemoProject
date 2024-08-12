package com.practice.annotations.processor;

import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("com.practice.annotations.processor.Builder")
public class BuilderProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        annotations.forEach(annotation ->
                roundEnv.getElementsAnnotatedWith(annotation)
                        .forEach(this::generateBuilderFile)
        );
        return true;
    }

    private void generateBuilderFile(Element element) {
        String className = element.getSimpleName().toString();
        String packageName = element.getEnclosingElement().toString();
        String builderName = className + "com.practice.annotations.processor.Builder";
        String builderFullName = packageName + "." + builderName;
        List<? extends Element> fields = element.getEnclosedElements()
                .stream().filter(el -> ElementKind.FIELD.equals(el.getKind())).collect(Collectors.toList());

        try (PrintWriter writer = new PrintWriter(
                processingEnv.getFiler().createSourceFile(builderFullName).openWriter())) {
            writer.println("""
                    package %s;

                    public class %s {
                    """
                    .formatted(packageName, builderName)
            );

            fields.forEach(field ->
                    writer.print("""
                                private %s %s;
                            """.formatted(field.asType().toString(), field.getSimpleName())
                    )
            );

            writer.println();
            fields.forEach(field ->
                    writer.println("""
                                public %s %s(%s value) {
                                    %s = value;
                                    return this;
                                }
                            """.formatted(builderName, field.getSimpleName(),
                            field.asType().toString(), field.getSimpleName())
                    )
            );

            writer.println("""
                        public %s build() {
                            return new %s(%s);
                        }
                    """.formatted(className, className,
                    fields.stream().map(Element::getSimpleName).collect(joining(", ")))
            );
            writer.println("}");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
