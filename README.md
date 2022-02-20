# human-id-java

a lightweight human id generator written in java without any dependencies

## How-To Use
   
```xml
<!--Add Dependency to your pom.xml-->
<dependency>
    <groupId>com.github.jorekai</groupId>
    <artifactId>human-id-java</artifactId>
    <version>1.0.0</version>
</dependency>
```
```java
// Build any Instance of the HumanId Generator
HumanId generator = HumanId.builder().build();
HumanId generatorWithProperties = HumanId.builder()
        .separator(HumanIdSeparator.DASH)
        .limit(100)
        .build();
// Choose any strategy to generate the Ids
String humanId = generator.generate(HumanIdStrategy.EXHAUSTIVE);
String humanId = generator.generate(HumanIdStrategy.NUMBERED, HumanIdSeparator.DASH);
```


### General Constraints

- adjectives: 131
- animals: 102
- verbs: 100
- numbers (postfix): 1000

- possibilities: 131 * 102 * 100 * 1000 = 1.336.200.000

### Exhaustive Constraints

- adjectives: 131
- animals: 102
- verbs: 100
- _numbers (prefix(exhaustive))_: 1000
- numbers (postfix): 1000
- _possibilities(exhaustive)_: 1000 * 131 * 102 * 100 * 1000 = 1.3e+12
