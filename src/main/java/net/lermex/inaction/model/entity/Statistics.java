package net.lermex.inaction.model.entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class Statistics {
    private List<Integer> statisticsList;

    public List<Integer> getStatisticsList() {
        return statisticsList;
    }

    public void setStatisticsList(List<Integer> statisticsList) {
        this.statisticsList = statisticsList;
    }

    public void generateStatistic() {
        Random random = new Random();
        this.statisticsList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            this.statisticsList.add(random.nextInt(6));
        }
    }
}
