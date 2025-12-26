# Chapter 01 - Introduction.

Introduction.

# What I learned.

# Motivation & Operating Systems fundamentals - Part 1.

<div align="center">
    <img src="javaMultiThreading.PNG"  alt="Java threads." width="500"/>
</div>

<div align="center">
    <img src="whatWeWillLearn.PNG"  alt="Java threads." width="500"/>
</div>

<div align="center">
    <img src="motivationWhyWeNeedThreads.PNG"  alt="Java threads." width="500"/>
</div>

1. Let's explain **Responsiveness**.

<div align="center">
    <img src="examplesOfPoorResponsiveness.PNG"  alt="Java threads." width="500"/>
</div>

1. Something does not respond soon. These are signs of poor **responsiveness**.

<div align="center">
    <img src="repsonsivenessWithASingleThread.PNG"  alt="Java threads." width="500"/>
</div>

1. If there is one user, with **HUGE** order, which makes the database query long, the second user `2.` needs to wait for the answer!

<div align="center">
    <img src="repsonsivenessWithMultipleThread.PNG"  alt="Java threads." width="500"/>
</div>

1. We can achieve multiple units working, in their **own** thread.

<div align="center">
    <img src="responsivenessOfTheUserFace.PNG"  alt="Java threads." width="500"/>
</div>

1. Once the **click** is happened, we would want to have action on the screen!
    - This can be achieved by using the **Multiple threads**.

<div align="center">
    <img src="concurrencyMultitasking.PNG"  alt="Java threads." width="500"/>
</div>

1. We can achieve this by using the **multiple threads**

<div align="center">
    <img src="concurrencyMultiTaskingInIllustration.PNG"  alt="Java threads." width="500"/>
</div>

1. We achieve this making task run next to each other.

<div align="center">
    <img src="concurrencyMultiTaskingInIllustrationWeCanAchieveUsingOneCore.PNG"  alt="Java threads." width="500"/>
</div>

1. Furthermore, we can **achieve** this even using with **one core**.

<div align="center">
    <img src="performanceMultipleCores.PNG"  alt="Java threads." width="500"/>
</div>

1. The performance is improved, with **multiple cores**!
2. We can achieve this **parallelism**, with multiple cores.

<div align="center">
    <img src="performanceImpact.PNG"  alt="Java threads." width="500"/>
</div>

<div align="center">
    <img src="weAreAchievingThisUsingMultipleThreads.PNG"  alt="Java threads." width="500"/>
</div>

<div align="center">
    <img src="multithreadingCaveat.PNG"  alt="Java threads." width="500"/>
</div>

1. **Multithreaded** programming is different than the **single threading**.

<div align="center">
    <img src="whatWeWillLearnNextStep.PNG"  alt="Java threads." width="500"/>
</div>

<div align="center">
    <img src="operatingSystemIsBeingLoadedFromTheHardDrive.PNG"  alt="Java threads." width="500"/>
</div>

1. Os is loaded from the hard disk to memory on the startup.

<div align="center">
    <img src="applicationAreLoadedFromTheHardDisk.PNG"  alt="Java threads." width="500"/>
</div>


1. The **OS** will take the program from the disk and makes instance to the memory. 

<div align="center">
    <img src="SingleThreadedApplicationProcess.PNG"  alt="Java threads." width="500"/>
</div>

1. The instance of the program, which is loaded from the **Hard Drive** is called **Process** or the **Context of the application**.
2. **Thread** contains the **Stack** and the **Instruction Pointer**.

<div align="center">
    <img src="whatThreadContains.PNG"  alt="Java threads." width="500"/>
</div>

1. Region in memory, where **local variables** are stored, and passed into functions.
2. Address of the **next instruction** to **execute**.

<div align="center">
    <img src="summary.PNG"  alt="Java threads." width="500"/>
</div>

# Operating Systems Fundamentals - Part 2.

<div align="center">
    <img src="topic.PNG"  alt="Java threads." width="500"/>
</div>

<div align="center">
    <img src="differentTopicsInThisSwitch.PNG"  alt="Java threads." width="500"/>
</div>

- We need to clarify, when to use:
    - **Process**.
    - **Threads**.

<div align="center">
    <img src="ChangeTheThreadInTheCPU.gif"  alt="Java threads." width="500"/>
</div>

- There will be multiple **Threads** in different processes.
    - **CPU** will have to stop thread and resume to the different processes in **consecutive** times!

<div align="center">
    <img src="ContextSwitching.gif"  alt="Java threads." width="500"/>
</div>

- Act of:
    - `Stop thread 1`. **Stopping one thread**.
    - `Schedule thread 1 out`. **Scheduling one thread out**.
    - `Schedule thread 2 in`. **Scheduling one thread in**.
    - `Start Thread 2`. **Starting one tread**.
        - This is called **Context Switching**.

