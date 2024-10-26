package com.ttknp.logic_layer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
// import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// @AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authors")
@Data
public class Author {
    @Id
    private String aid;
    private String fullname;
    private Short age;
    private Boolean alive;
    // Mapping to the other table
    @OneToMany(cascade = CascadeType.ALL) // ,targetEntity = Address.class ,mappedBy = "ob"
    @JoinColumn(name = "aid")
    // ** not good for toString()
    private List<EditHistory> editHistories;

    @Override
    public String toString() {
        return "Author{" +
                "aid='" + aid + '\'' +
                ", fullname='" + fullname + '\'' +
                ", age=" + age +
                ", alive=" + alive +
                '}';
    }
}
