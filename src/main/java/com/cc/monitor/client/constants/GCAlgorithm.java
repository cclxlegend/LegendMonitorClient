package com.cc.monitor.client.constants;

import java.util.Arrays;
import java.util.List;

import static com.cc.monitor.client.constants.LMCConstants.OLD_GC;
import static com.cc.monitor.client.constants.LMCConstants.YOUNG_GC;

public enum GCAlgorithm {

    COPY(YOUNG_GC, "Copy"),
    PARNEW(YOUNG_GC, "ParNew"),
    PS_SCAVENGE(YOUNG_GC, "PS Scavenge"),
    G1_YOUNG_GENERATION(YOUNG_GC, "G1 Young Generation"),
    MARK_SWEEP_COMPACT(OLD_GC, "MarkSweepCompact"),
    PS_MARK_SWEEP(OLD_GC, "PS MarkSweep"),
    CONCURRENT_MARK_SWEEP(OLD_GC, "ConcurrentMarkSweep"),
    G1_OLD_GENERATION(OLD_GC, "G1 Old Generation");

    private int gen;
    private String name;

    private static List<GCAlgorithm> youngList = Arrays.asList(new GCAlgorithm[]{
            COPY, PARNEW, PS_SCAVENGE, G1_YOUNG_GENERATION
    });

    private static List<GCAlgorithm> oldList = Arrays.asList(new GCAlgorithm[]{
            MARK_SWEEP_COMPACT, PS_MARK_SWEEP, CONCURRENT_MARK_SWEEP, G1_OLD_GENERATION
    });

    public static boolean isYoungGcAlgorithm(String gcName) {

        for(GCAlgorithm algorithm : youngList){
            if(algorithm.name().contains(gcName)){
                return true;
            }
        }
        return false;
    }

    public static boolean isOldGcAlgorithm(String gcName) {

        for(GCAlgorithm algorithm : oldList){
            if(algorithm.name().contains(gcName)){
                return true;
            }
        }
        return false;
    }

    private GCAlgorithm(int gen, String name) {
        this.gen = gen;
        this.name = name;
    }


}
