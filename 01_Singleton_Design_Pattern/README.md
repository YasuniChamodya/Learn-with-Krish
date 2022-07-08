Let's learn the most commonly used design pattern in the right way. What does Singleton mean? It means one instance per container. When it comes to Java, 1 instance per JVM. Before jumping to the implementation, I will explain some key points to keep in your mind that you may have misunderstood. If you implement the Singleton design pattern,

•	Only one instance of the class should exist in the JVM.

•	Even though you can take arguments and still give a single instance, do not take any argument when you create an instance.

•	Even though it is possible do not use Singleton everywhere except where it is really needed. Since there are no instance variables and there is no reference to create, it is hard to unit test.

Let’s go with an example to learn the Singleton design pattern. You can find the detailed explanation for this code from https://medium.com/@yasunichamodya/1-singleton-design-pattern-8e5954ff66a0 

 