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

1. We can achieve multiple units working, in their **own** thread.

<div align="center">
    <img src="responsivenessOfTheUserFace.PNG"  alt="Java threads" width="500"/>
</div>

1. Once the **click** is happened, we would want to have action on the screen!
    - This can be achieved by using the **Multiple threads**.

<div align="center">
    <img src="concurrencyMultitasking.PNG"  alt="Java threads" width="500"/>
</div>

1. We can achieve this by using the **multiple threads**

<div align="center">
    <img src="concurrencyMultiTaskingInIllustration.PNG"  alt="Java threads" width="500"/>
</div>

1. We achieve this making task run next to each other.

<div align="center">
    <img src="concurrencyMultiTaskingInIllustrationWeCanAchieveUsingOneCore.PNG"  alt="Java threads" width="500"/>
</div>

1. Furthermore, we can **achieve** this even using with **one core**.

<div align="center">
    <img src="performanceMultipleCores.PNG"  alt="Java threads" width="500"/>
</div>

1. The performance is improved, with **multiple cores**!
2. We can achieve this **parallelism**, with multiple cores.

<div align="center">
    <img src="performanceImpact.PNG"  alt="Java threads" width="500"/>
</div>

<div align="center">
    <img src="weAreAchievingThisUsingMultipleThreads.PNG"  alt="Java threads" width="500"/>
</div>

<div align="center">
    <img src="multithreadingCaveat.PNG"  alt="Java threads" width="500"/>
</div>

1. **Multithreaded** programming is different than the **single threading**.

<div align="center">
    <img src="whatWeWillLearnNextStep.PNG"  alt="Java threads" width="500"/>
</div>

<div align="center">
    <img src="operatingSystemIsBeingLoadedFromTheHardDrive.PNG"  alt="Java threads" width="500"/>
</div>

1. Os is loaded from the hard disk to memory on the startup.

<div align="center">
    <img src="applicationAreLoadedFromTheHardDisk.PNG"  alt="Java threads" width="500"/>
</div>


1. The **OS** will take the program from the disk and makes instance to the memory. 

<div align="center">
    <img src="SingleThreadedApplicationProcess.PNG"  alt="Java threads" width="500"/>
</div>

1. The instance of the program, which is loaded from the **Hard Drive** is called **Process** or the **Context of the application**.
2. **Thread** contains the **Stack** and the **Instruction Pointer**.

<div align="center">
    <img src="whatThreadContains.PNG"  alt="Java threads" width="500"/>
</div>

1. Region in memory, where **local variables** are stored, and passed into functions.
2. Address of the **next instruction** to **execute**.

<div align="center">
    <img src="summary.PNG"  alt="Java threads" width="500"/>
</div>
