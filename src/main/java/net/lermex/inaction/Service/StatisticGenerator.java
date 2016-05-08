package net.lermex.inaction.service;

import java.util.Random;

public class StatisticGenerator {
    private int [] statistics;

    public StatisticGenerator(){
    }

    public int[] generateStatistic(){
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            statistics[i] = random.nextInt(6);
        }
        return statistics;
    }

    public int [] getStatistics(){
        return statistics;
    }

}
