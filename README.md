# EasyExam
This is an Easy graphical interfaced Exam creater which also allows students to take the exam and then automatically grades it

Description: 

    This application allows users to load an exam file that has been created priviously.
    Once an exam file is read, the user can modify, save, take, and grade the exam.

    Breakdown:
            1. ExamBuilder – Used by an instructor to create and modify exams.
            2. ExamTaker   – Used by students to take an exam and record their answers.
            3. ExamGrader  – Used by an instructor to evaluate students’ answers and determine scores.

**************************************************************************
How to run the program

Makefile:

        1. To run Exam Builder application:
                "make examB"
                "java ExamBuilder"

        2. To run Exam Taker application:
                "make ExamT"
                "java ExamTaker"

        3. To run Exam Grader application:
                "make examG"
                "java ExamGraderGui"

**************************************************************************
Exam text File Format:

    There are four different types of exam questions:
        MCSAQuestion: Multiple choice single answer
        MCMAQuestion: Multiple choice multiple answer
        NumQuestion:  Essay question with just a numerical answer
        SAQuestion:   Essay question

    This repository contains a sample exam text file (exam.txt) for reference

    Format:
        Exam title
        Date placeholder

        MCSAQuestion (Question type from above)
        Question total points
        Question text
        Number of multiple choice options
        Answer point Answer text

        MCMAQuestion
        Question total points
        Question text
        Base credit (the lowest amount of points)
        Number of multiple choice options
        Answer point Answer text
 

        NumQuestion (Question type from above)
        Question total points
        Question text
        Answer
        Threshold 

        SAQuestion (Question type from above)
        Question total points
        Question text
        Answer

*************************************************************************
