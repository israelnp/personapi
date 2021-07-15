package br.com.israel.personapi.domain.exception;

public class PersonNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;

    public PersonNotFoundException(String message) {
        super(message);
    }

    public PersonNotFoundException(Long personId) {
        this(String.format("There are not a register de person with identifier %d", personId));
    }

}