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

# Validation
Dans le pom.xml
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```
Dans la classe java de l'entite JPA
```
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
```
```
@Column(name = "firstname")
@Size(min = 2)
@NotEmpty(message = "firstname obligatoire")
private String firstName;
```
Dans le controller : Ajouter l'annotation @Valid et un parametre de type BindingResult a la fonction qui repond au POST
```
@PostMapping
public String postLogin(@ModelAttribute @Valid User user, BindingResult result, Model model) {
    ...
}
```

# Requetes presonnalisees
Creer une interface java qui liste les fonctions personnalisees  
_=> voir l'interface fr.utc.sr03.chat.dao.UserRepositoryCustom_  

Implementer les fonctions de l'interface  
_=> voir la classe fr.utc.sr03.chat.dao.UserRepositoryImpl_  

Dans l'interface initiale qui etend JpaRepository (fr.utc.sr03.chat.dao.UserRepository), etendre egalement l'interface personnalisee  
_=> voir l'interface fr.utc.sr03.chat.dao.UserRepository_  

# Envoi de mail (gepuis Gmail)
Dans Gmail
- Compte Google > Securite
- Connexion à Google > Mot de passe des applications (il faut avoir activé la 2FA)  

Dans le pom.xml
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
```
Dans application.properties
```
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=<username_gmail>
spring.mail.password=<mot_de_passe_application_gmail>
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.connectiontimeout=5000
spring.mail.properties.mail.smtp.timeout=5000
spring.mail.properties.mail.smtp.writetimeout=5000
spring.mail.properties.mail.smtp.starttls.enable=true
```
Dans la classe java
```
import org.springframework.mail.javamail.JavaMailSender;
```
```
@Autowired
private JavaMailSender javaMailSender;
```
```
SimpleMailMessage msg = new SimpleMailMessage();
msg.setTo("destinataire@truc.fr");
msg.setSubject("Testing from Spring Boot");
msg.setText("Hello World \n Spring Boot Email");
javaMailSender.send(msg);
```
_=> voir la classe fr.utc.sr03.chat.snippets.SendMail_  

src :
> https://mkyong.com/spring-boot/spring-boot-how-to-send-email-via-smtp/

# Spring Security (CORS)
Dans le pom.xml :
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```
Creer une classe java qui etend WebSecurityConfigurerAdapter  
=> voir la classe fr.utc.sr03.chat.CustomSecurityConfiguration

# Websocket
Dans le pom.xml :
```
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-websocket</artifactId>
</dependency>
```
Creer une classe java de configuration  
=> voir la classe fr.utc.sr03.chat.websocket.WebSocketConfig

Creer une classe de java qui contient le serveur Websocket  
=> voir la classe fr.utc.sr03.chat.websocket.ChatServer

Client HTML / JS :  
=> voir les fichiers html et js dans src/main/resources/test_websocket

src :
> https://moodle.utc.fr/mod/folder/view.php?id=131205