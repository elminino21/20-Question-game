# 20-Question-game
## Application path for this project
1.  (feature)Ask if answer/question is correct

2.  (feature)Get correct answer/question from user, if wrong

    a.  Confirm correct answer from on a dictionary
    
    b.  Show user definition to confirm answer.
    
    c. show hightest rancked picture from google images on the subject
    
3.  ID each question and tie it to it answer(somehow), After considering a dozen of so implementation bit is the best option by far, that is if yes, count 1 if not 0. I could use this method to get an address location where the answer is, possibly(?), it could be use to get the next question.
4. Application needs two databases: one for question,and another for answers. For simplicity sake, the bit will be put on a bitset for  calculation when a question is needed, and when all questions have been answered.

    a. 1,048,576 is the number possible questions and answers for 20Q and 33554432 for 25Q 
    
    b. Based on the current acquitecture, all questions on the left size of the should be pair and the right should be unpair. That is due to the first degit being a 0(zero) or a 1(one) at the beging of the implementation. This should avoid collision when automaticalic writing data to the data table. 
    
    c. Junit testing needed for multiple path to test idea viability
    
5.	Get Ideas for questions somehow( read documents, play games online(yay), etc). 

6. (feature)For it to be future proof Create GUI implementation where if the path is not found the user can select a set of related questions, so that the user can find add an answers. 

    a. Giving the ability to add questions might be a possibility, but and SUDO version might be necessary to ensure questions are related, and accurate.  
