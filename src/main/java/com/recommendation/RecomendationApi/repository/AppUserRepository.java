package com.recommendation.RecomendationApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recommendation.RecomendationApi.model.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, String> {

}