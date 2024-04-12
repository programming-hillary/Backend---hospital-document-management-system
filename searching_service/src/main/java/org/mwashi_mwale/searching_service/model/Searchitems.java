package org.mwashi_mwale.searching_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "search_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Searchitems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String editor;
    private String comment;
    private LocalDateTime date;
}
