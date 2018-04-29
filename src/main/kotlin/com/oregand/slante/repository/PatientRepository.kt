
package com.oregand.slante.model

import com.oregand.slante.model.Patient
import org.springframework.data.repository.CrudRepository

interface PatientRepository : CrudRepository<Patient, String> {
    fun findTop3ByOrderByTotalDosageDesc(): List<Patient>
}
