Java Spring Boot Basic - 1

First, developing the app using only the 'core' Spring Framework and build on using only the 'pure' Java code for pure understanding of how Java Spring Boot Framework works.

--2022--

--July 1st -- 
build simple app - member & Order

-- July 2nd --
To get DIP principle, created AppConfig for DI(Dependency Injection)

-- July 3rd --
**Refactor AppConfig**: divide interface and implementation. This makes service depend on 'interface' of Repositories (DIP principle).
This will make changing easier!
App Config is an IoC (Inversion of Control) container OR DI (Dependency Injection) Container.
--
Conversion to Spring Framework

-- July 10th --
Registered Bean Searches - by name and type

-- July 13th --
Registered Bean Searches for same types

--July 16th --
Search Parent-Child Beans. Once Search registered Parent Bean, Child Beans are also searched. Java Beans are all Object Type

-- July 17th -- 
Spring's BeanDefinition's abstractions allows various system forms
Register Bean using XML - originally, registered bean in AppConfig

Making Beans has two methods - directly, or through factory Bean method (ex: appConfig). Usually factory Bean method is used.

-- July 18th -- 
problem with DI container: always makes new object whenever request is called - not appropriate for massive traffic.
Solution: make the object to be created only once & then shared

SINGLE TON PATTERN: this guarantees only one object will be created per server