package org.example;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum OperatorStatus {
    BEELINE("905"),
    MEGAFON("926"),
    TELE2("950"),
    MTS("910"),
    NONE("none");

    @Getter
    private final String operatorCode;
}


