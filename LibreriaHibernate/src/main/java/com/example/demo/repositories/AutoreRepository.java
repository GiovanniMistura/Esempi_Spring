package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Autore;

public interface AutoreRepository extends JpaRepository<Autore , Long> {

}
