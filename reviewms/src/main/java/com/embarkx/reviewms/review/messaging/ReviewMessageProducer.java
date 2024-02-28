package com.embarkx.reviewms.review.messaging;

import com.embarkx.reviewms.review.Review;
import com.embarkx.reviewms.review.dto.ReviewMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReviewMessageProducer {
    private final RabbitTemplate rabbitTemplate;

    public ReviewMessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Review review) {
        ReviewMessage reviewMessage = ReviewMessage.builder()
                .id(review.getId())
                .title(review.getTitle())
                .description(review.getDescription())
                .rating(review.getRating())
                .companyId(review.getCompanyId())
                .build();
        rabbitTemplate.convertAndSend("companyRatingQueue", reviewMessage);
    }
}
