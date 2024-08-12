package com.practice.collection.comparator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Designation {
    INTERN("Intern", 1),
    DEVELOPER("Developer", 2),
    SENIOR_DEVELOPER("Senior Developer", 3),
    TEAM_LEAD("Team Lead", 4),
    MANAGER("Manager", 5);

    private final String designation;
    private final Integer rank;
}
