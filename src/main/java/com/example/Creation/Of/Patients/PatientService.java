package com.example.Creation.Of.Patients;

import java.util.Optional;

public interface PatientService {

    Patient save(Patient patient);

    Optional<Patient> findById(int id);
    Iterable<Patient> findAll();
    void deleteById(int id);
}
