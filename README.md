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

The first feature would be to provide methods that enable to :
* register a component and instantiate it from its class
* fetch the instantiated component from its class

### Step 3

Once you are able to register components, you need to be able to inject dependencies between them automatically.
Stay simple and focus only on injecting components without abstractions (in other words, declaration class and implementation class is the same).

### Step 4

Following step 3, make sure that the container throws an exception when a dependency component has not been registered.

### Step 5

Following step 3 and 4, allow to inject actual components that are implementations or sub-classes of the declared component.

### Step 6

In steps 3, 4 and 5, we provided a way to declare explicitly components with method calls.
We know want the container to discover injectable components that are marked with the @Component annotation, and automatically register them.

<details><summary>Spoiler alert : finding annotated classes</summary>
<p>

Finding all annotated classes at runtime can be a daunting task: you would have to, among other things, to:
* retrieve the classpath property
* scan the .class in each classpath element (that means for instance browsing .jar files as ZIP files)
* provide you own classloader implementation to load binary .class files into real classes
* for each one of the classes check if it is annotated

You would better use a framework dedicated to classpath scanning, such as Classgraph (https://github.com/classgraph/classgraph), it will save you lots of time.
</p>
</details>

### Step 7

Our dependency-injection container brings a major flaw: it tries to inject every field of its register components, preventing you to define non-injectable fields.

In order to fix this, the next feature will be to inject only dependencies that are marked with the @Inject annotation. Please note that this change may break previously written tests and you will to fix these, too.

### Step 8

Following step 8, throw an exception when a component for a dependency marked with @Inject cannot be found.

### Step 9 and further

You may provide the following features:
* provide a way to discriminate dependencies when there are multiple implementations
* injection is done only by field: enable injection by constructor or by setter