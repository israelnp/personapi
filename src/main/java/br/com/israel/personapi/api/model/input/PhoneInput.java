package br.com.israel.personapi.api.model.input;

import br.com.israel.personapi.domain.model.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneInput {

    @Enumerated(EnumType.STRING)
    private PhoneType type;
    @NotBlank
    private String number;
}
