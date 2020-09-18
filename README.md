# cs101f2020-practical02

## DUE: September 21 by 9:10am

[![Actions Status](../../workflows/build/badge.svg)](../../actions)

## Table of Contents

- [Objectives](#objectives)

- [Introduction](#introduction)

- [Continuous Learning](#continuous-learning)

- [System Commands](#system-commands)

  - [Using Docker](#using-docker)
  - [Using Gradle](#using-gradle)

- [Program Requirements](#program-requirements)

- [Expected Program Output](#expected-program-output)

- [Automated Checks with GatorGrader](#automated-checks-with-gatorgrader)

- [Using GitHub Actions CI](#using-github-actions-ci)

- [Reporting Problems](#reporting-problems)

- [Receiving Assistance](#receiving-assistance)

- [Project Assessment](#project-assessment)

## Objectives

To continue to practice using GitHub to access the files for a course assignment. Additionally, to review how to use the Ubuntu operating system and software development programs such as a"terminal window" and the "Docker desktop". You will also continue to practice using Slack to support communication with the technical leaders and the instructor. Next, you will learn how to implement and test a Java program that uses arrays and loops to compute summary statistics fora list of data points, also practicing how to use an automated grading tool to assess your progress

## Introduction

Designed for use with [GitHub Classroom](https://classroom.github.com/) and [GatorGrader](https://github.com/GatorEducator/gatorgrader/), this repository contains the starter files for the second practical assignment in Data Abstraction class that uses the Java programming language. 

This assignment requires a programmer to implement and test a Java program, called `StatisticsCalculator`, that will produce ten lines of output. For this assignment, the programmer must implement a variance calculating method that accepts an array of `Double` values. The programmer is also responsible for learning how to run and fully understand a test suite written in the JUnit testing framework, as explained in Section 1.9 of the textbook. As verified by [Checkstyle](https://github.com/checkstyle/checkstyle), the source code for the `StatisticsCalculator.java` and `TestStatisticsCalculator.java` files must adhere to all of the requirements in the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html).

The source code in the `StatisticsCalculator.java` file must also pass additional tests set by the [GatorGrader tool](https://github.com/GatorEducator/gatorgrader). GatorGrader will also check that your program performs the correct computation and produces the expected output for calls to all of the methods that compute summary statistics. More details about the GatorGrader checks are included later in this document.

## Continuous Learning

If you have not done so already, please read all of the relevant [GitHub Guides](https://guides.github.com/) that explain how to use many of the features that GitHub provides. In particular, please make sure that you have read the following GitHub guides: [Mastering Markdown](https://guides.github.com/features/mastering-markdown/), [Hello World](https://guides.github.com/activities/hello-world/), and [Documenting Your Projects on GitHub](https://guides.github.com/features/wikis/). Each of these guides will help you to understand how to use both [GitHub](http://github.com) and [GitHub Classroom](https://classroom.github.com/).

Students who want to learn more about how to use [Docker](https://www.docker.com) should review the [Docker Documentation](https://docs.docker.com/). Students are also encouraged to review the documentation for their text editor, which is available for text editors like [Atom](https://atom.io/docs) and [VS Code](https://code.visualstudio.com/docs). You should also review the [Git documentation](https://git-scm.com/doc) to learn more about how to use the Git command-line client. In addition to talking with the instructor and technical leader for your course, students are encouraged to search [StackOverflow](https://stackoverflow.com/) for answers to their technical questions.

To do well on this assignment, you should also review Chapter 1 of the course textbook, paying close attention to the material about operators, expressions, `for` loops, and arrays. Students who want to learn more about how the provided source code uses JUnit are encouraged to read Section 1.9 of the textbook. Finally, students should read the [Calculating Variance of a Sample](https://www.wikihow.com/Calculate-Variance) article to learn more about how to calculate the variance of an array of `Double` values. Please see the course instructor or one of the student technical leaders if you have questions about any of these reading assignments.

## System Commands

This project invites students to enter system commands into a terminal window. This assignment uses [Docker](https://www.docker.com) to deliver programs, such as `gradle` and the source code and packages needed to run [GatorGrader](https://github.com/GatorEducator/gatorgrader), to a students' computer, thereby eliminating the need for a programmer to install them on their development workstation. Individuals who do not want to install Docker can optionally install of the programs mentioned in the [Project Requirements](#requirements) section of this document.

### Using Docker

Once you have installed [Docker Desktop](https://www.docker.com/products/docker-desktop), you can use the following `docker run` command to start `gradle grade` as a containerized application, using the [DockaGator](https://github.com/GatorEducator/dockagator) Docker image available on [DockerHub](https://cloud.docker.com/u/gatoreducator/repository/docker/gatoreducator/dockagator).

```bash
docker run --rm --name dockagator \
  -v "$(pwd)":/project \
  -v "$HOME/.dockagator":/root/.local/share \
  gatoreducator/dockagator
```

The aforementioned command will use `"$(pwd)"` (i.e., the current directory) as the project directory and `"$HOME/.dockagator"` as the cached GatorGrader directory. Please note that both of these directories must exist, although only the project directory must contain something. Generally, the project directory should contain the source code and technical writing of this assignment, as provided to a student through GitHub. Additionally, the cache directory should not contain anything other than directories and programs created by DockaGator, thus ensuring that they are not otherwise overwritten during the completion of the assignment. To ensure that the previous command will work correctly, you should create the cache directory by running the command `mkdir $HOME/.dockagator`.

If you are running your program on a Windows Operating System, you should run the following command instead, replacing the word "user" with the username of your machine:

```bash
docker run --rm --name dockagator -v "%cd%":/project -v "C:\Users\user/.dockagator":/root/.local/share gatoreducator/dockagator
```

Here are some additional commands that you may need to run when using Docker:

- `docker info`: display information about how Docker runs on your workstation
- `docker images`: show the Docker images installed on your workstation
- `docker container list`: list the active images running on your workstation
- `docker system prune`: remove many types of "dangling" components from your workstation
- `docker image prune`: remove all "dangling" docker images from your workstation
- `docker container prune`: remove all stopped docker containers from your workstation
- `docker rmi $(docker images -q) --force`: remove all docker images from your workstation

### Using Gradle

Since the above `docker run` command uses a Docker image that, by default, runs `gradle grade` and then exits the Docker container, you may want to instead run the following command so that you enter an "interactive terminal" that will allow you to repeatedly run commands within the Docker container.

In Linux and Mac OS:

```bash
docker run -it --rm --name dockagator \
  -v "$(pwd)":/project \
  -v "$HOME/.dockagator":/root/.local/share \
  gatoreducator/dockagator /bin/bash
```

In Windows OS:

```bash
docker run -it --rm --name dockagator -v "%cd%":/project -v "C:\Users\user/.dockagator":/root/.local/share gatoreducator/dockagator /bin/bash
```

Once you have typed this command, you can use the [GatorGrader tool](https://github.com/GatorEducator/gatorgrader) in the Docker container by typing the command `gradle grade` in your terminal. Running this command will produce a lot of output that you should carefully inspect. If GatorGrader's output shows that there are no mistakes in the assignment, then your source code and writing are passing all of the automated baseline checks. However, if the output indicates that there are mistakes, then you will need to understand what they are and then try to fix them.

You can also complete several important Java programming tasks by using the `gradle` tool. For instance, you can compile (i.e., create bytecode from the program's source code if it is correct) the program using the command `gradle build`. Here are some other commands that you can type:

- `gradle grade`: run the [GatorGrader](https://github.com/GatorEducator/gatorgrader) tool to check your work
- `gradle clean`: clean the project of all the derived files
- `gradle check`: check the quality of the code using Checkstyle
- `gradle build`: create the bytecode from the Java source code
- `gradle run`: run the Java program in the command-line
- `gradle cleanTest`: clean the JUnit test suite of derived files
- `gradle test`: run the JUnit test suite and display the results
- `gradle tasks`: display details about the Gradle system

To run one of these commands, you must be in the main (i.e., "home base") directory for this assignment where the `build.gradle` file is located.

## Program Requirements

Please study the source code of the `StatisticsCalculator`, noticing that some of its methods are incomplete. For instance, you will see that the program is missing an implementation of the `calculateVariance` method. To learn more about how to perform a summation to calculate the variance of a list of `Double` values, please read the [Calculating Variance of a Sample](https://www.wikihow.com/Calculate-Variance) article. Specifically, the article asks you to iterate through all of the values in an array so that you can subtract the mean from each data point and then square the result. You will need to ensure that the result from each iteration carries over to the next one. Then, you will perform a division and return this value. Once you have finished this step, please do a "project wide" search for the "TODO" markers inside of the provided Java source code. Make sure that you complete each of the requested tasks as you are working on this assignment. If you are stuck, please ask the course instructor and technical leaders for help!

You should run the test suite called `TestStatisticsCalculator` that is written in the `JUnit` testing framework. Please read each of the tests as they explain, in Java source code, the expected properties of the methods for calculating summary statistics. You can run the test suite for the `StatisticsCalculator` by typing "gradle test" in the terminal. You should revise your implementation of `calculateVariance` until all the tests pass. Overall, please make sure that you have provide an implementation of all the required methods in `StatisticsCalculator` and that, when run in Docker, it produces the output shown in the section below.

## Expected Program Output

Typing the command `gradle run` in the interactive terminal should produce the following output for the completed version of the assignment. As long as your program adheres to all of the requirements for the assignment and passes all of the verification checks, your version should produce similar output.

```
> Configure project :
Configured GatorGradle 0.4.4

> Task :run
Displaying the values in the array.
  12.5
  6.2
  1.5
  2.9
  10.8
Displaying the output with two decimal places.
This is the arithmetic mean: 6.78
This is the variance: 23.04
This is the standard deviation: 4.80
```

Running the command `gradle -q --console plain run` will suppress the display of Gradle's diagnostic information and produce output like the following.

```
Displaying the values in the array.
  12.5
  6.2
  1.5
  2.9
  10.8
Displaying the output with two decimal places.
This is the arithmetic mean: 6.78
This is the variance: 23.04
This is the standard deviation: 4.80
```

## Automated Checks with GatorGrader

In addition to meeting all of the requirements outlined in the assignment sheet, your submission must pass the following checks that [GatorGrader](https://github.com/GatorEducator/gatorgrader) automatically assesses:

- Repository has at least 5 commit(s)
- The StatisticsCalculator.java in src/main/java/practicaltwo has at least 1 of the `Math.sqrt` fragment
- The StatisticsCalculator.java in src/main/java/practicaltwo has at least 2 of the `for (` fragment
- The StatisticsCalculator.java in src/main/java/practicaltwo has at least 3 multiple-line Java comment(s)
- The StatisticsCalculator.java in src/main/java/practicaltwo has at least 5 of the `println(` fragment
- The StatisticsCalculator.java in src/main/java/practicaltwo has exactly 0 of the `Add Your Name Here` fragment
- The StatisticsCalculator.java in src/main/java/practicaltwo has exactly 0 of the `TODO` fragment
- The StatisticsCalculator.java in src/main/java/practicaltwo has exactly 1 of the `package practicaltwo` fragment
- The StatisticsCalculator.java in src/main/java/practicaltwo has exactly 1 of the `{12.5, 6.2, 1.5, 2.9, 10.8}` fragment!
- The TestStatisticsCalculator.java in src/test/java/practicaltwo has at least 1 multiple-line Java comment(s)
- The TestStatisticsCalculator.java in src/test/java/practicaltwo has at least 9 of the `@Test` fragment
- The TestStatisticsCalculator.java in src/test/java/practicaltwo has exactly 0 of the `Add Your Name Here` fragment
- The TestStatisticsCalculator.java in src/test/java/practicaltwo has exactly 0 of the `TODO` fragment
- The TestStatisticsCalculator.java in src/test/java/practicaltwo has exactly 1 of the `package practicaltwo` fragment
- The command `gradle -q --console plain run` executes correctly
- The command `gradle build` executes correctly
- The command output has exactly 1 of the `23.04` fragment
- The command output has exactly 1 of the `4.80` fragment
- The command output has exactly 1 of the `6.78` fragment
- The command output has exactly 10 lines
- The file StatisticsCalculator.java exists in the src/main/java/practicaltwo directory
- The file TestStatisticsCalculator.java exists in the src/test/java/practicaltwo directory

If [GatorGrader's](https://github.com/GatorEducator/gatorgrader) automated checks pass correctly, the tool will produce the output like the following in addition to returning a zero exit code (which you can access by typing the command `echo $?`).

```
        ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
        ┃ Passed 22/22 (100%) of checks for cs101f2020-practical02! ┃
        ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
```

## Using GitHub Actions CI

This assignment uses [GitHub Actions CI](https://github.com/features/actions) to automatically run [GatorGrader](https://github.com/GatorEducator/gatorgrader) and additional checking programs every time you commit to your GitHub repository. The checking will start as soon as you have accepted the assignment -- thus creating your own private repository. If you do not see either a yellow ● or a green ✔ or a red ✗ in your listing of commits, then please contact the instructor.

## Reporting Problems

If you have found a problem with this assignment's provided source code or documentation, then you can go to the [Computer Science 101 Fall 2020 Practical 02](https://github.com/allegheny-computer-science-101-f2020/practical02) repository and [raise an issue](https://github.com/allegheny-computer-science-101-f2020/practical02/issues). If you have found a problem with the [GatorGrader tool](https://github.com/GatorEducator/gatorgrader) and the way that it checks your assignment, then you can also [raise an issue](https://github.com/GatorEducator/gatorgrader/issues) in that repository. To ensure that your issue is properly resolved, please provide as many details as is possible about the problem that you experienced. If you discover a problem with the assignment sheet for this project, then please raise an issue in the GitHub repository that provides the assignment sheets for your course.

Whenever possible, individuals who find, and use the appropriate GitHub issue tracker to correctly document, a mistake in any aspect of this assignment will receive free [GitHub stickers](https://octodex.github.com/) and extra credit towards their grade for the project.

## Receiving Assistance

If you are having trouble completing any part of this project, then please talk with either the course instructor or a student technical leader during the course session. Alternatively, you may ask questions in the Slack workspace for this course. Finally, you can schedule a meeting during the course instructor's or technical leaders' office hours.

## Project Assessment

The grade that a student receives on this practical assignment is a checkmark grade (0 or 1) and is based on:

- **Percentage of Correct Gatorgrader Checks**: Students will receive 1 if their solution passes at least 80% of GatorGrader checks, otherwise they will receive 0\. Students are encouraged to repeatedly revise their source code in an attempt to get their GitHub Actions CI build to pass.
