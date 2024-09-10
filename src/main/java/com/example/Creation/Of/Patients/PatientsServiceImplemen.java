package com.example.Creation.Of.Patients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

    @Service
public class PatientsServiceImplemen implements PatientService {

        @Autowired
        private PatientRepository patientsRepository;

        @Override
        public Patient save(Patient patients) {
            return patientsRepository.save(patients);
        }


        @Override
        public Optional<Patient> findById(int id) {
            return patientsRepository.findById(id);
        }

        @Override
        public Iterable<Patient> findAll() {
            return patientsRepository.findAll();
        }

        @Override
        public void deleteById(int id) {
            patientsRepository.deleteById(id);
        }
    }

