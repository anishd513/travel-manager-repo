package com.travelbackend.travelmanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error {
    int errorCode;
    String errorMessage;
}
