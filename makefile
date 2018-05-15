SHELL:=/bin/bash
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	MlStringCheck.java

default: classes

classes: $(CLASSES:.java=.class)

test: MlStringCheck.class
	java MlStringCheck

clean:
	$(RM) *.class

check-release-params:
ifndef REL_DIR
	$(error REL_DIR is undefined)
endif

release: check-release-params
	@echo "releasing in: $(REL_DIR)"; \
    mkdir -p $(REL_DIR); \
    cp makefile $(REL_DIR); \
    cp MlStringCheck.java $(REL_DIR); \
    cp README.md $(REL_DIR);\
    tar -zcvf $(REL_DIR)/mlstrchk.tar.gz -C $(REL_DIR) .; \
    rm -rf $(REL_DIR)/makefile; \
    rm -rf $(REL_DIR)/MlStringCheck.java; \
    rm -rf $(REL_DIR)/README.md;
