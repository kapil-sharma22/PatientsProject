package com.example.Creation.Of.Patients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/PatientsTable")
public class CreationOfPatientsApplication {

	@Autowired
	private PatientService patientService;

	public static void main(String[] args) {
		SpringApplication.run(CreationOfPatientsApplication.class, args);
	}

	// Create or Update a Patient
	@PostMapping
	public Patient createOrUpdatePatient(@RequestBody Patient patient) {
		return patientService.save(patient);
	}

	// Retrieve a Patient by ID
	@GetMapping("/{id}")
	public Patient getPatientById(@PathVariable int id) {
		return patientService.findById(id).orElse(null);
	}

	// Update a Patient by ID
	@PutMapping("/{id}")
	public Patient updatePatient(@PathVariable int id, @RequestBody Patient patient) {
		Optional<Patient> existingPatient = patientService.findById(id);
		if (existingPatient.isPresent()) {
			Patient existPatient = existingPatient.get();
			existPatient.setFirst_name(patient.getFirst_name());
			existPatient.setLast_name(patient.getLast_name());
			existPatient.setEmail(patient.getEmail());
			existPatient.setHealthStatus(patient.getHealthStatus());

			return patientService.save(existPatient);
		}
		return null;
	}

	// Delete a Patient by ID
	@DeleteMapping("/{id}")
	public void deletePatient(@PathVariable int id) {
		if (patientService.findById(id).isPresent()) {
			patientService.deleteById(id);
		}
	}



}
