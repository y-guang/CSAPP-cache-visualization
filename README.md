# ANU-COMP2310-tools

Several tools to help understanding the concepts covered in COMP2310 / CSAPP. E.g. a cache line simulator can illustrate cache state and calculate the hit and miss rate.

## About the course

According to the main website of the course [COMP2310 Systems, Networks, and Concurrency](https://comp.anu.edu.au/courses/comp2310/#systems-networks-and-concurrency),

> This course first aims to teach how application programmers can use  their knowledge of modern computer systems to write correct programs  that deliver the best performance and efficiency.

In my understanding, it is an ANU implementation of CSAPP (*Computer Systems: A Programmer’s Perspective*). Most of the material in this book is covered by this course.

## Tools

During the final review period, I built these tools to help me understand the concepts in the course. If it is of any use to you, feel free to modify and use it.

### Cache lookups

Answer the typical question about Cache lookups.

The question might give an table of cache,

| Set index | Tag  | Valid | Byte 0 | Byte 1 | Byte 2 | Byte 3 |
| --------- | ---- | ----- | ------ | ------ | ------ | ------ |
| 0         | 0    | 1     | 21     | 12     | 90     | 82     |
|           | 83   | 1     | A2     | 89     | 12     | D3     |
| 1         | 0    | 1     | 12     | 32     | 31     | 27     |
|           | 83   | 0     | —      | —      | —      | —      |

and corresponding physical address wide, For the above table it's 11.

The complied `cache lookups.c` can illustrate information of such cache:

![image-20221109151752828](./README.assets/image-20221109151752828.png)

Also, given an physical address, it can figure out the corresponding information:

for given address `0x419`, we get following information.

![image-20221109152129094](./README.assets/image-20221109152129094.png)

Then, we can find it is value `89` in the table.