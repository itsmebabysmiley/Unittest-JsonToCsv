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
   Approaches : PWC  
   Test requirements :  3x2 =6
   (True,UTF-8,No pair of element),(True,UTF-8,At least one pair of elements),(True,UTF-8,missing key or value)
   (False,UTF-8,No pair of element),(False,UTF-8,At least one pair of elements),(False,UTF-8,missing key or value)
5. Derive test values and expected values. These are the
   values that you have to use when you implement test cases in JUnit.

| Test | uri                                      | encoder | Expected result   |
|------|------------------------------------------|---------|-------------------|
| T1   |                                          |         |                   |
| T2   | http://echo.jsontest.com/name/Nopparat/? | UTF-8   | [{name=Nopparat}] |
| T3   | http://echo.jsontest.com/name/?          | UTF-8   | [{name=}]         |
| T4   | http://www.google.com                    | UTF-8   | Null              |
| T5   | http://www.facebook.com                  | UTF-8   | Null              |
| T6   | http://www.gmail.com                     | UTF-8   | Null              |

## 6. testParseJsonObject

1. **Identify testable functions** : `parse`
2.
   - **Identify parameters** : `jsonObject(JSONObject)`
   - **return types** : `Map`
   - **return values**: `Map<String, String>`
   - **exceptional behavior** :``
3. **Model the input domain**(The characteristics developed for this test case using the techniques from Input Space Partitioning. You must create **at least** one interface-based characteristic and **at least** one functionality-based characteristic for each test case.)  
   Characteristics:

| Characteristics             | b1               | b2                         | b3                      | 
|-----------------------------|------------------|----------------------------|-------------------------|
| jsonObject is null          | True             | False                      | -                       |
| key and value in jsonObject | no key and value | at least one key and value | key or value is missing |

4. Combine partitions to define test requirements - use
   the 5 approaches to find combinations of values (ACoC, ECC, PWC, BCC, MBCC). You must apply the 5 approaches to your 10 unit test cases (thus each approach will be used in 2 unit test cases).  
   Approaches : PWC  
   Test requirements :  3x2 = 6
   (True,no key and value),(True,at least one key and value),(True,key or value is missing)
(False,no key and value),(False,at least one key and value),(False,key or value is missing)
6. Derive test values and expected values. These are the
   values that you have to use when you implement test cases in JUnit.

| Test | jsonObject                                                                | Expected result |
|------|---------------------------------------------------------------------------|-----------------|
| T1   | JSONObject jsonObj = null                                                 | null            |
| T2   |                                                                           |                 |
| T3   |                                                                           |                 |
| T4   | JSONObject jsonObj = new JSONObject();                                    | [{}]            |
| T5   | JSONObject jsonObj = new JSONObject(); jsonObj.put("name","Nopparat");    |[{name=Nopparat}] |
| T6   |                                                                           |                 |

## 7. testParseJsonArray

1. **Identify testable functions** : `parse`
2.
   - **Identify parameters** : `jsonArray(JSONArray)`
   - **return types** : `List`
   - **return values**: `List<Map<String, String>>`
   - **exceptional behavior** :``
3. **Model the input domain**(The characteristics developed for this test case using the techniques from Input Space Partitioning. You must create **at least** one interface-based characteristic and **at least** one functionality-based characteristic for each test case.)  
   Characteristics:

| Characteristics            | b1               | b2                         | b3                      | 
|----------------------------|------------------|----------------------------|-------------------------|
| jsonArray is null          | True             | False                      | -                       |
| jsonArray size             | 0                | />0                        | -                       |
| key and value in jsonArray | no key and value | at least one key and value | key or value is missing |

4. Combine partitions to define test requirements - use
   the 5 approaches to find combinations of values (ACoC, ECC, PWC, BCC, MBCC). You must apply the 5 approaches to your 10 unit test cases (thus each approach will be used in 2 unit test cases).  
   Approaches : BCC  
   Test requirements :  1+[(2-1)+(2-1)+(3-1)] = 5  
   Base choice: (False,/>0,at lease one key and value)
   (True,/>0,at lease one key and value),(False,0,at lease one key and value),
   (False,/>0,no key and value),(False,/>0,key or value is missing)
5. Derive test values and expected values. These are the
   values that you have to use when you implement test cases in JUnit.

| Test | jsonObject            | Expected result   |
|------|-----------------------|-------------------|
| T1   | [{"name":"Nopparat"}] | [{name=Nopparat}] |
| T2   | null                  | null              |
| T3   |                       |                   |
| T4   | []                    | []                |
| T5   |                       |                   | 


## 8. testGetCSV

1. **Identify testable functions** : `getCSV`
2.
   - **Identify parameters** : `flastJson List<Map<String, String>>`
   - **return types** : `String`
   - **return values**: `String`
   - **exceptional behavior** :``
3. **Model the input domain**(The characteristics developed for this test case using the techniques from Input Space Partitioning. You must create **at least** one interface-based characteristic and **at least** one functionality-based characteristic for each test case.)  
   Characteristics:

| Characteristics                | b1               | b2                         | b3                      | 
|--------------------------------|------------------|----------------------------|-------------------------|
| flatJson is empty              | True             | False                      | -                       |
| flatJson contain key and value | no key and value | at least one key and value | key or value is missing |

