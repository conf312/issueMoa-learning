package com.issuemoa.learning.domain.interview.favorites;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface InterviewFavoritesRepository extends JpaRepository<InterviewFavorites, Long> {
    @Query(value = "select f from interview_favorites f  join fetch f.interview where f.registerId = :registerId")
    public List<InterviewFavorites> findUserInterviewFavorites(@Param("registerId") Long registerId);
}
