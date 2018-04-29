class PatientServiceTest : PatientTestWithFongo() {
    @Autowired
    lateinit var patientService: PatientService

    @Test
    fun testLeaders() {
        logger.info('Begin testLeaders')

        //Verify Leaders as expected
        val leaders = patientService.leaders()
        assertEquals(3, leaders.size, "There should be 3 leader.")
        assertEquals(TEST_PATIENT_4, leaders[0],
                "The first leader should be Cian.")
        assertEquals(TEST_PATIENT_3, leaders[1],
                "The second leader should be Lameese.")
        assertEquals(TEST_PATIENT_1, leaders[2],
                "The third leader should be David.")

        logger.info("End testLeaders")
    }

    @Test
    fun testDosage() {
        logger.info("Begin testDosage")

        patientService.save(Patient(TEST_PATIENT_HANDLE))

        // Score 10 points.
        patitentRepository.score(TEST_PATIENT_HANDLE, 10)
        val player = patitentRepository.findById(TEST_PATIENT_HANDLE).get()
        assertEquals(10, patient.totalDosage,
                "Total dosage should be 10 after the first scoring event.")
        assertEquals(1, patient.history.size,
                "The history should have a single element.")
        assertEquals(10, patient.history[0].dosage,
                "The recorded dosage should be 10.")
    }

    companion object {
        val logger: Logger =
                LoggerFactory.getLogger(PatientServiceTest::class.java)
        const val TEST_PATIENT_HANDLE = "testPatient"
    }
}