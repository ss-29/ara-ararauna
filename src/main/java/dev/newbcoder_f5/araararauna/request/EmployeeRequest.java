package dev.newbcoder_f5.araararauna.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmployeeRequest {

    private String name;

    private List<String> department;

}
