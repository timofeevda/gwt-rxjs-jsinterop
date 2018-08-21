# gwt-rxjs-jsinterop (GWT rxjs interop)
[![Build Status](https://travis-ci.org/timofeevda/gwt-rxjs-jsinterop.svg?branch=master)](https://travis-ci.org/timofeevda/gwt-rxjs-jsinterop)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.timofeevda/gwt-rxjs-jsinterop/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.timofeevda/gwt-rxjs-jsinterop)


RxJS JavaScript interoperability bindings for GWT 2.8

RxJS 5.x.x JavaScript interoperability bindings see at [5.x.x](https://github.com/timofeevda/gwt-rxjs-jsinterop/tree/5.x.x) branch

Supported rxjs versions list (starting with RxJS 5.5.11 versions are synched to simplify versions mapping):

| rxjs          | gwt-rxjs-jsinterop |
| ------------- | ------------------ |
| 5.5.11        | 5.5.11-x           |
| 5.5.6         | >= 1.1.7           |
| 5.4.1         | >= 1.1.5           |
| 5.0.3         | <= 1.1.4           |

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

Also add following entry in gwt-maven-plugin configuration:
```xml
<generateJsInteropExports>true</generateJsInteropExports>
```

Don't forget to add actual [rxjs](https://github.com/ReactiveX/rxjs) library to page resources

**Note**: for building on Linux systems add -Dphantomjs.binary option pointing it to PhantomJS binary location. On Windows PhantomJS is installed automatically during build.


