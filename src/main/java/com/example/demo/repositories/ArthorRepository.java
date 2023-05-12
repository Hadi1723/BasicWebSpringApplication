package com.example.demo.repositories;

import com.example.demo.domain.Arthor;
import org.springframework.data.repository.CrudRepository;

//we can always extends/implement from other interfaces

// since CraudRepository has generics, we always need to use generics for ArthorRepository as well when extending it

public interface ArthorRepository extends CrudRepository<Arthor, Long> {
}
