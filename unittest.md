## 1. testParseStringJson

1. **Identify testable functions** : `parseJson`
2.
    - **Identify parameters** : `json(String)`
    - **return types** : `List`
    - **return values**: `List<Map<String,String>>`
    - **exceptional behavior** :``
3. **Model the input domain**(The characteristics developed for this test case using the techniques from Input Space Partitioning. You must create **at least** one interface-based characteristic and **at least** one functionality-based characteristic for each test case.)  
   Characteristics:

| Characteristics          | b1                     | b2                               | b3                    |
|--------------------------|------------------------|----------------------------------|-----------------------|
| String is empty          | True                   | False                            | -                     |
| String has key and value | no pair(key and value) | at least one pair(key and value) | has only key or value |
4. Combine partitions to define test requirements - use
   the 5 approaches to find combinations of values (ACoC, ECC, PWC, BCC, MBCC). 
You must apply the 5 approaches to your 10 unit test cases (thus each approach 
will be used in 2 unit test cases).  
   Approaches : ACoC  
   Test requirements :  2x3 = 6
   (True,No pair), (True, at least one pair),(True, has only key or value), 
(False, No pair), (False, at least one pair),(False, has only key or value),
5. Derive test values and expected values. These are the
   values that you have to use when you implement test cases in JUnit.

| Test | json                    | Expected result   |
|------|-------------------------|-------------------|
| T1   |                         |                   |
| T2   |                         |                   |
| T3   |                         |                   |
| T4   | "{}"                    | [{}]              |
| T5   | "{"name" : "Nopparat"}" | [{name=Nopparat}] |
| T6   | "{"Nopparat"}"          | null              |



## 2. testParseFileJson

1. **Identify testable functions** : `parseJson`
2.
   - **Identify parameters** : `file(File)`
   - **return types** : `List`
   - **return values**: `List<Map<String, String>>`
   - **exceptional behavior** :``
3. **Model the input domain**(The characteristics developed for this test case using the techniques from Input Space Partitioning. You must create **at least** one interface-based characteristic and **at least** one functionality-based characteristic for each test case.)  
   Characteristics:

| Characteristics            | b1                 | b2                            |
|----------------------------|--------------------|-------------------------------|
| file is valid              | True(json file)    | False(not json file)          |
| Elements in file are valid | no pair of element | at least one pair of elements |
4. Combine partitions to define test requirements - use
   the 5 approaches to find combinations of values (ACoC, ECC, PWC, BCC, MBCC). You must apply the 5 approaches to your 10 unit test cases (thus each approach will be used in 2 unit test cases).  
   Approaches : ACoC  
   Test requirements :  2x2 = 4
   (True, No pair of element), (True,at least one pair of elements)
   (False, No pair of element), (False,at least one pair of elements)
5. Derive test values and expected values. These are the
   values that you have to use when you implement test cases in JUnit.

| Test | file                            | Expected result   |
|------|---------------------------------|-------------------|
| T1   | files/testParseFileJson_t1.json | [{}]              |
| T2   | files/testParseFileJson_t2.json | [{name=Nopparat}] |
| T3   |                                 |                   |
| T4   |                                 |                   |


## 3. testParseFileJsonWithEncoding

1. **Identify testable functions** : `parseJson`
2.
   - **Identify parameters** : `file(File), encoding(String)`
   - **return types** : `List`
   - **return values**: `List<Map<String, String>>`
   - **exceptional behavior** :``
3. **Model the input domain**(The characteristics developed for this test case using the techniques from Input Space Partitioning. You must create **at least** one interface-based characteristic and **at least** one functionality-based characteristic for each test case.)  
   Characteristics:

| Characteristics            | b1                 | b2                            |
|----------------------------|--------------------|-------------------------------|
| file is valid              | True(json file)    | False(not json file)          |
| encoder type support file  | UTF-X              | -                             |
| Elements in file are valid | no pair of element | at least one pair of elements |

