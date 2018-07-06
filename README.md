# Apache-Ranger Client

This project is a Java library for communicating with Apache Ranger API. Please refer [docs](https://cwiki.apache.org/confluence/display/RANGER/Index) for more details.

## Repo
```
<repository>
    <id>clojars</id>
    <name>Clojars repository</name>
    <url>https://clojars.org/repo</url>
</repository>
```
## Dependency

- Maven
```
<dependency>
  <groupId>com.sumannewton</groupId>
  <artifactId>apache-ranger-client</artifactId>
  <version>1.0</version>
</dependency>
```
- Leiningen
```
[com.sumannewton/apache-ranger-client "1.0"]
```
- Clojure CLI/deps.edn
```
com.sumannewton/apache-ranger-client {:mvn/version "1.0"}
```
- Gradle
```
compile 'com.sumannewton:apache-ranger-client:1.0'
```
Please look at [releases](https://github.com/sumannewton/apache-ranger-client/releases) page for more versions.

## Usage

### Initialization

The following piece of code initializes the client.

```
public static final String RANGER_URL = "http://localhost:6080";

final RangerClientConfig rangerClientConfig = RangerClientConfig.builder()
                .connectTimeoutMillis(1000)
                .readTimeoutMillis(1000)
                .logLevel(Logger.Level.BASIC)
                .authConfig(RangerAuthConfig.builder()
                        .username("admin")
                        .password("admin")
                        .build())
                .url(RANGER_URL)
                .build();

RangerClient rangerClient = new RangerClient(rangerClientConfig);
```

### Start client
```
rangerClient.start();
```

### Create/Update/Get/Search Users

```
rangerClient.getUsers().createUser(User.builder().build());
rangerClient.getUsers().getUserByName("user");
rangerClient.getUsers().setUserVisibility(Maps.newHashMap());
rangerClient.getUsers().searchUsers("userSearch");
```

### Create/Update/Get/Search Services

```
rangerClient.getServices().createService(Service.builder().build());
rangerClient.getServices().getServiceByName("service");
rangerClient.getServices().updateService("service", Service.builder().build());
rangerClient.getServices().searchServices("serviceSearch");
```

### Create/Update/Get/Search Policies

```
rangerClient.getPolicies().createPolicy(Policy.builder().build());
rangerClient.getPolicies().getPolicyByName("service", "policy");
rangerClient.getPolicies().updatePolicy(1, Policy.builder().build());
rangerClient.getPolicies().getAllPoliciesByService("service");
rangerClient.getPolicies().searchPolicies("service", "policySearch");
```

## Build Instructions

This project is built using [Apache Maven](http://maven.apache.org/).

Run the following command from the root of repository, to build the client JAR:
- Clone the source:
$ git clone https://github.com/sumannewton/apache-ranger-client.git
- Build
$ mvn clean install

## Bugs

Bugs can be reported using Github issues.
