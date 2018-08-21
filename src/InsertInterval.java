import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class InsertInterval {
    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null && newInterval == null) {
            return null;
        }
        if (intervals == null && newInterval != null) {
            List<Interval> res = new ArrayList<>();
            res.add(newInterval);
            return res;
        }

        if (intervals != null && newInterval == null) {
            return intervals;
        }

        intervals.add(newInterval);
        intervals.sort((o1, o2) -> o1.start < o2.start ? -1 : 1);

        ArrayList<Interval> result = new ArrayList<>();

        Interval pre = intervals.get(0);
        for (int i = 0; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (curr.start > pre.end) {
                result.add(pre);
                pre = curr;
            } else {
                Interval merged = new Interval(pre.start, Math.max(pre.end, curr.end));
                pre = merged;
            }
        }
        result.add(pre);
        return result;
    }

    public static void main(String[] args) {
        //1,2],[3,5],[6,7],[8,10],[12,16]
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(12, 16));
        InsertInterval interval = new InsertInterval();
        interval.insert(intervals, new Interval(4, 8));
    }
}
