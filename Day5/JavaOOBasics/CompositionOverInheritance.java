class CanDoSomethingInheritance {
    public void canDoSomething() {
    }
}

class WantToDoThisTooInheritance extends CanDoSomethingInheritance {
}


interface CanDoSomething {
    void canDoSomething();
}

class CanDoSomethingComposition implements CanDoSomething {
    public void canDoSomething() {
    }
}

class WantToDoThisTooComposition implements CanDoSomething {
    private CanDoSomethingComposition canDoSomethingDelegate;

    public void canDoSomething() {
        canDoSomethingDelegate.canDoSomething();
    }
}
