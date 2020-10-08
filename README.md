# gwt-rxjs-jsinterop (GWT rxjs interop)
[![Build Status](https://travis-ci.org/timofeevda/gwt-rxjs-jsinterop.svg?branch=master)](https://travis-ci.org/timofeevda/gwt-rxjs-jsinterop)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.timofeevda/gwt-rxjs-jsinterop/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.timofeevda/gwt-rxjs-jsinterop)


RxJS 6.x.x JavaScript interoperability bindings see at [master](https://github.com/timofeevda/gwt-rxjs-jsinterop/tree/master) branch

RxJS 5.x.x JavaScript interoperability bindings for GWT 2.8/2.9

Supported rxjs versions list (starting from RxJS 5.5.11 versions are synced to simplify versions mapping):

| rxjs          | gwt-rxjs-jsinterop |
| ------------- | ------------------ |
| 5.5.11        | 5.5.11-x           |
| 5.5.6         | >= 1.1.7           |
| 5.4.1         | >= 1.1.5           |
| 5.0.3         | <= 1.1.4           |

Add dependency to your pom.xml for GWT 2.8.x and optionally dependency to jsinterop-annotations:
:
```xml
<dependency>
    <groupId>com.github.timofeevda</groupId>
    <artifactId>gwt-rxjs-jsinterop</artifactId>
    <version>${version}</version>
</dependency>
```

Add dependency to your pom.xml for GWT 2.9.x and optionally dependency to jsinterop-annotations:
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

Also add following entry in gwt-maven-plugin configuration:
```xml
<generateJsInteropExports>true</generateJsInteropExports>
```

Don't forget to add actual [rxjs](https://github.com/ReactiveX/rxjs) library to page resources

