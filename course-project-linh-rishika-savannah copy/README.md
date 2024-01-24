# Title: Bullet Journal Program

Info about your project goes here

Name of team members: Rishika Kundu, Savannah Haugen, Linh Dang

Project description: 
a. This is a journal program that helps you track your mood, hours of sleep, water intake, and task.
b. Technical guide: 
    i. Java 17 installed for Kilt-Graphics library. The java.util and java.awt are also needed. 
    ii. The source code consists of 4 widgets, which are all implementation of the BulletJournalWidget interface. The main class is BulletJournalProgram, which has all 4 widgets.
c. This program contains artwork from public sources, source codes take inspiration from homework, lab, and in-class activities with the help of COMP 127 professor and preceptors.

Known issues:
- The logic of the smaller widget is still running even when it's not the displayed widget (when we click on the canvas it's keep returning null even when the display widget doesn't have that function)
- In the sleep widget, when the user selects a box the previous boxes are not automatically filled. The user has to click on all eight boxes to fill up the bar, when it would be much easier for them to just select the furthest box that represents their hours of sleep. 
- The task widget list and position logic is not the best, newly added task doesn't appear on the top even when the old tasks are removed.
- onClick method is hard to implement in sleep widget and task widget. We don't know if this is the Kilt-Graphic problem or problem on our side.


Societal impact: 
- Although the main point of the program is to a helper application, it oversimplifies life, such as user only has a variety of mood to choose from. It doesn't color-blind friendly, doesn't have assistive sound for people with impaired eyesight.  
- Our program is not available on easy-access platform such as App Store or Google store. It only serves a very small, niche population who are familiar with VScode, Github platform.


