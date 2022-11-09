# ANU-COMP2310-tools

Several tools to help understanding the concepts covered in COMP2310 / CSAPP. E.g. a cache line simulator can illustrate cache state and calculate the hit and miss rate.

## About the course

According to the main website of the course [COMP2310 Systems, Networks, and Concurrency](https://comp.anu.edu.au/courses/comp2310/#systems-networks-and-concurrency),

> This course first aims to teach how application programmers can use  their knowledge of modern computer systems to write correct programs  that deliver the best performance and efficiency.

In my understanding, it is an ANU implementation of CSAPP (*Computer Systems: A Programmer’s Perspective*). Most of the material in this book is covered by this course.

## Tools

During the final review period, I built these tools to help me understand the concepts in the course. If it is of any use to you, feel free to modify and use it.

### Cache lookups

The question might give an table of cache,

| Set index | Tag  | Valid | Byte 0 | Byte 1 | Byte 2 | Byte 3 |
| --------- | ---- | ----- | ------ | ------ | ------ | ------ |
| 0         | 0    | 1     | 21     | 12     | 90     | 82     |
|           | 83   | 1     | A2     | 89     | 12     | D3     |
| 1         | 0    | 1     | 12     | 32     | 31     | 27     |
|           | 83   | 0     | —      | —      | —      | —      |

and corresponding physical address wide. Suppose the address wide is 11 in our question.

The complied `cache lookups.c` can illustrate format of such cache:

![image-20221109151752828](./README.assets/image-20221109151752828.png)

Also, given an physical address like `0x419`, it can figure out the corresponding information:

![image-20221109152129094](./README.assets/image-20221109152129094.png)

According to these information, we can find the value `89` in the cache table.