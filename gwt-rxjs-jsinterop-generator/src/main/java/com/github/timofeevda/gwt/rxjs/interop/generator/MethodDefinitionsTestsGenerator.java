/*
 * The MIT License
 *
 * Copyright 2017 timof.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.timofeevda.gwt.rxjs.interop.generator;

import groovy.lang.Writable;
import groovy.text.SimpleTemplateEngine;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Generates class with method definitions tests. Allows checking methods 
 * availability for existing bindings via Jasmine specs automatically
 * 
 * @author dtimofeev since 29.05.2017.
 */
public class MethodDefinitionsTestsGenerator {

    private static final Map<String, Integer> METHOD_COUNTERS = new HashMap<>();

    public static void main(String... args) throws ClassNotFoundException, IOException {
        Method[] methodDeclarations = Class.forName("com.github.timofeevda.gwt.rxjs.interop.RxJS")
                .getDeclaredMethods();

        Set<String> importsSet = generateImportsSet(methodDeclarations);

        List<GeneratedMethodDefinition> generatedMethodDefinitions = generateMethodsDefintions(methodDeclarations);

        SimpleTemplateEngine templateEngine = new SimpleTemplateEngine();

        InputStream templateStream = MethodDefinitionsTestsGenerator.class.getResourceAsStream("/definitions.template");
        
        Map<String, Object> templateBindings = new HashMap<>();
        templateBindings.put("methods", generatedMethodDefinitions);
        templateBindings.put("importsSet", importsSet);

        File destinationFile = new File(args[0]);
        destinationFile.mkdirs();
        
        File testDefinitonsFile = new File(args[0] + File.separator + "MethodsDefinitionsTest.java");
        testDefinitonsFile.createNewFile();

        Writable writable = templateEngine.createTemplate(new BufferedReader(new InputStreamReader(templateStream))).make(templateBindings);
        writable.writeTo(new PrintWriter(new FileOutputStream(testDefinitonsFile)));
    }

    private static List<GeneratedMethodDefinition> generateMethodsDefintions(Method[] methodDeclarations) {
        List<GeneratedMethodDefinition> generatedMethodDefinitions = Arrays.stream(methodDeclarations)
                .filter(methodDeclaration -> (methodDeclaration.getModifiers() & Modifier.STATIC) != Modifier.STATIC)
                .map(methodDeclaration
                        -> new GeneratedMethodDefinition(methodDeclaration.getName(),
                                generateUniqueMethodName(methodDeclaration),
                                generateMethodParameters(methodDeclaration))
                ).collect(Collectors.toList());
        return generatedMethodDefinitions;
    }

    private static Set<String> generateImportsSet(Method[] methodDeclarations) {
        Set<String> importsSet = Arrays.stream(methodDeclarations)
                .filter(m -> (m.getModifiers() & Modifier.STATIC) != Modifier.STATIC)
                .flatMap(m -> Arrays.stream(m.getParameterTypes()))
                .filter(type -> type.getPackage() != null)
                .map(Class::getCanonicalName)
                .collect(Collectors.toCollection(TreeSet::new));
        return importsSet;
    }

    private static String generateUniqueMethodName(Method methodDeclaration) {
        int count = METHOD_COUNTERS.getOrDefault(methodDeclaration.getName(), 0);
        String uniqueName = methodDeclaration.getName();
        if (count != 0) {
            count++;
            uniqueName += count;
        } else {
            count++;
        }
        METHOD_COUNTERS.put(methodDeclaration.getName(), count);
        return uniqueName;
    }

    private static List<GeneratedMethodParameter> generateMethodParameters(Method methodDeclaration) {
        return Arrays.stream(methodDeclaration.getParameterTypes())
                .map(MethodDefinitionsTestsGenerator::classToGeneratedMethodParameter)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private static Optional<GeneratedMethodParameter> classToGeneratedMethodParameter(Class<?> parameterClass) {
        Package p = parameterClass.getPackage();

        if (parameterClass.isPrimitive()) {
            return Optional.of(new GeneratedMethodParameter(null, 0));
        } else {
            if (p != null) {
                if (parameterClass.equals(Object.class)) {
                    // just return integer for simplicity
                    return Optional.of(new GeneratedMethodParameter("Integer", null));
                } else {
                    return Optional.of(new GeneratedMethodParameter(parameterClass.getCanonicalName(), null));
                }
            }
        }
        return Optional.empty();
    }

    static class GeneratedMethodParameter {

        private final String type;
        private final Object value;

        public GeneratedMethodParameter(String type, Object value) {
            this.type = type;
            this.value = value;
        }
    }

    static class GeneratedMethodDefinition {

        private final String originalMethodName;
        private final String uniqueMethodName;
        private final List<GeneratedMethodParameter> parameters;

        public GeneratedMethodDefinition(String methodName,
                String uniqueMethodName,
                List<GeneratedMethodParameter> parameters) {
            this.originalMethodName = methodName;
            this.uniqueMethodName = uniqueMethodName;
            this.parameters = parameters;
        }

    }

}
