package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Libro;

public interface LibroRepository extends JpaRepository<Libro , Long> {

}