4. Combine partitions to define test requirements - use
   the 5 approaches to find combinations of values (ACoC, ECC, PWC, BCC, MBCC). You must apply the 5 approaches to your 10 unit test cases (thus each approach will be used in 2 unit test cases).  
   Approaches : ECC  
   Test requirements :  2
   (True,UTF-8,at least one pair of elements), (False, UTF-8, no pair of element)
5. Derive test values and expected values. These are the
   values that you have to use when you implement test cases in JUnit.

| Test | file                                       | encoding | Expected result   |
|------|--------------------------------------------|----------|-------------------|
| T1   | files/testParseFileJsonWithEncoder_t1.json | UTF-8    | [{name=Nopparat}] |
| T2   | files/testParseFileJsonWithEncoder_t2.txt  | UTF-8    | null              |

## 4. testParseURIJson

1. **Identify testable functions** : `parseJson`
2.
   - **Identify parameters** : `uri(URI)`
   - **return types** : `List`
   - **return values**: `List<Map<String, String>>`
   - **exceptional behavior** :``
3. **Model the input domain**(The characteristics developed for this test case using the techniques from Input Space Partitioning. You must create **at least** one interface-based characteristic and **at least** one functionality-based characteristic for each test case.)  
   Characteristics:

| Characteristics | b1                 | b2                            | b3                   | b4  |
|-----------------|--------------------|-------------------------------|----------------------|-----|
| uri is valid    | True               | False                         | -                    | -   |
| Elements in uri | no pair of element | at least one pair of elements | missing key or value | -   |

4. Combine partitions to define test requirements - use
   the 5 approaches to find combinations of values (ACoC, ECC, PWC, BCC, MBCC). You must apply the 5 approaches to your 10 unit test cases (thus each approach will be used in 2 unit test cases).  
   Approaches : ECC  
   Test requirements :  3
   (False, no pair of element), (True, at least one pair of elements), (True, missing key or value)
5. Derive test values and expected values. These are the
   values that you have to use when you implement test cases in JUnit.

| Test | file                                     | Expected result   |
|------|------------------------------------------|-------------------|
| T1   | http://www.google.com                    | null              |
| T2   | http://echo.jsontest.com/name/Nopparat/? | [{name=Nopparat}] |
| T3   | http://echo.jsontest.com/                | null              |


## 5. testParseURIJsonWithEncoder

1. **Identify testable functions** : `parseJson`
2.
   - **Identify parameters** : `uri(URI), encoding(String)`
   - **return types** : `List`
   - **return values**: `List<Map<String, String>>`
   - **exceptional behavior** :``
3. **Model the input domain**(The characteristics developed for this test case using the techniques from Input Space Partitioning. You must create **at least** one interface-based characteristic and **at least** one functionality-based characteristic for each test case.)  
   Characteristics:

| Characteristics | b1                 | b2                            | b3                   | b4  |
|-----------------|--------------------|-------------------------------|----------------------|-----|
| uri is valid    | True               | False                         | -                    | -   |
| encoder type support file  | UTF-X              | -                             |
| Elements in uri | no pair of element | at least one pair of elements | missing key or value | -   |

4. Combine partitions to define test requirements - use
   the 5 approaches to find combinations of values (ACoC, ECC, PWC, BCC, MBCC). You must apply the 5 approaches to your 10 unit test cases (thus each approach will be used in 2 unit test cases).  
   Approaches : ECC  
   Test requirements :  3
   (False, UTF-8, no pair of element), (True, UTF-8, at least one pair of elements), 
(True, UTF-8, missing key or value)
5. Derive test values and expected values. These are the
   values that you have to use when you implement test cases in JUnit.

| Test | file                                     | encoder | Expected result   |
|------|------------------------------------------|---------|-------------------|
| T1   | http://www.google.com                    | UTF-8   | null              |
| T2   | http://echo.jsontest.com/name/Nopparat/? | UTF-8   | [{name=Nopparat}] |
| T3   | http://echo.jsontest.com/                | UTF-8   | null              |