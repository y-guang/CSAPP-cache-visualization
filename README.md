# CSAPP-cache-visualization

Several tools to help understanding and visualizing the cache concepts covered in CSAPP and ANU COMP2310 course.

## Tools

### CacheSimulator

A java program. 

### Cache lookups.c

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