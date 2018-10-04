JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Answer.java \
	Question.java \
	Exam.java \
	MCAnswer.java \
	MCQuestion.java \
	MCSAQuestion.java \
	NumQuestion.java \
	NumAnswer.java \
	MCSAAnswer.java \
	MCMAAnswer.java \
	MCMAQuestion.java \
	SAQuestion.java \
	SAAnswer.java \
	ScannerFactory.java \
	ExamTakerGUI.java \
	ExamTaker.java \

default: classes

classes: $(CLASSES:.java=.class)

clean: 
	$(RM) *.class
