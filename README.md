# Dependency Injection kata

### Step 1

Run the provided testcase.

You will soon notice that the test in PersonServiceTest fails. Can you explain why ? How would you fix it ?


<details><summary>Spoiler alert : about the test failure</summary>
<p>

Initialization of PersonRepository dependency is hardcoded in PersonService constructor.
This is a violation of the Dependency Inversion Principle (see https://en.wikipedia.org/wiki/SOLID).

The initialization of the dependency in PersonService should be performed from outside the PersonService class.
</p>
</details>

### Step 2

<details><summary>Spoiler alert : step 1 retrospective</summary>
<p>

Fixing step 1, you probably ended setting the dependency from PersonService to PersonRepository inside the test method.
Thus, you had the opportunity to provide a test double (aka a mock) for PersonRepository, freeing yourself from the thrown Exception.

</p>
</details>

Your goal is to provide a tiny Dependency-Injection container, and to implement it in a TDD manner.
This container would provide the following services:
* register components
* fetch components on demand given their class
* automatically inject dependencies between components

The first feature would be to enable to :
* register a component and instantiate it from its class
* fetch the instantiated component from its class

### Step 3

Once you are able to register components, you need to be able to inject dependencies between them automatically.
Stay simple and focus only on injecting components without abstractins (in other words, declaration class and implementation class is the same).