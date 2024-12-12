package 贪心;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class BestArrange {
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public class ProgramComparator implements Comparator<Program>{

        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }
    public int maxEvents(Program[] programs,int current) {
        Arrays.sort(programs,new ProgramComparator());
        int res=0;
        for (int i=0;i<programs.length;i++) {
            if (current<=programs[i].start) {
                res++;
                current = programs[i].start;
            }
        }
        return res;
    }
}
