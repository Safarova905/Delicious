package ru.kpfu.itis.model;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode

public class Label {
    private Product id;
    private String label;
}
