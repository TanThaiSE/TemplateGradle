# honto API member

This is one of honto API.  
Implemented by Spring Framework 4 with Spring Boot.

[![build status](https://devel.honto.jp/git/member/honto-api-member/badges/master/build.svg)](https://devel.honto.jp/git/member/honto-api-member/commits/master)

## Requirement

- Java Development Kit 8

## Installation

1. Install [JDK8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
1. Install IDE ([Eclipse](https://www.eclipse.org/downloads/index-developer.php) or [IDEA](https://www.jetbrains.com/idea/download/))

### Clone source

```
git clone https://devel.honto.jp/member/honto-api-member.git honto-api-member
```

### For Eclipse

Recommended Eclipse version is 4.4 (Eclipse Luna).

#### Install plugins

From Eclipse Marketplace

- Spring Tool Suite

lombok is manual install plugin.  
See [Official site](http://projectlombok.org/download.html).

#### Build gradle

```
cd honto-api-member
./gradlew eclipse
```

### For IDEA

#### Install plugins

- lombok

#### Build gradle

```
cd honto-api-member
./gradlew idea
```
