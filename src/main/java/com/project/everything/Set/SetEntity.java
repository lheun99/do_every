package com.project.everything.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "`sets`")
public class SetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "set_id", unique = true, nullable = false)
    private int setId;

    @Column(length = 15, nullable = false)
    private String setData;

    //빌더
    @Builder
    public SetEntity(int setId, String setData) {
        this.setId = setId;
        this.setData = setData;
    }
}
