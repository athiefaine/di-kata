# Dependency Injection kata

### Step 1

Run the provided testcase.

You will soon notice that the test in PersonServiceTest fails. Can you explain why ? How would you fix it ?


<details><summary>Spoiler alert</summary>
<p>
Initialization of PersonRepository dependency is hardcoded in PersonService constructor.
This is a violation of the Dependency Inversion Principle (see https://en.wikipedia.org/wiki/SOLID).

The initialization of the dependency in PersonService should be performed from outside the PersonService class.
</p>
</details>
