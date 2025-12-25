package org.java.builder;

import java.util.List;
/*
The task:
Thread Creation - MultiExecutor
In this exercise, we are going to implement a  MultiExecutor .

The client of this class will create a list of Runnable tasks and provide that list into MultiExecutor's constructor.
When the client runs the  executeAll(),  the MultiExecutor,  will execute all the given tasks.
To take full advantage of our multicore CPU, we would like the MultiExecutor to execute all the tasks in parallel by passing each task to a different thread.


Please implement the MultiExecutor below
*/


public class MultiExecutor {

    // Add any necessary member variables here

    List<Thread> listOfThreadsToExecute;
    /*
     * @param tasks to executed concurrently
     */
    public MultiExecutor(List<Runnable> tasks) {

        tasks.forEach((runnableTask) -> {
            listOfThreadsToExecute.add(new Thread(runnableTask));
        });
    }

    /**
     * Starts and executes all the tasks concurrently
     */
    public void executeAll() {
        for (Thread t : listOfThreadsToExecute) {
            t.start();
        }
    }
}