<div align="center">
    <img src="ContextSwitchingCost.PNG"  alt="Java threads." width="500"/>
</div>

1. **Context Switch** is not cheap, when dealing with many threads.
2. Every **Context Switch**, we need to **load** or **store** data of one tread and restore the another!

<div align="center">
    <img src="thrashingConcept.PNG"  alt="Java threads." width="500"/>
</div>

1. **Thrashing**, when time is spent more on the **switching the context** rather than actual work in the CPU!
2. **Threads** consumes less resources than the **Process**
    - **Context Switching** is cheaper in general if the switch is happening inside **same** process.

<div align="center">
    <img src="ThreadScheduling.PNG"  alt="Java threads." width="500"/>
</div>

- In this example:

<div align="center">
    <img src="ThreadSchedulingInPics.PNG"  alt="Java threads." width="500"/>
</div>

1. There **two** threads in **Music Player**.
2. There **two** threads in **Text Editor**.

<div align="center">
    <img src="ThreadSchedulingWithOneCpuExample.PNG"  alt="Java threads." width="500"/>
</div>

1. There will be **4** different threads from the **Music Player** and **Text Editor** app, in which **One CPU**, needs to prioritize with the **executing**.

<div align="center">
    <img src="whoRunsFirst.PNG"  alt="Java threads." width="500"/>
</div>

1. Which gets time to run first in **CPU**?

- If we decide the **First Cone First Serve** strategy, below is the example: 

<div align="center">
    <img src="FirstComeFirstServe.gif"  alt="Java threads." width="500"/>
</div>

- We can use **First Come First Serve**.

<div align="center">
    <img src="FirstComesFirstServesThreadStarvation.PNG"  alt="Java threads." width="500"/>
</div>

1. If there is **Thread** that takes much of time, this will cause **starvation** for other **Threads**.
    - UI threads can have big problem.

<div align="center">
    <img src="UIjobPrioritized.PNG"  alt="Java threads." width="500"/>
</div>

1. **UI** threads usually have shorter.
    - They usually responses to the input of the user. 

<div align="center">
    <img src="problemWithPrioritizingWithTheShortestJobFirst.PNG"  alt="Java threads." width="500"/>
</div>

1. If the **shorter jobs** get into the **scheduling** all the time, other **Threads** will never be executed.

<div align="center">
    <img src="ThreadSchedulingThreding.PNG"  alt="Java threads." width="500"/>
</div>

- **OS scheduler** organizes time **slices** into **epochs** for fairness. 

> An is **epoch** is full round during which every runnable thread (or process) gets a fair share of CPU time.

<div align="center">
    <img src="Epochs.gif"  alt="Java threads." width="500"/>
</div>

- We will try to fit processing time into **Epochs**.

<div align="center">
    <img src="ThreadSchedulingDynamicPriority.PNG"  alt="Java threads." width="500"/>
</div>

- `Dynamic Priority` = `Static Priority` + `Bonus`.
    - **Static Priority** is set by the **developer** programmatically.
    - **Bonus** is adjusted by the **Operating System** in every epoch, for each thread.

<div align="center">
    <img src="ThreadSchedulingDynamicPrioritySecond.PNG"  alt="Java threads." width="500"/>
</div>

<div align="center">
    <img src="threadsVsScheduling.PNG"  alt="Java threads." width="500"/>
</div>

<div align="center">
    <img src="multipleThreadsApproach.PNG"  alt="Java threads." width="500"/>
</div>

1. Should we have **Multiple threads** approach.

<div align="center">
    <img src="mentalImageOfTheProcessOfTheMultiProcess.PNG"  alt="Java threads." width="500"/>
</div>

1. Should we have **Multiple Processes** approach.

<div align="center">
    <img src="WhenToPreferMultiThreadedApproach.PNG"  alt="Java threads." width="500"/>
</div>

1. If there are **tasks** that **share** lot of data, then its preferred to use **Multithreaded architecture** approach!
2. Threads are much faster to **create** and **destroy**. Also, **switching** between threads of the same process is faster (shorter context switches), than switching between **processes**.

<div align="center">
    <img src="WhenToPreferMultiProcessApproach.PNG"  alt="Java threads." width="500"/>
</div>

1. If the tasks **are unrelated**, its better use different process!

<div align="center">
    <img src="summaryend.PNG"  alt="Java threads." width="500"/>
</div>

- Some additional links:
    - [Fair Scheduler](https://developer.ibm.com/tutorials/l-completely-fair-scheduler/).
    - [Tread State](https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.State.html).