4. Combine partitions to define test requirements - use
   the 5 approaches to find combinations of values (ACoC, ECC, PWC, BCC, MBCC). You must apply the 5 approaches to your 10 unit test cases (thus each approach will be used in 2 unit test cases).  
   Approaches : BCC  
   Test requirements :  1+[(2-1)+(3-1)] = 4  
   Base choice: (False,at least one key and value)
   (True,at least one key and value), (False,no key and value), (False,key or value is missing)
5. Derive test values and expected values. These are the
   values that you have to use when you implement test cases in JUnit.

| Test | jsonObject            | Expected result  |
|------|-----------------------|------------------|
| T1   | [{"name":"Nopparat"}] | name\nNopparat\n |
| T2   | null                  | null             |
| T3   |                       |                  |
| T4   | []                    | \n               |

## 9. testGetCSVWithSeparator

1. **Identify testable functions** : `getCSV`
2.
   - **Identify parameters** : `flastJson List<Map<String, String>>, separator(String)`
   - **return types** : `String`
   - **return values**: `String`
   - **exceptional behavior** :``
3. **Model the input domain**(The characteristics developed for this test case using the techniques from Input Space Partitioning. You must create **at least** one interface-based characteristic and **at least** one functionality-based characteristic for each test case.)  
   Characteristics:

| Characteristics                | b1               | b2                         | b3                      | b4         | 
|--------------------------------|------------------|----------------------------|-------------------------|------------|
| flatJson is empty              | True             | False                      | -                       | -          |
| separator is valid             | ,                | ;                          | \t                      | not , ; \y |
| flatJson contain key and value | no key and value | at least one key and value | key or value is missing |            |

4. Combine partitions to define test requirements - use
   the 5 approaches to find combinations of values (ACoC, ECC, PWC, BCC, MBCC). You must apply the 5 approaches to your 10 unit test cases (thus each approach will be used in 2 unit test cases).  
   Approaches : MBCC  
   Test requirements :  2 + [(2x(2-2))+(2x(4-2))+(2x(3-2))] = 8
   Base choice: (False,",",at least one key and value), (True,";",no key and value)
   (False,"\t",at least one key and value),(False,"not , ; \y",at least one key and value), (False,",",key or value is missing)
   (True,"\t",no key and value), (True,"not , ; \y",no key and value),(True,"not , ; \y",key or value is missing)
5. Derive test values and expected values. These are the
   values that you have to use when you implement test cases in JUnit.

| Test  | jsonObject            | separator | Expected result                   |
|-------|-----------------------|-----------|-----------------------------------|
| T1    | [{"name":"Nopparat"}] | ","       | name\nNopparat\n                  |
| T2    | []                    | ";"       |                                   |
| T3    | [{"name":"Nopparat"}] | "\t"      | name\nNopparat\n                  |     
| !!!T4 | [{"name":"Nopparat"}] | "-"       | Exception "-" is not fit for .csv |     
| T5    |                       |           |                                   |
| T6    | []                    | "\t"      |                                   |
| T7    | []                    | "="       |                                   |
| T8    |                       |           |                                   |


## 10. testWriteToFile

1. **Identify testable functions** : `writeToFile`
2.
   - **Identify parameters** : `csvString(String), fileName(String)`
   - **return types** : `void`
   - **return values**: ``
   - **exceptional behavior** :``
3. **Model the input domain**(The characteristics developed for this test case using the techniques from Input Space Partitioning. You must create **at least** one interface-based characteristic and **at least** one functionality-based characteristic for each test case.)  
   Characteristics:

| Characteristics                                           | b1               | b2                         | b3                      | b4         | 
|-----------------------------------------------------------|------------------|----------------------------|-------------------------|------------|
| csvString is empty                                        | True             | False                      | -                       | -          |
| filename is empty                                         | True             | False                      | -                       | -          |
| filename is exists                                        | True             | False                      | -                       | -          |
| csvString contain correct format according to .csv format | ,                | ;                          | \t                      | not , ; \y |

4. Combine partitions to define test requirements - use
   the 5 approaches to find combinations of values (ACoC, ECC, PWC, BCC, MBCC). You must apply the 5 approaches to your 10 unit test cases (thus each approach will be used in 2 unit test cases).  
   Approaches : MBCC  
   Test requirements :  2 + [(2x(2-2))+(2x(2-1))+(2x(2-1))+(2x(4-2))] = 10 
   Base choice: (False,False,False,","),(True,False,False,";")
   (False,True,False,","), (False,False,True,","), (False,False,False,"\t"),(False,False,False,"not , ; \y")
   (True,True,False,";"),(True,False,True,";"),(True,False,False,"\t"),(True,False,False,"not , ; \y")
   
5. Derive test values and expected values. These are the
   values that you have to use when you implement test cases in JUnit.

| Test  | csvString             | fileName | Expected result                   |
|-------|-----------------------|----------|-----------------------------------|
| T1    | "name\nNopparat\n"    | ","      | name\nNopparat\n                  |
| T2    | []                    | ";"      |                                   |
| T3    | [{"name":"Nopparat"}] | "\t"     | name\nNopparat\n                  |     
| !!!T4 | [{"name":"Nopparat"}] | "-"      | Exception "-" is not fit for .csv |     
| T5    |                       |          |                                   |
| !!!T6 | []                    | "\t"     |                                   |
| !!!T7 | []                    | "="      |                                   |
| T8    |                       |          |                                   |
| T9    |                       |          |                                   |
| T10   |                       |          |                                   |
