# EasyExam
This is an simple GUI-based exam creater which also allows instructors to make/grade and students to take an exam.

Description: 

    This application allows users to load/create an exam file.
    Once an exam file is read, the user can modify, save, take, and grade the exam.

    Division:
            1. ExamBuilder – Used by instructors to create exams.
            2. ExamTaker   – Used by students to take exams.
            3. ExamGrader  – Used by instructors to grade exams.

**************************************************************************
How to run

Makefile:

        1. To run Exam Builder application:
                "make"
                "java ExamBuilderGUI"

        2. To run Exam Taker application:
                "make"
                "java ExamTakerGUI"

        3. To run Exam Grader application:
                "make"
                "java ExamGraderGUI"

**************************************************************************
Exam Format:

    Types of exam questions:
        MCSAQuestion: Multiple choice single answer
        MCMAQuestion: Multiple choice multiple answer
        NumQuestion:  Short answer with numerical answer
        SAQuestion:   Short question

    A sample exam text file (se.txt) in included for reference

se.txt Format:

        Exam title
        Date 

        MCMAQuestion
        Question total points
        Question text
        Base credit (the lowest amount of points)
        Number of multiple choice options
        Answer point Answer text
        
        MCSAQuestion 
        Question total points
        Question text
        Number of multiple choice options
        Answer point Answer text
        
        *Not included in se.txt*
        NumQuestion 
        Question total points
        Question text
        Answer
        Threshold 

        SAQuestion 
        Question total points
        Question text
        Answer

*************************************************************************
