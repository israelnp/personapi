package br.com.israel.personapi.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonModel {

    private Long id;
    private String firstName;
    private String lastName;
    private String cpf;
    private List<PhoneModel> phones = new ArrayList<>();
}
