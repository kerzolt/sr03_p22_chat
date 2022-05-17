# Moteur de template

## THYMELEAF
Dans le pom.xml :
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```
Les fichiers html doivent etre dans ``src/main/resources/templates/``

## JSP
Dans le pom.xml :
```
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
</dependency>
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
</dependency>
```
Dans application.properties :
```
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
```
Les fichiers jsp doivent etre dans ``src/main/webapp/WEB-INF/jsp/``

# Endpoints
Test : http://localhost:8080/test  
Login : http://localhost:8080/login  
Users : http://localhost:8080/admin/users  
Channels : http://localhost:8080/channels

