.PHONY: all
all: doc test

.PHONY: doc
doc: | html
	javadoc -d html *.java

.PHONY: test
test: compile
	java TestFramework FactorialTest FibonacciTest

.PHONY: compile
compile:
	javac *.java

html:
	mkdir $@

.PHONY: clean
clean::
	$(RM) -r html/
