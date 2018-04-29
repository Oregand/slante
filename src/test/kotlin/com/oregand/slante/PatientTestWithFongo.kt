@RunWith(SpringRunner::class)
@SpringBootTest
abstract class PatientTestWithFongo(val initializeTestData: Boolean = true) {
    @get : Rule
    val fongoRule = FongoRule()

    @Autowired
    lateinit var patitentRepository: patitentRepository

    @Before
    fun setupDatabase() {
        if(initializeTestData) {
            patitentRepository.save(TEST_PATIENT_1)
            patitentRepository.save(TEST_PATIENT_2)
            patitentRepository.save(TEST_PATIENT_3)
            patitentRepository.save(TEST_PATIENT_4)
            patitentRepository.save(TEST_PATIENT_5)
        }
    }

    companion object {
        val TEST_PATIENT_1 = Patient('David', 10)
        val TEST_PATIENT_2 = Patient('Ian', 2)
        val TEST_PATIENT_3 = Patient('Lameese', 18)
        val TEST_PATIENT_4 = Patient('Cian', 67)
        val TEST_PATIENT_5 = Patient('Carl', 3)
    }
}