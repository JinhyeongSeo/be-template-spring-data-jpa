package com.springboot.coffee.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long coffeeId;
    @Column(length = 100, nullable = false)
    private String korName;
    @Column(length = 100, nullable = false)
    private String engName;
    @Column(nullable = false)
    private Integer price;
    @Column(length = 3, nullable = false, unique = true)
    private String coffeeCode;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private CoffeeStatus coffeeStatus = CoffeeStatus.COFFEE_FOR_SALE;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(nullable = false, name = "LAST_MODIFIED_AT")
    private LocalDateTime modifiedAt = LocalDateTime.now();

    public enum CoffeeStatus {
        COFFEE_FOR_SALE(""),
        COFFEE_SOld_OUT("");

        @Getter
        private String status;

        CoffeeStatus(String status) {
            this.status = status;
        }
    }

}
