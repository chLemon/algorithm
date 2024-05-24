package _solution.leetcode;

import java.util.List;

public class No253 {

    // 先按照开始时间排序
    /*
    然后维护一个小顶堆
    遍历会议时间，将结束时间推入堆中。
    
    当到第i个会议时，看一下堆顶的结束时间 是否 小于 当前的开始时间
    如果小于，说明这个会议室 现在可以用了，就 pop ，然后把当前的加入
    
    最后输出小顶堆的size
     */
    
    /*
    给定一系列的会议时间间隔intervals，包括起始和结束时间[[s1,e1],[s2,e2],...] (si < ei)，找到所需的最小的会议室数量。
    
    
    输入: intervals = [(0,30),(5,10),(15,20)]
    输出: 2
    解释:
    需要两个会议室
    会议室1:(0,30)
    会议室2:(5,10),(15,20)

    输入: intervals = [(2,7)]
    输出: 1
    解释:
    只需要1个会议室就够了
     */


    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        return 0;
    }

    private static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
