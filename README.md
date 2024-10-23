### Hexlet tests and linter status:
[![Actions Status](https://github.com/ynb4gang/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/ynb4gang/java-project-71/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/63dc8a747cd19b0bc625/maintainability)](https://codeclimate.com/github/ynb4gang/java-project-71/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/63dc8a747cd19b0bc625/test_coverage)](https://codeclimate.com/github/ynb4gang/java-project-71/test_coverage)
# Data Comparison Tool

## Description
The project allows comparing data from JSON, YAML, and YML files.

## Usage
### Installation
1. Clone the repository:
git clone https://github.com/ynb4gang/java-project-71.git

2. Navigate to the project directory:
cd project_directory

3. Build the project:
./gradlew build

4. Run the application:
./build/install/app/bin/app -f <format> <file1> <file2>


### Example Commands
- Compare two JSON files in the stylish format:
```bash
./build/install/app/bin/app -f stylish filepath1.json filepath2.json
```
```plaintext
{
  - address: {city=New York, zipcode=10001}
  + address: {city=New York, zipcode=10002}
  - age: 30
  + age: 31
  + car: null
    name: John
  - pets: [{type=dog, name=Buddy}, {type=cat, name=Whiskers}]
  + pets: [{type=dog, name=Bobby}, {type=cat, name=Fluffy}]
}
```
- Compare two YML files in the plain format:
```bash
./build/install/app/bin/app -f plain filepath1.yml filepath2.yml
```
```plaintext
Property 'address' was updated. From [complex value] to [complex value]
Property 'age' was updated. From 30 to 31
Property 'car' was added with value: null
Property 'pets' was updated. From [complex value] to [complex value]
```
- Compare a JSON files in the JSON format:
```bash
./build/install/app/bin/app -f json filepath1.json filepath2.json
```
```plaintext
{
  "address" : {
    "oldValue" : {
      "city" : "New York",
      "zipcode" : "10001"
    },
    "newValue" : {
      "city" : "New York",
      "zipcode" : "10002"
    }
  },
  "age" : {
    "oldValue" : 30,
    "newValue" : 31
  },
  "car" : {
    "value" : null,
    "status" : "added"
  },
  "name" : {
    "value" : "John",
    "status" : "unchanged"
  },
  "pets" : {
    "oldValue" : [ {
      "type" : "dog",
      "name" : "Buddy"
    }, {
      "type" : "cat",
      "name" : "Whiskers"
    } ],
    "newValue" : [ {
      "type" : "dog",
      "name" : "Bobby"
    }, {
      "type" : "cat",
      "name" : "Fluffy"
    } ]
  }
}
```
