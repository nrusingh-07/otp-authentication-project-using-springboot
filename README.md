# OTP-Based Authentication System (Spring Boot)

A complete **Signup → Login → Email OTP → Verify OTP** authentication system built using **Spring Boot**, **MySQL**, and **JavaMailSender**, with a clean and modern UI styled using external CSS.

This project demonstrates secure authentication using OTP verification and follows proper Spring Boot MVC architecture.

---

##  Features

- User Signup
- User Login with Username & Password
- OTP Generation on Login
- OTP sent via Email (SMTP)
- OTP Verification using HttpSession
- Invalid Signup & Login handling
- Session-based authentication flow
- Clean UI with external CSS
- Secure POST-based form submission

---

## 🛠️ Tech Stack

- **Backend:** Java, Spring Boot (MVC)
- **Database:** MySQL
- **ORM:** Spring Data JPA (Hibernate)
- **Email Service:** JavaMailSender (SMTP)
- **Frontend:** HTML5, CSS3
- **Build Tool:** Maven
- **Server:** Embedded Tomcat

---

##  Project Structure

src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── app/
│   │               ├── controller/
│   │               │   └── UserController.java
│   │               ├── service/
│   │               │   └── UserService.java
│   │               ├── repository/
│   │               │   └── UserRepo.java
│   │               └── entities/
│   │                   └── User.java
│   └── resources/
│       ├── templates/
│       │   ├── SignUp.html
│       │   ├── login.html
│       │   ├── verify.html
│       │   ├── invalidsignUp.html
│       │   ├── loginfail.html
│       │   ├── success.html
│       │   └── otp-fail.html
│       ├── static/
│       │   └── css/
│       │       └── style.css
│       └── application.properties


---

##  Configuration

###  `application.properties`

```properties
spring.application.name=otp-auth
server.port=9090

spring.datasource.url=jdbc:mysql://localhost:3306/otp_auth
spring.datasource.username=root
spring.datasource.password=YOUR_DB_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

# Email Configuration
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=YOUR_EMAIL@gmail.com
spring.mail.password=YOUR_GOOGLE_APP_PASSWORD
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```
## Application Flow

``User opens Signup Page``

- Submits signup form → User saved in database
- Redirects to Login Page
On login:
-  Credentials validated
- OTP generated
- OTP sent to registered email
- User enters OTP on Verify Page
- TP verified using HttpSession
- Login success or failure page shown

## OTP Logic (Backend)

- OTP is generated using Random
- OTP is stored temporarily in HttpSession

- OTP is sent via email
- User-entered OTP is verified against session OTP
- OTP is cleared after successful verification

# How to Run the Project

- Clone the repository:
```git clone https://github.com/your-username/otp-auth-project.git```

- Import the project into Eclipse / IntelliJ

- Create MySQL database:
 ```CREATE DATABASE otp_auth;```

- Update database & email credentials in application.properties

# Run the application:
``` mvn spring-boot:run```

# Open browser:
```http://localhost:9090/user/api/signup```

# UI Styling
- External CSS used for all pages

- Location
- src/main/resources/static/css/style.css
- Linked in HTML using:
```<link rel="stylesheet" href="/css/style.css```
# Future Enhancements

- OTP expiry (time-based)
- Resend OTP feature
- Password encryption (BCrypt)
- Role-based authorization
- REST API version
- Frontend using React or Thymeleaf
# Author
Nrusingh
