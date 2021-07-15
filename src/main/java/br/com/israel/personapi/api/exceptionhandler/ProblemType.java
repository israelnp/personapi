package br.com.israel.personapi.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    INVALID_DATA("/invalid-data", "Invalid data"),
    ACCESS_DENIED("/access-denied", "Access Denied"),
    SYSTEM_ERROR("/system-error", "System Error"),
    PARAMETER_INVALID("/parameter-invalid", "Invalid parameter"),
    MESSAGE_INCOMPREHENSIBLE("/message-incomprehensible", "Message-incomprehensible"),
    RESOURCE_NOT_FOUND("/resource-not-found", "Resource not found"),
    ENTITY_IN_USE("/entity-in-use", "Entity in use"),
    ERRO_NEGOCIO("/erro-negocio", "Violation of business rule");

    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = "https://wwww.israel.com.br" + path;
        this.title = title;
    }

}