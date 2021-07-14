package br.com.israel.personapi.api.model.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonInput {

    @NotBlank
    @Size(min = 2, max = 50)
    private String firstName;
    @NotBlank
    @Size(min = 2, max = 50)
    private String lastName;
    @NotBlank
    @Size(min = 2, max = 11)
    private String cpf;
    @Size(min = 0, max = 11)
    private String birthDate;
    @Valid
    @NotNull
    private List<PhoneInput> phones = new ArrayList<>();
}
