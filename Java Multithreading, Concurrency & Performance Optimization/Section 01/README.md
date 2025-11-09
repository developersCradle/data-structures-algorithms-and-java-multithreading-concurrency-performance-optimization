# Chapter 01 - Introduction.

Introduction.

# What I learned.

<div align="center">
    <img src="javaMultiThreading.PNG"  alt="Java threads" width="500"/>
</div>

<div align="center">
    <img src="whatWeWillLearn.PNG"  alt="Java threads" width="500"/>
</div>

<div align="center">
    <img src="motivationWhyWeNeedThreads.PNG"  alt="Java threads" width="500"/>
</div>

1. Let's explain **Responsiveness**.

<div align="center">
    <img src="examplesOfPoorResponsiveness.PNG"  alt="Java threads" width="500"/>
</div>

1. Something does not respond soon. These are signs of poor **responsiveness**.

<div align="center">
    <img src="repsonsivenessWithASingleThread.PNG"  alt="Java threads" width="500"/>
</div>

1. If there is one user, with **HUGE** order, which makes the database query long, the second user `2.` needs to wait for the answer!

<div align="center">
    <img src="repsonsivenessWithMultipleThread.PNG"  alt="Java threads" width="500"/>
</div>

1. We can achieve multiple working, in their **own** thread.