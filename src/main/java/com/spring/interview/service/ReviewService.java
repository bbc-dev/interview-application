package com.spring.interview.service;

import com.spring.interview.dto.ReviewRequestDTO;
import com.spring.interview.dto.ReviewResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    /**
     * Adds a new review for a specified book.

     * Requirements:
     * - The method should first check if the provided book ID is null or if the book does not exist.
     * - If the book ID is null or the book cannot be found, throw an IllegalArgumentException.
     * - If the book exists, the method should save the new review for the book.
     * - Ensure that the NewReview object contains all necessary information (e.g.comment, author details).
     * - Return the ID of the saved review upon successful addition.
     * 
     * @param reviewRequestDTO The review object containing details such as comment, and author information.
     * @param id The ID of the book to which the review will be added.
     * @return The ID of the saved review.
     * @throws IllegalArgumentException if the book ID is null or the book cannot be found.
     */
    public String addReview(ReviewRequestDTO reviewRequestDTO, String id) {
        throw new UnsupportedOperationException("We need to have an implementation");
    }

    /**
     * Retrieves all reviews for a specified book.

     * Requirements:
     * - The method should check if the provided book ID is null or if the book does not exist.
     * - If the book ID is null or the book cannot be found, throw an IllegalArgumentException.
     * - If the book exists, retrieve all reviews associated with the book.
     * - If there are no reviews, return an empty list.
     * - If reviews exist, return the list of reviews as ReviewDTO objects.
     * 
     * @param id The ID of the book for which reviews are requested.
     * @return A list of ReviewDTO objects representing the reviews for the specified book.
     *         If no reviews are found, return an empty list.
     * @throws IllegalArgumentException if the book ID is null or the book cannot be found.
     */
    public List<ReviewResponseDTO> getReviews(String id) {
        throw new UnsupportedOperationException("We need to have an implementation");
    }
}
