.PHONY: all
all:
	javac -d classes --module-source-path src $$(find src/ -name "*.java")

.PHONY: run
run:
	java --module-path classes --module checksum/com.nelkinda.training.java.modules.checksum.Main XOR

.PHONY: clean
clean::
	$(RM) -r classes/
