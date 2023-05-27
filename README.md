# ⚡ HELP.md ⚡

## Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.6/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.6/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#web)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

# ⚡ NOTES.md ⚡
![newbcoder_f5](https://dl.dropbox.com/s/47tnyr3wd6bhprb/newbcoder_f5x32.png) ***newbcoder_f5***

## Spring Boot Flow Diagram
![spring-boot flow diagram](https://dl.dropbox.com/s/qz3nmn1j2je1ibz/spring-boot%20flow%20diagram.png)

### ![intellij logo](https://dl.dropbox.com/s/4v43j6xgsd7638t/IntelliJ_IDEA_iconx32.png) IntelliJ IDEA shortcuts
💡 see all methods in IntelliJ ⏩ ***Ctrl+F12***</br>
💡 see all files and search among them in IntelliJ ⏩ ***Ctrl+Shift+N***</br>
💡 import unimplemented methods in IntelliJ ⏩ ***Ctrl+I***


### Timestamp 16:30
all right, so now we have created the java class so in order to convert this class into a controller we are going to add a single annotation which is the ***@Controller*** annotation

### Timestamp 18:20
inorder to map the handler method to the request uri we are going to use ***@RequestMapping*** annotation

### Timestamp 20:46
inorder to return http response from the handler method we are going to use ***@ResponseBody*** annotation

### Timestamp 23:20
instead of using the ***@Controller*** annotation we can use ***@RestController*** annotation which is a combination of ***@Controller + @ResponseBody*** annotation

### Timestamp 25:00
we can use ***@GetMapping*** annotation instead of ***@RequestMapping(value, method)*** annotation

### Timestamp 26:30
adding more dependencies

### Timestamp 27:25
by adding the **Spring Boot Dev Tools** dependency we don't need to stop the server and restart the project, it'll automatically detect changes and restart the server/project

### Timestamp 30:10
how to pass data from client to server

### Timestamp 30:30
anything we want to send from client to server can be done by using 2 ways:
1. Path Variable
2. Request Param

### Timestamp 40:16
if the parameter name in **Path Variable** method or **Request Param** method is same as the variable name in the handler method then no need to method the **Path Variable** or **Request Param**

### Timestamp 49:10
for the next video - **Http Put** and **Http Post** methods

### Timestamp 50:40
generate setters and getters using **Lombok**'s ***@Setter***, ***@Getter*** and ***@ToString*** annotation

### Timestamp 1:06:45
default values can be provided in ***@Value***:</br>
example:
```java
@Value("${app.name: Employee Tracker}")
private String appName;
```

### Timestamp 1:08:00
the port number can be changed using properties file, the property being ***server.port***=<new_port></br>
![port changed to 9090](https://dl.dropbox.com/s/azkcvmzh00cipvr/port%20changed%20to%209090.png)

### Timestamp 1:16:12
for hiding certain properties from response ***@JsonIgnore*** from **Jackson API** can be used

### Timestamp 1:16:38
anytime we want to give another name to the variable for response we can use ***@JsonProperty*** from **Jackson API**

### Timestamp 1:22:24
we can use ***@Autowired*** annotation so that respective class will be injected and Spring Container will automatically create an object of this class

### Timestamp 1:24:44
request URI (base path) mapping can also be done at the class level using ***@RequestMapping*** annotation at the class level where uri is given as parameter and whole url will be ***domain url*** + ***class level uri*** + ***handler method uri***

### Timestamp 1:26:44
request URI (base path) can also be added using **application.properties** file using the property ***server.servlet.context-path***=<base_uri>

### Timestamp 1:38:00
in order to turn a class into entity use ***@Entity*** annotation

### Timestamp 1:46:30
JpaRepository<'***entityClass***', '***dataType of PrimaryKey***'> and use ***@Repository*** annotation for repositories

### Timestamp 2:00:50
***Optional&lt;T&gt;*** means that either it'll be there or not, so for queries we use optional as result may or may not come

### Timestamp 2:18:02
use ***@CreationTimestamp*** and ***@UpdateTimestamp*** annotations for automatically record/updating values for when a record is created and/or updated

### Timestamp 2:23:40
***@Column*** annotation is not a mandatory annotation, if the variable name is same as the column name then this annotation can be ignored

### Timestamp 2:28:02
use ***@NotNull*** annotation when a field should not be null in api request, custom messages can be given using *message* also ***@Email*** annotation can be used to validate email for proper format

### Timestamp 2:35:08
creating a global exception handler class to handle all the exceptions and for that ***handleMethodArgumentNotValid()*** function needs to be overridden

### Timestamp 2:44:46
***@NotEmpty*** annotation checks for both null and empty values

### Timestamp 2:47:16
***@NotBlank*** annotation checks for null, empty values and also blank values (basically it trims and checks for null or empty values)

**@NotNull** > **@NotEmpty** > **@NotBlank**

https://stackoverflow.com/questions/17137307/in-hibernate-validator-4-1-what-is-the-difference-between-notnull-notempty

### Timestamp 3:00:26
whenever we want to create a finder method or query method, it should start with **findBy** keyword followed by the
column name, and it should not be the database column name, instead we have to  use entity class field name as it is mapped with database column name

### Timestamp 3:16:20
the difference between *Containing* and *Like* keyword in JPA is that when using *Containing* we can directly
give the keyword whereas in *Like* we have to wrap the keyword into ***%*** symbol e.g.: ***...Containing("ram");*** & ***Like("%ram%");***

therefore suggested to use ***Containing*** instead of ***Like***

### Timestamp 3:22:18
***PagingAndSortingRepository*** brings pagination and sorting out of the box 📦.

🌟 but everything is included in ***JpaRepository***

### Timestamp 3:31:04
we will use **Sort** class for sorting the data, the two ways of using *Sort* is displayed in code:</br>
***getEmployees(int pageNumber, int pageSize)*** in *EmployeeServiceImplementation.java* and ***findByNameContaining(String keyword, Sort sort)*** in *EmployeeRepository.java*

### Timestamp 3:40:00
when using custom *JPQL* queries we have to use ***@Query*** annotation

### Timestamp 3:41:32
variable name in query should be same as parameter name of the function, if not then parameter name should be preceded with ***@Param(***<span style="color:royalblue">"variable name in query"</span>***)***

### Timestamp 3:49:02
when writing ***DELETE*** query the return type should be either *void* or *int*, basically it will return the number of
records it has affected, for example:</br>
if the delete query deletes 2 records then it return 2

### Timestamp 3:54:44
whenever we are writing JPQL queries, that is modifying queries (create update delete), we should annotate with
***@Modifying*** annotation and also ***@Transactional*** annotation from *org.springframework.* and not *javax.transaction*

### Timestamp 4:16:56
since we have created a '*parameterized constructor*' in Employee.java, therefore we have to create a *no argument constructor* which can be done using lombok ***NoArgsConstructor*** annotation

### Timestamp 4:18:14
the property **spring.jpa.show-sql=true** shows the query run in the backend, in the console
