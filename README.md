# gwt-rxjs-jsinterop (GWT rxjs interop)
[![Build Status](https://travis-ci.org/timofeevda/gwt-rxjs-jsinterop.svg?branch=master)](https://travis-ci.org/timofeevda/gwt-rxjs-jsinterop)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.timofeevda/gwt-rxjs-jsinterop/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.timofeevda/gwt-rxjs-jsinterop)


RxJS JavaScript interoperability bindings for GWT 2.8

Currently supports major functionality of rxjs 5.0.3

Add dependency to your pom.xml:
```xml
<dependency>
    <groupId>com.github.timofeevda</groupId>
    <artifactId>gwt-rxjs-jsinterop</artifactId>
    <version>${version}</version>
</dependency>
```

Update your GWT module with the following line:
```xml
<inherits name="com.github.timofeevda.gwt.rxjs.interop"/>
```

Don't forget to add actual [rxjs](https://github.com/ReactiveX/rxjs) library to page resources


