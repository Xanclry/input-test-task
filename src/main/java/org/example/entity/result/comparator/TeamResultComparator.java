package org.example.entity.result.comparator;

import org.example.entity.result.Result;

import java.util.Comparator;

public class TeamResultComparator implements Comparator<Result> {
    @Override
    public int compare(Result o1, Result o2) {
        return Comparator.comparing(Result::getTeam)
                .thenComparing(Result::getName)
                .thenComparing(Result::getScore)
                .compare(o1, o2);
    }
}
