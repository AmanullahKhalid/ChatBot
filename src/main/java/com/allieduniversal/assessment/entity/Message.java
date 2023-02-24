package com.allieduniversal.assessment.entity;

import com.allieduniversal.assessment.converter.SetToStringConverter;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "body", nullable = false, updatable = false)
    private String body;

    @Column(name = "odr", nullable = false, updatable = false)
    private int order;

    @Convert(converter = SetToStringConverter.class)
    private Set<String> responses;

    private String choice;

    @Override
    public String toString() {
        return body;
    }
}
