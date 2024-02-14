class Super {
    public Object getValue() {
        return new Object();
    }
}

class Sub extends Super {
    @Override
    public String getValue() {
        return "foo";
    }
}
