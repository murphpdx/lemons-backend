package com.lemonaide.backend.RedisRepository;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Car")
@Data
@RequiredArgsConstructor
public class Car implements Serializable {
        @NonNull
        private String id;
        @NonNull
        private String model;

        @NonNull
        private String make;

        @NonNull
        private String year;

        @NonNull
        private String color;
}
