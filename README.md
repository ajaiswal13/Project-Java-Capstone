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

### Unit Testing:

What is Test Driven Development?
Quiz 2 - very imp asked in Microsoft etc
Flaky tests - Which important for MCQ (ex: intermittent responses)
Flaky test  mcq example answers: Anything containing INTERMITTENT keyword

Refer to notes.
In integration testing, we only check the integration part,rest all is ignored
In unit testing, we check all other parts except integration. Integration is mocked here.

FunctionalTests need mostly business/functional awareness than technical knowledge


### Testing Good Practices, Mocking, Types of Doubles:

Programming Languages use different sorting techniques internally to sort an array depending on various factors as
size of array, if the array is nearly sorted etc. (Google this)

Watch the video for 2 quiz (Asked in Microsoft and Goldman respectively)
1st quiz is around 1:00:00 timestamp
2nd quiz is at 2:05:00 timestamp

### Testing 3:

Watch from 1:05:00 to 1:07:00 timestamp
Very important from timestamp 2:07:00 till 2:12:30 - for last method of FakeStoreProductServiceTest

### Authentication - 1: Auth v/s Auth, Tokens, BCrypt:

Watch this video to understand how BCrypt works internally - still not that clear.Take ChatGPT's help

Token which is sent by user everytime it tries to do something is stored in Global cache
as these requests can be routed by Load Balancer to ANY server and it doesn't make sense to save this token in
Local database of servers.

What is the cost factor in bcrypt control? The number of iterations that have been done

What is Transport Layer Security? It makes the https connection secure
Why do we use L7 load balancer if it can be target of data breach?
L7 is used when we have to route on the basis of the logic mentioned in Load Balancer.

### Authentication - 2: JWT, OAuth 2:

Watch the video to know base64 encoding works internally or take ChatGPT's help - Might be asked in interview
 OAuth is applicable when we are logging using third party

What is symmetric and asymmetric encryption? What does WhatsApp use?
What are refresh tokens and how are they used alongside access tokens?
symmetric - same key is used to lock and unlock
asymmetric - public key is used to lock and private key is used to unlock

In case of Google, public key is used for verification and private key is used for signing

Login into multiple devices is controlled at API level.