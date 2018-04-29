
package com.oregand.slante.service

import com.oregand.slante.model.Patient
import com.oregand.slante.repository.PatientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

interface PatientService {
    fun leaders(): List<Patient>
    fun record(handle: String, dosage: Int) : Int
}

@Service('patientService')
class PatientServiceImpl : PatientService {
    @Autowired
    lateinit var patientRepository : PatientRepository

    override fun leaders(): List<Patient> = patientRepository.findTop3ByOrderByTotalDosageDesc()

    override fun record(handle: String, dosage: Int): Int {
        val patient = patientRepository.findById(handle).orElse(Patient(handle)) + dosage
        patientRepository.save(patient)
        return patient.totalDosage
    }
}
