.PHONY: all
all:
	javac -d classes -sourcepath src $$(find src/ -name "*.java")

.PHONY: run
run:
	java -cp classes com.nelkinda.training.java.hello.Hello

.PHONY: clean
clean::
	$(RM) -r classes/
