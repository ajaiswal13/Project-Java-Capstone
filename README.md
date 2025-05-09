### Very important lecture for JPA,ORM,JDBC basics etc:

Repositories, UUIDs, Representing Inheritance

JDBC connector - Goes to database and executes the JDBC query
Earlier companies were using JDBC for database connection.
Nowadays companies use Spring JPA
Hibernate is an ORM and it internally uses JDBC

Spring Data JPA is an interface and it can be used to switch between different ORMs like
Hibernate, Joog etc

Queries might not be optimal i.e indexes etc will not be considered by ORMs

### JPA Queries, Cardinality Mappings:
Go to the inheritance in DB section of this class - Very imp
If we need to update only 1 or 2 column, use patch
IF we need to update a lot of variables use put

### Query Methods, Fetch Type, Mode, Schema Versioning:

How to know your code support which databases?
Go to External Libraries, go to org.hibernate folder, go inside dialect folder

Refer to the notes.

If we want a dynamic fetch type, we have to override the fetch interface and during the runtime take the
input from user to switch between lazy and eager.

Fetch type and fetch modes are different.
We installed JPA Buddy plugin

