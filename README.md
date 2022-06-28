# The lottery
lottery spring boot app

### Prerequisites

* installed java. tested with

```
java 18.0.1.1 2022-04-22
Java(TM) SE Runtime Environment (build 18.0.1.1+2-6)
Java HotSpot(TM) 64-Bit Server VM (build 18.0.1.1+2-6, mixed mode, sharing)
```

### Run

```
> ./gradlew bootRun
```

### Try out
```
GET http://localhost:8080/lottery/participants
Accept: */*
Content-Type: application/json
```
```
POST http://localhost:8080/lottery/participants
Accept: */*
Content-Type: application/json

{
  "name": "Joe Doe",
  "age": 100,
  "city": "Saint P"
}
```
```
GET http://localhost:8080/lottery/start
Accept: */*
```
```
GET http://localhost:8080/lottery/winners
Accept: */*
Content-Type: application/json
```