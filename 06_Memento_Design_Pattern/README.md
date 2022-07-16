Have you used undo feature in any application? If Yes, you have a similar experience to what the Memento design pattern does.  If you need to implement rollback/undo/revert functionality in your applications, learning this pattern will really help you to do the implementation. With Momento, you can save the state of an object to restore them (previous state) whenever needed. The memento design pattern is implemented with three pillars.
1.	Originator – originator is the object whose state needs to be saved and restored
2.	Momento – a private inner class which used by the originator to keep the state
3.	Caretaker – caretaker is responsible for keeping the state of the Originator and restoring it through the Memento object
The originator couple with memento and pass the state to the caretaker. Whenever you need to get the previous state, you need to call the caretaker, check the previous state, and move. Let’s take an example to implement the Memento design pattern.

You can find more information from https://medium.com/@yasunichamodya/6-memento-design-pattern-2054996038b4