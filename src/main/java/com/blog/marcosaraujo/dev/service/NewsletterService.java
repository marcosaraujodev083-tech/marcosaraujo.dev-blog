package com.blog.marcosaraujo.dev.service;

import com.blog.marcosaraujo.dev.model.Subscriber;
import com.blog.marcosaraujo.dev.repository.SubscriberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewsletterService {

    private final SubscriberRepository subscriberRepository;

    public void subscribe(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Informe um e-mail válido.");
        }

        if (subscriberRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Este e-mail já está cadastrado!");
        }

        Subscriber subscriber = new Subscriber();
        subscriber.setEmail(email.toLowerCase().trim());

        subscriberRepository.save(subscriber);
    }
}