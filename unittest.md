## 1. testParseJson

1. **Identify testable functions** : `parseJson`
2.
    - **Identify parameters** : `json(String)`
    - **return types** : `List`
    - **return values**: `List<Map<String,String>>`
    - **exceptional behavior** :``
3. **Model the input domain**(The characteristics developed for this test case using the techniques from Input Space Partitioning. You must create **at least** one interface-based characteristic and **at least** one functionality-based characteristic for each test case.)  
   Characteristics:

| Characteristics          | b1      | b2                |
|--------------------------|---------|-------------------|
| String is not empty      | True    | False             |
| String has key and value | no pair | at least one pair |
4. Combine partitions to define test requirements - use
   the 5 approaches to find combinations of values (ACoC, ECC, PWC, BCC, MBCC). You must apply the 5 approaches to your 10 unit test cases (thus each approach will be used in 2 unit test cases).  
   Approaches : ACoC  
   Test requirements :  2x2 = 4
   (no variable is assign, True) invalid, (no variable is assign, False), (at least one variable is assign, True) invalid, (at least one variable is assign, False)
5. Derive test values and expected values. These are the
   values that you have to use when you implement test cases in JUnit.

| Test | user                                     | Expected result            |
|------|------------------------------------------|----------------------------|
| T1   |                                          |                            |
| T2   | new User()                               | can't save to DB.          |
| T3   |                                          |                            |
| T4   | new User(); user.setUsername("john1234") | save user name John to DB. |



## 2.

1. **Identify testable functions** : ``
2.
   - **Identify parameters** : ``
   - **return types** : ``
   - **return values**: ``
   - **exceptional behavior** :``
3. **Model the input domain**(The characteristics developed for this test case using the techniques from Input Space Partitioning. You must create **at least** one interface-based characteristic and **at least** one functionality-based characteristic for each test case.)  
   Characteristics:

| Characteristics | b1  | b2  |
|-----------------|-----|-----|
|                 |     |     |
|                 |     |     |
4. Combine partitions to define test requirements - use
   the 5 approaches to find combinations of values (ACoC, ECC, PWC, BCC, MBCC). You must apply the 5 approaches to your 10 unit test cases (thus each approach will be used in 2 unit test cases).  
   Approaches : ACoC  
   Test requirements :  2x2 = 4
   (no variable is assign, True) invalid, (no variable is assign, False), (at least one variable is assign, True) invalid, (at least one variable is assign, False)
5. Derive test values and expected values. These are the
   values that you have to use when you implement test cases in JUnit.

| Test | user                                     | Expected result            |
|------|------------------------------------------|----------------------------|
| T1   |                                          |                            |
| T2   | new User()                               | can't save to DB.          |
| T3   |                                          |                            |
| T4   | new User(); user.setUsername("john1234") | save user name John to DB. |
