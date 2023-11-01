package com.Ecommerce.Service;

import com.Ecommerce.Exception.ProductException;
import com.Ecommerce.Request.RatingRequest;
import com.Ecommerce.model.Rating;
import com.Ecommerce.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RatingService {

    public Rating createRating(RatingRequest req, User user) throws ProductException;
    public List<Rating> getProductsRating(Long productId);



}
