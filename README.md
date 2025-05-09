### Very important lecture for JPA,ORM,JDBC basics etc:

Repositories, UUIDs, Representing Inheritance

JDBC connector - Goes to database and executes the JDBC query
Earlier companies were using JDBC for database connection.
Nowadays companies use Spring JPA
Hibernate is an ORM and it internally uses JDBC

Spring Data JPA is an interface and it can be used to switch between different ORMs like
Hibernate, Joog etc

Queries might not be optimal i.e indexes etc will not be considered by ORMs

# JPA Queries, Cardinality Mappings:
Go to the inheritance in DB section of this class - Very imp
If we need to update only 1 or 2 column, use patch
IF we need to update a lot of variables use put
