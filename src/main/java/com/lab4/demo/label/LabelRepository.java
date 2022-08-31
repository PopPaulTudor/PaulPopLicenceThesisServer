package com.lab4.demo.label;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LabelRepository extends JpaRepository<Label, Long> {

    Label findLabelByNameNumber(int nameNumber);

}
