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

### Try

#### to request participants waiting the lottery
```
GET http://localhost:8080/lottery/participants
Accept: */*
Content-Type: application/json
```
#### to create new participant
```
POST http://localhost:8080/lottery/participants
Accept: */*
Content-Type: application/json

{
  "firstName": "Joe",
  "lastName": "Doe",
  "age": 100,
  "city": "Saint P",
  "externalId": "1cf3af52-6dca-4030-b605-da57c1c1d117"
}
```
#### to launch the lottery
```
POST http://localhost:8080/lottery/launches
Accept: */*
```
#### to request lottery winners
```
GET http://localhost:8080/lottery/winners
Accept: */*
Content-Type: application/json
```